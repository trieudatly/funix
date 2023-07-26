import java.util.Scanner;

//Cho một mảng 2 chiều các số nguyên n hàng m cột arr được nhập từ bàn phím.
// Bạn hãy viết chương trình tính tổng các phần tử trong mảng arr.
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int sumArr = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
                sumArr += arr[i][j];
            }
        }
        System.out.println(sumArr);
    }
}