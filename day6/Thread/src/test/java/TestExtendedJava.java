public class TestExtendedJava {
    public static void main(String[] args) {
        ExtendedThread thread1 = new ExtendedThread("One");
        ExtendedThread thread2 = new ExtendedThread("Two");
        ExtendedThread thread3 = new ExtendedThread("Three");
        ExtendedThread thread4 = new ExtendedThread("Four");
        ExtendedThread thread5 = new ExtendedThread("Five");
        ExtendedThread thread6 = new ExtendedThread("Six");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
