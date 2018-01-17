package fizzBuzz;

public class FizzBuzz02 {
	public static void main(String[] args) {

		for (int number = 1; number <= 100; number++) {
			if (number % 3 == 0) {
				if (number % 5 == 0) {
					System.out.println("FizzBuzz");
				} else {
					System.out.println("Fizz");
				}
			} else {
				if (number % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(number);
				}
			}
		}
	}
}