public class DoubleLinkedQueue<E> implements Queue<E> {
    int count;
    static class LinkedNode <E>{
        E element;
        LinkedNode next;
        LinkedNode previous;

        public LinkedNode() {
            this.element = null;
            this.previous = this;
            this.next = this;
        }

        public LinkedNode(E element, LinkedNode previous, LinkedNode next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
        public LinkedNode getPrevious(){
            return this.previous;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public E getElement() {
            return this.element;
        }

        public LinkedNode getNext() {
            return this.next;
        }

        public LinkedNode setNext(LinkedNode next) {
            this.next = next;
            return this.next;
        }
        public LinkedNode setPrevious(LinkedNode previous) {
            this.previous = previous;
            return this.previous;
        }
    }
    LinkedNode head;


    public DoubleLinkedQueue(){
        //this.head = null;
        //this.tail = null;
        this.head = new LinkedNode();
        this.count = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.count == 0;
//        if(this.head.getNext() == this.head){
//            return this.count == 0;
//        }
    }

    @Override
    public void add(E element) {
        LinkedNode newNode = new LinkedNode(element,this.head.getPrevious(), this.head);

        this.head.getPrevious().setNext(newNode);
        this.head.setPrevious(newNode);
        this.count++;
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
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        LinkedNode target = this.head.getNext();
        E element = (E)target.getElement();
        target.getPrevious().setNext(target.getNext());
        target.getPrevious().setPrevious(target.getPrevious());
        this.count--;
        return element;
    }

    @Override
    public int size() {
        return this.count;
    }
    public String toString(){
        StringBuilder line = new StringBuilder();
        DoubleLinkedQueue.LinkedNode node = this.head;
        while((node != null)){
            line.append(((line.length() != 0)?" ":"") + node.getElement());
            node = node.getNext();
        }
        return line.toString();
    }
}
