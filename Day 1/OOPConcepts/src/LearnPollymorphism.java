class Shape{
    void area(){
        System.out.println("Area of Shape");
    }
}

class Rectangle extends Shape{
    void area(){
        System.out.println("Area of Rectangle");
    }
}

class Circle extends Shape{
    void area(){
        System.out.println("Area of Circle");
    }
}

public class LearnPollymorphism {
    public static void main(String[] args) {
        Shape shapeObj = new Shape();
        Rectangle rectangleObj = new Rectangle();
        Circle circleObj = new Circle();

        shapeObj.area();
        rectangleObj.area();
        circleObj.area();

    }
}
