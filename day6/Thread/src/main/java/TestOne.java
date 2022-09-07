public class TestOne extends Thread{
    private String message;
    private int time;
    public TestOne(String message, int time){
        this.message = message;
        this.time = time;
    }
    public void run(){

            try {
                Thread.sleep(this.time);
                System.out.println(this.message + " : " + this.time);

            } catch (InterruptedException e) {
            }
    }

    //  synchronized
    //현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막는 개념

    public static void main(String[] args) {
        TestOne thread1 = new TestOne("thread1",3000);
        TestOne thread2 = new TestOne("thread2", 1000);
        thread1.start();
        thread2.start();
    }
}
