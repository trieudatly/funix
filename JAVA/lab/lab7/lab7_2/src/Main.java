import java.util.Scanner;

//Cho một mảng các số nguyên n phần tử arr được nhập từ bàn phím.
// Bạn hãy viết chương trình hiển thị ra phần tử lớn nhất trong mảng.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int max=arr[0];
        for (int i = 1; i < n; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
}