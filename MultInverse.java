//Name: Gaikwad Umesh Maroti
//Roll Number: 20

//Program to find multiplicative inverse modulo m using Euclidean algorithm
import java.util.Scanner;

class MultInverse{
	public static void print(Object o){
		System.out.print(o);
	}
	
	public static int extendedEuclidean(int m, int b){
		int A1 = 1, A2 = 0, A3 = m, B1 = 0, B2 = 1, B3 = b;
		print("\nQ\tA1\tA2\tA3\tB1\tB2\tB3\n\n");
		print("\t" + A1 + "\t" + A2 + "\t" + A3 + "\t" + B1 + "\t" + B2 + "\t" + B3 + "\n");
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
			print(Q + "\t" + A1 + "\t" + A2 + "\t" + A3 + "\t" + B1 + "\t" + B2 + "\t" + B3 + "\n");
		}
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		print("To find muliplicative inverse of 'b modulo m'\n");
		print("Enter value of m : ");
		int m = scan.nextInt();
		print("Enter value of b : ");
		int b = scan.nextInt();
		int i = extendedEuclidean(m, b);
		if(i == 0){
			print("\t" + "\t" + "\t" + "\t" + "\t" +  "\t" + "====" + "\n");
			print("\nInverse doesn't exit");
		}else{
			print("\t" + "\t" + "\t" + "\t" + "\t" + "====" + "\t" + "\n");
			print("\nMultiplicative inverse of '" + b + " modulo " + m + "' = " + i);
		}
	}
}
/*
OUTPUT-1
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac MultInverse.java
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java MultInverse
To find muliplicative inverse of 'b modulo m'
Enter value of m : 1759
Enter value of b : 550

Q       A1      A2      A3      B1      B2      B3

        1       0       1759    0       1       550
3       0       1       550     1       -3      109
5       1       -3      109     -5      16      5
21      -5      16      5       106     -339    4
1       106     -339    4       -111    355     1
                                        ====

Multiplicative inverse of '550 modulo 1759' = 355
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>

OUTPUT-2
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac MultInverse.java
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java MultInverse
To find muliplicative inverse of 'b modulo m'
Enter value of m : 20736
Enter value of b : 5994

Q       A1      A2      A3      B1      B2      B3

        1       0       20736   0       1       5994
3       0       1       5994    1       -3      2754
2       1       -3      2754    -2      7       486
5       -2      7       486     11      -38     324
1       11      -38     324     -13     45      162
2       -13     45      162     37      -128    0
                                                ====

Inverse doesn't exit
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>

OUTPUT-3
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>javac MultInverse.java
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>java MultInverse
To find muliplicative inverse of 'b modulo m'
Enter value of m : 2789
Enter value of b : 826

Q       A1      A2      A3      B1      B2      B3

        1       0       2789    0       1       826
3       0       1       826     1       -3      311
2       1       -3      311     -2      7       204
1       -2      7       204     3       -10     107
1       3       -10     107     -5      17      97
1       -5      17      97      8       -27     10
9       8       -27     10      -77     260     7
1       -77     260     7       85      -287    3
2       85      -287    3       -247    834     1
                                        ====

Multiplicative inverse of '826 modulo 2789' = 834
F:\ACADMIC EDUCATION\BE SEM - 2\CNS>
*/