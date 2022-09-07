import java.util.concurrent.locks.*;  //동시성을 보장하는 다양한 컬렉션을 제공
import java.time.LocalDateTime;
/*
 * ReadwriteLock의 경우에는 읽기때에는 동시에 여러 스레드가 읽을 수 있도록 락을 유지하고
 * 쓸때는 하나의 스레드만 접근할 수 있도록 만든 락 (ReentrantLock과 기본적인 동작과 개념은 유의함)
 * synchronized - 암묵적인 락
 * ReentrantLock- 명시적인 락
 */
/*public class TestFour {
    class Locks{
        private int count = 0;
        private Lock lock = new Lock;
        public int increment() throws InterruptedException {
            System.out.printf("[ %s ] : %s - 들어가기\n", LocalDateTime.now(), Thread.currentThread().getName());
            lock.lock();
            int newCount = ++count;
            System.out.printf("[ %s ] : %s - count : %d\n", LocalDateTime.now(), Thread.currentThread().getName(),newCount);
            lock.unlock();
            System.out.printf("[ %s ] : %s - 나오기\n", LocalDateTime.now(), Thread.currentThread().getName());
            return newCount;
        }
        public int decrement() throws InterruptedException {
            lock.lock();
            --count;
            lock.unlock();
            return count;
        }
    }
}
class Lock{
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }

    public static void main(String[] args) {
        //TestFour
    }
}*/
//if) synchronized에서 increment메소드를 1번 스레드가 쓰고 있다면 2번 스레드는 접근할 수 없고
// 하나의 동시객체로 인식하게 된다.
// 그렇다면 lock은?
/*
 * lock() : Lock을 얻어온다.
 * unlock() : Lock을 해제 한다.
 * tryLock() : 일정시간을 기다리던가 아니면 지금 즉시 상태를 확인하고 true, false를 return 한다. true인경우 Lock을 얻는다.
 * isHeldByCurrentThread() : 현재 Thread가 Lock을 얻었는가?
 * hasQueuedThreads() : 해당 객체의 Lock을 얻기위해 기다리는 Threads가 있는가?
 * getOwner() :  지금 Lock을 갖고 있는 Thread를 Return 한다.
 */