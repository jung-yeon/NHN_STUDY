
public class MyRationalNumber implements MyNumber{
    private int numerator, denominator;
    MyRationalNumber number;
    public MyRationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }
    public MyRationalNumber(int number){
        this.numerator = number;
        this.denominator = 1;
    }
    public MyRationalNumber(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("The denominator cannot be 0.");
        }else if(denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        toString();

    }
    int gcd(int numerator, int denominator){
        if(denominator == 0){
            return numerator;
        }
        else return gcd(denominator, numerator % denominator);
    }
    public int getNumerator() {
        return  this.numerator;
    }

    public int getDenominator() {
        return  this.denominator;
    }

    public String toString(){
        if(denominator == 1){
            return numerator + "";
        }else if(denominator == 0){
            return "0";
        }else return numerator + "/" + denominator;
    }
    @Override
    public MyRationalNumber plus( MyNumber operand) {
        if(!(operand instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return  new MyRationalNumber(
                this.numerator *  ((MyRationalNumber)operand).getDenominator()
                        + this.denominator * ((MyRationalNumber)operand).getNumerator(),
                this.denominator * ((MyRationalNumber)operand).getDenominator()
        );
    }

    @Override
    public MyRationalNumber minus(MyNumber operand) {
        if(!(operand instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return  new MyRationalNumber(
                this.numerator *  ((MyRationalNumber)operand).getDenominator()
                        - this.denominator * ((MyRationalNumber)operand).getNumerator(),
                this.denominator * ((MyRationalNumber)operand).getDenominator()
        );
    }

    @Override
    public MyRationalNumber multipliedBy( MyNumber operand) {
        if(!(operand instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return  new MyRationalNumber(
                this.numerator *  ((MyRationalNumber)operand).getNumerator(),
                this.denominator * ((MyRationalNumber)operand).getDenominator()
        );
    }

    @Override
    public MyRationalNumber divideBy( MyNumber operand) {
        if(!(operand instanceof MyRationalNumber)){
            throw new IllegalArgumentException("Number is not rational number");
        }
        return  new MyRationalNumber(
                this.numerator *  ((MyRationalNumber)operand).getDenominator(),
                this.denominator * ((MyRationalNumber)operand).getNumerator()
        );
    }
}
