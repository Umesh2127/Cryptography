//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Cipher Text(Encryption) using Monoalphabetic Subtitution Cipher
import java.util.Scanner;
class MonoD
{
	public static String encrypt(String input, String permutation)
	{
		char[] pText = input.toCharArray();
		char[] cText = new char[pText.length];
		char[] inversePermutation = new char[26];
		int t = 97;
		for(char c: permutation.toCharArray()){
			inversePermutation[(int)c - 97] = (char)t++;
		}
		
		permutation = new String(inversePermutation);
		
		for(int i = 0; i < pText.length; i++){
			if(Character.isLowerCase(pText[i]))
				cText[i] = Character.toLowerCase(permutation.charAt((int)pText[i] - 97));
			if(Character.isUpperCase(pText[i]))
				cText[i] = Character.toUpperCase(permutation.charAt((int)pText[i] - 65));
		}
		return new String(cText);
	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Cipher Text : ");
		String plainText = scan.nextLine();
		System.out.print("Enter Permutation : ");
		String permutation = scan.nextLine();
		String cipherText = encrypt(plainText, permutation);
		for(int i = 0; i < plainText.length(); i++){
			System.out.println(cipherText.charAt(i) + " -> " + plainText.charAt(i));
		}
		System.out.println("Plain Text : " + cipherText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac MonoD.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java MonoD
Enter Cipher Text : KzfIOPertvbdrsnFMFCSBDzdvbv
Enter Permutation : zxcvbnmlkjhgfdsaqwertyuiop
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
Plain Text : IamXYZstudentofMGMCOENanded

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/