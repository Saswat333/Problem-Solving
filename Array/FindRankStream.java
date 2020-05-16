/*
Given a stream of integers, lookup the rank of a given integer x. Rank of an integer in stream is Total number of elements less than or equal to x (not including x).

-If element is not found in stream , insert the element in the array then insert and return its rank.
Default cosideration:
- Largest number being rank 1.
- List in sorted in non-increasing order (decreasing & equal num in same level)
*/

import java.util.*;

class FindRankStream{
	public static void main(String[] args){
		List<Integer> ipList = Arrays.asList(100,90,90,85,80,70);
        ArrayList<Integer> list = new ArrayList<Integer>();
		int xNum = 82;
        list.addAll(ipList); 
		System.out.println("Input list : "+list);
		int rank = findRank(list,xNum);
		System.out.println("Finding rank of : "+xNum);
		System.out.println(rank);
		
	}	
	
	public static int findRank(ArrayList<Integer> input, int findNum){
		int rank = 0;
		//find the number present return rank if not present add and return rank
		if(input.contains(findNum)){
			rank = findRankLogic(input,findNum);
		}
		else{
			//saving time complexity, find the index to add element in list takes O(n) time
			for(int i = 0;i<input.size();i++)
			{
				if(input.get(i)< findNum){ 
					input.add(i,findNum);//add(index,element)
					break;
				}
			}
			System.out.println("New updated input list : "+input);
			rank = findRankLogic(input,findNum);
		}
		return rank;
	
	}
	
	public static int findRankLogic(ArrayList<Integer> input, int findNum){
		//run loop over each element and check, increase rank if num less than previous
		int numRank = 0;
		ListIterator itr = input.listIterator();
		for(int i = 0;i<input.size();i++)
		{
			System.out.println("hasnext: "+itr.hasNext());
			if(itr.hasNext() && input.get(i)>input.get(i+1)){
				//else numbers will be equal, and we dont have to increase rank.
				//101, 100, 90, 90, 85, 80, 70
				//100, 90, 90, 85, 82, 80, 70
				numRank++;
				System.out.println(input.get(i));
				if(input.get(i) == findNum){
					System.out.println("break ip "+ input.get(i));
					break;
				}
				
			}
		}
		return numRank;
	}
	
}