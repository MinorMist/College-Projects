package Lab1;

//1. Print the sum of the first N natural numbers.
import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Recursive: "+natNR(n));
		System.out.println("Iterative: "+natNI(n));
		sc.close();
	}

	private static int natNI(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}

	private static int natNR(int n) {
		if (n > 0)
			return (n + natNR(n - 1));
		return 0;
	}
}
