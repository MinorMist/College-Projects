import java.util.Scanner;

public class DSLab1Q4 {

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
		System.out.println("Enter key: ");
		k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((a[i] + a[j] == k) && (a[i] != a[j])) {
					System.out.println("Elements: " + a[i] + ", " + a[j] + " ---> Position: (" + i + ", " + j + ")");
				}
			}
		}
		sc.close();
	}

}
