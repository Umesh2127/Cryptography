//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Plain Text(Decryption) using Hill Cipher
import java.util.Scanner;
class HillD{
	public static void print(Object o){
		System.out.print(o);
	}
	public static int modulo(int a, int m){
		a = a % m;
		if(a < 0){
			return a + m;
		}
		else{
			return a;
		}
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
	public static String decrypt(String cipherText,int key[][]){
		char[] plainText = new char[cipherText.length()];
		int inverse[][] = new int[2][2];
		int det = modulo(key[0][0] * key[1][1] - key[1][0] * key[0][1], 26);
		inverse[0][0] = modulo(key[1][1] * extendedEuclidean(26, det), 26);
		inverse[1][1] = modulo(key[0][0] * extendedEuclidean(26, det), 26);
		inverse[0][1] = modulo(26-key[0][1] * extendedEuclidean(26, det), 26);
		inverse[1][0] = modulo(26-key[1][0] * extendedEuclidean(26, det), 26);
		for(int i = 0; i < cipherText.length(); i += 2){
			print("(" + cipherText.charAt(i) + "," + cipherText.charAt(i + 1) + ")");
			plainText[i] = (char) ((inverse[0][0] * ((int)cipherText.charAt(i) - 65) + inverse[1][0] * ((int)cipherText.charAt(i + 1) - 65)) % 26 + 97);
			plainText[i + 1] = (char) ((inverse[0][1] * ((int)cipherText.charAt(i) - 65) + inverse[1][1] * ((int)cipherText.charAt(i + 1) - 65))% 26 + 97);
			print("|" + inverse[0][0] + " " + inverse[0][1] + "| (mod 26) = (" + plainText[i] + "," + plainText[i + 1]  + ")\n");
			print("     |" + inverse[1][0] + " " + inverse[1][1] + "|\n\n");
		}
		return new String(plainText);
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("Enter Cipher Text(A-Z) : ");
		String cipherText = scan.nextLine();
		print("Enter Key Matrix(2x2) : ");
		int key[][] = new int[2][2];
		key[0][0] = scan.nextInt();
		key[0][1] = scan.nextInt();
		key[1][0] = scan.nextInt();
		key[1][1] = scan.nextInt();
		String plainText = decrypt(cipherText, key);
		print("Output Plain Text(A-Z) : " + plainText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac HillD.java
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java HillD
Enter Cipher Text(A-Z) : HCRZSSXNSP
Enter Key Matrix(2x2) :
3 2
8 5
(H,C)|21 2| (mod 26) = (h,i)
     |8 23|

(R,Z)|21 2| (mod 26) = (l,l)
     |8 23|

(S,S)|21 2| (mod 26) = (c,i)
     |8 23|

(X,N)|21 2| (mod 26) = (p,h)
     |8 23|

(S,P)|21 2| (mod 26) = (e,r)
     |8 23|

Output Plain Text(A-Z) : hillcipher
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/