import java.util.Scanner;

public class DSLab1Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1st Array length: ");
		int n1 = sc.nextInt();
		int a[] = new int[n1];
		System.out.println("1st Array elements: ");
		for (int i = 0; i < n1; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("2nd Array length: ");
		int n2 = sc.nextInt();
		int b[] = new int[n2];
		System.out.println("2nd Array elements: ");
		for (int i = 0; i < n2; i++) {
			b[i] = sc.nextInt();
		}
		int count = 0;
		System.out.println("Common elements: ");
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i] + "");
					count++;
				}
			}
		}
		System.out.println("Tot count: " + count);
		sc.close();

	}

}
