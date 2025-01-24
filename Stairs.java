import java.util.Scanner;

public class Stairs {
	public static void main(String[] args) {
        Scanner charInput = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String character = charInput.nextLine();
	    
		Scanner stepsInput = new Scanner(System.in);
		System.out.print("Enter number of steps: ");
		int numSteps = stepsInput.nextInt();
		
		for (int row = 0; row < numSteps; row++) {
			for (int col = 0; col < numSteps; col++) {
				if (col < numSteps - row - 1)
					System.out.print(" ");
				else
					System.out.print(character);
			}
			System.out.println();
		}
	}
}