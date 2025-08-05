import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String N;
    int A;
    String D;
    String R;

    Student(String N, int A, String D, String R) {
        this.N = N;
        this.A = A;
        this.D = D;
        this.R = R;
    }

    public String toString() {
        return "Name: " + N + ", Age: " + A + ", Department: " + D + ", Roll No: " + R;
    }
}

public class Student_Manage {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        ArrayList<Student> student = new ArrayList<>();

        int C;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            C = S.nextInt();
            S.nextLine(); 

            switch (C) {
                case 1:
                    System.out.print("Name: ");
                    String N = S.nextLine();
                    System.out.print("Age: ");
                    int A = S.nextInt();
                    S.nextLine();
                    System.out.print("Department: ");
                    String D = S.nextLine();
                    System.out.print("Roll No: ");
                    String R = S.nextLine();

                    student.add(new Student(N, A, D, R));
                    System.out.println("Student Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll No of student to update: ");
                    String rollU = S.nextLine();
                    boolean foundU = false;

                    for (Student s : student) {
                        if (s.R.equals(rollU)) {
                            foundU = true;
                            System.out.println("\n--- Select Field to Update ---");
                            System.out.println("1. Name.");
                            System.out.println("2. Age.");
                            System.out.println("3. Department.");
                            System.out.println("4. Roll Number.");
                            System.out.print("Enter your choice: ");
                            int fieldC = S.nextInt();
                            S.nextLine();

                            switch (fieldC) {
                                case 1:
                                    System.out.print("Enter New Name: ");
                                    s.N = S.nextLine();
                                    System.out.println("Name updated.");
                                    break;
                                case 2:
                                    System.out.print("Enter New Age: ");
                                    s.A = S.nextInt();
                                    S.nextLine(); 
                                    System.out.println("Age updated.");
                                    break;
                                case 3:
                                    System.out.print("Enter New Department: ");
                                    s.D = S.nextLine();
                                    System.out.println("Department updated.");
                                    break;
                                case 4:
                                    System.out.print("Enter New Roll Number: ");
                                    s.R = S.nextLine();
                                    System.out.println("Roll Number updated.");
                                    break;
                                default:
                                    System.out.println("Invalid field choice.");
                            }
                            break;
                        }
                    }

                    if (!foundU) {
                        System.out.println("Student with Roll No " + rollU + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No of student to delete: ");
                    String rollToDelete = S.nextLine();
                    boolean removed = student.removeIf(s -> s.R.equals(rollToDelete));
                    if (removed) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student with Roll No " + rollToDelete + " not found.");
                    }
                    break;

                case 4:
                    if (student.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("All Student Records:");
                        for (Student s : student) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (C != 5);

        S.close();
    }
}
