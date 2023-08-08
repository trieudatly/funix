import java.util.Scanner;
class Student{
    private String name;
    private int age;

    public void display(){
        System.out.println("Name: " + name+"\nAge: "+age);
    }
    public void getInformation(){
        Scanner sc=new Scanner(System.in);
        name=sc.next();
        age=sc.nextInt();
    }
}
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.getInformation();
        s1.display();
    }
}