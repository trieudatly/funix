import java.util.Scanner;

//Given a string,s , and an integer,k ,
// complete the function so that it
// finds the lexicographically smallest and largest substrings of length k.
public class Main {
    public static String getSmallestAndLargest(String s, int k) {
        int stringlenght = s.length();
        int subCount = stringlenght - k + 1;
        String[] arr = new String[subCount];
        for (int i = 0; i < subCount; i++) {
            arr[i] = s.substring(i, i + k);
        }
        //System.out.println(Arrays.toString(arr));
        String smallest = arr[0];
        String largest = arr[0];
        for (String str : arr
        ) {
            if (largest.compareTo(str) < 0)
                largest = str;
        }
        for (String str : arr
        ) {
            if (smallest.compareTo(str) > 0)
                smallest = str;
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}