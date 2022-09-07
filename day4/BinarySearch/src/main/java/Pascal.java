public class Pascal {
    int start = 1;
    int floors;
    int[][] arr ;

    public Pascal(int floors){
        this.floors = floors;
        arr = new int[floors][floors];
    }

    public void roof(){
        for(int i = 0; i < floors; i++){
            for(int j = 0; j <= i ; j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        for(int i=0;i<floors;i++)
        {
            for(int j=0;j<=i;j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Pascal pa = new Pascal(4);
        pa.roof();
    }
}
