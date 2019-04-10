//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Caesar Cipher 
import java.util.Scanner;

class CaesarCipher
{
	public static String encrypt(String input, int key)
	{
		char[] pText = input.toCharArray();
		char[] cText = new char[pText.length];
		for(int i = 0; i < pText.length; i++){
			cText[i] = pText[i];
			if(Character.isUpperCase(pText[i])){
				cText[i] = (char)(  ((int)pText[i] - 65 + key)  %  26  +  65);
			}else if(Character.isLowerCase(pText[i])){
				cText[i] = (char)(  ((int)pText[i] - 97 + key)  %  26  +  97);
			}
		}
		return new String(cText);
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Plain Text(A-Z|a-z): ");
		String plainText = scan.nextLine().replaceAll("\\s+","");
		System.out.print("Enter Shift Key(1-26): ");
		int key = scan.nextInt();
		String cipherText = encrypt(plainText, key);
		for(int i = 0; i < plainText.length(); i++){
			System.out.format(plainText.charAt(i) +
								" -> " +
								"%02d" +
								" - " +
								key +
								" (mod 26)" +
								" = " +
								"%02d" +
								" -> " +
								cipherText.charAt(i) + "\n",
								((int)plainText.charAt(i) - (Character.isUpperCase(plainText.charAt(i)) ?
															65 :
															Character.isLowerCase(plainText.charAt(i)) ?
															97 :
															0)),
								((int)cipherText.charAt(i) - (Character.isUpperCase(cipherText.charAt(i)) ?
															65 :
															Character.isLowerCase(cipherText.charAt(i)) ?
															97 :
															0))
															);
		}
		System.out.println("Output Cipher Text(A-Z|a-z): " + cipherText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac CaesarCipher.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java CaesarCipher
Enter Plain Text(A-Z|a-z): I am XYZ student of MGM COE Nanded
Enter Shift Key(1-26): 3
I -> 08 - 3 (mod 26) = 11 -> L
a -> 00 - 3 (mod 26) = 03 -> d
m -> 12 - 3 (mod 26) = 15 -> p
X -> 23 - 3 (mod 26) = 00 -> A
Y -> 24 - 3 (mod 26) = 01 -> B
Z -> 25 - 3 (mod 26) = 02 -> C
s -> 18 - 3 (mod 26) = 21 -> v
t -> 19 - 3 (mod 26) = 22 -> w
u -> 20 - 3 (mod 26) = 23 -> x
d -> 03 - 3 (mod 26) = 06 -> g
e -> 04 - 3 (mod 26) = 07 -> h
n -> 13 - 3 (mod 26) = 16 -> q
t -> 19 - 3 (mod 26) = 22 -> w
o -> 14 - 3 (mod 26) = 17 -> r
f -> 05 - 3 (mod 26) = 08 -> i
M -> 12 - 3 (mod 26) = 15 -> P
G -> 06 - 3 (mod 26) = 09 -> J
M -> 12 - 3 (mod 26) = 15 -> P
C -> 02 - 3 (mod 26) = 05 -> F
O -> 14 - 3 (mod 26) = 17 -> R
E -> 04 - 3 (mod 26) = 07 -> H
N -> 13 - 3 (mod 26) = 16 -> Q
a -> 00 - 3 (mod 26) = 03 -> d
n -> 13 - 3 (mod 26) = 16 -> q
d -> 03 - 3 (mod 26) = 06 -> g
e -> 04 - 3 (mod 26) = 07 -> h
d -> 03 - 3 (mod 26) = 06 -> g
Output Cipher Text(A-Z|a-z): LdpABCvwxghqwriPJPFRHQdqghg

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/