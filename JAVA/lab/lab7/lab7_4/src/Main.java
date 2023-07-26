import java.util.Scanner;

//Cho một mảng các số nguyên n phần tử arr được nhập từ bàn phím.
// Bạn hãy viết chương trình hiển thị ra màn hình những số chẵn trong mảng.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]%2==0){
                System.out.print(arr[i]+" ");
            }
        }
    }
}