import java.util.HashSet;
import java.util.Set;

public class LearnHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(14);
        set.add(22);
        set.add(39);
        set.add(45);
        set.add(58);

        System.out.println(set);

        set.remove(14);
        System.out.println(set);
        System.out.println(set.size());
    }
}
