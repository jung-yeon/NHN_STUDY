public class Example1_2 {
    static class Task extends Thread{
        long interval;
        boolean stopFlag;
        public Task(long interval){
            this.stopFlag = false;
            this.interval = interval;
        }
        public void run(){
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 을 시작합니다.");
                try{
                    while(!this.stopFlag){
                        Thread.sleep(this.interval);
                        System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 동작중 ");
                    }

                }catch (InterruptedException e){
                    System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 인터럽트 발생 ");
                }finally {
                    this.stopFlag = false;
                }
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 을 종료합니다. ");
        }

        public void stop2() {
            this.stopFlag = true;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task = new Task(1000);

        task.start();
        Thread.sleep(5000);
        task.stop2();
        task.join();
    }
}
