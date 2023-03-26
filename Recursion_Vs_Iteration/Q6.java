package Lab1;

//6. Print the first N natural numbers in reverse order.
import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Recursive :");
		numI(n);
		System.out.println("\nIterative :");
		numR(n);
		sc.close();
	}

	private static void numR(int n) {
		for (int i = n; i > 1; i--)
			System.out.print(i+" ");
		System.out.print(1);
	}

	private static void numI(int n) {
		if(n==1) {
			System.out.print(1);
			return;
		}
		System.out.print(n+" ");
		numI(n-1);
	}
}
