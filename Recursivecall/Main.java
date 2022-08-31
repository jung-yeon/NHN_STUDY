package Recursivecall;

public class Main {
    static int sum;
    static int mul;
    public static void main(String[] args) {
        int n = 100000;
        long start = System.currentTimeMillis();
        long recursion = Main.recursion(n);
        System.out.println(sum(10));
        System.out.println(Factorial(5));
    }
    public static int recursion(int n){
        if(n <= 0){
            return 0;
        }
        return n + Main.recursion(n-1);
    }
    public static int sum(int n){
        if(n <= 0){
            return n;
        }
        return n += sum(n-1);
    }
    //iteration (숫자가 작으면 괜찮다)
    public static int iteration(int n){
        int sum2 = 0;
        for(int i = n; n>0; n --){
            sum += n;
        }
        return sum;
    }
    public static int Factorial(int n){
        if(n == 1){
            return n;
        }
        return n *= Factorial(n-1);
    }
}
