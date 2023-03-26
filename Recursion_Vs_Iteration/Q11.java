package Lab1;

//11. Reverse a given number.
import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print("Recursive :");
		revR(n);
		System.out.print("\nIterative :");
		revI(n);
		sc.close();
	}

	private static void revI(int n) {
		while (n > 0) {
			System.out.print("" + n % 10);
			n = n / 10;
		}
	}

	private static void revR(int n) {
		if (n > 0) {
			System.out.print("" + n % 10);
			revR(n / 10);
		}

	}
}
