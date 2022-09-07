import java.time.LocalDateTime;
/*
 * synchronized가 정상적으로 적용되기 위해서는 아래의 조건이 필요하다
 * - 동기화 메소드가 포함되어 있는 객체가 동일할 것
 * - 동기화 메소드가 정적 메소드일 것
 */
public class TestSynchronizedCounter2 {
    static class SynchronizedCounter{
        private  static int count = 0;
        public synchronized void increment() throws InterruptedException{
            System.out.printf("[ %s ] : %s - 들어가기\n", LocalDateTime.now(), Thread.currentThread().getName());
            this.count++;
            System.out.printf("[ %s ] : %s - count : %d\n",
                    LocalDateTime.now(), Thread.currentThread().getName(), this.count);
            Thread.sleep(1000);
            System.out.printf("[ %s ] : %s - 나오기\n", LocalDateTime.now(), Thread.currentThread().getName());
        }
        public synchronized void decrement(){
            count--;
        }
        /*
        //동기화 코드 부분이 정적 메소드로 되어있다
        public synchronized static void decrement(SynchronizedCounter counter){
            counter.count--;
        }*/
        public synchronized int value(){
            return count;
        }
        public String toString(){
            return String.valueOf(this.count);
        }
    }
    static class CountBox extends Thread{
        SynchronizedCounter counter;
        public CountBox(SynchronizedCounter counter){
            this.counter = counter;
        }
        //정적 메소드
        /*public CountBox(){
            this.counter = new SynchronizedCounter();
        }*/
        @Override
        public void run(){
            while(true){
                try{
                    //정적메소드로 했을 때 실행
                    /*
                    this.counter.increment(this.counter);
                     */
                    this.counter.increment();
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        CountBox cb1 = new CountBox(counter);
        CountBox cb2 = new CountBox(counter);

        cb1.start();
        cb2.start();
    }
}
