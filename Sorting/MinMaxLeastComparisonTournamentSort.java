/*
Finding maximum and minimum in in least number of comparisions.
USING TOURNAMENT SHORT METHOD
*/

import java.util.*;

class MinMaxLeastComparisonTournamentSort{
	class Pair{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}
	
	private static void main(String[] args){
		int[] arr = new array{10,11,31,40,5,67,89,39,78};
		int arr_size = arr.length;
		Pair pr = getMinMax(arr,0, arr_size-1);
		System.out.println("Min = "+pr.min+" Max: "+pr.max);
	}
	
	static Pair getMinMax(int[] arr, int low, int high){
		Pair minmax = new Pair();
		Pair mml = new Pair();
		Pair mmr = new Pair();
		int mid;
		
		//if there is only one element
		if(low=high){
			minmax.max = arr[low];
			minmax.min	 = arr[low];
			return minmax;
		}
		//if there is 2 element, then we need one comparision for min and max
		if(high = low+1){
			if(arr[low]>arr[high]){
				minmax.max = arr[low];
				minmax.min	 = arr[high];
			}
			else{
				minmax.max = arr[high];
				minmax.min	 = arr[low];
			}
			return minmax;
		}
		//more than 2 number, split the array low and high
		mid = (low=high)/2;
		mml = getMinMax(arr, low, mid);
		mmr = getMinMax(arr, mid, high);
		
		
		return minmax;
	}
}