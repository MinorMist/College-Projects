import java.util.Scanner;

public class DSLab1Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Array length: ");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Array elements: ");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int l=a[0],s=a[0];
		for(int i=0;i<n;i++) {
			if(a[i]>l)
				l=a[i];
			if(a[i]<l)
				s=a[i];
		}
		System.out.println("Smallest element: "+s+"\nLargest element: "+l);
		sc.close();
	}
}
