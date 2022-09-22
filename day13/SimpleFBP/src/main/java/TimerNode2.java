public class TimerNode2 extends InputNode2{
    private long interval;
    private String name;
    Thread thread;
    public long startTime;
    public TimerNode2(String name, long interval){
        super(name, (int) interval); //임의로
        this.interval = interval;
        this.thread = new Thread();
        this.startTime = System.currentTimeMillis();
    }
    public synchronized void main(){
        try{
            thread.start();
            this.setInterval(this.interval);
            thread.sleep(this.interval);
            thread.interrupt();

        }catch (Exception e){

        }
    }
}
