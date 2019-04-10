/*
Gaikwad Umesh Maroti
Roll No. : 20
ElGamal
*/

import java.util.Scanner;

class Elgamal{
	public static int extendedEuclidean(int m, int b){
		int A1 = 1, A2 = 0, A3 = m, B1 = 0, B2 = 1, B3 = b;
		while(true){
			
			if(B3 == 0){
				return 0;
			}
			if(B3 == 1){
				return B2 < 0 ? (B2 % m) + m : B2;
			}
			int Q = (int)(A3/B3);
			int T1 = A1 - Q*B1; A1 = B1; B1 = T1;
			int T2 = A2 - Q*B2; A2 = B2; B2 = T2;
			int T3 = A3 - Q*B3; A3 = B3; B3 = T3;
		}
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter q (prime number)        : ");
		int q = scan.nextInt();
		System.out.print("Enter a (premitive root of q) : ");
		int a = scan.nextInt();
		System.out.print("Enter XA (private key)        : ");
		int XA = scan.nextInt();
		//Calculate YA
		int YA = 1;
		for(int i = 0; i < XA; i++){
			YA = (YA * a) % q;
		}
		System.out.println("\nCalculation of YA : " + a + " ^ " + XA + " (mod " + q + ") = " + YA);
		System.out.println("\nPublic Key {q, a, YA} = " + "{" + q + ", " + a + ", " + YA + "}");
		System.out.println("Private key        XA = " + XA);
		
		//Encryption
		System.out.print("\nEnter M (plain text)     : ");
		int M = scan.nextInt();
		System.out.print("Enter k (random integer) : ");
		int k = scan.nextInt();
		int K = 1;
		for(int i = 0; i < k; i++){
			K = (K * YA) % q;
		}
		System.out.println("\nBob calculates of K : " + YA + " ^ " + k + " (mod " + q + ") = " + K);
		int C1 = 1;
		for(int i = 0; i < k; i++){
			C1 = (C1 * a) % q;
		}
		int C2 = (K * M) % q;
		System.out.println("\nBob calculates of C1  : " + a + " ^ " + k + " (mod " + q + ") = " + C1);
		System.out.println("Bob calculation of C2 : " + K + " * " + M + " (mod " + q + ") = " + C2);
		System.out.println("Bob sends cipher text                   = (" + C1 + ", " + C2 +")");
		
		//Decryption
		K = 1;
		for(int i = 0; i < XA; i++){
			K = (K * C1) % q;
		}
		int MIK = extendedEuclidean(q, K);
		M = (C2 * MIK) % q;
		System.out.println("\nAlice calculates of K       : " + C1 + " ^ " + XA + " (mod " + q + ") = " + K);
		System.out.println("Alice calculates plain text : " + C2 + " * " + MIK + " (mod " + q + ") = " + M);
	}
}
/*
OUTPUT
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac Elgamal.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java Elgamal
Enter q (prime number)        : 19
Enter a (premitive root of q) : 10
Enter XA (private key)        : 5

Calculation of YA : 10 ^ 5 (mod 19) = 3

Public Key {q, a, YA} = {19, 10, 3}
Private key        XA = 5

Enter M (plain text)     : 17
Enter k (random integer) : 6

Bob calculates of K : 3 ^ 6 (mod 19) = 7

Bob calculates of C1  : 10 ^ 6 (mod 19) = 11
Bob calculation of C2 : 7 * 17 (mod 19) = 5
Bob sends cipher text                   = (11, 5)

Alice calculates of K       : 11 ^ 5 (mod 19) = 7
Alice calculates plain text : 5 * 11 (mod 19) = 17

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/