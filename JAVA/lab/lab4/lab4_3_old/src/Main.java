import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if (score >= 0 && score <= 10) {
            System.out.println("The score is valid");
        } else {
            System.out.println("The score is not valid");
        }
    }
}