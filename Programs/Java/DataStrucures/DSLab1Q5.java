import java.util.Scanner;

public class DSLab1Q5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Degree of polynomial: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		System.out.println("Enter first set of elements");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter second set of elements");
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println("Sum: ");
		System.out.print((a[0] + b[0]) + "");
		for (int i = 1; i < n; i++) {
			System.out.print((" + " + (a[i] + b[i]) + "x^" + i));
		}
	}

}
