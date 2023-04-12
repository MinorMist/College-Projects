import java.util.Scanner;

public class DSLab1Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Array length: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Array elements: ");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int k;
		boolean flag = false;
		System.out.println("Key to search: ");
		k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			if (a[i] == k)
				flag = true;
		}
		if (flag)
			System.out.println("Key found");
		else
			System.out.println("Key not found");
		sc.close();
	}

}
