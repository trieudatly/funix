import java.util.Scanner;
//Bạn hãy viết chương trình nhập vào từ bàn phím số nguyên a và b.
// Sau đó hiển thị ra màn hình tổng các số từ a tới b
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=0;
        for (int i = a; i <=b; i++) {
            c+=i;
        }
        //System.out.print(b*(b+1)/2-a*(a-1)/2);
        System.out.println(c);
    }
}