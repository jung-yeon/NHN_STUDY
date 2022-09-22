public class ReplicationNode2 extends InputOutputNode2 {
    //    ClockNode2 clockNode2;
    public ReplicationNode2(String name) {
        super(name);
    }
    @Override
    public synchronized void main() {
        for(int i = 0; i < getInputPortCount(); i++){
            if( this.getInputPort(i) != null && this.getInputPort(i).hasMessage()){
                Object value = this.getInputPort(i).get().getPayload();
                this.output(new Message(value));
                this.getLogger().info(" [ " + this.name + " ] " + "" + value);
                this.getInputPort(i).remove();
            }
        }
    }
}
