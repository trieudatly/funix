public class Main{
    public static void main(String[] args){
        Rectangle r = new Rectangle(4, 5);
        System.out.println("Area: " + r.getArea());
        System.out.println("Perimeter: " + r.getPerimeter());
        r.setLength(2);
        r.setWidth(3);
        System.out.println("Area: " + r.getArea());
        System.out.println("Perimeter: " + r.getPerimeter());
    }
}