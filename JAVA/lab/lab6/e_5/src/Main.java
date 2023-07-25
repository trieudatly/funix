import java.util.Scanner;

//Given two strings of lowercase English letters, a and b, perform the following operations:
//Sum the lengths of a and b.
//Determine if a is lexicographically larger than b
// (i.e.: does b come before a in the dictionary?).
//Capitalize the first letter in a and b and print them on a single line, separated by a space.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int lenghtSum = a.length() + b.length();
        System.out.println(lenghtSum);
        if (a.compareTo(b) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        a = Character.toUpperCase(a.charAt(0)) + a.substring(1);
        b = Character.toUpperCase(b.charAt(0)) + b.substring(1);
        System.out.println(a + " " + b);
    }
}