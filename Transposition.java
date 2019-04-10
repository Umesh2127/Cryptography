//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Transposition Technique
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
class Transposition{
	public static void print(Object o){
		System.out.print(o);
	}
	
	public static String encrypt(String plainText, int[] key){
		int paddingLength = key.length - plainText.length() % key.length;
		plainText += IntStream.range(0, paddingLength).mapToObj(i -> "X").collect(Collectors.joining(""));
		
		char table[][] = new char[plainText.length()/key.length][key.length];
		
		StringBuilder cipherText = new StringBuilder();
		print("\n");
		for(int j = 0; j < key.length; j++){
				print(key[j] + " ");
			}
		for(int i = 0; i < plainText.length() / key.length; i++){
			print("\n");
			for(int j = 0; j < key.length; j++){
				table[i][j] = plainText.charAt(i*key.length + j);
				print(table[i][j] + " ");
			}
		}
		for(int j = 1; j <= key.length; j++){
			int i;
			for(i = 0; i < key.length; i++){
				if(j == key[i]){
					break;
				}
			}
			for(int k = 0; k < plainText.length() / key.length; k++){
				cipherText.append(table[k][i]);
			}
		}
		return cipherText.toString();
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("Enter Plain Text(A-Z|a-z|0-9) : ");
		String plainText = scan.nextLine().replaceAll("\\s+", "");
		print("Enter key : ");
		int key[] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		String cipherText = encrypt(plainText, key);
		print("\n\nOutput Cipher Text : " + cipherText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac Transposition.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java Transposition
Enter Plain Text(A-Z|a-z|0-9) : I am XYZ student of MGM COE Nanded
Enter key : 2 3 1 4

2 3 1 4
I a m X
Y Z s t
u d e n
t o f M
G M C O
E N a n
d e d X

Output Cipher Text : msefCadIYutGEdaZdoMNeXtnMOnX
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/