import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //public static boolean canWin(int leap, int[] game) {
    //Return true if you can win the game; otherwise, return false.
    //        for (int j = 0; j < game.length; j++) {
    //            System.out.println("[" + j + "] " + game[j]);
    //        }
    //        ArrayList<Integer> visitedList = new ArrayList<Integer>();
    //        visitedList.add(0);
    //        int i = 0;
    //        while (i < game.length - 1) {
    //            if (i + leap >= game.length) {
    //                return true;
    //            }
    //            if (canGoBack(visitedList, game, i)) {
    //                i--;
    //                visitedList.add(i);
    //            } else if (canGoNext(visitedList, game, i)) {
    //                i++;
    //                visitedList.add(i);
    //            } else if (canLeaf(visitedList, game, i, leap)) {
    //                i = i + leap;
    //                visitedList.add(i);
    //            } else {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //
    //    public static boolean visited(ArrayList visitedList, int i) {
    //        if (visitedList.contains(i)) {
    //            return true;
    //        }
    //        return false;
    //    }
    //
    //    public static boolean canGoNext(ArrayList visitedList, int[] game, int i) {
    //        if (!visited(visitedList, i + 1) && game[i + 1] == 0) {
    //            return true;
    //        }
    //        return false;
    //    }
    //
    //    public static boolean canGoBack(ArrayList visitedList, int[] game, int i) {
    //        if (i - 1 > 0) {
    //            if (!visited(visitedList, i - 1) && game[i - 1] == 0) {
    //                return true;
    //            }
    //        }
    //
    //        return false;
    //    }
    //
    //    public static boolean canLeaf(ArrayList visitedList, int[] game, int i, int leap) {
    //        if ((!visited(visitedList, i + leap) && game[i + leap] == 0)) {
    //            return true;
    //        }
    //        return false;
    //    }
    public static boolean canWin(int leap, int[] game) {
        int index = 0;
        ArrayList<Integer> added = new ArrayList<Integer>();


        if (game[index + 1] == 0)
            added.add(index + 1);
        if (index - 1 >= 0 && game[index - 1] == 0)
            added.add(index - 1);
        if (index + leap < game.length && game[index + leap] == 0)
            added.add(index + leap);
        if (leap >= game.length)
            return true;


        int bufferLength = 0;
        while (true) {
            int count = 0;
            bufferLength = added.size();
            //            System.out.println("added= " + added);
            //            System.out.println("added.size= " + added.size());
            //            System.out.println("count= " + count);
            while (count < added.size()) {
                //System.out.println("added.get(" + count + ")= " + added.get(count));
                if ((added.get(count) + leap > game.length - 1) || (added.get(count) + 1 > game.length - 1))
                    return true;
                if (game[added.get(count) + 1] == 0) {
                    if (!added.contains(added.get(count) + 1))
                        added.add(added.get(count) + 1);
                }
                if (added.get(count) - 1 >= 0 && game[added.get(count) - 1] == 0) {
                    if (!added.contains(added.get(count) - 1))
                        added.add(added.get(count) - 1);
                }
                if (game[added.get(count) + leap] == 0) {
                    if (!added.contains(added.get(count) + leap))
                        added.add(added.get(count) + leap);
                }
                //                System.out.println("added= " + added);
                //                System.out.println("added.size= " + added.size());
                count++;

            }
            //nếu size ko đổi tức là ko có gì thêm vào arraylist
            if (bufferLength == added.size())
                return false;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
