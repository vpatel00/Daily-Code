/**
 * Class for managing a collection of student records.
 * This class demonstrates basic collection management and exception handling.
 */
import java.util.ArrayList;
import java.util.List;

public class StudentRecordsManager {
    private List<Student> students;

    /**
     * Constructor to initialize the student records manager
     */
    public StudentRecordsManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the records
     * @param student The student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Retrieves a student by their ID
     * @param studentId The ID of the student to find
     * @return The student object if found, null otherwise
     */
    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Calculates the class average across all students
     * @return The average grade of all students
     */
    public double calculateClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getAverageGrade();
        }
        return sum / students.size();
    }

    /**
     * Returns a string representation of all student records
     * @return String containing all student information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Records:\n");
        sb.append("----------------\n");
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
            sb.append("----------------\n");
        }
        sb.append("Class Average: ").append(String.format("%.2f", calculateClassAverage()));
        return sb.toString();
    }
}