//import java.util.HashMap;
//import java.util.Map;
//import java.util.NoSuchElementException;
//public abstract class Node {
//    private static Integer count = 0;
//    private final String id;    //final은 생성할 때만 생성가능
//    private String name;
//    private final Logger logger;
//    private static final Map<String, Node> nodes = new HashMap<>();
//    //private static Node nodes;
////    private Map map;
//
//    protected Node(){
//        ++Node.count;
//        this.id = String.format("%s@%08d", this.getClass().getSimpleName(),Node.count);
//        this.name = this.getClass().getSimpleName();
//        this.logger = new Logger(this.name);
//        Node.nodes.put(this.id, this);
//    }
//
//
//    protected Node(String name) {
//        ++Node.count;
//        this.id = String.format("%s@%08d", this.getClass().getSimpleName(),Node.count);
//        this.name = name;
//        this.logger = new Logger(this.name);
//        Node.nodes.put(this.id, this);
//    }
//
//    protected String getId() {
//        return this.id;
//    }
//
//    protected String getName() {
//        return this.name;
//    }
//   // public void setName(String name){this.name = name;}
//
//    protected Logger getLogger() {
//        return this.logger;
//    }
////    public static Node getNode(String id){
////        if(!Node.nodes.containsKey(id)){
////            throw new NoSuchElementException();
////        }
////        return Node.nodes.get(id);
////    }
//
//}
public abstract class Node {
    private final String id;
    private String name;
    private final Logger logger;
    private Node nodes;
    private static int count = 0;
    public Node(){
        ++Node.count;
        this.id = String.format("%s@%08d",this.getClass().getSimpleName(),Node.count);
        this.name = this.getClass().getSimpleName();
        this.logger = new Logger(this.name);
    }
    public Node(String name){
        ++Node.count;
        this.id = String.format("%s@%08d",this.getClass().getSimpleName(),Node.count);
        this.name = name;
        this.logger = new Logger(this.name);
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;

    }
    public Logger getLogger(){
        return this.logger;
    }

}