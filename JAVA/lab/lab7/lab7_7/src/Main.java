import java.util.Scanner;

//Cho một mảng các số nguyên n phần tử arr.
// Bạn hãy viết chương trình hiển thị
// những số lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10 trong mảng arr
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && arr[i] <= 10) {
                System.out.print(arr[i]+" ");
            }
        }

    }
}