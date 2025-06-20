import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LearnHashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Sentence : ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        Map<String, Integer> wordcount = new HashMap<>();
        for (String word : words) {
            wordcount.put(word, wordcount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordcount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
