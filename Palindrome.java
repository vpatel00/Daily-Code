import java.util.Scanner; // Importing the Scanner utility

class Palindrome { // The Palindrome class, titled same as the file name
    public static void main(String[] args) {
        Scanner stringInput = new Scanner(System.in); // Creating a scanner to get user's string input
        System.out.print("Enter an string: ");
        String string = stringInput.nextLine(); // Sets the user's input equal to the variable string
        string = string.toLowerCase(); // Makes the string lowercase so case doesn't matter
        String reversedString = ""; // Creating an empty new string to store the reversed version of the string
        for (int i = 0; i < string.length(); i++) {
            reversedString = string.charAt(i) + reversedString; // Adds each character to the beginning of reversedString, instead of at the end, so it's reversed
        }
        if (string.equals(reversedString)) { // Uses if else and the equals method to check whether or not the strings are equal
            System.out.println("String is a palindrome");
        }
        else {
            System.out.println("String is not a palindrome");
        }
        stringInput.close(); // Closes the scanner
    }
}