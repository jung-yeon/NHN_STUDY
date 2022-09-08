import java.awt.image.ImagingOpException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Example6_1 {
    static int remain = 1;
    static class Producer implements Runnable{
        Market market;
        String items;
        long interval;
        boolean stopFlag;
        static Lock locker = new ReentrantLock();
        public Producer(){}
        public Producer(Market market, String items, long interval){
            this.market = market;
            this.items = items;
            this.interval = interval;
        }
        @Override
        public void run() {
            this.stopFlag = false;
            System.out.println(Thread.currentThread().getName() + "을 시작합니다.");
                if (remain < 1) {
                    try {
                        System.out.print("상품이 없습니다.");
                        wait();
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        Thread.sleep(this.getInterval());
                        System.out.println(Thread.currentThread().getName() + "에서 "
                                + this.items + "를 납품합니다.");
                        while (remain != 0) {
                            Thread.sleep(this.getInterval());
                            System.out.println(this.items + "의 재고는 " + remain + "개 입니다.");
                        }
                        System.out.println(this.items + "가 품절되었습니다. 물건을 기다립니다. ");

                    } catch (InterruptedException e) {
                    }
            }
        }



        public boolean isStop(){
            return this.stopFlag = true;
        }

        public long getInterval() {
            return this.interval;
        }
    }
    static class Consumer implements Runnable{
        Market market;
        String[] items;
        long interval;
        long Childinterval;
        boolean buy;
        boolean stopFlag;
        static Lock locker = new ReentrantLock();
        public Consumer(){}
        public Consumer(Market market, String[] items, long interval, long Childinterval){
            this.market = market;
            this.items = items;
            this.interval = interval;
            this.Childinterval = Childinterval;

        }


        //못기다려서 포기하는것이 lock
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "을 시작합니다.");

            if(remain < 1){
                try{
                    locker.lock();
                    Thread.sleep(this.getInterval());
                    System.out.println("구매할 상품이 없습니다.");

                }catch (InterruptedException e){}
            }
            else{
                try{
                    //thread1이 답할때까지 대기
                    Thread.sleep(this.Childinterval);
                    System.out.println(Thread.currentThread().getName() + "에서 "
                            + this.getItem() + "를 구매하길 원합니다.");
                    if(remain > 0){
                        Thread.sleep(this.Childinterval);
                        System.out.println(Thread.currentThread().getName() + "가 "
                                + this.getItem() + "을 구매하였습니다.");
                        remain --;
                    }
                    else{
                        locker.lock();
                        buy = false;
                    }
                }catch (InterruptedException e){}
            }

            //this.thread = null;
        }

        public String getItem() {
            String item = null;
            for (int i = 0; i < this.items.length; i++) {
                item = items[i];
            }
            return item;

        }

        public long getInterval() {
            return this.interval;
        }

}
    static class Market{
        int count;
        public Market(int count){
            this.count = count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Market market = new Market(10);
        Thread producer = new Thread(new Producer(market, "apple", 3000));
        Thread consumer = new Thread(new Consumer(market, new String[]{"apple"}, 1000, 4000));

        producer.start();
        consumer.start();

        while(true){
            Thread.sleep(1000);
        }
    }
}
