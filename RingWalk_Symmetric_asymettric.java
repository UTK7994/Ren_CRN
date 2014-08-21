/*
here the symmettric as well as asymettric goes together
User is asked for choice and he has to select the choice =1,2
Then if choice=1 here the 2 subset2 (s1,s2) are same and then user1 and user2 startwalking in opposite directions
Must read "Ring Walk for Rendezvous Paper" to get a clear understanding
Then they may collide.
*/

import java.util.Scanner;

class user
{
	int id;

	public user(int id)
	{
		this.id = id;
	}
}

class RingWalk_Symmetric_asymettric
{
	static Scanner sc;
	static int[] s1, s2;
	static int m1,m2;
	static int check = 0;

	public static void main(String args[]) throws Exception
	{
		sc = new Scanner(System.in);
		System.out.println("Enter the ids of 2 users");
		int id1 = sc.nextInt();
		int id2 = sc.nextInt();

		while (id1 == id2)
		{
			System.out.println("Renter the ids");
			id1 = sc.nextInt();
			id2 = sc.nextInt();
		}

		System.out.println("1->Symmetric or 2->Asymmetric??");
		int choice = sc.nextInt();

		if(choice==2){
			System.out.println("Enter the no of channels for user1");}
		else if(choice==1){
			System.out.println("Enter the no of channels for Common set");
		}
		
		m1 = sc.nextInt();
		s1 = new int[m1];
		System.out.println("enter the elements in set1");
		for (int i = 0; i < m1; i++)
		{
			s1[i] = sc.nextInt();
		}

		if (choice == 2)
		{
			//request for other array!!
			System.out.println("Enter the no of channels for user2");
			m2 = sc.nextInt();
			s2 = new int[m2];
			System.out.println("enter the elements in set2");
			for (int i = 0; i < m2; i++)
			{
				s2[i] = sc.nextInt();
			}

			int i = 0, j = 0;
			for (i = 0; i < s1.length; i++)
			{
				for (j = 0; j < s2.length; j++)
				{
					if (s1[i] == s2[j])
					{
						System.out.println("Rendezvous possible!!!!");
						i = s1.length + 1;
						j = s2.length + 1;
						break;
					}
				}
			}

			if (i == s1.length && j == s2.length)
			{
				System.out.println("Rendezvous Impossible!!!!");
				System.exit(0);
			}
			
		} else if (choice == 1)
		{
			//size will be same
			s2=new int[m1];
			m2=m1;
			for (int i = 0; i < m1; i++)
			{
				s2[i] = s1[i];
			}
		}

		System.out.println("Enter the shift");
		int k = sc.nextInt();

		System.out.println("User 1 in clockwise and user2 in Anticlockwise");
		boolean ren = false;
		int loop_no1 = 0;
		int loop_no2 = 0;
		int time = 0;

		while (!ren)
		{
			time++;
			int res1=s1[(int)(loop_no1/id1)%m1];
			loop_no1++;
			System.out.print("res is "+res1+" user 2 is ");
			
			int res2=0;
			
			if(loop_no1>k){
				res2=s2[(int)(loop_no2/id2)%m2];
				loop_no2++;
				System.out.println(" "+res2);
			}else{
				System.out.println(" not yet started!!!");
			}
			
			if(res1==res2){
				System.out.println("Rendezvous!!!! at time = "+time);
				System.exit(0);
			}
			Thread.sleep(1000);
		
		}

	}
}
