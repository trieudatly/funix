public class Rectangle implements IShape {
    private double lenght;
    private double width;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double getArea() {
        return lenght * width;
    }

    @Override
    public double getPerimeter() {
        return (lenght + width) * 2;
    }
}
