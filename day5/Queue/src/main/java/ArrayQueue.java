public class ArrayQueue<E> implements Queue<E>{
    final int defaultSize = 100;
    E[] elements;
    int head;
    int tail;
    public ArrayQueue(){
        this.elements = (E[]) new Object[this.defaultSize];
        this.head = 0;
        this.tail = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public void add(E element) {
        this.elements[this.tail] = element;//배열의 끝에 도달하면 어떻게 될지
        this.tail ++;
    }

    @Override
    public E element() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return this.elements[this.head];
    }

    @Override
    public E remove() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        E value = (E)this.elements[this.head];
        this.head++;
        return value;
    }

    @Override
    public int size() {
        return (this.defaultSize + this.tail - this.head) % this.defaultSize;
    }
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        int node = this.head;
        while(node != this.tail){
            line.append((line.length()!=0?" ":"")+ this.elements[node]);
            node++;
        }
        return line.toString();
    }
}
