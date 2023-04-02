package Stack_using_array;

import java.util.Scanner;

class ArrayS{
	int[] a;
	int size,top;
	ArrayS(int s){
		size=s;
		top=-1;
		a=new int[size];
		for(int i=0;i<size;i++)
			a[i]=0;
	}
	void push(int d) {
		if(top<size-1) {
			top++;
			a[top]=d;
			System.out.println("Pushed "+d);
		}
		else {
			System.out.println("Stack is Full");
		}
	}
	int pop(){
		if(top>-1) {
			int t=a[top];
			a[top]=0;
			top--;
			System.out.println("Popped "+t);
			return(t);
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	int peek(){
		if(top>-1) {
			System.out.println("Peeked "+a[top]);
			return(a[top]);
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	boolean isEmpty() {
		if(top<0) {
			System.out.println("Empty");
			return true;
		}
		else
			return false;
	}
	boolean isFull() {
		if(top>=size-1) {
			System.out.println("Full");
			return true;
		}
		else
			return false;
	}
	void print() {
		System.out.println();
		for(int i=0;i<=top;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
//	void p() {
//		System.out.println("top="+top+"\n");
//	}
	void printS() {
		System.out.println("Stack: ");
		for(int i=0;i<size;i++)
			System.out.println(a[i]);
		System.out.println();
	}
}
public class ArrayStack {
	
	public static void main(String[] args) {
		ArrayS o=new ArrayS(5);
		o.push(4);
		o.push(5);
		o.push(8);
		o.peek();
		o.printS();
		o.pop();
		o.pop();
		o.pop();
		o.printS();
		o.isEmpty();
		o.push(97);
		o.push(90);
		o.push(67);
		o.push(5678);
		o.push(45);
		o.push(458);
		o.printS();
		o.isFull();
	}

}
