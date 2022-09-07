import java.time.LocalDateTime;
public class TestSynchronizedCounter {
    static class SynchronizedCounter{
        private static int count = 0;

        public synchronized void increment() throws InterruptedException{
            System.out.printf("[ %s ] : %s - 들어가기\n", LocalDateTime.now(), Thread.currentThread().getName());
            this.count++;
            System.out.printf("[ %s ] : %s - count : %d\n", LocalDateTime.now(), Thread.currentThread().getName(), this.count);
            Thread.sleep(1000);
            System.out.printf("[ %s ] : %s - 나오기\n", LocalDateTime.now(), Thread.currentThread().getName());
        }
        public synchronized void decrement(){
            count--;
        }
        public synchronized int value(){
            return count;
        }
        public String toString(){
            return String.valueOf(this.count);
        }
    }
    static class CountBox extends Thread{
        SynchronizedCounter counter;
        public CountBox(){
            this.counter = new SynchronizedCounter();
        }
        @Override
        public void run(){
            while(true){
                try{
                    this.counter.increment();
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        CountBox cb1 = new CountBox();
        CountBox cb2 = new CountBox();

        cb1.start();
        cb2.start();
    }
}
//동작이 생각했던 것과 같지 않은 이유
// synchronized 키워드를 사용하더라도 실제로 synchronized가 적용되는 객체가 다를경우에는 별개의 동기화 구간으로 취급된다
