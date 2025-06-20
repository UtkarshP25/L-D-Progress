import java.util.*;
public class LearnQueueList {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(11);
        que.offer(22);
        que.offer(33);
        que.offer(44);
        que.offer(55);

        System.out.println(que);

        System.out.println(que.poll());

        System.out.println(que);

        System.out.println(que.peek());
    }
}
