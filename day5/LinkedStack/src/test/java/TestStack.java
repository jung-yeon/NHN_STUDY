public class TestStack {
    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<>();
        stack.setTrace(true);

        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.pop();
        stack.pop();
        stack.push('D');
        stack.push('E');
        stack.push('F');
        stack.pop();
        stack.push('G');
        stack.pop();
        System.out.println(" 위에서 두번째 데이터 : " + stack.peunltimate(stack));
    }
}
