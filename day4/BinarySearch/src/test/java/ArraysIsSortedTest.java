import java.util.Random;
public class ArraysIsSortedTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for(int i =0 ; i < arr.length; i++){
            arr[i] = random.nextInt(20);
        }


        ArraysIsSorted array = new ArraysIsSorted(arr);
        array.isSorted();
        array.Minmax();
        array.Average();
        array.Overlap();
        array.Reverse();



    }
}
