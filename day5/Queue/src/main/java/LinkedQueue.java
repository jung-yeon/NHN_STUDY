public class LinkedQueue<E> implements Queue<E> {
    int count;
    static class LinkedNode<E>{
        E element;
        LinkedNode next;

        public LinkedNode(E element, LinkedNode next){
            this.element = element;
            this.next = next;
        }
        public E getElement(){
            return (E)this.element;
        }
        public LinkedNode getNext() {
            return this.next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }
    LinkedNode head;
    LinkedNode tail;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(E element) {
        if(this.isEmpty()){
            this.head = new LinkedNode(element, null);
            this.tail = this.head;
        }
        else {
            this.tail.setNext(new LinkedNode(element, null));
            this.tail = this.tail.getNext();
        }
        this.count ++;
    }

    @Override
    public E element() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return (E)this.head.getElement();
    }

    @Override
    public E remove() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        E value = (E)this.head.getElement();
        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
        }
        this.count--;

        return	value;
    }

    @Override
    public int size() {
        return this.count;
    }
    public String toString(){
        StringBuilder line = new StringBuilder();
        LinkedNode node = this.head;
        while((node != null)){
            line.append((line.length() != 0?" ":"") + node.getElement());
            node = node.getNext();
        }
        return line.toString();
    }
}
