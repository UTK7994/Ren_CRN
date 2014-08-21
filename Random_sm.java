/*
This is named as Random_sm(meaning the symetric nature or common channels in Hopping)
The set of channels used by user1 are same as used by user2(hence Program prompts single time the input of channels)
*/


import java.util.Random;
import java.util.Scanner;

class Random_sm
{
	//Scanner for input
		static Scanner sc;
		public static void main(String args[]){
			sc=new Scanner(System.in);
			System.out.println("Enter the number of channels!!");
			int m=sc.nextInt();
			System.out.println("Channels from 1 to "+m+" are available");
			Random r=new Random();
			boolean ren=false;
			
			
			//start choosing randomly
			int time=0;
			do{
				time++;
			int index1=r.nextInt(m)+1;
			int index2=r.nextInt(m)+1;
			System.out.println("Ch1 is "+index1+" Ch2 is  "+index2);
			if(index1==index2){
				System.out.println("Got Rendezvous at time= "+time+" Channel = "+index1+"\nEXITED!!");
				ren=true;
				System.exit(0);
			}
			}while(!ren);
			
		}
}
