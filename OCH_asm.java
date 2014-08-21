/*
The set of channels are not all same
An oscillatory scheme was considered such that user1 and user2 move in oscillatory movements(to and fro) to match up with each other
This was Our currently Developed Scheme.
*/

import java.util.Random;
import java.util.Scanner;

class OCH_asm
{

	static int[] arr, arr1, arr2;
	static int m, m1, m2;
	static Scanner sc;
	static Random rand;

	public static void main(String[] args) throws Exception
	{
		// Asymmetric case
		rand = new Random();
		sc = new Scanner(System.in);
		System.out.println("Enter the number of channels!! in the main set");
		m = sc.nextInt();
		System.out.println("Channels in the main set are from 1 to " + m
				+ " to 1");
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

		// ============================//

		System.out.println("Enter the number of channels in the subset Ai");
		m1 = sc.nextInt();
		while (m1 > m)
		{
			System.out
					.println("Ai is the subset of main set value leq is accepted");
			m1 = sc.nextInt();
		}
		arr1 = new int[m1];

		// =============================//

		System.out.println("Enter the number of channels in the subset Aj");
		m2 = sc.nextInt();
		while (m2 > m)
		{
			System.out
					.println("Aj is the subset of main set value leq is accepted");
			m2 = sc.nextInt();
		}
		arr2 = new int[m2];

		// ============================//

		System.out.println("Enter the common channels ");
		int g = sc.nextInt();
		//added 2 lines 1 after while and 1 is the for loop of g
		for (g = 2; g <= 20; g += 2)
		{
			int[] final_array = new int[m - g];
			int final_array_index = 0;
			while (final_array_index < final_array.length)
			{
					final_array[final_array_index++] = final_array_index;
			}
			disp(final_array);
			for (int i = 0; i < arr1.length; i++)
			{
				arr1[i] = final_array[i];
			}
			System.out.println("array 1 is  ");
			disp(arr1);
			/*System.out.println("shuffled array1 is ");
			disp(Shuffle(arr1));*/

			int index_forarr2_byfinal = final_array.length;
			int index_forarr2 = arr2.length;

			while (index_forarr2 > 0)
			{
				arr2[--index_forarr2] = final_array[--index_forarr2_byfinal];
			}
			disp(arr2);
			/*System.out.println("shuffled array2 is ");
			disp(Shuffle(arr2));*/

			System.out.println("Finally the  sets are Main");
			System.out.println("Main1  ");
			disp(arr);
			System.out.println("Set1  ");
			disp(arr1);
			System.out.println("Set2  ");
			disp(arr2);

			System.out.println("Enter the shift  for g= "+g);
			int d =rand.nextInt(2*m-1)+1;

			boolean ren = false;
			int in1 = 0;
			int in2 = 0;
			int time = 0;

			while (!ren)
			{
				
				in1++;
				// computation of res 1
				int k = (in1 - 1) / (2 * m - 1);
				int res1 = arr[(in1 - 1) % (2 * m - 1)];
				if (!belongs(res1, arr1))
				{
					res1 = arr1[k % m1];
				}
				System.out.print("res1 is " + res1);

				// Computation of res 2 if time passes the shift
				if (in1 > d)
				{
					// work out res2
					int round_no = in2 / (2 * m - 1);
					int res2 = arr2[round_no % m2];
					System.out.println("  res2 is " + res2);
					if (res1 == res2)
					{
						ren = true;
						System.out.println("Got rendezvous!!!! at time= "
								+ time + "\nExited!!");
						break;
						//System.exit(0);
					}
					in2++;
					time++;
				} else
				{
					System.out.println(" Not started");
				}
				// Thread.sleep(1000);
			}

		}
	}

	private static int[] Shuffle(int[] cards)
	{
		for (int i = 0; i < cards.length; i++)
		{
			int randomPosition = rand.nextInt(cards.length);
			int temp = cards[i];
			cards[i] = cards[randomPosition];
			cards[randomPosition] = temp;
		}
		return cards;
	}

	private static boolean belongs(int f, int[] array)
	{
		int i = 0;
		for (i = 0; i < array.length; i++)
		{
			if (array[i] == f)
			{
				break;
			}
		}
		if (i == array.length)
		{
			return false;
		}
		return true;
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
