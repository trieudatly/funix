public class Rectangle{
    private double length;
private double width;

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public Rectangle(){

    }
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }

    public double getArea(){
        double area;
        area=(this.length*this.width);
        return area;
    }
    public double getPerimeter(){
        double perimeter;
        perimeter=(this.length+this.width)*2;
        return perimeter;
    }
}
