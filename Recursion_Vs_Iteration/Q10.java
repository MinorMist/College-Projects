package Lab1;

import java.util.Scanner;

//10. Reverse a string.
public class Q10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("Recursive :"+revR(s));
		System.out.println("Iterative :"+revI(s));
		sc.close();
	}

	private static String revI(String s) {
		String str2 = "";
		for(int i=s.length()-1;i>-1;i--) {
			str2+=s.charAt(i);
		}
		return str2;
	}

	private static String revR(String s) {
		if(s.length()>0) {
			return (s.charAt(s.length()-1)+revR(s.substring(0,s.length()-1)));
		}
		return "";
	}

}
