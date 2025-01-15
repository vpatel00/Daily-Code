// If you're running this in an online IDE, remember the class has to be named the same name as the file
public class FizzBuzzJava
{
    public static void main(String[] args) {
        int three = 3;
        int five = 5;
        int fifteen = 15;
        int number = 23;

        // Fizzbuzz for fifteen
        if (fifteen % 15 == 0) {
            System.out.println("fizzbuzz");
            } else if (fifteen % 5 == 0) {
                System.out.println("buzz");
            } else if (fifteen % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println("hawktuahsenpai");
            }
        
        // Fizzbuzz for three
        if (three % 15 == 0) {
            System.out.println("fizzbuzz");
            } else if (three % 5 == 0) {
                System.out.println("buzz");
            } else if (three % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println("hawktuahsenpai");
            }
        
        // Fizzbuzz for five
        if (five % 15 == 0) {
            System.out.println("fizzbuzz");
            } else if (five % 5 == 0) {
                System.out.println("buzz");
            } else if (five % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println("hawktuahsenpai");
            }
        
        // Fizzbuzz for other number
        if (number % 15 == 0) {
            System.out.println("fizzbuzz");
            } else if (number % 5 == 0) {
                System.out.println("buzz");
            } else if (number % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println("hawktuahsenpai");
            }
    }
}
