import java.util.Scanner;
//Cho một mảng các số nguyên n phần tử arr.
// Bạn hãy viết chương trình sắp xếp các phần tử của mảng theo thứ tự tăng dần
// và hiển thị ra màn hình mảng sau khi đã sắp xếp.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //System.out.println(Arrays.toString(arr));
                if (arr[i] > arr[j]) {
                    //System.out.println(Arrays.toString(arr));
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //System.out.println(Arrays.toString(arr));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}