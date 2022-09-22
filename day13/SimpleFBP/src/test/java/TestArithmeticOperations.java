public class TestArithmeticOperations {
    public static void main(String[] args) {
        int interval = 1000;
        RNGNode2 v1 = new RNGNode2(interval);
        RNGNode2 v2 = new RNGNode2(interval);
        RNGNode2 v3 = new RNGNode2(interval);
        RNGNode2 v4 = new RNGNode2(interval);
        AdditionNode2 additionNode = new AdditionNode2();
        SubtractionNode2 subtractionNode = new SubtractionNode2();
        MultiplecationNode2 multiplecationNode = new MultiplecationNode2();

        StandardOutNode2 outNode = new StandardOutNode2(1);

        v1.connect(0, additionNode.getInputPort(0));
        v2.connect(0, additionNode.getInputPort(1));
        v3.connect(0, subtractionNode.getInputPort(0));
        v4.connect(0, subtractionNode.getInputPort(1));

        additionNode.connect(0, multiplecationNode.getInputPort(0));
        subtractionNode.connect(0, multiplecationNode.getInputPort(1));
        multiplecationNode.connect(0, outNode.getInputPort(0));

//        outNode.start();
//        additionNode.start();
//        subtractionNode.start();
//        multiplecationNode.start();
//        v1.start();
//        v2.start();
//        v3.start();
//        v4.start();

        v1.main();
        v2.main();
        v3.main();
        v4.main();
        additionNode.main();
        subtractionNode.main();
        multiplecationNode.main();
        outNode.main();
    }
}
