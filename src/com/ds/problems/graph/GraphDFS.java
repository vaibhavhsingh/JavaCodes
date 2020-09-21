package com.ds.problems.graph;

import java.util.LinkedList;

public class GraphDFS {

	private int V;
	private LinkedList<Integer> adj[];
	
	public GraphDFS(int v) {
		this.V = v;
		adj = new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);
	}
	
	public void dfs(int s, boolean []visited) {
		visited[s] = true;
		
		System.out.print(s + " ");
		LinkedList<Integer> list = adj[s];
		
		list.forEach(i -> {
			if(!visited[i]) {
				dfs(i, visited);
			}
		});
	}
	
	public void dfsUtil(int s) {
		boolean visited[] = new boolean[this.V];
		dfs(s, visited);
	}
	
	public static void main(String args[]) {
		GraphDFS graph = new GraphDFS(4);
		
		// Data setup is like that of a directed graph
		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
		
		graph.dfsUtil(2);
		
	}
}
