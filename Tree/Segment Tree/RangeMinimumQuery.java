/*************** Range Minimum Query *****************
Problem Description:
Given an integer array A of size N. You have to perform two types of query, in each query you are given three integers x,y,z.     
If x = 0, then update A[y] = z.
If x = 1, then output the minimum element in the array A between index y and z inclusive. Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.     

*******************/

public class Solution {
    int[] tree=null;
    
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int lenA = A.size(), fill=1;
        tree = new int[4*lenA];
        int[] a = new int[lenA+1];
        for(int i=0;i<lenA;i++)
            a[fill++]=A.get(i);
            
        build(a,1,lenA,1);
        int rowB =B.size();
        for(int i=0;i<rowB;i++)
        {
            //update
            if(B.get(i).get(0)==0)
            {
                int loc = B.get(i).get(1);
                int val = B.get(i).get(2);
                a[loc]=val;
                update(1,1,lenA,loc,a[loc]);
            }
            else if(B.get(i).get(0)==1)
            {
                //query
                int l=B.get(i).get(1);
                int r=B.get(i).get(2);
                res.add(query(1,1,lenA,l,r));
            }
        }
        return res;
    }
    
    private int build(int[] a, int start, int end, int indx)
    {
        if(start==end)
        {
            tree[indx]=a[start];
            return tree[indx];
        }
        int mid = getMid(start,end);
        int l = build(a, start, mid, 2*indx);
        int r = build(a, mid+1, end, 2*indx+1);
        tree[indx]=Math.min(l,r);
        return tree[indx];
    }
    
    private void update(int indx, int start, int end, int pos, int val)
    {
        if(pos<start || pos>end)
        {
            return;
        }
        if(start==end)
        {
            tree[indx]=val;
            return;
        }
        int mid = getMid(start,end);
        update(2*indx, start, mid, pos, val);
        update(2*indx+1,mid+1, end, pos, val);
        tree[indx] = Math.min(tree[2*indx],tree[2*indx+1]);
    }
    
    private int query(int indx, int start, int end, int l, int r)
    {
        if(l>end || r<start)
            return Integer.MAX_VALUE; //no overlap
        if(l<=start && r>=end)
        {
            return tree[indx];//complete overlap or equal, return val
        }
        
        int mid = getMid(start, end);
        int left = query(2*indx,start, mid, l,r);
        int right = query(2*indx+1, mid+1,end, l, r);
        return Math.min(left,right);
    }
    
    private int getMid(int start, int end)
    {
        return start+(end-start)/2;
    }
    
}
