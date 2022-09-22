import java.util.Queue;

public class InputSocket extends Socket{
    private OutputConnector outputConnector;
    private Queue<Message> messageQueue;
    public InputSocket(Node node) {
        super(node);
    }
    public void plug(OutputConnector outputConnector){
        this.outputConnector = outputConnector;
        this.outputConnector.connect(this);
    }
    public void unplug(){
        this.outputConnector = null;
    }
    public int getMessageCount(){
        return this.count;
    }
    public void put(Message message) {
        this.messageQueue.add(message);
    }
}
