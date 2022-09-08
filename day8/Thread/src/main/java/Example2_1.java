import java.util.Arrays;
//관리 포인트 줄이면 문제 발생률이 줄어듦
public class Example2_1 {
    static class Task implements Runnable{
        long interval;
        boolean stopFlag;
        public Task(long interval){
            this.stopFlag = false;
            this.interval = interval;
        }

        @Override
        public void run() {
            this.stopFlag = false;
            try{
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 시작");
                while(!this.stopFlag){
                    Thread.sleep(this.interval);
                    System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 동작중");
                    Thread.dumpStack(); //현재 스레드의 스택을 다 dump 해줌
                }
            }catch(InterruptedException e){
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 인터럽트 발생");
            }
            finally {
                this.stopFlag =false;
            }
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 종료");
        }

        public void stop() {
            this.stopFlag = true;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task = new Task(1000);
        Thread taskThread = new Thread(task);

        taskThread.start();

        Thread.sleep(5000);

        task.stop();
        taskThread.join();
    }
}
