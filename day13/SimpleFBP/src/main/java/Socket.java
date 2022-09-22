public class Socket {
    public static int count = 0;
    private String id;
    protected Node node;
    private Logger logger;

    public Socket(Node node){
        Socket.count++;
        this.id = String.format("%s@%08d",this.getClass().getSimpleName(),Socket.count);
        this.node = node;
    }
    public String getId(){ return this.id; }
    public Logger getLogger(){ return this.logger; }
}