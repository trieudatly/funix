public class Main {
    public static void main(String[] args) {
        Point begin = new Point(1, 1);
        Point end = new Point(2, 2);
        Line line1 = new Line(begin, end);
        System.out.println(line1.getLength());

        Line line2 = new Line(2, 3, 5, 4);
        System.out.println(line2.getLength());
    }
}