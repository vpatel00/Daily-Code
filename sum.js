function sum() { // Creating a sum function
    let user_input = prompt("Enter numbers separated by space: "); // Getting user input
    let numbers = user_input.split(" "); // Splitting the numbers into a list
    let sum = 0; // The sum starts at 0
    for (let i = 0; i < numbers.length; i++) { // Adding each number to the sum
        sum += parseInt(numbers[i]);
    }
    console.log(sum);
}

sum(); // Calling the function