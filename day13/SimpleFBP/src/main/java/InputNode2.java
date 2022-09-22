public abstract class InputNode2 extends ActiveNode{

    private final InputPort[] peerInputPorts;
    protected InputNode2(String name, int count){
        super(name);
        this.peerInputPorts = new InputPort[count];
    }
    public String getName(){
        return this.getClass().getSimpleName();
    }
    protected InputNode2(int count){
        super();
        this.peerInputPorts = new InputPort[count];
    }

    public void connect(int index, InputPort port){
        if(index < this.peerInputPorts.length){
            this.peerInputPorts[index] = port;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void output(Message message){
//        for(int i = 0; i < peerInputPorts.length; i++){
//            if(peerInputPorts[i] != null){
//                peerInputPorts[i].put(message);
//            }
//        }
        for(InputPort port : this.peerInputPorts){
            if(port != null){
                port.put(message);
            }
        }
    }
}
