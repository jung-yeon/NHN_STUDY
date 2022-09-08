import java.util.TreeMap;

public class Example1_3 {
    static class Task extends Thread{
        long interval;
        public Task(long interval) {
            this.interval = interval;
        }
        public void run(){
            try {
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 을 시작합니다.");
                while(true){
                    Thread.sleep(this.interval);
                    System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 동작중 ");
                }

            } catch (InterruptedException e) {
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 인터럽트 발생 ");
            }
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 을 종료합니다. ");
        }
//        public void stop2(){
//            this.currentThread().interrupt();
//        }
    }
    public static void main(String[] args) throws InterruptedException{
        Task task = new Task(1000);

        task.start();
        Thread.sleep(5000);
        task.interrupt();

        task.join();
        //task 스레드의 실행이 완료될 때 까지 main()은 더 이상 진행을 하지 않는다.
        //만약 join을 해주지 않는다면 main이 실행하는 속도가 빠르면 main이 먼저 실행되어버림
    }
}
