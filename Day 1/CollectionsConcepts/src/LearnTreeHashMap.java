import java.util.Map;
import java.util.TreeMap;

public class LearnTreeHashMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> score = new TreeMap<>();
        score.put("utkarsh", 11);
        score.put("vinit", 23);
        score.put("akshar", 35);
        score.put("karak", 47);

        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
