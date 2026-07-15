import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Assume there are 5 students and each student has grades in 3 subjects.
        //

        String[] students = new String[5];
        double[][] grade = new double[5][3];

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your student names and grades:");

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter Student [" + i + "] name:");
            students[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                // Grades must be between 0 and 100. If an invalid grade is entered, print 'Invalid grade.'
                // we use do while to ask again
                do {
                    System.out.println("Enter grade of Subject [" + j + "]:");
                    grade[i][j] = sc.nextDouble();

                    if (grade[i][j] < 0 || grade[i][j] > 100) {
                        System.out.println("Invalid grade.");
                    }
                } while (grade[i][j] < 0 || grade[i][j] > 100);
            }

            sc.nextLine(); // why because do not skip a line in the output
        }

        System.out.println("/////////////////////////////////////////");

        System.out.println("Main Menu");
        System.out.println("1. Show All Students names.");
        System.out.println("2. Show all Students grades in each subject.");
        System.out.println("3. Search Student by name.");
        System.out.println("4. Count Passed Students");
        System.out.println("0. Exit");

        System.out.println("choice");
        int choice = sc.nextInt();
        sc.nextLine();

        int count = 0;

        switch (choice) {
            case 1:
                for (int i = 0; i < students.length; i++) {
                    System.out.println("Student Names is " + students[i]);
                }
                break;

            case 2:
                for (int i = 0; i < students.length; i++) {
                    System.out.print("Grades for " + students[i] + ": ");
                    for (int j = 0; j < 3; j++) {
                        double g = grade[i][j];
                        char letter;
                        if (g >= 85) letter = 'A';
                        else if (g >= 75) letter = 'B';
                        else if (g >= 65) letter = 'C';
                        else if (g >= 50) letter = 'D';
                        else letter = 'F';

                        System.out.print("[Subject " + j + ": " + g + " (" + letter + ")] ");
                    }

                    System.out.println();
                }
                break;

            case 3:
                boolean found = false; // to solve not found repetition  // HOW  => we create  boolean found that if found name return true else return false and print not found once
                System.out.print("\nEnter student name to search: ");
                String searchName = sc.nextLine();

                for (int i = 0; i < students.length; i++) {
                    // why use equalsIgnoreCase because student probably enter your name capital or small letters
                    if (students[i].equalsIgnoreCase(searchName)) {
                        System.out.println("Student Found! " + students[i] + " is at index [" + i + "]");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found!");
                }
                break;

            case 4:
                for (int i = 0; i < students.length; i++) {
                    double sum = 0;
                    for (int j = 0; j < 3; j++) {
                        sum += grade[i][j];
                    }
                    double average = sum / 3;

                    if (average >= 60) {
                        System.out.println(students[i] + " passed");
                        count++;
                    } else {
                        System.out.println(students[i] + " Failed");
                    }
                }
                System.out.println("the number of student passed is " + count);
                break;

            case 0:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}