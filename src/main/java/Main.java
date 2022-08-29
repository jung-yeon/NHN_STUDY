public class Main {
    public static void main(String[] args) {
        MyNaturalNumber n1 = new MyNaturalNumber(4);
        MyNaturalNumber n2 = new MyNaturalNumber(5);
        MyNaturalNumber n3 = n1.plus(n2);
        System.out.println(n1 + " + " + n2 + " = " + n3);
        MyRationalNumber rn1 = new MyRationalNumber(4,5);
        MyRationalNumber rn2 = new MyRationalNumber(4,7);
        MyRationalNumber rn3 = rn1.plus(rn2);
        System.out.println(rn1 + " + " + rn2 + " = " + rn3);
        MyRationalNumber rn4 = rn1.minus(rn2);

        System.out.println(rn1 + " - " + rn2 + " = " + rn4);
        MyRationalNumber rn5 = rn1.multipliedBy(rn2);
        System.out.println(rn1 + " * " + rn2 + " = " + rn5);
        MyRationalNumber rn6 = rn1.divideBy(rn2);
        System.out.println(rn1 + " % " + rn2 + " = " + rn6);
    }
}
