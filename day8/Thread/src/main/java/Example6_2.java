public class Example6_2 {
    static class Producer implements Runnable{
        String name;
        Market market;
        String items;
        int quantity;
        long interval;
        public Producer(String name, Market market, String items, int quantity, long interval){
            this.name = name;
            this.market = market;
            this.items = items;
            this.quantity = quantity;
            this.interval = interval;
        }
        @Override
        public void run(){
            System.out.println(this.name + "를 시작합니다.");

        }
    }
    static class Consumer implements Runnable{
        String name;
        Market market;
        String[] items;
        long childinterval;
        long interval;
        public Consumer(String name, Market market, String[] items, long interval, long childinterval){
            this.name = name;
            this.market = market;
            this.items = items;
            this.childinterval = childinterval;
            this.interval = interval;
        }
        @Override
        public void run(){
            System.out.println(this.name + "가 시장에 왔습니다.");

        }
    }
    static class Market{
        int count;
        public Market(int count){
            this.count = count;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Market market = new Market(10);
        Thread [] producers = {
                new Thread(new Producer("상인1", market, "apple", 20, 3000)),
                new Thread(new Producer("상인2", market, "banana", 50, 3000)),
                new Thread(new Producer("상인3", market, "mango", 30, 3000))};

        Thread [] consumers = {
                new Thread(new Consumer("고객1", market, new String[]{"apple","banana"}, 5000, 1000)),
                new Thread(new Consumer("고객2", market, new String[]{"apple","mango"}, 10000, 2000)),
                new Thread(new Consumer("고객3", market, new String[]{"banana","mango"}, 6000, 3000)),
                new Thread(new Consumer("고객4", market, new String[]{"apple","banana","mango"}, 5000, 2000)),
                new Thread(new Consumer("고객5", market, new String[]{"apple","banana","mango"}, 5000, 3000))};
        for(Thread producer : producers){
            producer.start();
        }
        for(Thread consumer : consumers){
            consumer.start();
        }
        while(true){
            System.out.println("Market : " + market);
            Thread.sleep(1000);
        }
    }
}
