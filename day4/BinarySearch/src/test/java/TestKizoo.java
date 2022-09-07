class F {
    public F m() {
        System.out.println("F");
        return new F();
    }
}

class G extends F {
    public G m() {
        System.out.println("G");
        return new G();
    }

    public static void test() {
        F f = new G();
        f.m();
    }
}
public class TestKizoo {


    public static void main(String[] args) {
        G.test();
    }
}

