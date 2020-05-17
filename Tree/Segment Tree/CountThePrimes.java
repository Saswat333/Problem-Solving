/******** PROBLEM DESCRIPTION ********************************************************************************************************************
-----Count the primes--------
Problem Description
Given an array A, containing positive integers. You need to perform some queries on it. You will be given Q Queries. Each query will have one string and two integers. Each Query can be of two type :
"C" X Y - Here "C" says that we need to Change the integer at position X to integer Y.
"A" X Y - Here "A" say that we are Asked number of primes in the the range : [X, Y] (inclusive)
 For each Query of type 2, you need to calculate an integer denoting the answer to it. NOTE: 
Assume 1-indexing for all queries.
Your code will be run on multiple test cases (< 10). Make sure to come up with an optimised solution and take care of clearing global variables.
- NOTE: Approach discuused at end of page
**************************************************************************************************************************************************/

public class Solution {
    final int N = 4*10010; int M = 1000010;
    int[] tree=null;
    int[] isPrime = new int[M];
    int[] a = null;
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B, ArrayList<Integer> C, ArrayList<Integer> D) 
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int rowA = A.size(),fill=1;
        tree = new int[4*rowA];
        a = new int[rowA+1];
        seive();
        for(int i=0;i<rowA;i++)
        {
            a[fill++]= isPrime[A.get(i)];
        }
        build(a,1,rowA, 1);
        
        //row count of B,C AND D are 
        int rowB = B.size();
        for(int i=0;i<rowB;i++)
        {
            String type=B.get(i);
            if(type.charAt(0) == 'A')
            {
                int l = C.get(i);
                int r = D.get(i);
                res.add(query(1,1,rowA, l,r));
            }
            else if(type.charAt(0)=='C')
            {
                int pos = C.get(i);
                int val = D.get(i);
                a[pos] = isPrime[val];
                update(1,1,rowA,pos,a[pos]);
            }
        }
        return res;
    }
    
    private void update(int indx, int start, int end, int pos, int val)
    {
        if(start==end)
        {
            tree[indx]=val;
            return;
        }
        int mid = start+(end-start)/2;
        if(pos<=mid)
            update(2*indx, start, mid, pos, val);
        else
            update(2*indx+1,mid+1, end, pos, val);
            
        tree[indx] = tree[2*indx]+tree[2*indx+1];
    }
    
    private int query(int indx, int start, int end, int l, int r)
    {
        if(l>end || r<start)
            return 0; //no overlap
        if(l<=start && r>=end)
        {
            return tree[indx];//complete overlap or equal, return val
        }
        
        int mid = getMid(start, end);
        int left = query(2*indx,start, mid, l,r);
        int right = query(2*indx+1, mid+1,end, l, r);
        return left+right;
    }
    
        
    private void build(int[] a,int start, int end, int indx)
    {
       if(start==end)
        {
            tree[indx] = a[start];
            return;
        }
        int mid = start+(end-start)/2;
        build(a, start, mid, 2*indx);
        build(a, mid+1, end, 2*indx+1);
        tree[indx]=tree[2*indx]+tree[2*indx+1];
        return;
    }
    
    //create seive to check number is prime or not
    private void seive()
    {
        //prime = new boolean[num+1];
        Arrays.fill(isPrime, 1);
        isPrime[0]= isPrime[1] =0;
        for(int i=2;i*i<M;i++)
        {
            if(isPrime[i]==1)
            {
                for(int j=2*i;j<M;j+=i)
                {
                    isPrime[j]=0;
                }
            }
        }
    }
    
    private int getMid(int start, int end)
    {
        return (start+end)/2;
    }
}

/*************************************************** APPROACH ****************************************************************************************

- Convert question to range sum segment tree, but here we are storing wheather then number is prime or not, in leaf
- if the number is prime then store 1, in leaf else store 0 in leaf(if not prime)
- rest approach is same as range sum query

************************************** DESIGN *******************************************************

- main method:
	- READS input and does required call, for C = call update(as value is changed), A= call query for reading value betwn(C(i), D(i))
	- a[] = keeps 1=prime, 0=if non prime value(from input array A), checks if the current changed value is prime or not, update according to these 4 conditions
	- 4 important cases:(optional to handle... we can just update all kind of changes)
		- Case 1: If x and y both are primes. Count of primes in the subarray does not change so we just update array and donot modify the segment tree
		- Case 2: If x and y both are non primes ,Count of primes in the subarray does not change so we just update array and donot modify the segment tree
		- Case 3: If y is prime but x is non prime .Count of primes in the subarray decreases so we update array and add -1 to every  range, the index i which is  to be updated, is a part of in the segment tree.
		- Case 4: If y is non prime but x is prime. Count of primes in the subarray increases so we update array and add 1 to every range, the index i which is to be updated, is a part of in the segment tree.
	- Now if value A, call query pass a
	- If value is C, change value in a[] first then call the update query with the updated value.
	- pur all values in result arraylist and return;
*/