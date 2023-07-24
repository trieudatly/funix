//Cho số nguyên dương n được nhập từ bàn phím,
// bạn hãy viết phương thức đệ quy trả về n! (n giai thừa).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(factorial(n));

    }
    public static int factorial(int n) {
        if (n == 1||n==0) return 1;
        return n * factorial(n - 1);
    }
}