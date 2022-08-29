public class MyNaturalNumber implements MyNumber{
    private int number;
    MyNaturalNumber num;
    //MyNumber operand;
    public MyNaturalNumber(int number){
        this.number = number;
        toString();
    }
    public String toString() {
        return number + "";
    }
    public int getMyNaturalNumber(){
        return number;
    }
    @Override
    public MyNaturalNumber plus(MyNumber operand) {
        num = (MyNaturalNumber) operand;
        int sum = number + (num.number);
        return new MyNaturalNumber(sum);
    }

    @Override
    public MyNaturalNumber minus(MyNumber operand) {
        num = (MyNaturalNumber) operand;
        int minus = number - (num.number);
        return new MyNaturalNumber(minus);
    }

    @Override
    public MyNaturalNumber multipliedBy(MyNumber operand) {
        num = (MyNaturalNumber) operand;
        int multipleied = number * (num.number);
        return new MyNaturalNumber(multipleied);
    }

    @Override
    public MyNaturalNumber divideBy(MyNumber operand) {
        num = (MyNaturalNumber) operand;
        int divded = number / (num.number);
        return new MyNaturalNumber(divded);
    }
}

