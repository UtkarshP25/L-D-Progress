class Vehicle{
    protected String brand = "tata";
    protected  void start(){
        System.out.println("Starting Vehicle" + brand);
    }
}

class Car extends Vehicle{
    private String model = "Vista";
    protected  void start(){
        System.out.println("Starting Car" + " " + brand + " " + model );
    }
}

public class LearnInheritance {
    public static void main(String[] args) {
        Car obj = new Car();
        obj.start();


    }
}
