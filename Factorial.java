import java.util.Scanner;

class Factorial {
    static void factorial () {
        Scanner numinput = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = numinput.nextInt();
        int outputnum = num;
        for (int i = num; i > 1; i--) {
            num = num * (i - 1);
        }
        System.out.println("The factorial of " + outputnum + " is " + num + ".");
        numinput.close();
    }

public static void main(String[] args) {
    factorial();
}

}