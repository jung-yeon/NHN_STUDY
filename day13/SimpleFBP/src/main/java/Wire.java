import java.util.NoSuchElementException;

public class Wire implements InputConnector, OutputConnector{
    private static int count = 0;
    private final String id;
    private InputSocket inputSocket;

    private Logger logger;

    public Wire(){
        Wire.count++;
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(),Wire.count);
        this.logger = new Logger(this.getClass().getSimpleName());
    }
    public String getId(){ return this.id; }
    public void connect(InputSocket inputSocket){
        this.inputSocket = inputSocket;
    }
    public void disconnect(InputSocket inputSocket){
        if(this.inputSocket == inputSocket) {
            this.inputSocket = null;
        }else{
            throw new NoSuchElementException();
        }
    }
    public void put(Message message){
        if(this.inputSocket != null){
            this.inputSocket.put(message);
        }
    }
    public Logger getLogger(){
        return this.logger;
    }
}
