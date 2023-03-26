package Lab1;

//4. Calculate xy.
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("Recursive :"+raiseR(x, y));
		System.out.println("Iterative :"+raiseI(x, y));
		sc.close();
	}

	private static int raiseI(int x, int y) {
		return (int) (Math.pow(x, y));
	}

	private static int raiseR(int x, int y) {
		if (y > 0)
			return (x * raiseR(x, y - 1));
		return 1;
	}

}
