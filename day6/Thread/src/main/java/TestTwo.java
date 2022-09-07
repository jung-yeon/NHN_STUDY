import java.time.LocalDateTime;
public class TestTwo extends Thread{
    private String message;
    private int time;
    public TestTwo(String message){
        this.message = message;
    }
    public void run(){
        try{
            while(true){
                System.out.println("[ " + LocalDateTime.now() + " ] : 들어가기 " + this.message );
                Thread.sleep(1000);
                System.out.println("[ " + LocalDateTime.now() + " ] : 나오기 " + this.message );
            }

        }catch (InterruptedException e){
        }
    }

    public static void main(String[] args) {
        TestTwo thread = new TestTwo("thread");
        thread.start();
        try{
            Thread.sleep(2000); //thread 안전하게 종료
        }catch (InterruptedException e){
        }thread.interrupt();



    }
}
