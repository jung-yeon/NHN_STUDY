public class Message {
    private static Integer count = 0;
    private final String id;
    private final long creationTime;
    private Object payload;
    public Message(){
        Message.count++;
        this.id =  String.format("%s@%08d", this.getClass().getSimpleName(),Message.count);
        this.creationTime = System.currentTimeMillis();
    }

    public Message(Object payload){
        //this();
        Message.count++;
        this.id =  String.format("%s", this.getClass().getSimpleName());
        this.creationTime = System.currentTimeMillis();
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
