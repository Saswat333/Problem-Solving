/*LEETCODE
307. Range Sum Query - Mutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

*/

class NumArray {
    int ipSize=0; //size of input array
    int[] segTree=null;//segment tree

    public NumArray(int[] nums) {
        if( nums!=null && nums.length!=0)
        {
            ipSize = nums.length;
            segTree = new int[4*ipSize-1];
            build(nums, 0,0,ipSize-1);
        }
    }
    
    //segIndx = iterate over segmentTree
    private void build(int[] nums, int segIndx, int segStart, int segEnd)
    {
        if(segStart==segEnd)
        {
            segTree[segIndx] = nums[segStart];
            return;
        }
        int mid = segStart+(segEnd-segStart)/2;
        build(nums, 2*segIndx+1,segStart, mid);
        build(nums, 2*segIndx+2,mid+1, segEnd);
        
        segTree[segIndx]= segTree[2*segIndx+1]+segTree[2*segIndx+2];
    }
    
    public void update(int i, int val) {
        updateUtil(i,val,0,0,ipSize-1);
    }
    
    private void updateUtil(int i, int val, int segIndx, int segStart, int segEnd)
    {
        if(segStart==segEnd)
        {
            segTree[segIndx]=val;
            return;
        }
        
        int mid = segStart+(segEnd-segStart)/2;
        //we need to traverse only one path
        if(i<=mid)
            updateUtil(i,val,2*segIndx+1,segStart,mid);
        else
            updateUtil(i,val,2*segIndx+2,mid+1,segEnd);
        
        segTree[segIndx]= segTree[2*segIndx+1]+segTree[2*segIndx+2];
    }
    
    public int sumRange(int i, int j) {
        return querySum(i,j,0,0,ipSize-1);
    }
    
    private int querySum(int i, int j, int nodeIndex, int segStart, int segEnd) {
        if (i > j) return 0;
        if (i == segStart && j == segEnd) return segTree[nodeIndex];
        int mid = segStart + (segEnd - segStart) / 2;
        return querySum(i, Math.min(mid, j), nodeIndex * 2 + 1, segStart, mid) + 
                querySum(Math.max(mid + 1, i), j, nodeIndex * 2 + 2, mid + 1, segEnd);
    }
    
}

/***CONCEPT******
    1. total overlap : if(i>segStart && j<segEnd: return segTree[indx]
    2. no overlap: if(i>segEnd || j<i) : return no overlap(max_int)
    3. partial overlap: 
    */