import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E>{
    E element;

    int count;
    static class LinkedNode<E>{
        E element;
        LinkedNode next;

        public LinkedNode(E element, LinkedNode next){
            this.element = element;
            this.next = next;
        }
        public E getElement(){
            return this.element;
        }
        public LinkedNode getNext() {
            return this.next;
        }
    }
    LinkedNode head;

    public LinkedStack(){
        this.head = null;
        this.count = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void push(E element) {
        this.head = new LinkedNode(element, this.head);
        this.count++;
        //this.head = this.head.getNext();
    }
//        this.count++;
//        this.head = this.head.getNext();

//        if(this.isEmpty()){
//            this.head = (LinkedNode) element;
//            System.out.println(this.head);
//        }
//        LinkedNode.next = this.head;
//        this.head = null;

    @Override
    public E pop() {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        E value = (E) this.head.getElement();
        this.head = this.head.getNext();
        this.count--;

        return value;
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return (E) this.head.getElement();
    }

    @Override
    public int size() {
        return this.count;
    }
    public String toString(){
        StringBuilder line = new StringBuilder();
        LinkedNode node = this.head;
        while((node != null)){
            line.append((this.size() != 0?" ":"") + node.getElement());
            node = node.getNext();

        }
        return line.reverse().toString();
    }
}
