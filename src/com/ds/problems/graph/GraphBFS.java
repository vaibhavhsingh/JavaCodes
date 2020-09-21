package com.ds.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

	private int V;
	private LinkedList<Integer> adj[];
	
	public GraphBFS(int v) {
		this.V = v;
		adj = new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);
	}
	
	public void bfs(int s) {
		boolean visited[] = new boolean[this.V];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			Integer data = queue.poll();
			System.out.print(data + " ");
			
			LinkedList<Integer> list = adj[data];
			list.forEach(i -> {
				if(!visited[i]) {
					queue.add(i); 
					visited[i] = true;
				}
			});
		}
	}
	
	public static void main(String args[]) {
		GraphBFS graph = new GraphBFS(10);
		
		// Data setup is like that of a directed graph
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		graph.addEdge(8, 9);
		
		graph.bfs(1);
		
	}
}
