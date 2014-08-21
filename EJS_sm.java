/*
The concept is same as a pattern hopping but with a different scheme
Must read the paper of Rendezvous Ejs Algo for it
*/

import java.util.Random;
import java.util.Scanner;

class EJS_sm
{
	static Scanner sc;
	static int m, m1, m2;
	static int[] arrM, arrK,arrJ ;
	static Random rand;
	int problem=0;

	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		rand = new Random();

		System.out.println("Enter the total channels!!!!");
		m = sc.nextInt();
		arrM=new int[m];
		
		for (int i = 0; i < m; i++)
			arrM[i] =i+1;
		//==============================//
		
		System.out.println("Channels the kth user holds");
		int k = sc.nextInt();
		System.out.println("Ck denotes the set of channels availbale to the user k");
		System.out.println("Enter the channels for the Ck user");
		arrK = new int[k];
		
		for (int i = 0; i < k; i++)
			arrK[i] = sc.nextInt();
		
		int G_MK=Common(arrK,arrM);
		if(G_MK==0){
			System.out.println("No common channels were there b/w M and K!!!");
			System.exit(0);
		}
		//==============================//
		
		System.out.println("Channels the Jth user holds");
		int J = sc.nextInt();
		System.out.println("CJ denotes the set of channels availbale to the user k");
		System.out.println("Enter the channels for the CJ user");
		arrJ = new int[J];
		
		for (int i = 0; i < J; i++)
			arrJ[i] = sc.nextInt();

		int G_MJ=Common(arrJ,arrM);
		if(G_MJ==0){
			System.out.println("No common channels were there b/w M and J!!!");
			System.exit(0);
		}
		
		//==============================//
		
		int G_KJ=Common(arrK,arrJ);
		if(G_KJ==0){
			System.out.println("No common channels were there b/w K and J!!!");
			System.exit(0);
		}
		System.out.println("Common channels b/w K and J are "+G_KJ);
		//==============================//
		//Finding Prime>m
		
		int prime = 0;
		int new_m = m + 1;
		if (check_P(new_m) == true)
		{
			prime = new_m;
			System.out.println("result is " + prime);
		} else
		{
			while (!check_P(new_m))
			{
				new_m++;
			}
			prime = new_m;
			System.out.println("result is " + prime);
		}

		boolean ren = false;
		int time = 0;
		int rounds = 0;
		int new_in_K = 0;
		int new_in_J= 0;
		
		System.out.println("Enter details for the kth user");
		System.out.println("Enter r_K");
		int r_K = sc.nextInt();// rand.nextInt(m) + 1;
		System.out.println("Enter i0_K");
		int in_K = sc.nextInt();// rand.nextInt(prime) + 1;
		
		System.out.println("Enter details for the Jth user");
		System.out.println("Enter r_J");
		int r_J = sc.nextInt();// rand.nextInt(m) + 1;
		System.out.println("Enter i0_J");
		int in_J = sc.nextInt();// rand.nextInt(prime) + 1;
		
		while (!ren)
		{
			rounds = time / (4 * prime); // each round with 4 time slots
			new_in_K = (in_K + rounds - 1) % prime + 1;
			new_in_J = (in_J + rounds - 1) % prime + 1;
			int j_K = EJSHopping(m, prime, r_K, new_in_K, time);
			int j_J = EJSHopping(m, prime, r_J, new_in_J, time);
			int res1=j_K;
			int res2=j_J;
			if (!Belongs(j_K, arrK))
			{
				System.out.println("j is modified from "+res1 +" to "+(res1=arrK[(j_K-1)%k]));
			}
			if (!Belongs(j_J, arrJ))
			{
				System.out.println("j is modified from "+res2 +" to "+(res2=arrJ[(j_J-1)%J]));
			} 
			System.out.println("result 1: " + res1+" result 2 is "+res2);
			if(res1==res2){
				System.out.println("Got rendezvous");
				ren=true;
				System.exit(0);
			}
			time++;
		}
	}

	private static int Common(int[] arrK2, int[] arrJ2)
	{
		int count=0;
		for(int i=0;i<arrK2.length;i++){
			int temp=arrK2[i];
			for(int j=0;j<arrJ2.length;j++){
				if(temp==arrJ2[j]){
					count++;
				}
			}
		}
		return count;
	}

	private static boolean Belongs(int j, int[] arrK2)
	{
		for(int h=0;h<arrK2.length;h++){
			if(j==arrK2[h]){
				return true;
			}
		}
		return false;
	}

	private static int EJSHopping(int m, int p, int r, int i, int t)
	{
		int j = 0;
		t = t % (4 * p); // each round takes 4P time slots
		if (t == 0)
			System.out.println("Jump started");

		if (t == 3 * p)
			System.out.println("Stay started");

		if (t < 3 * p) // jump Pattern
			j = ((i + t * r - 1) % p) + 1;
		else
			j = r;
		//Remapping
		if (j > m)
			j = ((j - 1) % m) + 1;
		return j;
	}

	private static boolean check_P(int n)
	{
		for (int i = 2; i <= (int) Math.sqrt(n); i++)
			if (hcf(n, i) != 1)
				return false;
		return true;
	}

	private static int hcf(int n1, int n2)
	{
		if (n2 != 0)
			return hcf(n2, n1 % n2);
		else
			return n1;
	}

}
