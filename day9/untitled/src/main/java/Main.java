/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if(a == b && b == c){
            System.out.println(10000 + (a * 1000));
        }
        else if(a == b || a == c || b == c){
            int same,dif;
            if(a == b){
                same = a;
            } else if ( a == c) {
                same = c;
            }else{
                same = b;
            }
            System.out.println(1000 + (same * 100));
        }
        else{
            int max;
            if(a > b && a > c){
                max = a;
            }else if(b > c && b > a){
                max = b;
            }
            else{
                max = c;
            }
            System.out.println(max * 100);
        }
    }
}*/

//import java.util.*;

//2839
/*import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();


        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}*/
/*
//1929
import java.util.Scanner;
public class Main{
    int[] arr2;
    public static void main(String[] args) {
        int start;
        int end;

        Scanner in = new Scanner(System.in);
        start = in.nextInt();
        end = in.nextInt();
        int[] arr = new int[end - start + 1];
        int num = start;
        for(int i = 0; i <= end - num; i++){
            arr[i] = start;
            start++;
        }
        for(int i = 0; i < arr.length; i++){
            if(num(arr[i]) == true){
                System.out.println(arr[i]);
            }
        }

    }
    public static boolean num(int num){
        if(num == 1 || num == 0) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
       return true;
    }
}*/
//1193
/*import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        num = in.nextInt();
        int cross = 1;   //대각선
        int pre_num = 0;    //이전합
        while(true){
            if(num <= pre_num + cross){
                if(cross % 2 == 1){
                    System.out.println((cross - (num - pre_num - 1)) + "/" + (num - pre_num));
                    break;
                } else{
                    System.out.println((num - pre_num) + "/" + (cross - (num - pre_num - 1)));
                    break;
                }
            } else{
                pre_num += cross;
                cross++;
            }
        }

    }
}*/
//1085
/*import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int startX = 0, startY = 0;
        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        int[] minArr = new int[4];

        minArr[0] = x - startX;
        minArr[1] = y - startY;
        minArr[2] = w - x;
        minArr[3] = h - y;

        Arrays.sort(minArr);
        System.out.println(minArr[0]);
    }
}*/
//1966 프린터 큐
import java.security.InvalidParameterException;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Queue<int[] > queue = new LinkedList<>();
        int testcase = 0;
        int count = 0;
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); //TestCase
        while(T-- > 0){
            int N = in.nextInt();   //문서의 개수
            int M = in.nextInt();   //몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)
            int importance;
//            if(N <= M){
//                System.out.println("다시 입력!");
//                continue;
//            }
            for (int i = 0; i < N; i++) {
                importance = in.nextInt();
                queue.add(new int[]{i, importance});
            }

                while (true) {
                    int now[] = queue.remove();
                    boolean flag = true;

                    for (int q[] : queue) {
                        if(q[1] > now[1]) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {  //true일때 count++;
                        count++;
                        if(now[0] == M) break;
                    }else {
                        queue.add(now);
                    }
                }
                System.out.println(count);
                testcase++;
            }
        }
    }
