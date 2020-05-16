/* **********************Largest Sum Contiguous Subarray
Kadane's algorithm:
-2, -3, 4, -1, -2, 1, 5, -3}

when we are at elem x, we can have 2 possiblity:(let x=4)
	1. Either only x > Mx (where Mx is max num subset ), eg: 4 > [-2 + -3]
	2. x+Mx , x+Mx > x only , eg: 
	
*/

import java.util.*;

class KadaneAlgorithm{
	public static void main(String[] args){
		int arr[] ={-2, -3, 4, -1, -2, 1, 5, -3};
		int sol = findMaxContigSubarray(arr);
		System.out.println("Largest Sum: "+sol);
		
	}
	/*
	public static int findMaxContigSubarray(int arr[]){
		int len = arr.length;
		int max_Cur =0, max_Total = Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++){
			max_Cur = max_Cur+arr[i];
			
			if(max_Cur < 0)
				max_Cur =0;
			if(max_Total < max_Cur){
				System.out.println("max_total: "+max_Total);
				max_Total = max_Cur;
			}
		}
		return max_Total;
		
	}*/
	//dynamic programing- O(log n) - kadane algorithm
	
	public static int findMaxContigSubarray(int[] arr){
		int len = arr.length;
		int max_Cur =arr[0], max_Total = arr[0];
		
		for(int i=1;i<len;i++){
			max_Cur = Math.max(arr[i], arr[i]+max_Cur);
			if(max_Cur>max_Total)
				max_Total = max_Cur; 
		}
		return max_Total;
	}
}
