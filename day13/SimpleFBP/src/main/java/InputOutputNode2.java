import java.util.function.BiConsumer;

public class InputOutputNode2 extends ActiveNode{
    private final InputPort[] inputPorts;
    private final InputPort[] outputPorts;

    protected String name;
    private BiConsumer<String, Object> trace;

    protected  InputOutputNode2(){
        this.inputPorts = new InputPort[1]; //!!!
        this.outputPorts = new InputPort[1]; //!!!
    }

    protected InputOutputNode2(int inputCount, int outputCount){
        this.inputPorts = new InputPort[inputCount];
        this.outputPorts = new InputPort[outputCount];

        for(int i = 0; i < inputCount; i++){
            this.inputPorts[i] = new InputPort(this);
        }
//        for(int i = 0; i < outputCount; i++){
//            this.peerInputPorts[i] = new InputPort(this);
//        }
    }

    public InputOutputNode2(String name,int count) {
        this.name = name;
        this.inputPorts = new InputPort[count];
        this.outputPorts = new InputPort[1];
        for(int i = 0; i < count; i++){
            this.inputPorts[i] = new InputPort(this);
        }
    }
    public InputOutputNode2(String name) {
        this.name = name;
        this.inputPorts = new InputPort[2]; //!!!
        this.outputPorts = new InputPort[2]; //!!!

        for(int i = 0; i < 2; i++){
            this.inputPorts[i] = new InputPort(this);
        }
    }


    public void connect(int index, InputPort port){
        if(index < this.outputPorts.length){
            this.outputPorts[index] = port;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void output(Message message){
        for(InputPort port : this.outputPorts){
            if(port != null){
                port.put(message);
            }
        }
        if(this.trace != null){
            this.trace.accept(this.getId(), message.getPayload());
        }
    }
//    public int getInputSocketCount(){ return this.inputSockets.length;}
//    public InputSocket getInputSocket(int index){
//        if(index < this.inputSockets.length){
//            return this.inputSockets[index];
//        }else{
//            throw new IndexOutOfBoundsException();
//        }
//    }

    public int getInputPortCount(){
        return this.inputPorts.length;
    }

    public InputPort getInputPort(int index){
        if(index < this.inputPorts.length){
            return this.inputPorts[index];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void setTract(BiConsumer<String, Object> trace) {
        this.trace = trace;
    }
}

