import java.util.Scanner;

//Cho một mảng 2 chiều các số nguyên n hàng m cột arr được nhập từ bàn phím.
// Bạn hãy viết chương trình tính tổng các phần tử chia hết cho 5 trong arr.
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int result=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]%5==0){
                    result+=arr[i][j];
                }
            }
        }
        System.out.println(result);
    }
}