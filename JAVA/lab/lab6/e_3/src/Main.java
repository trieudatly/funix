import java.util.Scanner;
//The challenge here is to read n lines of input until you reach EOF,
// then number and print all  lines of content.
//Hint: Java's Scanner.hasNext() method is helpful for this problem.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(counter + " " + line);
            counter++;
        }
    }
}