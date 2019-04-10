//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Plain Text(Decryption) using Transposition Technique
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
class TranspositionD{
	public static void print(Object o){
		System.out.print(o);
	}
	
	public static String decrypt(String cipherText, int[] key){
		
		char table[][] = new char[cipherText.length()/key.length][key.length];
		StringBuilder plainText = new StringBuilder();
		
		for(int j,i = 1; i <= key.length; i++){
			
			for(j = 0; key[j] != i; j++){}
			for(int k = 0; k < cipherText.length()/key.length; k++){
				table[k][j] = cipherText.charAt((i-1) * cipherText.length()/key.length + k);
			}
		}
		print("\n");
		for(int i = 0; i < key.length; i++){
			print(key[i] + " ");
		}
		for(int i = 0; i < cipherText.length()/key.length; i++){
			print("\n");
			for(int j = 0; j < key.length; j++){
				plainText.append(table[i][j]);
				print(table[i][j] + " ");
			}
		}
		return plainText.toString();
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("Enter Cipher Text(A-Z|a-z|0-9) : ");
		String cipherText = scan.nextLine();
		print("Enter key : ");
		int key[] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		String plainText = decrypt(cipherText, key);
		print("\n\nOutput Plain Text : " + plainText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac TranspositionD.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java TranspositionD
Enter Cipher Text(A-Z|a-z|0-9) : msefCadIYutGEdaZdoMNeXtnMOnX
Enter key : 2 3 1 4

2 3 1 4
I a m X
Y Z s t
u d e n
t o f M
G M C O
E N a n
d e d X

Output Plain Text : IamXYZstudentofMGMCOENandedX
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/