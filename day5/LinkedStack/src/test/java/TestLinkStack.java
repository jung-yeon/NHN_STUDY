public class TestLinkStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<Integer>();

        System.out.println("Stack : " + stack);
        stack.push(1);
        System.out.println("Stack : " + stack);
        stack.push(2);
        System.out.println("Stack : " + stack);
        stack.push(3);
        System.out.println("Stack : " + stack);
        stack.pop();
        System.out.println("Stack : " + stack);
        stack.push(4);
        System.out.println("Stack : " + stack);
        stack.push(5);
        System.out.println("Stack : " + stack);
        stack.push(6);
        System.out.println("Stack : " + stack);
        stack.pop();
        System.out.println("Stack : " + stack);
        stack.push(7);
        System.out.println("Stack : " + stack);
        stack.pop();
        System.out.println("Stack : " + stack);
        stack.pop();
        System.out.println("Stack : " + stack);
        stack.pop();
        System.out.println("Stack : " + stack);
    }
}
