import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
       // Supplier<String>ILoveJava=()->"I love Java!";
        Supplier<String>ILoveJava=()->{return "I love Java!";};
        String supplierResult=ILoveJava.get();
        System.out.println(supplierResult);
    }
}