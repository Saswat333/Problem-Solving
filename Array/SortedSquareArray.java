/*
Problem statement:
You have sorted array of integers, write a function that returns a sorted array containing the squares of these integers.

function defination:
int[] sortedSquareArray(int[] arr){
	//code
}

input array: 1<= N <= 10000
element:  -10000 <= N <= 10000

-Input and output array must be sorted.

Note: Solve it in one pass of array.
*/

import java.util.*;

class SortedSquareArray{
	public static void main(String[] args){
		int arr[] = {-6,-4,1,2,3,5};
		int arrLen = arr.length;
		System.out.println(Arrays.toString(arr));
		int solArr[] = new int[arrLen];
		solArr = sortedSquareArrayMethod(arr);
		System.out.println("Output array: "+Arrays.toString(solArr));
		System.out.println("Expected ouput: [1, 4, 9, 16, 25, 36]");
	}
	
	public static int[] sortedSquareArrayMethod(int[] arr)
	{
		int len = arr.length;
		int solArr[] = new int[len];
		int i =0, j= len-1, itr = len-1;
		
		while(i<=j){
			if(Math.abs(arr[i]) > Math.abs(arr[j])){
				solArr[itr] = arr[Math.abs(i)]*arr[Math.abs(i)];
				//System.out.println("i: "+arr[i]+" j:"+arr[j]);
				itr--;
				i++;
			}
			else{
				solArr[itr] = arr[Math.abs(j)]*arr[Math.abs(j)];
				//System.out.println("i: "+arr[i]+" j:"+arr[j]);
				itr--;
				j--;
			}
		}
		return solArr;
	}

}

