class Employee{
    public void display(){
        System.out.println("I'm an employee");
    }
}
class Manager extends Employee{
    @Override
    public void display(){
        System.out.println("I'm a manager");
    }
}
public class Main {
    public static void main(String[] args) {
Employee e=new Manager();
e.display();
    }
}