import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 implements Runnable {
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}

public class LearnExcutorSevice {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            service.execute(new Task1());
        }

        System.out.println("Thread Name: " + Thread.currentThread().getName());

    }
}