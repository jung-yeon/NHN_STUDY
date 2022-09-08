//스레드안에서 스레드생성하기

public class Example3_2 {
    static class Task implements Runnable{
        long interval;
        boolean stopFlag;
        Thread thread;
        Task Childtask;
        //long interval2;

        public Task(long interval) {
            this.stopFlag = false;
            this.interval = interval;
            this.thread = new Thread(this); //this - 자기 객체를 가지고 있다.
        }
        public Task(long interval, long childinterval){

            this.stopFlag = false;
            this.interval = interval;
            this.thread = new Thread(this); //this - 자기 객체를 가지고 있다.
            //this.thread = new Thread(new Task(this.interval));
            if(childinterval != 0){
                this.Childtask = new Task(childinterval);
                this.Childtask.setDaemon(true);
            }
        }

        @Override
        public void run(){
            if(this.Childtask != null){
                //this.task = new Task(childInterval);
                this.Childtask.start();
            }
            this.stopFlag = false;
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 시작");

                while(!this.stopFlag){
                    //Thread를 thread로 바꿔도 같은 결과나옴(run()에 다 해당)
                    try{
                        //Thread를 thread로 바꾸고 this.getInterval()을 this.interval로 바꿔도 같은 결과
                        Thread.sleep(this.getInterval());
                        System.out.println("스레드 [ " + Thread.currentThread().getName() + " ( " + Thread.currentThread().isDaemon() + " ) " +  " ] 동작중");
                    }catch(InterruptedException e){
                        System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 인터럽트 발생");
                    }
                }
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 종료");


            //runnable과 관계를 끊는다.
            this.thread = null;
        }
        public void stop2(){ this.stopFlag = true; }

        public long getInterval(){  return this.interval; }
        public void start() {
            this.thread.start();
        }

        public void join() throws InterruptedException {
            this.thread.join();
        }
        public void setDaemon(boolean on){
            this.thread.setDaemon(on);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task = new Task(2000,1000);
        task.start();
        Thread.sleep(10000);
        task.stop2();
        task.join();

    }
}
