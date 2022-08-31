package Node;
import java.util.List;

public abstract class Node {
    Integer value;
    Node leftChildNode;
    Node rightChildNode;

    public Node(Integer value, Node leftChildNode, Node rightChildNode) {
        this.value = value;
        this.leftChildNode = rightChildNode;
        this.rightChildNode = rightChildNode;
    }

    public abstract void constructor();

    public Integer getValue() {
        return this.value;
    }

    public Node getLeftChildNode() {
        return this.leftChildNode;
    }

    public Node getRightChildNode() {
        return this.rightChildNode;
    }
    public abstract Integer search(Integer key) throws Exception;

    public abstract void getList(List<Integer> list);
    public abstract void add(Integer value);
    public abstract void remove(Integer key);

}
