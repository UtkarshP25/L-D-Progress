import java.util.Scanner;

public class LearnCustomExc {

    public static void validateAge(int age) throws InvalidAge {
        if (age < 18) {
            throw new InvalidAge("You must be at least 18 years old.");
        } else {
            System.out.println("Age is valid. Access granted.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validateAge(age);
        } catch (InvalidAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
