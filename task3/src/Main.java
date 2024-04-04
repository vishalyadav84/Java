import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");

        // Assuming three subjects for simplicity, you can modify this based on your needs
        System.out.print("Subject 1: ");
        int subject1Marks = scanner.nextInt();

        System.out.print("Subject 2: ");
        int subject2Marks = scanner.nextInt();

        System.out.print("Subject 3: ");
        int subject3Marks = scanner.nextInt();

        // Calculate Total Marks: Sum up the marks obtained in all subjects
        int totalMarks = subject1Marks + subject2Marks + subject3Marks;

        // Calculate Average Percentage: Divide the total marks by the total number of subjects
        double averagePercentage = totalMarks / 3.0;

        // Grade Calculation: Assign grades based on the average percentage achieved
        char grade = calculateGrade(averagePercentage);

        // Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
