//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Monoalphabetic Subtitution Cipher
import java.util.Scanner;
class Mono
{
	public static String encrypt(String input, String permutation)
	{
		char[] pText = input.toCharArray();
		char[] cText = new char[pText.length];
		for(int i = 0; i < pText.length; i++){
			if(Character.isLowerCase(pText[i]))
				cText[i] = Character.toLowerCase(permutation.charAt((int)pText[i] - 97));
			if(Character.isUpperCase(pText[i]))
				cText[i] = Character.toUpperCase(permutation.charAt((int)pText[i] - 65));
			//System.out.println(pText[i]);
		}
		return new String(cText);
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Plain Text(A-Z|a-z) : ");
		String plainText = scan.nextLine().replaceAll("\\s+", "");
		System.out.print("Enter Permutation(a-z) : ");
		String permutation = scan.nextLine();
		String cipherText = encrypt(plainText, permutation);
		for(int i = 0; i < cipherText.length(); i++){
			System.out.println(plainText.charAt(i) + " -> " + cipherText.charAt(i));
		}
		System.out.println("Cipher Text(A-Z|a-z) : " + cipherText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac Mono.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java Mono
Enter Plain Text(A-Z|a-z) : I am XYZ student of MGM COE Nanded
Enter Permutation(a-z) : zxcvbnmlkjhgfdsaqwertyuiop
I -> K
a -> z
m -> f
X -> I
Y -> O
Z -> P
s -> e
t -> r
u -> t
d -> v
e -> b
n -> d
t -> r
o -> s
f -> n
M -> F
G -> M
M -> F
C -> C
O -> S
E -> B
N -> D
a -> z
n -> d
d -> v
e -> b
d -> v
Cipher Text(A-Z|a-z) : KzfIOPertvbdrsnFMFCSBDzdvbv

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/