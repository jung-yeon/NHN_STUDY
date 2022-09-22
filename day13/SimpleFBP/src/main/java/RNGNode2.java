import java.util.Scanner;

public class RNGNode2 extends InputNode2{
    private int num;
    Message message;
    private int count;
    protected RNGNode2(int count) {
        super(count);
        this.count = count;
    }
    @Override
    public synchronized void main(){
        this.message = new Message(this.count);
        this.output(message);
    }

    public void connectOutput(int i, Wire wire1) {

    }
}

