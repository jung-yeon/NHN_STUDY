/*public class IArrayQueue<E> implements Queue<E>{
    E[] elements;
    final int defaultSize = 100;
    int head;
    int tail;
    public IArrayQueue(){
        this.elements = new Integer[this.defaultSize];
        this.head = 0;
        this.tail = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public void add(E element) {
        this.elements[this.tail] = element;
        this.tail++;
    }

    @Override
    public Integer element() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return this.elements[this.head];
    }

    @Override
    public Integer remove() {
        if(this.isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        Integer value = this.elements[this.head];
        this.head++;
        return value;
    }

    @Override
    public int size() {
        return (this.elements.length + this.tail - this.head) % this.elements.length;
    }
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        int node = this.head;
        while(node != this.tail){
            line.append(((line.length() != 0)?" ":"") + this.elements[node]);
        }
        return line.toString();
    }
}*/
