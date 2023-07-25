import java.util.Scanner;

//Bạn hãy viết chương trình nhập vào từ bàn phím số nguyên a và b.
// Sau đó hiển thị ra màn hình các số chia hết cho 3 từ a tới b
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        for (int i = a; i <=b ; i++) {
            if(i%3==0){
                System.out.print(i+" ");
            }
        }

    }
}