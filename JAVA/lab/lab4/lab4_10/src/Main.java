import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if (a.equals(b)) {
            System.out.println("two people have the same name");
        } else {
            System.out.println("two people don't have the same name");
        }
    }
}