import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import java.io.IOException;
//import java.time.Period;
//import java.util.Queue;
//
//public abstract class ActiveNode extends  Node implements Runnable{
//    private Thread thread;
//    private boolean stopped = false;
//    private final PeriodicTimer periodicTimer;
//    //private final Queue<Message> messagesQueue;
//    private long startTime;
//    private long interval;
//
//    public ActiveNode(){
//        this.startTime = System.currentTimeMillis();
//    }
//    public ActiveNode(String name){
//        this.startTime = System.currentTimeMillis();
//    }
//    public void setInterval(long interval){
//        this.interval = interval;
//    }
//    @Override
//    public void run(){
//
//    }
//    public void stop(){ this.thread.interrupt(); }
//    public boolean isStopped(){ return this.stopped; }
//    public void start(){ this.thread.start(); }
//    public void preprocess() throws IOException{}
//    public void synchronized idle() throws InterruptedException{
//        Thread.sleep(this.periodicTimer.getIntervalRemainTime());
//    }
//    public void postprocess() throws IOException {}
//
//    public boolean teminated(){
//        return this.stopped = false;
//    }
//}
public abstract class ActiveNode extends Node implements Runnable{
    private final Thread thread;
    private boolean stopped;
    //private long startTime;
    public long interval;
    Lock lock = new ReentrantLock();

    public ActiveNode(){
        super();
        this.thread = new Thread(this);
        this.stopped = true;
        this.interval = 1000;
    }
    public ActiveNode(String name){
        super(name);
        this.thread = new Thread(this);
        this.stopped = true;
        this.interval = 1000;
    }
    public void setInterval(long interval){
        if (this.isStopped()) {
            this.interval = interval;
        }
    }
    @Override
    public void run(){
        try{
            this.preprocess();
        }catch (IOException e){
            return;
        }
        this.stopped = false;
        while(!this.stopped){
            try{
                this.main();
                this.idle();
            }catch (InterruptedException e) {
                this.getLogger().info("" + e);
                this.stopped = true;
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        this.postprocess();
    }
    public void lock(){this.lock.lock();}

    public void unlock(){this.lock.unlock();}
    public void start(){
        this.thread.start();
    }
    public void stop(){
        this.thread.interrupt();
    }
    public boolean isStopped(){ return this.stopped; }
    protected void preprocess() throws IOException {}
    protected void postprocess(){}

    protected synchronized void main() throws IOException{}
    protected synchronized void idle() throws InterruptedException{
       // Thread.sleep(this.interval);
    }
}
