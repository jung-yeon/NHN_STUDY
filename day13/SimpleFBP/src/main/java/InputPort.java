import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InputPort{
    Node node;
    Queue<Message> messageQueue;
    Lock locker;

    public InputPort(Node node){
        this.node = node;
        this.messageQueue = new LinkedList<>();
        this.locker = new ReentrantLock();
    }
    public void put(Message message){
        this.locker.lock();
        this.messageQueue.add(message);
        this.locker.unlock();
    }
    public boolean hasMessage(){
        return !this.messageQueue.isEmpty();
    }
    public Message get(){
        Message message;
        this.locker.lock();
        message = this.messageQueue.poll();
        this.locker.unlock();
        return message;
    }
    public void remove(){
        this.locker.lock();
        this.messageQueue.poll();
        this.locker.unlock();
    }
}
