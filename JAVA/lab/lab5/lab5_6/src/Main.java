import java.util.Scanner;

//Cho số nguyên n được nhập từ bàn phím,
// bạn hãy viết phương thức đệ quy
// trả về tổng các số lẻ từ 1 tới n.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(sumN(n));
    }
    public static int sumN(int n) {

        if (n == 1) {
            System.out.println(n);
            return 1;
        }
        if (n % 2 == 0) {
            return sumN(n - 1);
        } else {
            System.out.println(n);
            return n + sumN(n - 1);
        }
    }
}