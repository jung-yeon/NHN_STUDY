package TowerOfHanoi;

import java.util.Stack;

public class Tower {
    String name;
    Stack stack = new Stack();
    long count;
    public Tower(String name){
        this.name = name;
    }
    public void push(Disk disk) {
        stack.push(disk.size);
    }

    public int getSize() {
        return stack.size();
    }

    public String getName() {
        return name;
    }

    /*public Disk pop() {
        return stack.pop(Disk);
    }*/

    public long getCount() {

        return this.count;
    }
}
