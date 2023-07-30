import java.util.Scanner;

public class Main {
    //https://www.hackerrank.com/challenges/java-negative-subarray/problem
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        int count=0;
        //vòng lập từ đầu đến cuối mảng
        for (int i = 0; i <n; i++) {
            int temp=0;
            //mỗi lần lập sẽ tính tổng các phần tử bắt đầu từ i
            // cho đến phần tử kế tiếp cho đến cuối mảng
            for (int j = i; j < n; j++) {
                //System.out.println("j= "+j);
                temp+=arr[j];
                //mỗi lần như vậy coi như 1 subarray
                //nếu tổng subarray <0 thì tăng biến count 1 đơn vị
                if (temp<0){
                    count++;
                }
                //System.out.println("temp= "+temp);
            }
        }
        System.out.println(count);
    }
}