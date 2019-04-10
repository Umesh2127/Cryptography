/*
Gaikwad Umesh M.
Roll No. : 20
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class RSA{
	public static boolean print(Object o){
		System.out.print(o);
		return true;
	}
	public static boolean isPrime(int n){
		for(int i = 2; i < n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	public static int gcd(int a, int b){
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
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
		print("Enter p : ");
		int p = scan.nextInt();
		print("Enter q : ");
		int q = scan.nextInt();
		
		int n = p * q;
		int phi_n = (p - 1) * (q - 1);
		
		print("\n");
		List<Integer> select_e = new ArrayList<Integer>();
		for(int i = 2; i < phi_n; i++){
			if(gcd(phi_n, i) == 1){
				select_e.add(i);
			}
		}
		print(select_e);
		print("\n\nSelect 'e' from above list : ");
		int e = scan.nextInt();
		
		print("Enter M (message) : ");
		int M = scan.nextInt();
		int c = 1;
		for(int i = 0; i < e; i++){
			c = (c * M) % n;
		}
		System.out.println("\nEncryption by Bob (Cipher Text) : " + M + "^" + e + " (mod " + n + ") = " + c);
		int d = extendedEuclidean(phi_n, e);
		
		M = 1;
		for(int i = 0; i < d; i++){
			M = (M * c) % n;
		}
		System.out.println("Decryption by Alice (Message)  : " + c + "^" + d + " (mod " + n + ") = " + M);
	}
}
/*
OUTPUT
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac RSA.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java RSA
Enter p : 17
Enter q : 11

[3, 7, 9, 11, 13, 17, 19, 21, 23, 27, 29, 31, 33, 37, 39, 41, 43, 47, 49, 51, 53, 57, 59, 61, 63, 67, 69, 71, 73, 77, 79, 81, 83, 87, 89, 91, 93, 97, 99, 101, 103, 107, 109, 111, 113, 117, 119, 121, 123, 127, 129, 131, 133, 137, 139, 141, 143, 147, 149, 151, 153, 157, 159]

Select 'e' from above list : 7
Enter M (message) : 88

Encryption by Bob (Cipher Text) : 88^7 (mod 187) = 11
Decryption by Alice (Message)  : 11^23 (mod 187) = 88

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/