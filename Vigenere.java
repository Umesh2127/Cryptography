//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Polyalphabetic(Vigenere) Cipher
import java.util.Scanner;
class Vigenere{
	public static String encrypt(String plainText, String key){
		char cipherText[] = new char[plainText.length()];
		int keyIndex = 0;
		for(int i = 0; i < plainText.length(); i++){
			if(Character.isUpperCase(plainText.charAt(i))){
				cipherText[i] = (char)	((((int)plainText.charAt(i) - 65 +
											(int)key.charAt(keyIndex) - 97) %
											26) +
											65);
			}
			if(Character.isLowerCase(plainText.charAt(i))){
				cipherText[i] = (char)	((((int)plainText.charAt(i) - 97 +
											(int)key.charAt(keyIndex) - 97) %
											26) +
											97);
			}
			keyIndex++;
			keyIndex %= key.length();
		}
		return new String(cipherText);
	}
	
	public static void main(String argv[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Plain Text(A-Z|a-z) : ");
		String plainText = scan.nextLine().replaceAll("\\s+","");
		System.out.print("Enter key(a-z) : ");
		String key = scan.nextLine();
		String cipherText = encrypt(plainText, key);
		int keyIndex = 0;
		for(int i = 0; i < plainText.length(); i++){
			System.out.format(plainText.charAt(i) +
								" + " +
								key.charAt(keyIndex) +
								" -> " +
								"%02d" +
								" + " +
								"%02d" +
								" (mod 26) " +
								" -> " +
								"%02d" +
								" -> " +
								cipherText.charAt(i) + 
								"\n",
								(int)plainText.charAt(i) - (Character.isUpperCase(plainText.charAt(i)) ?
															65 :
															Character.isLowerCase(plainText.charAt(i)) ?
															97 : 0),
								(int)key.charAt(keyIndex) - 97,
								(int)cipherText.charAt(i) - (Character.isUpperCase(cipherText.charAt(i)) ?
															65 :
															Character.isLowerCase(cipherText.charAt(i)) ?
															97 : 0)
							);
			
			keyIndex++;
			keyIndex %= key.length();
		}
		System.out.print("Output Cipher Text : " + cipherText);
	}
}
/*
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac Vigenere.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java Vigenere
Enter Plain Text(A-Z|a-z) : I am XYZ student of MGM COE Nanded
Enter key(a-z) : caserp
I + c -> 08 + 02 (mod 26)  -> 10 -> K
a + a -> 00 + 00 (mod 26)  -> 00 -> a
m + s -> 12 + 18 (mod 26)  -> 04 -> e
X + e -> 23 + 04 (mod 26)  -> 01 -> B
Y + r -> 24 + 17 (mod 26)  -> 15 -> P
Z + p -> 25 + 15 (mod 26)  -> 14 -> O
s + c -> 18 + 02 (mod 26)  -> 20 -> u
t + a -> 19 + 00 (mod 26)  -> 19 -> t
u + s -> 20 + 18 (mod 26)  -> 12 -> m
d + e -> 03 + 04 (mod 26)  -> 07 -> h
e + r -> 04 + 17 (mod 26)  -> 21 -> v
n + p -> 13 + 15 (mod 26)  -> 02 -> c
t + c -> 19 + 02 (mod 26)  -> 21 -> v
o + a -> 14 + 00 (mod 26)  -> 14 -> o
f + s -> 05 + 18 (mod 26)  -> 23 -> x
M + e -> 12 + 04 (mod 26)  -> 16 -> Q
G + r -> 06 + 17 (mod 26)  -> 23 -> X
M + p -> 12 + 15 (mod 26)  -> 01 -> B
C + c -> 02 + 02 (mod 26)  -> 04 -> E
O + a -> 14 + 00 (mod 26)  -> 14 -> O
E + s -> 04 + 18 (mod 26)  -> 22 -> W
N + e -> 13 + 04 (mod 26)  -> 17 -> R
a + r -> 00 + 17 (mod 26)  -> 17 -> r
n + p -> 13 + 15 (mod 26)  -> 02 -> c
d + c -> 03 + 02 (mod 26)  -> 05 -> f
e + a -> 04 + 00 (mod 26)  -> 04 -> e
d + s -> 03 + 18 (mod 26)  -> 21 -> v
Output Cipher Text : KaeBPOutmhvcvoxQXBEOWRrcfev
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/