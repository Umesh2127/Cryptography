//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Hill Cipher
import java.util.Scanner;
class Hill{
	public static void print(Object o){
		System.out.print(o);
	}
	public static String encrypt(String plainText,int key[][]){
		char[] cipherText = new char[plainText.length()];
		for(int i = 0; i < plainText.length(); i += 2){
			print("(" + plainText.charAt(i) + "," + plainText.charAt(i + 1) + ")");
			cipherText[i] = (char) ((key[0][0] * ((int)plainText.charAt(i) - 97) + key[1][0] * ((int)plainText.charAt(i + 1) - 97)) % 26 + 65);
			cipherText[i + 1] = (char) ((key[0][1] * ((int)plainText.charAt(i) - 97) + key[1][1] * ((int)plainText.charAt(i + 1) - 97))% 26 + 65);
			print("|" + key[0][0] + " " + key[0][1] + "| (mod 26) = (" + cipherText[i] + "," + cipherText[i + 1]  + ")\n");
			print("     |" + key[1][0] + " " + key[1][1] + "|\n\n");
		}
		return new String(cipherText);
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("Enter Plain Text(a-z) : ");
		String plainText = scan.nextLine();
		if(plainText.length() % 2 == 1)
			plainText = new String(plainText + "x");
		print("Enter Key Matrix(2x2) : ");
		int key[][] = new int[2][2];
		key[0][0] = scan.nextInt();
		key[0][1] = scan.nextInt();
		key[1][0] = scan.nextInt();
		key[1][1] = scan.nextInt();
		String cipherText = encrypt(plainText, key);
		print("Output Cipher Text(A-Z) : " + cipherText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac Hill.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java Hill
Enter Plain Text(a-z) : hillcipher
Enter Key Matrix(2x2) :
3 2
8 5
(h,i)|3 2| (mod 26) = (H,C)
     |8 5|

(l,l)|3 2| (mod 26) = (R,Z)
     |8 5|

(c,i)|3 2| (mod 26) = (S,S)
     |8 5|

(p,h)|3 2| (mod 26) = (X,N)
     |8 5|

(e,r)|3 2| (mod 26) = (S,P)
     |8 5|

Output Cipher Text(A-Z) : HCRZSSXNSP
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/