public class Main {
    public static void main(String[] args) {
        Point vertice1 = new Point(1, 3);
        Point vertice2 = new Point(2, 3);
        Point vertice3 = new Point(4, 2);
        Triangle triangle1 = new Triangle(vertice1, vertice2, vertice3);
        Triangle triangle2 = new Triangle(4, 5, 2, 6, 3, 7);
        System.out.println(triangle1.getPerimeter());
        System.out.println(triangle2.getPerimeter());
    }
}