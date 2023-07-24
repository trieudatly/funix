import java.util.Scanner;

public class Main {
    public static double circumference(double r) {
        return 2 * r * 3.14;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.print(circumference(r));
    }
}