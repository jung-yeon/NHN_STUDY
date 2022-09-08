public class Example1_1 {
    static class Task extends Thread{
        //private int time = 0;
        long interval;
        /*public Task(int time){
            this.time = time;
        }*/
        public Task(long interval){
            this.interval = interval;
        }
        public void run(){
            while(true) {
                try {
                    Thread.sleep(this.interval);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task1 = new Task(2000);
        Task task2 = new Task(3000);

        task1.start();
        task2.start();

        for(int i = 0; i < 100; i++){
            System.out.printf("%s - %s\n", task1.getState(), task2.getState());
            Thread.sleep(1000);
        }
    }
}
