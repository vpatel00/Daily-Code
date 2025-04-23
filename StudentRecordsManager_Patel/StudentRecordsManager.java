import java.io.*;
import java.util.*;

/**
 * Main class that manages student records.
 * This class demonstrates file I/O and exception handling in Java.
 * 
 * The StudentRecordsManager handles:
 * - Reading student data from CSV files
 * - Processing and validating the data
 * - Calculating statistics
 * - Writing formatted results to output files
 * - Proper exception handling throughout the process
 */
public class StudentRecordsManager {
    
    /**
     * Main method to run the program.
     * Handles user input and delegates processing to other methods.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        StudentRecordsManager manager = new StudentRecordsManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter input filename: ");
        String inputFile = scanner.nextLine();
        
        System.out.print("Enter output filename: ");
        String outputFile = scanner.nextLine();
        
        try {
            manager.processStudentRecords(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("Error processing student records: " + e.getMessage());
            e.printStackTrace();
        } finally {
            /**
             * The scanner is closed in the finally block to ensure resources are
             * properly released regardless of whether an exception occurred.
             * This demonstrates proper resource management.
             */
            scanner.close();
        }
    }
    
    /**
     * Process student records from an input file and write results to an output file.
     * This method orchestrates the entire data processing workflow.
     * 
     * @param inputFile Path to the input file containing student records
     * @param outputFile Path to the output file where results will be written
     */
    public void processStudentRecords(String inputFile, String outputFile) {
        try {
            List<Student> students = readStudentRecords(inputFile);
            writeResultsToFile(students, outputFile);
            System.out.println("Student records processed successfully! Results written to " + outputFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            System.err.println("Please check if the file exists and the path is correct.");
        } catch (IOException e) {
            System.err.println("Input/output error occurred: " + e.getMessage());
            System.err.println("Please check file permissions and available disk space.");
        }
    }
    
    /**
     * Read student records from a file and convert them to Student objects.
     * This method demonstrates file reading operations and exception handling.
     * 
     * @param filename Path to the input file
     * @return List of Student objects created from the file data
     * @throws IOException If an I/O error occurs during file reading
     */
    public List<Student> readStudentRecords(String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 6) {
                        System.err.println("Warning: Line " + lineNumber + " has insufficient data: " + line);
                        continue;
                    }
                    
                    String studentId = parts[0].trim();
                    String name = parts[1].trim();
                    
                    int[] grades = new int[4];
                    for (int i = 0; i < 4; i++) {
                        grades[i] = Integer.parseInt(parts[i + 2].trim());
                        
                        if (grades[i] < 0 || grades[i] > 100) {
                            throw new InvalidGradeException("Grade value " + grades[i] + " is outside valid range (0-100)");
                        }
                    }
                    
                    Student student = new Student(studentId, name, grades);
                    students.add(student);
                    
                } catch (NumberFormatException e) {
                    System.err.println("Error on line " + lineNumber + ": Invalid grade format - " + e.getMessage());
                } catch (InvalidGradeException e) {
                    System.err.println("Error on line " + lineNumber + ": " + e.getMessage());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error on line " + lineNumber + ": Missing data - " + e.getMessage());
                }
            }
        }
        
        return students;
    }
    
    /**
     * Write processed student results to an output file.
     * This method demonstrates file writing operations.
     * 
     * @param students List of Student objects to be written to the file
     * @param filename Path to the output file
     * @throws IOException If an I/O error occurs during file writing
     */
    public void writeResultsToFile(List<Student> students, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header
            writer.println("==============================");
            writer.println("STUDENT RECORDS ANALYSIS");
            writer.println("==============================");
            writer.println();
            
            // Write individual student information
            for (Student student : students) {
                writer.println(student.toString());
                writer.println("------------------------------");
            }
            
            // Calculate and write statistics
            int totalStudents = students.size();
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
            double sumGrades = 0.0;
            
            for (Student student : students) {
                sumGrades += student.getAverageGrade();
                
                switch (student.getLetterGrade()) {
                    case 'A': countA++; break;
                    case 'B': countB++; break;
                    case 'C': countC++; break;
                    case 'D': countD++; break;
                    case 'F': countF++; break;
                }
            }
            
            double classAverage = totalStudents > 0 ? sumGrades / totalStudents : 0;
            
            // Write statistics section
            writer.println("\nCLASS STATISTICS");
            writer.println("==============================");
            writer.println("Total number of students: " + totalStudents);
            writer.println("Class average grade: " + String.format("%.2f", classAverage));
            writer.println("\nGrade Distribution:");
            writer.println("A: " + countA + " students (" + 
                    String.format("%.1f", totalStudents > 0 ? (100.0 * countA / totalStudents) : 0) + "%)");
            writer.println("B: " + countB + " students (" + 
                    String.format("%.1f", totalStudents > 0 ? (100.0 * countB / totalStudents) : 0) + "%)");
            writer.println("C: " + countC + " students (" + 
                    String.format("%.1f", totalStudents > 0 ? (100.0 * countC / totalStudents) : 0) + "%)");
            writer.println("D: " + countD + " students (" + 
                    String.format("%.1f", totalStudents > 0 ? (100.0 * countD / totalStudents) : 0) + "%)");
            writer.println("F: " + countF + " students (" + 
                    String.format("%.1f", totalStudents > 0 ? (100.0 * countF / totalStudents) : 0) + "%)");
        }
    }
}