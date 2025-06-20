import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {
    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.offer(21);
        pq.offer(39);
        pq.offer(45);
        pq.offer(12);

        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq);

    }
}
