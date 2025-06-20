import java.util.*;

class Student {
    String name;
    int rollNumber;
    float marks;

    public Student(String name, int rollNumber, float marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNumber + ", Marks: " + marks);
    }
}

public class LearnArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Search student by roll number");
            System.out.println("4. Remove student by roll number");
            System.out.println("5. Sort students by marks");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    String name = sc.next();
                    System.out.println("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.println("Enter marks: ");
                    float marks = sc.nextFloat();
                    studentList.add(new Student(name, roll, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (studentList.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("Student List:");
                        for (Student s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.rollNumber == searchRoll) {
                            System.out.println("Student found:");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with roll number " + searchRoll + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter roll number to remove: ");
                    int removeRoll = sc.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).rollNumber == removeRoll) {
                            studentList.remove(i);
                            System.out.println("Student removed successfully.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student with roll number " + removeRoll + " not found.");
                    }
                    break;

                case 5:
                    if (studentList.isEmpty()) {
                        System.out.println("No students to sort.");
                    } else {
                        Collections.sort(studentList, new Comparator<Student>() {
                            public int compare(Student s1, Student s2) {
                                return Float.compare(s2.marks, s1.marks); // Descending order
                            }
                        });
                        System.out.println("Students sorted by marks (highest to lowest):");
                        for (Student s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
