import java.util.Scanner;

//Bạn hãy viết chương trình nhập vào từ bàn phím
// 10 số nguyên và hiển thị ra 10 số vừa nhập.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}