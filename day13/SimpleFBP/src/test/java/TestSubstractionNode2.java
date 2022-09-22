public class TestSubstractionNode2 {
    public static void main(String[] args) {
        RNGNode2 inNode1 = new RNGNode2(4000);
        RNGNode2 inNode2 = new RNGNode2(3000);

        SubtractionNode2 subtractionNode = new SubtractionNode2(2,1);

        StandardOutNode2 outNode2 = new StandardOutNode2(1);

        inNode1.connect(0, subtractionNode.getInputPort(0));
        inNode2.connect(0, subtractionNode.getInputPort(1));

        subtractionNode.connect(0, outNode2.getInputPort(0));

        inNode1.main();
        inNode2.main();
        subtractionNode.main();
        outNode2.main();

//        outNode2.start();
//        subtractionNode.start();
//        inNode2.start();
//        inNode1.start();

    }
}
