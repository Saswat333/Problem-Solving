import java.util.*;

class SwapCollection{
	public static void main(String[] args){
		final ArrayList<Integer> a = new ArrayList<Integer>();
		a.add( -50);
		a.add(-41 );
		a.add(-40 );
		a.add(-19 );
		a.add(5 );
		a.add(21);
		a.add(28);
		final ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(-50);
		b.add(-21);
		b.add(-10);
		
		mymethod(a,b);
	}
	
	public static void mymethod(final ArrayList<Integer> a, final ArrayList<Integer>b){
		int p = a.size();
		int q = b.size();
		System.out.println("\nbefore swap");
		System.out.println("A:");
		for(int i: a)
			System.out.print(i+",");
		System.out.println("\nB");
		for(int i: b)
			System.out.print(i+",");
		
		if(p>q){
			mymethod(b,a);
		}
		/*System.out.println("After swap");
		System.out.println("A:");
		for(int i: a)
			System.out.print(i+",");
		System.out.println("B");
		for(int i: b)
			System.out.print(i+",");*/
		
	}
}