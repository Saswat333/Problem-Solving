/*
1- updating value 2-querying
- we need two input arrays and have to build two segment trees for it segment trees(2D tree)
*/
public class Solution {
    int N = 400005; long mod =1000000007L;
    long[][] tree;
    long[] a,b;
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int lenA = A.size();
        int lenBrow = B.size();
        tree = new long[2][N*2];
        a = new long[N];
        b = new long[N];
        for(int i=1;i<lenA+1;i++)
            a[i]= (long)A.get(i-1);
        for(int i=1;i<lenA+1;i++)
            b[i] = (long)i*a[i];
        build(1,1,lenA);
        for(int i=0;i<lenBrow;i++)
        {
            int type = B.get(i).get(0);
            if(type==1)
            {
                //update
                int pos = B.get(i).get(1); 
                long val = B.get(i).get(2);
                update(0,1,1, lenA, pos, val); //segtree1
                update(1,1,1, lenA, pos, pos*val); //segtree2
            }
            else{
                //query
                int l = B.get(i).get(1); 
                int r = B.get(i).get(2);
                long tempVal = (query(1,1,1,lenA,l,r)%mod - ((l-1)*query(0,1,1,lenA,l,r)%mod)+mod)%mod;
                res.add((int)tempVal);
            }
        }
        return res;
    }
    
    private void build(int indx, int start, int end)
    {
        if(start==end)
        {
            tree[0][indx] =a[start];
            tree[1][indx] =b[start];
            return;
        }
        
        int mid = getMid(start,end);
        build(2*indx, start, mid);
        build(2*indx+1, mid+1, end);
        
        tree[0][indx] = getModSum(0,indx);
        tree[1][indx] = getModSum(1,indx);
    }
    
    private void update(int row, int indx, int start, int end, int pos, long val)
    {
        if(start==end)
        {
            tree[row][indx] = val;
            return;
        }
        int mid = getMid(start, end);
        if(start<=pos && pos<=mid)
            update(row, 2*indx,start, mid, pos,val);
        else
            update(row, 2*indx+1,mid+1, end, pos,val);
        
        tree[0][indx] = getModSum(0,indx);
        tree[1][indx] = getModSum(1,indx);
    }
    
    private long query(int row, int indx, int start, int end, int l, int r)
    {
        //start-end inside Qrange return val
        if(l<=start && r>=end)
            return tree[row][indx];
        if(r<start || l> end)
            return 0;
        int mid = (start+end)/2;
        long left = query(row, 2*indx, start, mid, l, r);
        long right = query(row, 2*indx+1, mid+1, end, l, r);
        return (left+right)%mod;
    }
    
    private int getMid(int start, int end)
    {
        return (start+(end-start)/2)%(int)mod;
    }
    
    private long getModSum(int row, int indx)
    {
        long result = (tree[row][2*indx]%mod + (tree[row][2*indx+1]%mod))%mod;
        return result;
    }
}
