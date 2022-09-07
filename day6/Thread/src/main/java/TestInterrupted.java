public class TestInterrupted {
    static class Task extends Thread{
        public void run(){
            System.out.println("Started");
            try{
                while(true){
                    System.out.println("Running");
                    Thread.sleep(4000);
                }
            }catch (InterruptedException e){
                System.out.println("Interrupt occurred!");
            }
            System.out.println("Finished!");
        }
    }

    public static void main(String[] args){
        Thread thread = new Task();
        thread.start();
        //Thread.sleep(3000); //throw InterruptedException 사용해야함
        try{
            Thread.sleep(1000);
//            Thread.sleep((long) (Math.random() * 3000));
        }catch (InterruptedException e){
        }
        thread.interrupt();
    }
}
