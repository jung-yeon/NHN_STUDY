import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class MessageServer{
    private static MessageServer globalServer;
    Lock locker = new ReentrantLock();
    InputNode inputNode;

    public MessageServer(){
    }
    Queue<PostMessage> postMessageQueue = new LinkedList();
    private PostMessage message;

    public static MessageServer getGlobalServer() {
        return MessageServer.globalServer;
    }
    public void postMessage(PostMessage message){
        this.locker.lock();
        this.postMessageQueue.add(message);
        this.locker.unlock();
    }
    public void main() throws IOException {

    }

    public void connect(InputOutputNode2 inputOutputNode2) {

    }
}
