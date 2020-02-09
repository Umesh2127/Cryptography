/*
Name: Gaikwad Umesh M
Roll No: 20
*/

import java.util.Scanner;

class DiffieHellman{
	public static void print(Object o){
		System.out.print(o);
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("Enter a: ");
		int a = scan.nextInt();
		print("Enter q: ");
		int q = scan.nextInt();
		print("Enter XA (private key of A) : ");
		int XA = scan.nextInt();
		print("Enter XB (private key of B) : ");
		int XB = scan.nextInt();
		//Calculation of YA
		int YA = 1;
		for(int i = 0; i < XA; i++){
			YA = (YA * a) % q;
		}
		//Calculation of YB
		int YB = 1;
		for(int i = 0; i < XB; i++){
			YB = (YB * a) % q;
		}
		print("\n");
		System.out.println("A computes YA (public key) : " + a + " ^ " + XA + " (mod " + q + ") = " + YA);
		System.out.println("B computes YB (public key) : " + a + " ^ " + XB + " (mod " + q + ") = " + YB);
		
		//A computes of K
		int KA = 1;
		for(int i = 0; i < XA; i++){
			KA = (KA * YB) % q;
		}
		//Calculation of YB
		int KB = 1;
		for(int i = 0; i < XB; i++){
			KB = (KB * YA) % q;
		}
		print("\n");
		System.out.println("A computes K : " + YB + " ^ " + XA + " (mod " + q + ") = " + KA);
		System.out.println("B computes K : " + YA + " ^ " + XB + " (mod " + q + ") = " + KB);
	}
}
/*
OUTPUT
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac DiffieHellman.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java DDiffieHellman
Enter a: 3
Enter q: 353
Enter XA (private key of A) : 97
Enter XB (private key of B) : 233

A computes YA (public key) : 3 ^ 97 (mod 353) = 40
B computes YB (public key) : 3 ^ 233 (mod 353) = 248

A computes K : 248 ^ 97 (mod 353) = 160
B computes K : 40 ^ 233 (mod 353) = 160

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/
