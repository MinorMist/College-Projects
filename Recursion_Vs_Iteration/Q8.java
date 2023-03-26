package Lab1;

//8. Print the elements of an array.
public class Q8 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 3, 6, 8, 5, 3, 2 };
		System.out.println("Array length: " + arr.length);
		System.out.println("Recursive :");
		printR(arr, arr.length);
		System.out.println();
		System.out.println("Iterative :");
		printI(arr, arr.length);
	}

	private static void printI(int[] arr, int l) {
		int i = 0;
		while (i < l) {
			System.out.print(arr[i] + " ");
			i++;
		}
	}

	private static void printR(int[] arr, int l) {
		if (l > -1) {
			printI(arr, --l);
			System.out.print(arr[l] + " ");
		}
		return;
	}
}
