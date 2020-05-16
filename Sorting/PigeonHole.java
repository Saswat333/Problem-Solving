/*********PIGEONHOLE SORTING*************

*/
 
import java.lang.*; 
import java.util.*;
class PigeonHole{
	//driver code
	public static void main(String[] args){
		int[] arr = {8, 3, 2, 7, 4, 6, 8}; 
		pigeonholeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//function
	public static void pigeonholeSort(int arr[]){
		int maxVal = arr[0], minVal = arr[0], len = arr.length,index=0;
		//find the min and max value
		for(int i=0;i<len;i++){
			minVal = Math.min(minVal,arr[i]);
			maxVal = Math.max(maxVal,arr[i]);
		}
		int range  = maxVal-minVal+1;
		//build a new array
		int[] phole = new int[range];
		Arrays.fill(phole,0);
		
		//fil the new array, with value of i/p array
		for(int i=0;i<len;i++){
			phole[arr[i]-minVal]++; //keeping 1 in the location where elem is present
		}
		
		//now extract all value from phole array to original array
		for(int j=0;j<range;j++){
			while(phole[j]-- >0)
				arr[index++] = j+minVal;
		}
	} 
}