import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Example6_1 {
    static class Producer implements Runnable {
        Market market;
        String items;
        long interval;

        public Producer(Market market, String items, long interval) {
            this.market = market;
            this.items = items;
            this.interval = interval;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "을 시작합니다.");

            try {
                while (true) {
                    System.out.printf("%s에서 %s를 납품합니다.\n", Thread.currentThread().getName(), this.items);
                    this.market.put(this.items);
                    Thread.sleep(this.interval - (System.currentTimeMillis() - startTime) % this.interval);
                }
            } catch (InterruptedException e) {
                System.out.printf("%s에 인터럽트가 발생하였습니다.\n", Thread.currentThread().getName());
                System.out.printf("%s를 종료합니다.\n", Thread.currentThread().getName());
            }

        }
    }

    static class Consumer implements Runnable {
        Market market;
        String[] items;
        long interval;
        long Childinterval;

        public Consumer(Market market, String[] items, long interval, long Childinterval) {
            this.market = market;
            this.items = (String[]) Arrays.copyOf(items, items.length);
            this.interval = interval;
            this.Childinterval = Childinterval;

        }

        //못기다려서 포기하는것이 lock
        @Override
        public void run() {
            Random random = new Random();
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "을(를) 시작합니다.");
            try {
                while (true) {
                    String item = this.items[random.nextInt(this.items.length)];
                    try {
                        System.out.println(Thread.currentThread().getName() + "에서 "
                                + item + "(을)를 구매하길 원합니다.");
                        this.market.get(item);
                        System.out.println(Thread.currentThread().getName() + "가 "
                                + item + "(을)를 구매하였습니다.");

                    } catch (NoSuchObjectException e) {
                        System.out.println(item + "(아)가 품절되었습니다. 물건을 기다립니다.");
                        this.market.WaitForStock();
                        System.out.println(item + "의 재고가 추가되었습니다.");
                    }
                    Thread.sleep(this.interval + (long) (Math.random() * (double) (this.Childinterval - this.interval)));
                }
            } catch (InterruptedException e) {
                System.out.printf("%s에 인터럽트가 발생하였습니다.\n", Thread.currentThread().getName());
                System.out.printf("%s를 종료합니다.\n", Thread.currentThread().getName());
            }
        }
    }

        static class Market {
            int size;
            Map<String, Integer> table;
            Lock lock;

            public Market(int size) {
                this.size = size;
                this.table = new HashMap();
                this.lock = new ReentrantLock();
            }

            public synchronized void put(String fruit) {
                this.lock.lock();//lock을 걸어주면 꼭 풀어줘야 진행이 된다. lock은 조심히 다뤄줘야함.
                int stock = 0;
                if (this.table.containsKey(fruit)) {
                    stock = (Integer) this.table.get(fruit) + 1;
                    this.table.replace(fruit, stock);
                } else {
                    stock = 1;
                    this.table.put(fruit, 1);
                }

                System.out.printf("%s의 재고는 %d개 입니다.\n", fruit, stock);
                this.lock.unlock();
                this.notify();
            }


            public synchronized void get(String fruit) throws NoSuchObjectException {
                try {
                    this.lock.lock();
                    if (!this.table.containsKey(fruit) || this.table.get(fruit) == 0) {
                        throw new NoSuchObjectException(fruit + "가 품절되었습니다. 물건을 기다립니다.\n");
                    }
                    int stock = (Integer) this.table.get(fruit) - 1;
                    this.table.replace(fruit, stock);
                    System.out.printf("%s의 재고는 %d개 입니다.\n", fruit, stock);
                } catch (Exception e) {
                    throw e;
                } finally {
                    this.lock.unlock();
                }
            }

            public synchronized void WaitForStock() throws InterruptedException {
                this.wait();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Market market = new Market(10);
            Thread producer = new Thread(new Producer(market, "apple", 3000));
            Thread consumer = new Thread(new Consumer(market, new String[]{"apple"}, 1000, 4000));

            producer.start();
            consumer.start();

            while (true) {
                Thread.sleep(1000);
            }
        }
    }



