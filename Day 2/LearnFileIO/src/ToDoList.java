import java.io.*;
import java.util.Scanner;

class TaskWriter {

    public static void writeTask(String task) {
        String fullEntry =  task;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ToDoList.txt"));
            writer.write(fullEntry);
            writer.newLine();
            System.out.println(" Task logged successfully!");
            writer.close();
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }
}

class TaskReader {

    public static void readTasks() {
        System.out.println("\n Task Log:");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ToDoList.txt"));
            String line;
            boolean hasContent = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasContent = true;
            }
            if (!hasContent) {
                System.out.println("No tasks logged yet.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Task file not found.");
        } catch (IOException e) {
            System.out.println(" Error reading from file: " + e.getMessage());
        }
    }
}

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add new task");
            System.out.println("2. View task log");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your task: ");
                    String task = scanner.nextLine();
                    TaskWriter.writeTask(task);
                    break;

                case 2:
                    TaskReader.readTasks();
                    break;

                case 3:
                    System.out.println("Exiting Task Logger.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);
    }
}
