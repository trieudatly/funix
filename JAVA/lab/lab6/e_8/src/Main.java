import java.util.Scanner;

//Given a string, s , matching the regular expression [A-Za-z !,?._'@]+,
// split the string into tokens.
// We define a token to be one or more consecutive English alphabetic letters.
// Then, print the number of tokens, followed by each token on a new line.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int count=0;
        //	\\W Bất kỳ ký tự nào không phải chữ cái và chữ số
        //   + xảy ra một hoặc nhiều lần
        //String[] words=s.split("[\\s|!|,|\\?|.|_|'|@]");
        String[] words=s.split("\\W+|_");
        for (String w : words) {
            if(w.compareTo("")!=0) {
                count++;
            }
        }
        System.out.println(count);
        for (String w : words) {
            if(w.compareTo("")!=0) {
                System.out.println(w);
            }
        }
        scan.close();
    }
}
