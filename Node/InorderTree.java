package Node;
import java.util.ArrayList;
import java.util.List;
public class InorderTree extends Node{

    public InorderTree(Integer value){ super(value, null, null); }
    public InorderTree(Integer value,InorderTree leftChildNode){ super(value, leftChildNode, null);}
    public InorderTree(Integer value, InorderTree leftChildNode, InorderTree rightChildNode) {
        super(value, leftChildNode, rightChildNode);
    }

    @Override
    public void constructor() {

    }

    @Override
    public Integer search(Integer key) throws Exception {
        Integer value = null;

        if (this.leftChildNode != null) {
            try {
                return this.leftChildNode.search(key);
            } catch (Exception ignore) {}

        } else if (this.value.equals(key)) {
            return this.value;
        }

        if (this.rightChildNode != null) {
            try {
                return this.rightChildNode.search(key);
            } catch (Exception ignore) {}
        }
        throw new Exception("not Found!");
    }
    @Override
    public void add(Integer value){
        if(this.value.compareTo(value) > 0){
            if(value < this.value){
                if(this.leftChildNode != null){
                    ((InorderTree)this.leftChildNode).add(value);
                }else{
                    this.leftChildNode = new InorderTree(value);
                }
            }
        }

        else if(this.value.compareTo(value) <= 0){
            if(value > this.value){
                if(this.rightChildNode != null){
                    ((InorderTree)this.rightChildNode).add(value);
                }else{
                    this.rightChildNode = new InorderTree(value);
                }
            }
        }
    }
    @Override
    public void remove(Integer key){
        /*remove(2)했을 때 노드의 2의값이 있다면 2를 삭제하고 그 자리에 null이 출력될 수 있도록*/

    }
    @Override
    public void getList(List<Integer> list){
        if(this.leftChildNode != null){
            this.leftChildNode.getList(list);
        }
        list.add(this.value);

        if(this.rightChildNode != null){
            this.rightChildNode.getList(list);
        }
    }
    public String toString(){
        List<String>  list = new ArrayList<>();

        if ((this.leftChildNode != null) || (this.rightChildNode != null)) {
            if (this.leftChildNode != null) {
                list.add(this.leftChildNode.toString());
            } else {
                list.add("null");
            }

            list.add(this.value.toString());

            if (this.rightChildNode != null) {
                list.add(this.rightChildNode.toString());
            } else {
                list.add("null");
            }

            return list.toString();
        }
        else { return this.value.toString(); }

    }
}
