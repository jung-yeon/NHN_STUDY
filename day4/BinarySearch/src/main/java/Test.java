public class Test {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i< 100; i++){
            arr[i] = i+1;
            if(i%10 == 0){
                System.out.println();
            }
            System.out.print(arr[i] + " ");

        }
        System.out.println();
        boolean a;
        for(int i = 0; i < 100; i++){
            a = is_Prime(arr[i]);
            if(is_Prime(arr[i]) == true && a == true){
                a = false;
                for(int j = i+1; j<100; j++){
                    if( arr[j] != 0 && arr[i] != 0){
                        if(arr[j] % arr[i] == 0 ){
                            arr[j] = 0;
                        }
                    }

                }
            }
        }
        for(int i = 0; i< 100; i++){
            if(i%10 == 0){
                System.out.println();
            }
            System.out.print(arr[i] + " ");

        }
    }
    static boolean is_Prime(int Number) {
        if(Number == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(Number); i++) {

            if(Number % i == 0) return false;

        }
        return true;
    }

}
