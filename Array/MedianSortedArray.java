/*******MEDIAN OF TWO SORTED ARRAY OF SAME SIZE 
Merge two sorted array of same size
1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
*/

import java.util.*;

class MedianSortedArray{
	public static void main(String[] args){
		int[] arr1 = {1,2,3,6};//median 2+3/2 = 2.5
		int[] arr2 = {4,6,8,10};//median = 6+8/2 = 7
		int n1 = arr1.length;
		int n2 = arr2.length;
		if(n1 == n2){
			int sol = getMedian(arr1,arr2);
			System.out.println("Median of both array: "+sol);
		}
		else{
			System.out.println("OOPS !! UNEQUAL ARRAY SIZE .");
		}
	}
	
	static int getMedian(int[] arr1, int[] arr2)
	{
		int len = arr1.length;
		//edge case for different length, n<=0, n=1 and n=2 (in both arrays)
		if(len<=0)
			return -1;
		if(len==1)
			return (arr1[0]+arr2[1])/2;
		if(len==2){
			int a = Math.max(arr1[0],arr1[1]);
			int b = Math.min(arr2[0],arr2[1]);
			int med = (a+b)/2;
			return med;
		}
		//1. Get the median of both array
		int m1 = median(arr1);
		int m2 = median(arr2);
		
		//2. if m1 = m2, then return median
		if(m1 == m2)
			return m1;
		
		/*4) If m2 is greater than m1, then median is present in one of the below two subarrays.
				a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1]) //part2 of m1
				b)  From first element of ar2 to m2 (ar2[0...|_n/2_|]) //part1 of m2
		*/
		if(m1 < m2){
			if(len%2 == 0)
				return getMedian(arr1+len/2-1,arr2);
			return getMedian(arr1+len/2,arr2);//bydefault send math.floor value
		}
		/* 3.If m1 is greater than m2, then median is present in one 
			of the below two subarrays.
				a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
				b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])*/
		else{
			if(n%2 == 0)
				return getMedian(arr1,arr2+len/2-1);
			return getMedian(arr1,arr2+len/2);
		}
	}
	
	public static int median(int[] array){
		//median in sorted array
		int len = array.length;
		if(len%2 ==0 ){
			int mid = (array[len/2]+array[len/2-1])/2;
			System.out.println("median method mid val: "+mid);
			return mid;
		}
		else{
			int mid = array[Math.floor(len/2)];
			return mid;
		}
	}
}
























