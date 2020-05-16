/***************   MEDIAN OF TWO SORTED ARRAY OF DIFFERENT SIZE 
1. TRY TO divide both array in 2 parts (arr1-1,arr1-2, arr2-1, arr2-2), such that (arr1-1+arr2-1) = (arr1-2+arr2-2)
2. Cases(arrSplitL/R is split index of the array)
Note:PartitionX + PartitionY = (x+y+1)/2; //x =length of arr1,y = len of arr2
3. SPLITING OF ARRAY equally
		-Binary Search on smaller array, and find point where every elem in left side is smaller than equal to every elem on right side.
Eg: A = 1,3,8,9,15 (X=5)
	B = 7,11,18,19,21,25 (y=6)
Loop1:	As, A is smaller array, apply binary search start = 0, end =4, partitionX = 4/2 =2, partitionY = 5+6+1/2 - partitionX = 4
		( partitionY calculation is derived from : PartitionX + PartitionY = (x+y+1)/2 )
		A:Left: 1,3 B:Left: 7,11,18,19		A:Right: 8,9,15, B:Right: 21,25 (Px:2, Py:4)
	Now, check for if condition: if(3<21): true && if(19<8): false , So recalculate start, end , partitionX, partitionY
Loop2: Now , we have to move our BS towards right side of A, as A:Right < B:Left, start = partitionX+1 = 2+1=3, end =4
 (low=3, high=4)partitionX = 3+4/2 = 3, partitionY = 5+6+1/2 - partitionX = 6-3= 3.
	A:Left: 1,3,8 B:Left: 7,11,18		A:Right: 9,15, B:Right: 19,21,25
	Now, check if condition: if(8<19) :true && if(18<9):false . Condition fails . So recalculate start, en, partitionX,Y
Loop3: Now, we have to move our BS towards right side of A, as A:Right < B:Left, start = partitionX+1 = 3+1=4, end =4
	partitionX = 4+4/2= 4 	partitionY =  6-4 =2
	A:Left: 1,3,8,9 B:Left: 7,11	A:Right: 15, B:Right: 18,19,21,25
	Now, check for if condition: if(9<18): true && if(11<15): true , So the median will be max(Aleftmax, Bleft max) : (9,11)=11
	
4.Element found: 	if (arr1MaxL <= arr2MinR) && (arr2MaxL <= arr1MinR) , then median will be 
						Even elem: Math.avg(Max(arr1SplitL,arr2SplitL),Min(arr1SplitR,arr2SplitR))
						Odd elem: (extra elem in left) Math.max(arr1SplitL,arr2SplitL)
					Else if:
						arr1MaxL > arr2MinR then Move binarySearch towards left X500Principal
					Else if:
						Move towards right in X
	*************************************************************************************/

public class MedianOfTwoSortedArrayOfDifferentLength{
	//function
	//Note: PartitionX + PartitionY = (x+y+1)/2;
	public double findMedianSortedArrays(int[] input1, int[] input2) 
	{
		double sol =0.0;
		int x = input1.length;
		int y = input2.length;
		//System.out.println("x:"+x+"  y:"+y);
		//Edge cases
		if(x==0 && y==0)
			return -1;
		if(x==0 && y ==1)
		    return input2[0];
		else if(x == 1 && y==0)
		    return input1[0];
		 
		if(x==0&& y>1)
		 {
		     sol = returnMedianO(input2);
		     return sol;
		 }
		else if(x>1&&y==0){
		     sol = returnMedianO(input1);
		     return sol;
		 }

		//keep input1 as the smaller array
		if(x > y){
			return findMedianSortedArrays(input2, input1);
		}
		
		int low =0, high = x; //we consider Binary search wrt smaller array && low high is use to calculation partition point
		//keep iterating to find correct partition point 
		
		while(low<=high)
		{
			//every iteration we recalculate start maxLeftX, minRightY && maxLeftY , minRightX, partitionX/Y
			//System.out.println("low: "+low+" high:"+high);
			int partitionX = (low+high)/2; //half of the array 
			int partitionY = (x+y+1)/2 - partitionX;
			//System.out.println("partition....inside while"+partitionX+" "+partitionY);
			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX-1];
			int minRightY = (partitionY == y)?  Integer.MAX_VALUE : input2[partitionY];
			int minRightX = (partitionX == x)? Integer.MAX_VALUE : input1[partitionX];
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY-1];
			//System.out.println("after calulating maxleft/right ..... inside while");
			if(maxLeftX <= minRightY && maxLeftY <= minRightX)
			{
				//array is partitioned at correct place
				//System.out.println("inside conditional check...");
				if((x+y)%2 == 0){
					//System.out.println("inside conditional check...if..");
					//sol =(double)((Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2);
					double m = Math.max(maxLeftX,maxLeftY);
				    double n = Math.min(minRightX,minRightY);
					//System.out.println("inside conditional check...if..");
					sol =(m+n)/2;
					return sol;
				}
				else{
					//System.out.println("inside conditional check...else..");
					sol = (double)Math.max(maxLeftX,maxLeftY);
					return sol;
				}
			}
			else if(maxLeftX > minRightY) 
			{// we are too far on right side for partition, move left by sending more elem to left side in X
				high = partitionX-1;
				//System.out.println("inside conditional check...elseif outer..updated high "+high+" low:"+low);
			}
			else{
				low = partitionX+1;
				//System.out.println("inside conditional check...else outer..updated low "+low+" high"+high);
			}
		}
		return sol;
		//throw new IllegalArgumentException();
	}
	
	public static double returnMedianO( int[] a){
        int size = a.length; double sol=0.0;
        if(size%2 ==0){
            double p = a[size/2];
            double q = a[size/2-1];
            //System.out.println("val1: "+p+"  val2: "+q);
            sol = (p+q)/2;
            //System.out.println("Solution returnMedianO : "+sol);
            return sol;
        }
        return (double)a[size/2];
    }
	//driver code
	 public static void main(String[] args) {
// -37 -10 -5 5 17 34 39 , -30 -27 -21 -21 41
        int[] x = {-37, -10, -5, 5, 17, 34, 39};
        int[] y = {-30, -27, -21, -21,41};
		//-50,-50,-41,-40,-21,-19,-10,5,21,28
        MedianOfTwoSortedArrayOfDifferentLength mm = new MedianOfTwoSortedArrayOfDifferentLength();
        double sol = mm.findMedianSortedArrays(x, y);
		System.out.println("Median :"+sol);
    }
}















