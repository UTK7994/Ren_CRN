/*
The set of channels are  all same
An oscillatory scheme was considered such that user1 and user2 move in oscillatory movements(to and fro) to match up with each other
Also the 2 users take in account the shift i-e the users do not start at teh same time and one will have to Wait!!!
This was also Our currently Developed Scheme.
*/


import java.util.Scanner;

class OCH_sm
{

	static Scanner sc;
	static int[] arr;
	static int m, k;

	public static void main(String[] args)
	{
		//Symmetric case
		sc = new Scanner(System.in);
		System.out.println("enter the number of Channels");
		m = sc.nextInt();
		System.out.println("m is " + m + " and  2m-1 is " + (2 * m - 1));
		// forming array with channels starting from 1 to c
		arr = new int[2 * m - 1];
		for (int i = 0; i < arr.length; i++)
		{
			if (i < m)
			{
				arr[i] = i + 1;
			} else
			{
				arr[i] = arr[2 * (m - 1) - i];
			}
		}
		System.out.println("Displaying");
		disp();
		System.out.println("Enter the shift!!!");
		k = sc.nextInt();
		boolean ren = false;
		int i1 = 0;
		int i2=0;
		int time=0;
		System.out.println("Started\n\n");

		while(!ren)
		{
			time++;
			i1++;
			int res1=arr[(i1 - 1) % (2 * m - 1)];
			System.out.print(res1);
			if (i1 > k)
			{
				int round_no=i2/(2*m-1);
				int res2=arr[round_no%m];
				System.out.println("  User2 is at " + res2);
				if(res1==res2){
					ren=true;
					System.out.println("Got rendezvous!!!! at time= "+time+"\nExited!!");
					System.exit(0);
				}
				i2 ++;
			} else
			{
				System.out.println("  other has not started!!!");
			}
		}
	}

	private static void disp()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}

}
