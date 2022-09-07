import java.time.LocalDateTime;

public class TestThree extends Thread{
    private String message;
    private int time;
    public TestThree(String message){
        this.message = message;
    }
    public void run(){
        while(true){
            System.out.println("[ " + LocalDateTime.now() + " ] : 들어가기 " + this.message );
            if(Thread.interrupted()) {
                break;
            }
            System.out.println("[ " + LocalDateTime.now() + " ] : 나오기 " + this.message );
        }
    }
//interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시킴

    public static void main(String[] args) {
        TestThree thread1 = new TestThree("thread1");
        TestThree thread2 = new TestThree("thread2");
        thread1.start();
        thread2.start();
        try{
            Thread.sleep(1000); //thread 안전하게 종료
        }catch (InterruptedException e){
        }
        thread1.interrupt();
        thread2.interrupt();

    }
}
