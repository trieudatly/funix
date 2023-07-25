import java.util.Scanner;

//Given a string ,
// print Yes if it is a palindrome,
// print No otherwise.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String left = "";
        String right = "";
        String revertRight="";
        char ch;
        int stringLenght = a.length();
        //lấy độ dài của chuỗi
        //tách đều 2 bên trái phải của chuỗi
        //nếu chuỗi có độ dài là số lẻ thì bỏ qua ký tự ở giữa
        if (stringLenght % 2 == 0) {
            left = a.substring(stringLenght / 2);
            right = a.substring(0, stringLenght / 2);
        } else {
            left = a.substring(stringLenght / 2 + 1);
            right = a.substring(0, stringLenght / 2);
        }
        //đảo ngược chuỗi bên phải
        for (int i=0; i<right.length(); i++)
        {
            ch= right.charAt(i);
            revertRight= ch+revertRight;
        }
        //so sánh 2 chuỗi có giống nhau không
        String result=(left.compareTo(revertRight)==0)?"Yes":"No";
        System.out.println(result);
    }
}