public class ExtendedThread extends Thread{
    private String message;
    private int loopCount;
    public ExtendedThread(String message){
        this.message = message;
        this.loopCount = 0;
    }
    public void run(){
        while(!Thread.interrupted()){   //일시정지할 때까지
            try{
                ++this.loopCount;
                System.out.println(this.message + " : " + this.loopCount);
                //Thread.sleep(1000); //다 같은 loopCount를 갖게됨
                Thread.sleep((long)(Math.random() * 1000)); //지정된 시간동안(이 코드에선 랜덤) 현재 스레드 일시정지
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
