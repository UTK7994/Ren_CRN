/*
here the users are there but the main set and 2 subsets of it also play  a role !!!
m=total channels you entered
here the main set channels are asked and channel id starts from 1 to m;
m1=hopping set for user_1
Now the program ask for subset channels and then give the chance to user_1 to hopp in channels from 1 to input_limit(m1)
user1 is given the channels from 1 to m1
now comes the number of channels user2 takes (m2) from m1-g+1 to m1+m2-g such that g channels are in common.....
eg m=10 m1=6 and m2=6 g=2
the m={1,2,3,4,5,6,7,8,9,10}  m1={1,2,3,4,5,6} and m2={5,6,7,8,9,10}
and then users1 choose from m1 set and user2 chooses from m2 set till they get Rendezvous
*/

import java.util.Random;
import java.util.Scanner;

class Random_asm
{
	// Scanner for input
	static int[] arr, arr1, arr2;
	static Scanner sc;

	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		System.out.println("Enter the Total number of channels in main set!!");
		int m = sc.nextInt();
		arr = new int[m];
		for (int i = 0; i < m; i++)
		{
			arr[i] = i + 1;
		}
		System.out.println("Channels from 1 to " + m + " are available");
		
		// ===========================================

		System.out.println("Enter the number of channels in Sub_set1!!");
		int m1 = sc.nextInt();
		while (m1 > m)
		{
			System.out.println("Renter the channels <= " + m);
			m1=sc.nextInt();
		}
		arr1 = new int[m1];
		System.out.println("Enter the id of each channel");

		for (int i = 0; i < m1; i++)
		{
			arr1[i] = i+1;
		}
		disp(arr1);
		
		// ===========================================

		System.out.println("Enter the number of channels in Sub_set2!!");
		int m2 = sc.nextInt();
		while (m2 > m)
		{
			System.out.println("Renter the channels <= " + m);
		}
		arr2 = new int[m2];
		
		System.out.println("Also enter the common channels");
		int g=sc.nextInt();
		while (m2 +m1-g > m)
		{
			System.out.println("Renter the common channels cant choose the tuple m1,m2 and g such that m2 +m1-g > m");
			g=sc.nextInt();
		}

		for (int i = 0; i < m2; i++)
		{
			arr2[i] = arr[i+arr1.length-g];
		}
		disp(arr2);
		
		boolean b = find();
		if (b == false)
		{
			System.out.println("No channels were in common\n EXITED");
			System.exit(0);
		}
				

		Random r = new Random();
		boolean ren = false;

		// start choosing randomly
		int time = 0;
		do
		{
			time++;
			int index1 = r.nextInt(m1) ;
			int index2 = r.nextInt(m2);
			System.out.println("Ch1 is " + arr1[index1] + " Ch2 is  " +arr2[ index2]);
			if (arr1[index1] ==arr2[ index2])
			{
				System.out.println("Got Rendezvous at time= " + time);
				ren = true;
				System.exit(0);
			}
		} while (!ren);

	}

	private static boolean find()
	{
		boolean b=false;
		//Checks all the elements with set2 elements
		for (int j = 0; j < arr1.length; j++)
		{
			int temp = arr1[j];
			for (int i = 0; i < arr2.length; i++)
			{
				if (arr2[i] == temp)
				{
					b=true;
					//System.out.println("Found " + temp + " in common!!!");
				}
			}
		}
		return b;

	}
	
	private static void disp(int[] Arr)
	{
		System.out.print("{");
		for (int i = 0; i < Arr.length; i++)
		{
			System.out.print(Arr[i] + ",");
		}
		System.out.print("}");
		System.out.println();
	}
	
}
