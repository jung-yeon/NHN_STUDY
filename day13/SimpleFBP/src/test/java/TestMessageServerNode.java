public class TestMessageServerNode {
    public static void main(String[] args) {
        RNGNode2 v1 = new RNGNode2(1);
        RNGNode2 v2 = new RNGNode2(1);
        RNGNode2 v3 = new RNGNode2(1);
        RNGNode2 v4 = new RNGNode2(1);
        AdditionNode2 additionNode = new AdditionNode2();
        SubtractionNode2 subtractionNode = new SubtractionNode2();
        MultiplecationNode2 multiplecationNode = new MultiplecationNode2();

        StandardOutNode2 outNode = new StandardOutNode2();
        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        Wire wire3 = new Wire();
        Wire wire4 = new Wire();
        Wire wire5 = new Wire();
        Wire wire6 = new Wire();
        Wire wire7 = new Wire();

        v1.connectOutput(0, wire1);
        v2.connectOutput(0, wire2);
        v3.connectOutput(0, wire3);
        v4.connectOutput(0, wire4);

        additionNode.connectInput(0, wire1);
        additionNode.connectInput(1, wire2);
        additionNode.connectOutput(0, wire5);

        subtractionNode.connectInput(0, wire3);
        subtractionNode.connectInput(1, wire4);
        subtractionNode.connectOutput(0, wire6);

        multiplecationNode.connectInput(0, wire5);
        multiplecationNode.connectInput(1, wire6);
        multiplecationNode.connectOutput(0, wire7);

        outNode.connectInput(0, wire7);
        MessageServer.getGlobalServer().connect(additionNode);
        MessageServer.getGlobalServer().connect(subtractionNode);
        MessageServer.getGlobalServer().connect(multiplecationNode);

        additionNode.setTract(
                (x,y) -> MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(),y)));
        subtractionNode.setTract(
                (x,y) -> MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(),y)));
        multiplecationNode.setTract(
                (x,y) -> MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(),y)));

        outNode.start();
        additionNode.start();
        subtractionNode.start();
        multiplecationNode.start();
        v4.start();
        v3.start();
        v2.start();
        v1.start();
    }
}
