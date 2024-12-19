
public class Rectangle implements Shape {

    public double length;
    public double width;

    public double area(){
        return length*width;
    }
    public double perimeter(){
        return (length*2) +(width*2);
    }

}
