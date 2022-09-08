public class Example5_3 {
    static class Printer{
        public Printer(){}
        synchronized void printAndSleep(long interval) throws InterruptedException{
            //System.out.println(message);
            Thread.sleep(interval);
        }
    }
    static class Task extends Thread{
        long interval;
        Printer printer;
        boolean stopFlag;
        public Task(long interval, Printer printer){
            this.interval = interval;
            this.printer = printer;
        }

        public void print(long interval) throws InterruptedException{
            Thread.sleep(interval);
        }
        public void stop2(){this.stopFlag = true;}
        public boolean isStop(){return this.stopFlag;}

        //static을 붙혀야 하나가 block이 걸린다
        // 하나는 무조건 block이 걸려야한다.
        public void run(){
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;
            this.stopFlag = false;
            while(!this.isStop()){
                try{
                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60, totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000, Thread.currentThread().getName());
                    printer.printAndSleep(this.interval);
                    previousPrintTime = totalElapsedTime;
                }catch (InterruptedException e){
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Printer printer = new Printer();
        Task task1 = new Task(3000, printer);
        Task task2 = new Task(5000, printer);

        task1.start();
        task2.start();

        long startTime = System.currentTimeMillis();
        long previousPrintTime = 0;

        for(int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            if (i % 2 == 0) {
                //인터럽트로 인해 발생한 문제 해결하기
                //정해진 시간 간격에 맞도록 메시지가 출력되도록 하라
                task1.interrupt();
                task2.interrupt();
            }
            long totalElapsedTime = System.currentTimeMillis() - startTime;
            long elapsedTime = totalElapsedTime - previousPrintTime;
            System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s - %s\n",
                    totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60, totalElapsedTime % 1000,
                    (elapsedTime / 1000), elapsedTime % 1000,
                    task1.getState(), task2.getState());
            previousPrintTime = totalElapsedTime;
        }
        task1.stop2();
        task2.stop2();
    }
}
