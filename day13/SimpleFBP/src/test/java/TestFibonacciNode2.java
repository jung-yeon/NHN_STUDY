public class TestFibonacciNode2 {
    public static void main(String[] args) throws InterruptedException {
        ClockNode2 clockNode = new ClockNode2("clock", 1000);
        LatchNode2 latchNode1 = new LatchNode2("latch1", (int)1.0);
        LatchNode2 latchNode2 = new LatchNode2("latch2", (int)0.0);
        DelayNode2 delayNode2 = new DelayNode2(100);
        ReplicationNode2 replicationNode1 = new ReplicationNode2("replication1");
        ReplicationNode2 replicationNode2 = new ReplicationNode2("replication2");
        ReplicationNode2 replicationNode3 = new ReplicationNode2("replication3");

        AdditionNode2 additionNode1 = new AdditionNode2("addition1");
        StandardOutNode2 standardOutNode1 = new StandardOutNode2("out1");

        clockNode.connect(0,replicationNode1.getInputPort(0));
        replicationNode1.connect(1, latchNode1.getInputPort(0));
        replicationNode1.connect(0, latchNode2.getInputPort(0));
        latchNode1.connect(0, replicationNode2.getInputPort(0));
        latchNode2.connect(0, additionNode1.getInputPort(0));
        delayNode2.connect(0, latchNode2.getInputPort(1));
        replicationNode2.connect(0, delayNode2.getInputPort(0));
        replicationNode2.connect(1,additionNode1.getInputPort(1));
        additionNode1.connect(0, replicationNode3.getInputPort(0));
        replicationNode3.connect(0, standardOutNode1.getInputPort(0));
        replicationNode3.connect(1,latchNode1.getInputPort(1));

        standardOutNode1.start();
        replicationNode1.start();
        replicationNode2.start();
        replicationNode3.start();
        additionNode1.start();
        delayNode2.start();
        latchNode2.start();
        latchNode1.start();
        clockNode.start();

//        clockNode.main();
//        replicationNode1.main();
//        latchNode1.main();
//        replicationNode2.main();
//        latchNode2.main();
//
//        additionNode1.main();
//        replicationNode3.main();
//        delayNode2.main();
//        standardOutNode1.main();
    }
}
