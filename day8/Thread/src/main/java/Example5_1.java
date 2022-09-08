//두 객체를 동기화 시켜라
//lock을 이용하여 동기화 시키기
/*
 * lock() : Lock을 얻어온다.
 * unlock() : Lock을 해제 한다.
 * tryLock() : 일정시간을 기다리던가 아니면 지금 즉시 상태를 확인하고 true, false를 return 한다. true인경우 Lock을 얻는다.
 * isHeldByCurrentThread() : 현재 Thread가 Lock을 얻었는가?
 * hasQueuedThreads() : 해당 객체의 Lock을 얻기위해 기다리는 Threads가 있는가?
 * getOwner() :  지금 Lock을 갖고 있는 Thread를 Return 한다.
 */
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Example5_1 {
    static class Task extends Thread{
        long interval;
        private Lock lock = new ReentrantLock();
        public Task(long interval){
            this.interval = interval;
        }
        public void run(){
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;
            while(true){
                try{
                    lock.lock();
                    //Thread.sleep(this.interval);
                    Thread.sleep(this.interval - (System.currentTimeMillis() - startTime) % this.interval);
                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60, totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000, Thread.currentThread().getName());
                    previousPrintTime = totalElapsedTime;
                    lock.unlock();
                }catch (Exception e){

                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(3000);
        Task task2 = new Task(5000);

        task1.start();
        task2.start();

        task1.join();
    }
}

//static 이용한 Lock

/*

import java.time.LocalDateTime;
        import java.util.concurrent.TimeUnit;
        import java.util.concurrent.locks.Condition;
        import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;
public class Example5_1 {
    static class Task extends Thread{
        long interval;
        static Lock locker = new ReentrantLock();

        public Task(long interval){
            this.interval = interval;
        }
        public void run(){
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;
            while(true){
                try{
                    locker.lock();
                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60, totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000, Thread.currentThread().getName());
                    previousPrintTime = totalElapsedTime;

                    Thread.sleep(this.interval);
                    locker.unlock();
                    Thread.yield(); //yield()??
                }catch (InterruptedException e){
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(3000);
        Task task2 = new Task(5000);

        task1.start();
        task2.start();

        task1.join();
    }
}*/