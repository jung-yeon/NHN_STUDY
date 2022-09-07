import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    E [] elements;
    final int DEFAULT_SIZE = 100;   //임의로 크기 정해줌
    int top;                        //배열에서 어디가 젤 위인가
    boolean trace;
    //생성자로서 Stack을 초기화 합니다.
    public ArrayStack(){
        this.elements = (E[])new Object[this.DEFAULT_SIZE];
        this.top = -1; //배열에서 인덱스가 빠지는경우 -1로 표현한다.(배열밖으로 빠진다)
        this.trace = false;
    }//자바는 레퍼런스가 다 object 타입이다
    public ArrayStack(int size){
        if(size <= 0){      //사이즈가 너무 작을때 예외처리
            throw new IllegalArgumentException("Stack size is too small");
        }
        this.elements = (E[])new Object[size];
        this.top = -1;
        this.trace = false;
    }
    public void setTrace(boolean trace){ this.trace = trace; }

    @Override
    public boolean isEmpty() {
        return this.top < 0;
    }

    @Override
    public void push(E element) {
        if(this.top < this.elements.length){
            ++this.top;
            this.elements[this.top] = element;
        }
        if(this.trace){
            System.out.println(this);
        }
    }

    @Override
    public E pop() {
        if(this.top < 0){
            throw new EmptyStackException();
        }
        E value = this.elements[this.top];
        this.top--; // remove
        if(this.trace){
            System.out.println(this);
        }
        return value;
    }

    @Override
    public E peek() {
        if(this.top < 0){
            throw new EmptyStackException();
        }
        return this.elements[this.top];
    }

    @Override
    public int size() {
        return this.top + 1;
    }
    public String toString(){
        StringBuilder line = new StringBuilder();
        for(int i = 0; i<=this.top; i++){
            line.append(((line.length() != 0)?" ":"") + this.elements[i]);
        }
        return line.toString();
    }
    //역순
    /*public static <E> Stack<E> reversed(Stack<E> stack){
        Stack nstack = new ArrayStack();
        while(!(stack.isEmpty())){
            E ivalue = stack.pop();
            nstack.push(ivalue);
        }
        return nstack;
    }*/
    //역순 but 원래의 데이터는 원래의 순서로 남아있음
    /*public static <E> Stack<E> reversed(Stack<E> stack){
        ArrayStack stack1 = new ArrayStack();
        ArrayStack stack2 = new ArrayStack();
        while(!(stack.isEmpty())){  //역순
            E ivalue = stack.pop();
            stack2.push(ivalue);
        }
        while(!(stack2.isEmpty())){  //원래대로
            E ivalue = stack.pop();
            stack.push(ivalue);
        }
        return stack2;
    }*/
    public E peunltimate(Stack<E> stack) {
        ArrayStack stack1 = new ArrayStack();
        E value = null;
        stack.pop();
        value = stack.pop();

        return value;
    }

}
/*
 * null로 바꿔주어야함
 */
