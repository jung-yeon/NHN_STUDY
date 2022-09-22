public class TestAdditionNode2 {
    public static void main(String[] args) {
        RNGNode2 inNode1 = new RNGNode2(6400);
        RNGNode2 inNode2 = new RNGNode2(3000);

        AdditionNode2 additionNode2 = new AdditionNode2();

        StandardOutNode2 outNode2 = new StandardOutNode2(1);

        inNode1.connect(0, additionNode2.getInputPort(0));
        inNode2.connect(0, additionNode2.getInputPort(1));

        additionNode2.connect(0, outNode2.getInputPort(0));

//        inNode2.main();
//        inNode1.main();
//        additionNode2.main();
//        outNode2.main();

        outNode2.start();
        additionNode2.start();
        inNode2.start();
        inNode1.start();
    }
}
