/*
	Implementing a queue:
	Since Queue is an interface you need to instantiate a concrete implementation of the interface in order to use it. You can choose between the following Queue implementations in the Java Collections API:
	java.util.LinkedList (standard)
	java.util.PriorityQueue (PriorityQueue stores its elements internally according to their natural order (if they implement Comparable), or according to a Comparator passed to the PriorityQueue.)
	Generic Queue:
	By default you can put any Object into a Queue, but from Java 5, Java Generics makes it possible to limit the types of object you can insert into a Queue.
	Methods:
	add()- This method is used to add elements at the tail of queue. More specifically, at the last of linked-list if it is used, or according to the priority in case of priority queue implementation.
	peek()- This method is used to view the head of queue without removing it. It returns Null if the queue is empty.
	element()- This method is similar to peek(). It throws NoSuchElementException when the queue is empty.
	remove()- This method removes and returns the head of the queue. It throws NoSuchElementException when the queue is empty.
	poll()- This method removes and returns the head of the queue. It returns null if the queue is empty.
	size()- This method return the no. of elements in the queue.
	- Since, it is a subtype of Collections class, it inherits all the methods of it namely size(), isEmpty(), contains() etc.
*/

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample
{
	public static void main(String[] args)
	{
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<5;i++)
		{
			q.add(i);
		}
		
		System.out.println("Elements in queue "+q); //[0, 1, 2, 3, 4]
		
		int removeElem = q.remove();
		System.out.println();//0
		
		int peekVal = q.peek();
		System.out.println("Peek value: "+peekVal);//1
		
		int size = q.size(); 
		System.out.println("Size of queue-" + size);//4
	}
}






















