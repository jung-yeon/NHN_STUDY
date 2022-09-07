public class Test2 {
    static int arr[] = new int[10];
    static int j=0;
    static int[] prime_factorization(int num){
        int i = 2;
        while(num != 1) {
            if(num % i == 0) {
                arr[j] = i;
                j++;
                num /= i;
            }else {
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        prime_factorization(40);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                break;
            }
            System.out.println(arr[i] + " ");
        }
        int count =1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != 0){
                if(arr[i-1] == arr[i]){
                    count ++;
                    arr[i-1] = 0;
                }
                else if(arr[i-1] != arr[i]){
                    count = 1;
                }
                System.out.print(arr[i] + "^" + count + " ");
            }

        }

    }
}
