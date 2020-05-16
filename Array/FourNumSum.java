/**
4 number sum problem
Avg case time complexity = O(n^2)
Worst = O(n^3), Naive approach = O(n^4)
Space avg = O(n^2)
Algorithm:
1. Create a empty hashmap<Key, value of 2D arrrayist> for 
2. Create a 2D ArrayList for solution array
3. nested for loop
	- for (i=1 to endofIPArray) goes forward 1 to lengh-1 (exclude 1st and last element)
		- for(j=i+1 to lastelem), 
			- add cur num(i) to curnum(j), and find the difference and check whether its available in hashtable
			- if the difference is there in the hastable
				- for(loop): add all number to solution ArrayList
		- for(k=0;k<i)
			- curSum = arr[i] + arr[j], put the sum in an array 
			- check if the curSum is there in the hashtable 
				- if not present add the array into the hashtable(the sum could be already present, we can add any number of distinct sum )
				
**/

import java.util.ArrayList;
import java.util.HashMap;

public class FourNumSum{
	public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum)
	{
		HashMap<Integer, ArrayList<Integer[]>> allPair = new HashMap<Integer, ArrayList<Integer[]>>();
		ArrayList<Integer[]> quadruple = new ArrayList<Integer[]>();
		for(int i=1;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				int curSum = array[i]+array[j];
				int curDiff = taregetSum - curSum;
				if(allPair.containsKey(curDiff))
				{
					//There could be multiple pair of sum in hashtable
					for(Integer[] pair : allPair.get(curDiff))
					{
						Integer[] newQuadruple = {array[i],array[j],pair[0],pair[1]};
						quadruple.add(newQuadruple);
					}
				}
			}
			
			for(int k =0;k<i;k++)
			{
				int curSumPair = array[i]+array[k];
				Integer[] pair = {array[i],array[k]};
				if(!allPair.containsKey(curSumPair))
				{
					ArrayList<Integer[]> newPair = new ArrayList<Integer[]>();
					newPair.add(pair);
					allPair.put(curSumPair,newPair);//key,value
				}
				else{
					
				}
			}
		}
	}
}