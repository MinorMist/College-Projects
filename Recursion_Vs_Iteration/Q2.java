package Lab1;

//2. Print the factorial of N.
import java.util.Scanner;

public class Q2 {
	public static int factR(int n) {
		if (n == 1)
			return n;
		return (n * factR(n - 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Recursive: "+factR(n));
		System.out.println("Iterative: "+factI(n));
		sc.close();
	}

	private static int factI(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++)
			fact *= i;
		return fact;
	}
}
