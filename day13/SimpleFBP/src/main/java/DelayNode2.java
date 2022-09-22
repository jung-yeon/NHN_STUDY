public class DelayNode2 extends InputOutputNode2{
    private int delay;
    public DelayNode2(){
        super();
        this.delay = 100;
    }
    public DelayNode2(int delay){
        super(1,delay);
        this.delay = delay;
    }
    public DelayNode2(int outputCount, int delay){
        super(1,outputCount);
        this.delay = delay;
    }
    @Override
    public synchronized void main(){
        InputPort port = this.getInputPort(0);
        if(port.hasMessage()){
            try{
                Thread.sleep(this.delay);
            }catch (InterruptedException e){

            }
            Object value = port.get().getPayload();
            this.getLogger().info(" " + value);
            this.output(new Message(value));
        }
    }
}
