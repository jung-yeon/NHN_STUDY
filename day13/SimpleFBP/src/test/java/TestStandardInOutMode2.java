public class TestStandardInOutMode2 {
    public static void main(String[] args) {
        StandardInNode2 standardInNode2 = new StandardInNode2(1);
        StandardOutNode2 standardOutNode2 = new StandardOutNode2(2);
        //TimerNode2 timerNode2 = new TimerNode2(3000);


        standardInNode2.connect(0,standardOutNode2.getInputPort(0));
        standardInNode2.start();
        //timerNode2.start();
        standardOutNode2.start();


    }

}
