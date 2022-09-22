import java.util.Queue;

public class InputNode extends ActiveNode{
    public ActiveNode node;
    private OutputSocket [] outputSockets;
    protected InputNode(int count){
        //this.outputSockets[count] = node;
    }
    public void connect(){}
    public int getOutputSocketCount(){
        return this.outputSockets.length;
    }
    public OutputSocket getOutputSocket(int index){
        return outputSockets[index];
    }
    public void output(Message message){}
}
