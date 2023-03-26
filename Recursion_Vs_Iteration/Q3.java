package Lab1;

//3. Print the Nth Fibonacci number.
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print("Iterative: ");
		fiba(0, 1, n);
		System.out.println("Recursive: " + fibaR(0, 1, n));
		sc.close();
	}

	private static int fibaR(int f, int s, int n) {
		if (n == 0)
			return f;
		else if (n == 1)
			return s;
		else {
			int t = f+s;
			for (int i = 3; i <= n; i++) {
				t = f + s;
				f = s;
				s = t;
			}
			return t;
		}
	}

	private static void fiba(int f, int s, int n) {
		if (n > 1)
			fiba(s, f + s, --n);
		else
			System.out.println(f);
	}

}
