public class OutputSocket extends Socket{
    private InputConnector inputConnector;

    public OutputSocket(Node node) {
        super(node);
    }
    public void plug(InputConnector inputConnector){
        this.inputConnector = inputConnector;
    }
    public void unplug(){
        this.inputConnector = null;
    }
    public void put(Message message){
        if(this.inputConnector != null){
            this.inputConnector.put(message);
        }
    }
}
