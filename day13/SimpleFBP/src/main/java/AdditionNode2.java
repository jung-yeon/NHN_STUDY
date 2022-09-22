public class AdditionNode2 extends InputOutputNode2{
    Message message;
    protected int count;
    protected String name;
    ClockNode2 clockNode2;


    public AdditionNode2(){
        super(2, 1);
    }
    public AdditionNode2(String name){
        super(2, 1);
        this.name = name;
    }

    Double sum = 0.0;
    public void main() {
        for (int i = 0; i < this.getInputPortCount(); i++) {
            while (this.getInputPort(i) != null && this.getInputPort(i).hasMessage()) {
                sum += (Double) this.getInputPort(i).get().getPayload();
                this.getInputPort(i).remove();
            }
        }
        this.getLogger().info("" + sum);
        this.message = new Message(sum);
        this.output(message);
    }

    public void connectOutput(int index, Wire wire) {
//        wire.connect();
        wire.put(new Message(message));
    }
    public void connectInput(int i, Wire wire) {
        while (this.getInputPort(i) != null && this.getInputPort(i).hasMessage()) {
            sum += (Double) this.getInputPort(i).get().getPayload();
            this.getInputPort(i).remove();
        }
        this.getLogger().info("" + sum);
        this.message = new Message(sum);
    }

    public void setTract(Object o) {
    }
}
