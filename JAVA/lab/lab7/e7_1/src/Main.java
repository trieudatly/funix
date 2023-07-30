import java.util.Scanner;

//Two strings,a  and b, are called anagrams
// if they contain all the same characters in the same frequencies.
// For this challenge, the test is not case-sensitive.
// For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
public class Main {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            char[] c = a.toLowerCase().toCharArray();
            char[] d = b.toLowerCase().toCharArray();
            for (char item : c) {
                int countc = 0;
                int countd = 0;
                for (char element : c) {
                    if (item == element) {
                        countc++;
                    }
                }
                for (char element : d) {
                    if (item == element) {
                        countd++;
                    }
                }
                if (countd != countc) {
                    return false;
                }
            }
        }return true;

        //System.out.println(Arrays.toString(c));
        //System.out.println(Arrays.toString(d));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}