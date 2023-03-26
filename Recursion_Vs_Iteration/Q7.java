package Lab1;

import java.util.Scanner;

//7. Find the gcdR(HCF) of two numbers.
public class Q7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println("Recursive :"+gcdR(n, m));
		System.out.println("Iterative :"+gcdI(n, m));
		sc.close();
	}

	private static int gcdI(int n, int m) {
		int k = 0;
		if (n > m)
			k = n;
		else
			k = m;
		while (k > 0) {
			if ((n % k == 0) && (m % k == 0))
				break;
			k--;
		}
		return k;
	}

	private static int gcdR(int n, int m) {
		if (m == 0)
			return n;
		else if (n > m)
			return gcdR(m, n % m);
		else
			return gcdR(n, m % n);

	}
}
