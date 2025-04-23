/**
 * Class representing a student record with grades.
 * This class demonstrates basic OOP principles and data encapsulation.
 */
public class Student {
    // Private fields for student data
    private String studentId;
    private String name;
    private int[] grades;
    private double averageGrade;
    private char letterGrade;
    
    /**
     * Constructor to initialize a Student object
     * @param studentId The student's ID
     * @param name The student's name
     * @param grades Array of the student's grades
     */
    public Student(String studentId, String name, int[] grades) {
        this.studentId = studentId;
        this.name = name;
        this.grades = grades;
        this.averageGrade = calculateAverage();
        this.letterGrade = determineLetterGrade();
    }
    
    /**
     * Calculates the average of all grades
     * @return The average grade as a double
     */
    private double calculateAverage() {
        if (grades.length == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        
        return (double) sum / grades.length;
    }
    
    /**
     * Determines the letter grade based on the average
     * @return A character representing the letter grade (A, B, C, D, or F)
     */
    private char determineLetterGrade() {
        if (averageGrade >= 90) {
            return 'A';
        } else if (averageGrade >= 80) {
            return 'B';
        } else if (averageGrade >= 70) {
            return 'C';
        } else if (averageGrade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    // Getters for all fields
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int[] getGrades() {
        return grades;
    }
    
    public double getAverageGrade() {
        return averageGrade;
    }
    
    public char getLetterGrade() {
        return letterGrade;
    }
    
    /**
     * Returns a string representation of the student
     * @return String containing all student information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(studentId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Grades: ");
        
        for (int i = 0; i < grades.length; i++) {
            sb.append(grades[i]);
            if (i < grades.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("\nAverage Grade: ").append(String.format("%.2f", averageGrade));
        sb.append("\nLetter Grade: ").append(letterGrade);
        
        return sb.toString();
    }
}