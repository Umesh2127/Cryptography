//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Plain Text(Decryption) using Polyalphabetic(Vigenere) Cipher
import java.util.Scanner;
class VigenereD{
	public static String decrypt(String cipherText, String key){
		char plainText[] = new char[cipherText.length()];
		int keyIndex = 0;
		for(int i = 0; i < cipherText.length(); i++){
			if(Character.isUpperCase(cipherText.charAt(i))){
				plainText[i] = (char)	((((int)cipherText.charAt(i) - 65 -
											((int)key.charAt(keyIndex) - 97) +
											26) %
											26) +
											65);
			}
			if(Character.isLowerCase(cipherText.charAt(i))){
				plainText[i] = (char)	((((int)cipherText.charAt(i) - 97 -
											((int)key.charAt(keyIndex) - 97) +
											26) %
											26) +
											97);
			}
			keyIndex++;
			keyIndex %= key.length();
		}
		return new String(plainText);
	}
	
	public static void main(String argv[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Cipher Text(A-Z|a-z) : ");
		String cipherText = scan.nextLine();
		System.out.print("Enter key(a-z) : ");
		String key = scan.nextLine();
		String plainText = decrypt(cipherText, key);
		int keyIndex = 0;
		for(int i = 0; i < plainText.length(); i++){
			System.out.format(cipherText.charAt(i) +
								" - " +
								key.charAt(keyIndex) +
								" -> " +
								"%02d" +
								" - " +
								"%02d" +
								" (mod 26) " +
								" -> " +
								"%02d" +
								" -> " +
								plainText.charAt(i) + 
								"\n",
								(int)cipherText.charAt(i) - (Character.isUpperCase(cipherText.charAt(i)) ?
															65 :
															Character.isLowerCase(cipherText.charAt(i)) ?
															97 : 0),
								(int)key.charAt(keyIndex) - 97,
								(int)plainText.charAt(i) - (Character.isUpperCase(plainText.charAt(i)) ?
															65 :
															Character.isLowerCase(plainText.charAt(i)) ?
															97 : 0)
							);
			
			keyIndex++;
			keyIndex %= key.length();
		}
		System.out.print("Output Plain Text : " + plainText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac VigenereD.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java VigenereD
Enter Cipher Text(A-Z|a-z) : KaeBPOutmhvcvoxQXBEOWRrcfev
Enter key(a-z) : caserp
K - c -> 10 - 02 (mod 26)  -> 08 -> I
a - a -> 00 - 00 (mod 26)  -> 00 -> a
e - s -> 04 - 18 (mod 26)  -> 12 -> m
B - e -> 01 - 04 (mod 26)  -> 23 -> X
P - r -> 15 - 17 (mod 26)  -> 24 -> Y
O - p -> 14 - 15 (mod 26)  -> 25 -> Z
u - c -> 20 - 02 (mod 26)  -> 18 -> s
t - a -> 19 - 00 (mod 26)  -> 19 -> t
m - s -> 12 - 18 (mod 26)  -> 20 -> u
h - e -> 07 - 04 (mod 26)  -> 03 -> d
v - r -> 21 - 17 (mod 26)  -> 04 -> e
c - p -> 02 - 15 (mod 26)  -> 13 -> n
v - c -> 21 - 02 (mod 26)  -> 19 -> t
o - a -> 14 - 00 (mod 26)  -> 14 -> o
x - s -> 23 - 18 (mod 26)  -> 05 -> f
Q - e -> 16 - 04 (mod 26)  -> 12 -> M
X - r -> 23 - 17 (mod 26)  -> 06 -> G
B - p -> 01 - 15 (mod 26)  -> 12 -> M
E - c -> 04 - 02 (mod 26)  -> 02 -> C
O - a -> 14 - 00 (mod 26)  -> 14 -> O
W - s -> 22 - 18 (mod 26)  -> 04 -> E
R - e -> 17 - 04 (mod 26)  -> 13 -> N
r - r -> 17 - 17 (mod 26)  -> 00 -> a
c - p -> 02 - 15 (mod 26)  -> 13 -> n
f - c -> 05 - 02 (mod 26)  -> 03 -> d
e - a -> 04 - 00 (mod 26)  -> 04 -> e
v - s -> 21 - 18 (mod 26)  -> 03 -> d
Output Plain Text : IamXYZstudentofMGMCOENanded
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/