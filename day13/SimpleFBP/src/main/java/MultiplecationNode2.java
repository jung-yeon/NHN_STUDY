public class MultiplecationNode2 extends InputOutputNode2{
    Message message;
    public MultiplecationNode2(){
        super(2,1);
    }
    public MultiplecationNode2(int inputCount, int outputCount){
        super(inputCount, outputCount);
    }
    @Override
    public void main(){
        int result = 1;
        for (int i = 0; i < this.getInputPortCount(); i++) {    //this.getInputPortCount() => 2
            System.out.println(getInputPort(i));
            while (this.getInputPort(i) != null && this.getInputPort(i).hasMessage()) { //this.getInputPort(i) != null => true
                result *= (Integer) this.getInputPort(i).get().getPayload();
                this.getInputPort(i).remove();
            }
        }
        this.message = new Message(result);
        this.output(message);
    }

    public void connectOutput(int index, Wire wire) {
        this.output(message);
    }
    int result = 1;
    public void connectInput(int i, Wire wire) {

        while (this.getInputPort(i) != null && this.getInputPort(i).hasMessage()) { //this.getInputPort(i) != null => true
            result *= (Integer) this.getInputPort(i).get().getPayload();
            this.getInputPort(i).remove();
        }
        this.message = new Message(result);
    }


}
