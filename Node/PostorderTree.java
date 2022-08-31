package Node;

import java.util.List;

public class PostorderTree extends Node{
    public PostorderTree(Integer value){ super(value, null , null); }
    public PostorderTree(Integer value, PostorderTree leftChildNode){ super(value, leftChildNode, null); }
    public PostorderTree(Integer value, PostorderTree leftChildNode, PostorderTree rightChildNode) {
        super(value, leftChildNode, rightChildNode);
    }

    @Override
    public void constructor() {

    }

    @Override
    public Integer search(Integer key) throws Exception {
        Integer value = null;

        if(this.leftChildNode != null){
            try{
                return this.leftChildNode.search(key);
            }catch (Exception ignore){}
        }
        else if(this.rightChildNode != null) {
            try {
                return this.rightChildNode.search(key);
            } catch (Exception ignore) {}
        }
        else if(this.value.equals(key)){
            return this.value;
        }
        throw new Exception("not Found");
    }

    @Override
    public void getList(List<Integer> list) {
        if(this.leftChildNode != null){
            this.leftChildNode.getList(list);
        }
        if(this.rightChildNode != null){
            this.rightChildNode.getList(list);
        }
        list.add(this.value);
    }

    @Override
    public void add(Integer value) {
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
    public void remove(Integer key) {

    }
}
