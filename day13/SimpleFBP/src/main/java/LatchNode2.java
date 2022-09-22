public class LatchNode2 extends InputOutputNode2 {
    protected double count;

    protected LatchNode2(String name, int count) {
        super(name, 2);
        this.count = count;

    }

    @Override
    public void main() {
        this.output(new Message(this.count));
        this.getInputPort(0).remove();
        //처음엔 주어진 count값 주고 업데이트 되어가는 형식
//        for (int i = 0; i < this.getInputPortCount(); i++) {
//            if (this.getInputPort(i) != null && this.getInputPort(i).hasMessage()) {
//                Object value = this.getInputPort(i).get().getPayload();
//                this.output(new Message(value));
//                this.getInputPort(i).remove();
//                this.getLogger().info("[ " + this.name + " ] " + "" + value);
//            }
//        }
        if(this.getInputPort(1) != null && this.getInputPort(1).hasMessage()){
            Object value = this.getInputPort(1).get().getPayload();
            this.output(new Message(value));
            this.count = (double) value;
            this.getInputPort(1).remove();
            this.getLogger().info("[ " + this.name + " ] " + "" + value);
        }
    }
}
