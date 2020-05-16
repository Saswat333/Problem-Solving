class Segregate
{
	void segregate(int arr[], int size)
	{
		int left =0 , right =size-1;
		
		while(left < right)
		{
			if(arr[left] == 0 )
				left++;
			
			if(arr[right] == 1)
				right--;
			
			else
			{
				arr[left] =0 ;
				arr[right] =1;
				left++;
				right--;
			}
		}
	}
	void printfun(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+",");
		}
	}
	
	public static void main(String[] args)
	{
		Segregate seg = new Segregate();
		int arr[] = new int[]{0, 1, 0, 1, 1, 1};
		int arr_size = arr.length; 
        seg.segregate(arr, arr_size);
		seg.printfun(arr);
  
	}
}