package Recursivecall;

public class Fibonaccinumbers {
    public static int recursion(int n){
        if(n == 1){
            return 1;
        }
        else if(n == 0){
            return 0;
        }
        return recursion(n-1) + recursion(n-2);
    }
    public static void main(String[] args) {
        System.out.println(recursion(5));
    }
}
