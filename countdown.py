def main(): # Defines the main function    
    int_input = input("Enter a number: ") # Asks for a number as input
    while not int_input.isdigit(): # Checks if the input is a digit and if not then it asks for it again
        int_input = input("Please enter a positive number: ")
    int_input = int(int_input) # Casts the input as an integer
    for i in range (int_input, 0, -1): # Counts down from the inputted number to 1
        print(i) # Prints each number

main() # Calls the main function