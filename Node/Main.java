package Node;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InorderTree node1 = new InorderTree(1);
        InorderTree node2 = new InorderTree(2);
        InorderTree node3 = new InorderTree(3, node1, node2);
        InorderTree node4 = new InorderTree(4, node3);
        InorderTree node5 = new InorderTree(5);
        InorderTree node6 = new InorderTree(6, node5);
        InorderTree node7 = new InorderTree(7, node6);
        InorderTree node8 = new InorderTree(8, node4, node7);

        PreorderTree prenode1 = new PreorderTree(1);
        PreorderTree prenode2 = new PreorderTree(2);
        PreorderTree prenode3 = new PreorderTree(3, prenode1, prenode2);
        PreorderTree prenode4 = new PreorderTree(4, prenode3);
        PreorderTree prenode5 = new PreorderTree(5);
        PreorderTree prenode6 = new PreorderTree(6, prenode5);
        PreorderTree prenode7 = new PreorderTree(7, prenode6);
        PreorderTree prenode8 = new PreorderTree(8, prenode4, prenode7);

        System.out.println(node8);
        InorderTree node10 = new InorderTree(50);
        Random random = new Random();
        for(int i = 0 ; i < 10 ; i++) {
            node10.add(random.nextInt(100)-50);
        }

        PreorderTree prenode10 = new PreorderTree(50);
        for(int i = 0 ; i < 10 ; i++) {
            prenode10.add(random.nextInt(100)-50);
        }

        System.out.println(prenode10);
        System.out.println(node10);
        node8.remove(8);
        System.out.println(node8);
    }
}
