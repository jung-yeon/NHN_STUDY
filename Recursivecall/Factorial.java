package Recursivecall;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger recursion(BigInteger n){
        //if(n.compareTo())
        return null;
    }
    public static BigInteger iterator(BigInteger n){
        BigInteger result = new BigInteger("1");
        for(;n.compareTo(new BigInteger("1")) >= 0; n = n.subtract((new BigInteger("1")))){
            result = result.multiply(n);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 10;
        long start = System.currentTimeMillis();
        BigInteger recursion = Factorial.recursion(new BigInteger(String.valueOf(n)));
        long middle = System.currentTimeMillis();
        BigInteger iterator = Factorial.iterator(new BigInteger(String.valueOf(n)));
        long finish = System.currentTimeMillis();
    }
}
