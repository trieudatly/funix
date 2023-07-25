import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 1; j <= n; j++) {
                int e = 0;
                for (int k = 0; k < j; k++) {
                    int d = 1;
                    for (int l = 0; l < k; l++) {
                        d = d * 2;
                    }
                    e = d * b;
                }
                a += e;
                System.out.print(a + " ");
            }
//            int sum = a;
//            int c = 1;
//            for(int j=0;j<n;j++){
//                sum = sum + c*b;
//                System.out.print(sum+" ");
//                c = c*2;
//            }
            System.out.println();
        }
        in.close();
    }
}