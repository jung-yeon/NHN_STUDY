public class PostMessage extends Message{
    private static Integer count = 0;
    private final String id;
    private String receiverID;
    private final long creationTime;
    private Object payload;
    public PostMessage(){
        PostMessage.count++;
        this.id =  String.format("%s@%08d", this.getClass().getSimpleName(),PostMessage.count);
        this.creationTime = System.currentTimeMillis();
    }

    public PostMessage(Object payload){
        //this();
        PostMessage.count++;
        this.id =  String.format("%s", this.getClass().getSimpleName());
        this.creationTime = System.currentTimeMillis();
        this.payload = payload;
    }
    public PostMessage(String id, String ReceiverID, Object payload){
        //this();
        PostMessage.count++;
        this.id =  String.format("%s", this.getClass().getSimpleName());
        this.creationTime = System.currentTimeMillis();
        this.receiverID = ReceiverID;
        this.payload = payload;
    }

    public String getId(){ return this.id; }

    public long getCreationTime() {
        return this.creationTime;
    }
    public Object getPayload(){
        return this.payload;
    }
    public void setPayload(Object payload){ this.payload = payload;}

}
