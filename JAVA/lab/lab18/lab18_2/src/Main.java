import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> lamdaFunction = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        String test = "1234567890";
        System.out.println(everySecondChar(lamdaFunction,test));
        //System.out.println(lamdaFunction.apply(test));
    }

    public static String everySecondChar(Function<String, String> func, String source) {
        return func.apply(source);
    }
}