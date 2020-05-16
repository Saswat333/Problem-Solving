/***************************************************************************
Heap construction
**********************************************************************/
import java.util.ArrayList;
class Program
{
	static class MinHeap()
	{
		ArrayList<Integer> heap = new ArrayList<Integer>();
		//minheap constructor, everytime new node is inserted it automatically calls buildHeap on it to insert it in proper location
		public MinHeap(ArrayList<Integer> array)
		{
			heap = buildHeap(array);
			
		}
		
		public ArrayList<Integer> buildHeap(ArrayList<Integer> array)
		{
			
		}
		
		//when shifting down we have 2 child nodes and we have to give option which child node to move
		//so we have endIndx too
		public void shiftDown(int curIndx, int endIndx, ArrayList<Integer> heap)
		{
			int childOneIdx = (curIdx*2)+1;
			//if there is no child at all we dont find the 2nd child too, if one one child then we do null check on 2nd child
			while(childOneIdx<=endIndx)
			{
				int childTwoIdx = (curIdx*2)+2 <= endIndx ? (curIdx*2)+2 : -1;
			}
		}
		
		//when shifting up we have only one parent which can be calculated from curIndxs, So pass only curIndx
		public void shiftUp(int curIndx, ArrayList<Integer> heap)
		{
			int parentIndx = Math.floor((curIndx-1)/2);
			while(curIndx>0 && heap.get(curIndx)<heap.get(parentIndx))
			{//if curIdx(leaf) value less than parentIndx value then, swap and update curIdx and parentIndx
				swap(curIdx, parentIndx, heap);
				curIdx = parentIndx;
				parentIndx = Math.floor((curIdx-1)/2);
			}	
		}
		
		public int peek()
		{
			return heap.get(0);
		}
		
		public int remove()
		{
			//swap first value and last value(remove last val),and shift down the curent first value
			swap(0,heap.size()-1, heap);
			int valToReturn = heap.get(heap.size()-1);
			heap.remove(heap.size()-1);
			shiftDown(0,heap.size()-1,heap); //starting from root element keep swapping
			return valToReturn;
		}
		
		public void insert(int value)
		{
			heap.add(value);
			heap.shiftUp(heap.size()-1,heap)
		}
		
		public void swap(int i, int j, ArrayList<Integer>heap)
		{
			Integer temp = heap.get(j);
			heap.set(j.heap.get(i));
			heap.set(i,temp);
		}
	}
}
