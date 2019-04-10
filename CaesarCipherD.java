//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to get Plain Text(Decryption) using Caesar Cipher
import java.util.Scanner;
class CaesarCipherD
{
	public static String decrypt(String input, int key)
	{
		key %= 26;
		char[] cText = input.toCharArray();
		char[] pText = new char[cText.length];
		for(int i = 0; i < cText.length; i++){
			pText[i] = cText[i];
			if(Character.isUpperCase(cText[i])){
				pText[i] = (char)(  ((int)cText[i] + 13 - key)  %  26  +  65);	//13 <- 65(mod 26)
			}else if(Character.isLowerCase(cText[i])){
				pText[i] = (char)(  ((int)cText[i] + 7 - key)  %  26  +  97);   //07 <- 97(mod 26)
			}
		}
		return new String(pText);
	}

	public static void main(String[] args)
	{	
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Cipher Text(A-Z|a-z): ");
		String cipherText = scan.nextLine();
		System.out.print("Enter Shift Key(1-26): ");
		int key = scan.nextInt();
		String plainText = decrypt(cipherText, key);
		for(int i = 0; i < plainText.length(); i++){
			System.out.format(cipherText.charAt(i) +
								" -> " +
								"%02d" +
								" - " +
								key +
								" (mod 26)" +
								" = " +
								"%02d" +
								" -> " +
								plainText.charAt(i) +
								"\n",
								((int)cipherText.charAt(i) - (Character.isUpperCase(cipherText.charAt(i)) ?
															65 :
															Character.isLowerCase(cipherText.charAt(i)) ?
															97 :
															0)),
								((int)plainText.charAt(i) - (Character.isUpperCase(plainText.charAt(i)) ?
															65 :
															Character.isLowerCase(plainText.charAt(i)) ?
															97 :
															0))
															);
		}
		System.out.println("Output plainText Text(A-Z|a-z): " + plainText);
	}
}
/*
OUTPUT

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac CaesarCipherD.java

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java CaesarCipherD
Enter Cipher Text(A-Z|a-z): LdpABCvwxghqwriPJPFRHQdqghg
Enter Shift Key(1-26): 3
L -> 11 - 3 (mod 26) = 08 -> I
d -> 03 - 3 (mod 26) = 00 -> a
p -> 15 - 3 (mod 26) = 12 -> m
A -> 00 - 3 (mod 26) = 23 -> X
B -> 01 - 3 (mod 26) = 24 -> Y
C -> 02 - 3 (mod 26) = 25 -> Z
v -> 21 - 3 (mod 26) = 18 -> s
w -> 22 - 3 (mod 26) = 19 -> t
x -> 23 - 3 (mod 26) = 20 -> u
g -> 06 - 3 (mod 26) = 03 -> d
h -> 07 - 3 (mod 26) = 04 -> e
q -> 16 - 3 (mod 26) = 13 -> n
w -> 22 - 3 (mod 26) = 19 -> t
r -> 17 - 3 (mod 26) = 14 -> o
i -> 08 - 3 (mod 26) = 05 -> f
P -> 15 - 3 (mod 26) = 12 -> M
J -> 09 - 3 (mod 26) = 06 -> G
P -> 15 - 3 (mod 26) = 12 -> M
F -> 05 - 3 (mod 26) = 02 -> C
R -> 17 - 3 (mod 26) = 14 -> O
H -> 07 - 3 (mod 26) = 04 -> E
Q -> 16 - 3 (mod 26) = 13 -> N
d -> 03 - 3 (mod 26) = 00 -> a
q -> 16 - 3 (mod 26) = 13 -> n
g -> 06 - 3 (mod 26) = 03 -> d
h -> 07 - 3 (mod 26) = 04 -> e
g -> 06 - 3 (mod 26) = 03 -> d
Output plainText Text(A-Z|a-z): IamXYZstudentofMGMCOENanded

F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/