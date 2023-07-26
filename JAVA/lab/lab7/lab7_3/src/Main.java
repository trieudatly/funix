import java.util.Scanner;

//Cho một mảng các số nguyên n phần tử arr được nhập từ bàn phím.
// Bạn hãy viết chương trình hiển thị ra tổng của phần tử đầu tiên
// và cuối cùng trong mảng arr.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int result = arr[0] + arr[n - 1];
        System.out.println(result);
    }
}