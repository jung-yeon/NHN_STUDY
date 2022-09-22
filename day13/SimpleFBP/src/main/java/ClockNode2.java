public class ClockNode2 extends TimerNode2{
    private  String name;
    private int count;
    private long interval;
    protected ClockNode2(String name, long interval) {
        super(name, (int)interval);
        this.name = name;
        this.interval = interval;
        this.count = 1;
    }
    public long getInterval(){
        return this.interval;
    }
    @Override
    public void main(){
        this.lock();
        if(this.interval != 0){
            this.setInterval(this.interval);
            this.output(new Message());
        }
        this.unlock();
    }
}
