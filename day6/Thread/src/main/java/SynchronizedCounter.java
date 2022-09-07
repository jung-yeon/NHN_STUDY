/*
 * synchronized - 자바에서 동기화 지원을 위해 synchronized를 지원하며, 메소드나 코드블록에 적용 가능함
 *
 * synchronized를 이용한 메소드 동기화 방법은 아래와 같이 메소드의 접근 제한자에 키워드 추가만으로 가능하다.
 */
public class SynchronizedCounter {
    private int c = 0;
    public synchronized void increment(){
        c++;
    }
    public synchronized void decrement(){
        c--;
    }
    public synchronized int value(){
        return c;
    }
}
/*
 * count가 SynchronizedCounter 클래스의 인스턴스인 경우 메서드를 동기화하면 두 가지 효과가 있다.
 * 1. 동일한 개체에서 동기화된 메소드를 두 번 호출하여 메소드 수행 중 끼어들게 할 수 없습니다.
 * 2. 동기화된 메서드가 종료되면 대기 중이던 모든 스레드에서 동기화된 메소드 호출 전 상태로 돌아가 다시 실행하게 됨
 */
