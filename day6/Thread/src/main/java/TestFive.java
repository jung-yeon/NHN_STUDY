import java.time.LocalDateTime;
//TestThree 해결을 위해 synchronized를 이용하기
public class TestFive {
    private String name;
    public TestFive(String name){
        this.name = name;
    }
    static class SynchronizedCounter{
        private int count = 0;
        public synchronized void run(){
            while(true){
                try{
                    //메소드가 사용중이라면 나올때까지 대기하고 그다음 넘어가도록!
                    if()
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }


        }


    }
}
