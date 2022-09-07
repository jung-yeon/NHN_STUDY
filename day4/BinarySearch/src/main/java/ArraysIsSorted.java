import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysIsSorted {
    int []arr;
    int []arr2;
    public ArraysIsSorted(int[] arr){
        this.arr = arr;
        this.arr2 = arr;
    }
    public void isSorted(){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(this.arr[i] != arr2[i]){
                System.out.println("not sorted!!");
                break;
            }
        }
        System.out.println(" arr : " + Arrays.toString(arr));
        System.out.println(" arr2 : " + Arrays.toString(arr2));
    }
    public void Minmax(){
        int min = arr[0];
        int max = arr[arr.length - 1];
        System.out.println( "min : " + min + ", " + "max : " + max );
    }
    public void Average(){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        int av = sum/arr.length;
        System.out.println( "average : " + av );
    }
    public void Overlap(){
        int[] arrOverlap = Arrays.stream(arr).distinct().toArray();
        System.out.println(" arrOverlap : " + Arrays.toString(arrOverlap));
        int[] arrClone = arr.clone();
        System.out.println(" arrClone : " + Arrays.toString(arrClone));
    }
    public void Reverse(){
        List list = Arrays.asList(arr);
        Collections.reverse(list);

        //int[] arrRev = list.toArray(arr);
        //System.out.println(Arrays.asList(arrRev));
    }
    public void Conect(int[] arr){

    }

}
