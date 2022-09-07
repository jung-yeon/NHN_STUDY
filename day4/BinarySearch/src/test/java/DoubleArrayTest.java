import java.util.Arrays;
import java.util.Random;
public class DoubleArrayTest {
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];

        int[][] arr4 = new int[3][3];
        int[][] arr5 = new int[3][3];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(10);
            arr2[i] = random.nextInt(10);
            arr3[i] = arr1[i] + arr2[i];
        }
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j< 3; j++){
                arr4[i][j] = random.nextInt(10);
                arr5[i][j] = random.nextInt(10);
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        int sum = 0;
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                sum += arr4[i][j] * arr5[j][i];
            }
        }
        System.out.println(sum);
    }
}
