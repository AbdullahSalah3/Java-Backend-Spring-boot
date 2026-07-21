import java.util.Scanner;

public class Main {

    private static void displayMenu() {
        System.out.println("============================================");
        System.out.println("                 MAIN MENU                  ");
        System.out.println("============================================");
        System.out.println("1. Display Students");
        System.out.println("2. Calculate Average Grade");
        System.out.println("3. Find Highest Grade");
        System.out.println("4. Search Student by ID");
        System.out.println("0. Exit");
        System.out.println("============================================");
    }


    private static void displayStudents(Student[] students) {
        if (students.length == 0) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (int i = 0; i < students.length; i++) {
            students[i].print();
        }
    }


// mean calculate average = sum/count(size of array)
    private static void calculateAverageGrade(Student[] students) {
        if (students.length == 0){
            return;
        }
        double sum = 0;
        for (int i =0 ; i<students.length ; i++) {
            sum += students[i].getGrade();
        }
        System.out.printf("Average Grade: " +  (sum / students.length));
    }



    private static void findHighestGrade(Student[] students) {
        if (students.length == 0) return;

        Student topStudent = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getGrade() > topStudent.getGrade()) {
                topStudent = students[i];
            }
        }
        System.out.println("Top Performing Student:");
        topStudent.print();
    }

    // 4. Search Student by ID
    private static void searchStudentById(Student[] students, Scanner sc) {
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (s.getStudentsID().equals(searchId)) {
                System.out.println("Student Found:");
                s.print();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student number: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline after nextInt()

        Student[] students = new Student[n];

        // Read Student Data
        for (int i = 0; i < students.length; i++) {
            System.out.println("\n--- Entering Student [" + (i + 1) + "] ---");

            System.out.print("Enter ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(id, name, grade);
        }

        // Main Interactive Menu
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayStudents(students);
                    break;
                case 2:
                    calculateAverageGrade(students);
                    break;
                case 3:
                    findHighestGrade(students);
                    break;
                case 4:
                    searchStudentById(students, sc);
                    break;
                case 0:
                    System.out.println("Exiting System.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}