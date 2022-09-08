public class Example2_2 {
    static class Task implements Runnable{
        long interval;
        boolean stopFlag;
        Thread thread;
        public Task(long interval){
            this.stopFlag = false;
            this.interval = interval;
            this.thread = new Thread(this); //this - 자기 객체를 가지고 있다.
            //this.thread = new Thread(new Task(this.interval));
        }

        @Override
        public void run(){
            this.stopFlag = false;
            try{
                //Thread를 thread로 바꿔도 같은 결과나옴(run()에 다 해당)
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 시작");
                while(!this.stopFlag){
                    //Thread를 thread로 바꾸고 this.getInterval()을 this.interval로 바꿔도 같은 결과
                    Thread.sleep(this.getInterval());
                    System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 동작중");
                }
            }catch(InterruptedException e){
                System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 인터럽트 발생");
            }
            finally {
                this.stopFlag =false;
            }
            System.out.println("스레드 [ " + Thread.currentThread().getName() + " ] 종료");
            //runnable과 관계를 끊는다.
            this.thread = null;
        }
        public void stop(){ this.stopFlag = true; }

        public long getInterval(){  return this.interval; }
        public void start() {
            this.thread.start();
        }

        public void join() throws InterruptedException {
            this.thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task = new Task(1000);
        task.start();
        Thread.sleep(5000);
        task.stop();
        task.join();
    }
}
