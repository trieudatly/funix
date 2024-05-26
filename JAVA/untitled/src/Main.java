import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Creating an array list
        ArrayList<Integer> numbers = new ArrayList<>();

// Add elements
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Unsorted ArrayList: " + numbers);

// 1. Using the sort() method
        Collections.sort(numbers);
        System.out.println(numbers);
// 2. Sort the ArrayList in ascending order
        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);
//        int var1 = 5;
//        int var2 = 6;
//        int var3;
//        var3 = ++var2 * var1 / var2 + var2;
//        System.out.println(var3);
//        int ascii[] = { 65, 66, 67, 68 };
//        String s = new String(ascii, 1, 3);
//        System.out.println(s);
//        StringBuffer sb = new StringBuffer("Hello Viblo");
//        sb.replace(1, 3, "Java");
//        System.out.println(sb);
//        String s1 = "Hello World";
//        String s2 = s1.substring(0, 4);
//        System.out.println(s2);
//        double a = 0.02;
//        double b = 0.03;
//        double c = b - a;
//        System.out.println(c);
//        int z = 888;
//        byte x = 10;
//        char y = 'c';
//        System.out.println(x + y + z);
//        StringBuffer aaaa=new StringBuffer("sdaa");
//        aaaa.s
//        A obj1 = new A();
//        System.out.print(obj1.toString());
//        double aa;
//        aa = 0.0 / 0.0;
//        System.out.println(aa);
//        double var1 = 1 + 5;
//        double var2 = var1 / 4;
//        int var3 = 1 + 5;
//        int var4 = var3 / 4;
//        System.out.println(var2 + " " + var4);
//        int x = 3;
//        int y = ~x;
//        int z;
//        z = x > y ? x : y;
//        System.out.println(z);
//        int a = 5;
//        int b = 10;
//        first: {
//            second: {
//                third: {
//                    if (a == b >> 1)
//                        break second;
//                }
//                System.out.println(a);
//            }
//            System.out.println(b);
//        }
//        test obj = new test();
//        int a = 10;
//        int b = 20;
//        obj.meth(a, b);
//        System.out.println(a + " " + b);
    }

}
class A {
    int i;
    int j;

    A() {
        i = 1;
        j = 2;
    }

}
class test {
    int a;
    int b;

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }}