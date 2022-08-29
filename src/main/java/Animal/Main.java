package Animal;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new Bat(),new Tiger(), new Whale(), new Falcon(), new Ostrich(), new Penguin());
        //stream - 연속적으로 데이터가 계속 나올 수 있는 것
        System.out.println("Flyable animals : " + Arrays.toString(animals.stream().filter(x->x instanceof Fly).toArray()));
    }
}
