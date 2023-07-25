import java.util.Scanner;
//Bạn hãy viết chương trình nhập từ bàn phím số nguyên n
// và hiển thị ra màn hình số các ước số của n.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int count=0;
        int i=1;
        while(i<=a){
            if(a%i==0){
                count++;
            }i++;
        }
        System.out.println(count);
    }
}