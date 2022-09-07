import java.util.Arrays;
public class BinarySearch {
    public int number;
    int arr[] = {10,39,40,23,42,22,13,5,80,36};

    public BinarySearch(int number){
        this.number = number;
    }

    int bottom = 0;
    int top = arr.length - 1;
    int middle = top/2;
    int count = 0;

    public void Search(){
        while(number != arr[middle]){
            for(int i = bottom; i <= middle; i++){
                if(number == arr[i]){
                    this.top = this.middle;
                    this.middle = top/2;
                    count++;
                }
            }
            for(int i = middle; i < top; i++){
            }
        }
    }

}

