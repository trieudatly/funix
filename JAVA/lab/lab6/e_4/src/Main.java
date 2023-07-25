import java.util.Scanner;
//You are given a class Solution with a main method.
// Complete the given code so that it outputs the area of a parallelogram
// with breadth  and height . You should read the variables from the standard input.
//If breadth <=0 or height<=0 , the output should be
// "java.lang.Exception: Breadth and height must be positive" without quotes.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();
        int h=sc.nextInt();
        int aria=b*h;
        if (b<=0||h<=0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else{
            System.out.println(aria);
        }

    }
}