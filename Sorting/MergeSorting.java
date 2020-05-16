/*MERGE SORT
	- MErgeSorting
	- Merge Procedure
*/

import java.util.*;

class MergeSorting{
	public static void main(String[] args){
		int[] arr = {10,9,11,4,5,6,30,27,12,11,0};
		int low = 0;
		int high = arr.length-1;
		long start = System.nanoTime(); 
		mergeSort(arr,low,high);
		long end = System.nanoTime();
		long elapsedTime = end- start;
		System.out.println("Sorted Array:");
		for(int i=0;i<high;i++){
			System.out.print(arr[i]+" ,");
		}
		//print runtime of program in milli second
		double elapsedTimeInMS = (double) elapsedTime / 1000000;
		System.out.println();
		System.out.println("RUN TIME: " + elapsedTimeInMS + "ms");
	}
	
	public static void mergeSort(int arr[], int low, int high){
		if(high>low){
			int mid = (low+high)/2;
			//sort the left and right side of leaves
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			mergeProcedure(arr,low,mid,high);
		}
	}
//merge 2 subarrays, first subarrays is arr[low, mid] and second arr[mid+1,high]
	public static void mergeProcedure(int arr[], int l, int m, int r){
		//find size of 2 subarray to merge
		int len1 = m-l+1;
		int len2 = r-m;
		
		int L[] = new int[len1];
		int R[] = new int[len2];
		
		//copy data to temp array, SPLITTING 
		for(int i=0;i<len1;i++)
			L[i] = arr[l+i];//copy array from first half starting from L. arr[l,mid]
		for(int i=0;i<len2;i++)
			R[i] = arr[m+1+i]; //copy 2nd half starting from mid+1, arr[mid+1, r]
		
		//Merge the temp array MERGING
		int i=0,j=0;
		int k = l;
		
		while(i<len1 && j<len2){
			if(L[i]<R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//copy remaning code into arr
		while(i<len1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<len2){
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}
}
