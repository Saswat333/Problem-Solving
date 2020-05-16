/* *************  Search element in a sorted matrix  *******************************
Let’s start our search from the top-right corner of the array. There are three possible cases.

The number we are searching for is greater than the current number. This will ensure, that all the elements in the current row is smaller than the number we are searching for as we are already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and we continue our search on the next row. Here elimination means we won’t search on that row again.
The number we are searching for is smaller than the current number. This will ensure, that all the elements in the current column is greater than the number we are searching for. Thus, the entire column gets eliminated and we continue our search on the previous column i.e. the column at the immediate left.
The number we are searching for is equal to the current number. This will end our search.
Since, at each step, we are eliminating an entire row or column, the time complexity of the search becomes O(n).
Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)
*/

import java.util.*;

class FindElement2d{
	public static void main(String[] args){
		int mat[][] = { { 10, 20, 30, 40 }, 
                        { 15, 25, 35, 45 }, 
                        { 27, 29, 37, 48 }, 
                        { 32, 33, 39, 50 } }; 
  
        searchElem(mat, 4, 29); 
	}
	
	static void searchElem(int mat[][], int n, int x){
		int i=0, j=n-1;
		int step=0;
		//from last column and first row.
		while(i<n && j>=0){
			if(mat[i][j] == x){
				System.out.println("Element found at i:"+i+", j: "+j);
				System.out.println("Steps: "+step);
				return;
			}
			if(mat[i][j]>x){
				++step;
				j--; //goto previous elem in same row.
			}
			else {
				++step;
				i++;//goto next row last elem
			}
		}
		System.out.println("NO ELEMENT FOUND !!!");
		return;
	}
	
	//int i = #rows, int j_low and j_high used because after removing columns we will split desired rows intwo two half and apply 
	//binary search on it.
	static void binarySearch(int mat[][], int i, int j_low, int j_high, int x){
		
		while(j_low < j_high){
			
		}
	}
}






















