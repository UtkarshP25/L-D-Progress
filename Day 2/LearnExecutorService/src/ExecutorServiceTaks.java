import java.util.*;
import java.util.concurrent.*;

class StudentReportTask implements Callable<String> {

    private String studentName;
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Report generated for " + studentName + " Grade: A";
    }

    StudentReportTask(String studentName) {
        this.studentName = studentName;
    }

}

public class ExecutorServiceTaks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> futureList = new ArrayList<>();

        String[] students = {"Utkarsh", "Manas", "Vaishnavi", "Swanand", "Vinit"};

        // Submit 5 report tasks
        for (String student : students) {
            StudentReportTask task = new StudentReportTask(student);
            Future<String> future = executor.submit(task);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            String result = future.get();
            System.out.println(result);
        }

        executor.shutdown();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Reminder: Submit attendance report");
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduler.shutdown();

        System.out.println("All tasks completed.");

    }
}