/*

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
// 교수님 코드
//

import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example6_1 {
    public Example6_1() {
    }

    public static void main(String[] args) throws InterruptedException {
        Market market = new Market(10);
        Thread producer = new Thread(new Producer(market, "apple", 3000L));
        Thread consumer = new Thread(new Consumer(market, new String[]{"apple"}, 1000L, 4000L));
        producer.start();
        consumer.start();

        while(true) {
            Thread.sleep(1000L);
        }
    }

    static class Market {
        int size;
        Map<String, Integer> table;
        Lock lock;

        public Market(int size) {
            this.size = size;
            this.table = new HashMap();
            this.lock = new ReentrantLock();
        }

        public synchronized void put(String fruit) {
            this.lock.lock();
            //int stock = false;
            int stock;
            if (this.table.containsKey(fruit)) {
                stock = (Integer)this.table.get(fruit) + 1;
                this.table.replace(fruit, stock);
            } else {
                stock = 1;
                this.table.put(fruit, 1);
            }

            System.out.printf("%s의 제고는 %d개 입니다.\n", fruit, stock);
            this.lock.unlock();
            this.notify();
        }

        public synchronized void get(String fruit) throws NoSuchObjectException {
            try {
                this.lock.lock();
                if (!this.table.containsKey(fruit) || (Integer)this.table.get(fruit) == 0) {
                    throw new NoSuchObjectException(fruit + "은 품절입니다.");
                }

                int stock = (Integer)this.table.get(fruit) - 1;
                this.table.replace(fruit, stock);
                System.out.printf("%s의 제고는 %d개 입니다.\n", fruit, stock);
            } catch (Exception var6) {
                throw var6;
            } finally {
                this.lock.unlock();
            }

        }

        public synchronized void waitingForStock() throws InterruptedException {
            this.wait();
        }

        public String toString() {
            StringBuilder line = new StringBuilder();
            Iterator var2 = this.table.keySet().iterator();

            while(var2.hasNext()) {
                String fruit = (String)var2.next();
                line.append(fruit + " : " + this.table.get(fruit) + " ");
            }

            return line.toString();
        }
    }

    static class Consumer implements Runnable {
        Market market;
        String[] fruits;
        long minInterval;
        long maxInterval;

        public Consumer(Market market, String[] fruits, long minInterval, long maxInterval) {
            this.market = market;
            this.minInterval = minInterval;
            this.maxInterval = maxInterval;
            this.fruits = (String[])Arrays.copyOf(fruits, fruits.length);
        }

        public void run() {
            Random random = new Random();
            long startTime = System.currentTimeMillis();
            System.out.printf("%s를 시작합니다.\n", Thread.currentThread().getName());

            try {
                while(true) {
                    String fruit = this.fruits[random.nextInt(this.fruits.length)];

                    try {
                        System.out.printf("%s가 %s를 구매하길 원합니다.\n", Thread.currentThread().getName(), fruit);
                        this.market.get(fruit);
                        System.out.printf("%s가 %s를 구매하였습니다.\n", Thread.currentThread().getName(), fruit);
                    } catch (NoSuchObjectException var6) {
                        System.out.printf("%s가 품절되었습니다. 물건을 기다립니다.\n", fruit);
                        this.market.waitingForStock();
                        System.out.printf("%s가 제고가 추가되었습니다.\n", fruit);
                    }

                    Thread.sleep(this.minInterval + (long)(Math.random() * (double)(this.maxInterval - this.minInterval)));
                }
            } catch (InterruptedException var7) {
                System.out.printf("%s에 인터럽트가 발생했습니다.\n", Thread.currentThread().getName());
                System.out.printf("%s를 종료합니다.\n", Thread.currentThread().getName());
            }
        }
    }

    static class Producer implements Runnable {
        Market market;
        String fruit;
        long interval;

        public Producer(Market market, String fruit, long interval) {
            this.market = market;
            this.fruit = fruit;
            this.interval = interval;
        }

        public void run() {
            long startTime = System.currentTimeMillis();
            System.out.printf("%s를 시작합니다.\n", Thread.currentThread().getName());

            try {
                while(true) {
                    System.out.printf("%s에서 %s를 납품합니다.\n", Thread.currentThread().getName(), this.fruit);
                    this.market.put(this.fruit);
                    Thread.sleep(this.interval - (System.currentTimeMillis() - startTime) % this.interval);
                }
            } catch (InterruptedException var4) {
                System.out.printf("%s에 인터럽트가 발생했습니다.\n", Thread.currentThread().getName());
                System.out.printf("%s를 종료합니다.\n", Thread.currentThread().getName());
            }
        }
    }
}*/

