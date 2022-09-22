import java.rmi.NoSuchObjectException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Example6_2 {
    static class Producer implements Runnable {
        String name;
        Market market;
        String items;
        int quantity;
        long interval;
        static Lock locker = new ReentrantLock();

        public Producer(String name, Market market, String items, int quantity, long interval) {
            this.name = name;
            this.market = market;
            this.items = items;
            this.quantity = quantity;
            this.interval = interval;
        }

        public String getName() {
            return this.name;
        }

        public String getItems() {
            return this.items;
        }

        public Integer getDelivery() {
            return this.quantity;
        }

        public long getInterval() {
            return this.interval;
        }

        @Override
        public void run() {
            long nextDeliveryDate = System.currentTimeMillis();
            System.out.println(this.name + "를 시작합니다.");
            try {
                while (true) {
                    System.out.println(this.getName() + "(이)가 " + this.getItems() + "(을)를"
                            + this.getDelivery() + "개 납품합니다.");
                    this.market.replenish(this.getItems(), this.getDelivery());
                    nextDeliveryDate += this.getInterval();
                    Thread.sleep(nextDeliveryDate - System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                System.out.printf("%s에 인터럽트가 발생했습니다.\n", Thread.currentThread().getName());
                System.out.printf("%s를 종료합니다.\n", Thread.currentThread().getName());
            }
        }

        static class Consumer implements Runnable {
            String name;
            Market market;
            String[] items;
            long childinterval;
            long interval;

            public Consumer(String name, Market market, String[] items, long interval, long childinterval) {
                this.name = name;
                this.market = market;
                this.items = Arrays.copyOf(items, items.length);
                this.childinterval = childinterval;
                this.interval = interval;
            }

            public String getName() {
                return this.name;
            }

            public long getWaitingTime() {
                return this.interval;
            }

            @Override
            public void run() {
                Random random = new Random();
                long startTime = System.currentTimeMillis();
                System.out.println(this.name + "가 시장에 왔습니다.");
                try {
                    while (true) {
                        String product = this.items[random.nextInt(this.items.length)];
                        try {
                            this.market.buy(product, this.getWaitingTime());
                            System.out.printf("%s가 %s를 구매하였습니다.\n", this.getName(), product);
                        } catch (NoSuchObjectException e) {
                            System.out.println(e);
                        }

                        Thread.sleep((System.currentTimeMillis() - startTime) % this.interval);
                    }
                } catch (InterruptedException e) {
                    System.out.printf("%s에 인터럽트가 발생했습니다.\n", this.getName());
                    System.out.printf("%s를 종료합니다.\n", this.getName());
                }

            }
        }

        static class Market {
            int size;
            Map<String, Integer> table;
            Lock lock;

            public Market(int size) {
                this.size = size;
                this.table = new HashMap<>();
                this.lock = new ReentrantLock();
            }

            public synchronized void replenish(String fruit, Integer quantity) {
                this.lock.lock();
                if (this.table.containsKey(fruit)) {
                    this.table.replace(fruit, (Integer) this.table.get(fruit) + quantity);
                } else {
                    this.table.replace(fruit, quantity);
                }
                this.lock.unlock();
                this.notify();
            }

            public synchronized void buy(String fruit, long millis) throws NoSuchObjectException, InterruptedException {
                if (!this.table.containsKey(fruit) || (this.table.get(fruit) == 0)) {
                    System.out.println(fruit + "가 품절되어 기다립니다.");
                    this.wait(millis);
                    if (!this.table.containsKey(fruit) || this.table.get(fruit) == 0) {
                        throw new NoSuchObjectException(fruit + "가 품절입니다.");
                    }
                }
                this.lock.lock();
                this.table.replace(fruit, (Integer) this.table.get(fruit) - 1);
                this.lock.unlock();
            }
            public String toString() {
                StringBuilder line = new StringBuilder();
                Iterator var2 = this.table.keySet().iterator();

                while(var2.hasNext()) {
                    String product = (String)var2.next();
                    line.append(product + " : " + this.table.get(product) + " ");
                }

                return line.toString();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Market market = new Market(10);
            Thread[] producers = {
                    new Thread(new Producer("상인1", market, "apple", 20, 30000)),
                    new Thread(new Producer("상인2", market, "banana", 50, 60000)),
                    new Thread(new Producer("상인3", market, "mango", 30, 40000))};

            Thread[] consumers = {
                    new Thread(new Consumer("고객1", market, new String[]{"apple", "banana"}, 5000, 1000)),
                    new Thread(new Consumer("고객2", market, new String[]{"apple", "mango"}, 10000, 2000)),
                    new Thread(new Consumer("고객3", market, new String[]{"banana", "mango"}, 6000, 3000)),
                    new Thread(new Consumer("고객4", market, new String[]{"apple", "banana", "mango"}, 5000, 2000)),
                    new Thread(new Consumer("고객5", market, new String[]{"apple", "banana", "mango"}, 5000, 3000))};
            for (Thread producer : producers) {
                producer.start();
            }
            for (Thread consumer : consumers) {
                consumer.start();
            }
            while (true) {
                //System.out.println("Market : " + market);
                Thread.sleep(1000);
            }
        }
    }
}


