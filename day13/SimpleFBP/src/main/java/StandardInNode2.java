import java.io.OptionalDataException;
import java.util.Scanner;

public class StandardInNode2 extends InputNode2{
    Scanner scanner;
    Message message;
    private int count;

    protected StandardInNode2(int count) {
        super(count);
        this.count = count;
        scanner = new Scanner(System.in);
    }
    @Override
    public synchronized void main(){
        String message2 = this.scanner.nextLine();
        this.message = new Message(message2);
        this.output(message);
    }
}
