@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class LearnLambdaExp {
    public static void main(String[] args) {

        Calculator add = (a,b) -> a + b;
        Calculator sub = (a,b) -> a - b;
        Calculator mul = (a,b) -> a * b;
        Calculator div = (a,b) -> a / b;

        System.out.println("Addition is: " + add.operate(10,20));
        System.out.println("Subtraction is: " + sub.operate(10,20));
        System.out.println("Multiplication is: " + mul.operate(10,20));
        System.out.println("Division is: " + div.operate(10,20));

    }
}
