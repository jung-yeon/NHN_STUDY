/*
 * yield() 메소드
 *
 * static 메소드
 * 현재 실행 중인 스레드를 중지시켜 동일한 우선 순위의 다른 대기 스레드를 동작 시킬 수 있다.
 * 동일한 우선 순위가 없는 경우, 다시 실행
 * 하나의 스레드가 프로세서를 과도하게 점유하지 않도록 조정할 수 있다.
 * 결과가 랜덤으로 나옴!!!!
 */
public class TestThreadYield {
    static class MyThread extends Thread{
        public void run(){
            for(int i = 0; i < 5; ++i){
                Thread.yield();
                System.out.println("Thread started: " + Thread.currentThread().getName());
            }
            System.out.println("Thread ended: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for(int i = 0; i < 5; ++i){
            System.out.println("Thread started: " + Thread.currentThread().getName());
        }
        System.out.println("Thread ended: " + Thread.currentThread().getName());
    }
}
