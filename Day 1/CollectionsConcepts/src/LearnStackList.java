import java.util.*;
public class LearnStackList {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.push("cat");
        animals.push("dog");
        animals.push("horse");

        System.out.println("Stack" + animals);

        System.out.println("on top "+animals.peek());

    }
}
