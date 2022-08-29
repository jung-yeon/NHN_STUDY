public class MyInteger extends MyRationalNumber {
    private int number;
    public MyInteger(int number){
        super(number);
    }
    public MyInteger(MyInteger number){
        super(number);
    }
    int getValue(){
        return this.getNumerator();
    }
    @Override
    public MyInteger plus(MyNumber operand) {
        return new MyInteger(this.getValue() + ((MyInteger)operand).getValue());
        //return null;
    }

    @Override
    public MyInteger minus(MyNumber operand) {
        return new MyInteger(this.getValue() - ((MyInteger)operand).getValue());
    }

    @Override
    public MyInteger multipliedBy(MyNumber operand) {
        return new MyInteger(this.getValue() * ((MyInteger)operand).getValue());
    }

    @Override
    public MyInteger divideBy(MyNumber operand) {
        return new MyInteger(this.getValue() / ((MyInteger)operand).getValue());
    }
}
