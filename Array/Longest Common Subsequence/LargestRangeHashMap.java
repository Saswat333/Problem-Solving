/*
Largest range(longest subsequence)
Using Hashmap

ip: [1,11,3,0,15,5,24,10,7,12,6]
op:[0,7]

Algo:
- initialise a hashmap and put all nums and give val as true.
- traverse the array again
	- check if the value is already traversed, check true/false value
	- else, if num not traversed put the value as false in hashmap
	- intitalise left: value 1 less than the current num in array, right : value=1, and currentLength: to keep track of the length
	- Write 2 while loops to check the left and right values are there as key in the hashmap
	- Finally, we can check is the curlen > longestLen
		- if true then we can put the left and right value int the array 
		note: in while loop left has already decremented to value where it fails in while loop, so we do left+1 before saving in solution array, same for right.
*/

import java.util.HashMap;

public class LargestRangeHashMap
{
	public static int largestRange(int[] array)
	{
		int[] bestRange = new int[2];
		int longestLen =0;
		HashMap<Integer,Boolean> nums = new HashMap<Integer,Boolean>();
		for(int n : array)
			nums.put(n,true);
		
		for(int n : array)
		{
			if(!nums.get(n)) //get: returns the object that contains the value associated with the key
				continue;
			nums.put(n,false);
			int left = n -1;
			int right = n+1;
			int curLen = 1;
			
			while(nums.containsKey(right))
			{
				nums.put(right,false);
				curLen++;
				right++;
			}
			while(nums.containsKey(left))
			{
				nums.put(left,false);
				curLen++;
				left--;
			}
			if(curLen > longestLen)
			{
				longestLen = curLen;
				bestRange = new int[]{left+1,right-1};
			}
		}
		return bestRange;
	}
}