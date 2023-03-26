package Lab1;

//5. Print the first N natural numbers.
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Recursive :");
		numR(n);
		System.out.println("Iterative :");
		numI(n);
		sc.close();
	}

	private static void numR(int n) {
		for (int i = 1; i < n; i++)
			System.out.print(i + " ");
		System.out.println(n);
	}

	private static void numI(int n) {
		if (n == 1) {
			System.out.print(n);
			return;
		}
		numI(n - 1);
		System.out.print(" " + n);
	}

}
