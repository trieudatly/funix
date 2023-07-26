import java.util.Scanner;

//Cho một mảng các số nguyên n phần tử arr và số nguyên k được nhập từ bàn phím.
// Bạn hãy viết chương trình hiển thị ra màn hình
// số phần tử có giá trị bằng k trong mảng arr.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
		int count=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]==k){
                count++;
            }
        }
        System.out.println(count);

    }
}