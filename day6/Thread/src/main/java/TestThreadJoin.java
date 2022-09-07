import java.time.LocalDateTime;

public class TestThreadJoin {
    public static class Task implements Runnable{
        String name;
        int loopCount;
        int maxLoopCount;
        int interval;

        public Task(String name, int interval, int maxLoopCount){
            this.name = name;
            this.interval = interval;
            this.maxLoopCount = maxLoopCount;
        }
        public String getName(){
            return this.name;
        }
        public int getInterval(){
            return this.interval;
        }
        public int getMaxLoopCount(){
            return this.maxLoopCount;
        }
        public int getLoopCount(){
            return this.loopCount;
        }
        public void incrementLoopCount(){
            ++this.loopCount;
        }
        @Override
        public void run() {
            System.out.printf("[ %s ] : %s이 시작 되었습니다.\n", LocalDateTime.now(), this.getName());
            try{
                while(this.getLoopCount() < this.getMaxLoopCount()){
                    Thread.sleep(this.getInterval());
                    this.incrementLoopCount();
                    System.out.printf("[ %s ] : %s이 %d번째 실행되었습니다.\n", LocalDateTime.now(), this.getName(), this.getLoopCount());
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.printf("[ %s ] : %s이 종료 되었습니다.\n", LocalDateTime.now(), this.getName());
        }
    }
    //join() : 호출한 스레드가 종료될때까지 기다린다.
    //join(long mills) : 호출한 스레드를 지정된 시간동안만 기다린다. 대기 시간은 밀리초 단위로 제어한다.
    //join(long mills, int nanos) : 호출한 스레드를 지정된 시간동안 기다린다. 대기 시간은 나노초 단위로 제어한다.
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Task("one", 1000, 3));

        System.out.printf("[ %s ] :  main에서 스레드를 시작시킵니다.\n", LocalDateTime.now());
        thread.start();
        System.out.printf("[ %s ] : main에서 스레드가 종료되길 기다립니다.\n", LocalDateTime.now());
        thread.join();
        System.out.printf("[ %s ] : %s가 종료 되었습니다.\n", LocalDateTime.now(), Thread.currentThread().getName());
    }
}
