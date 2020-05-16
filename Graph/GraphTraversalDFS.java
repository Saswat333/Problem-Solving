/*
DFS - geeksforgeeks algo......
*/

import java.util.*;
import java.io.*;

class GraphTraversalDFS{
	private int verticesCount; //nnumber of verticesCount
	
	//Array  of lists for Adjacency List Representation 
	//2D
	private LinkedList<Integer> adj[];
	
	//constructr
	Graph(int v){
		this.verticesCount = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;++i)
			adj[i] = new LinkedList();
	}
	
	public static void main(String[] args){
		
	}
}