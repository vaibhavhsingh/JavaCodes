package com.ds.problems.arrays.twodim;

import java.util.Stack;

public class DFSInMatrix {

	public void dfs(int arr[][]) {
		int h = arr.length;
		if(h==0) {
			return;
		}
		
		int l = arr[0].length;
		boolean isVisited[][] = new boolean[h][l];
		Stack<Point> stack = new Stack<>();
		stack.push(new Point(0, 0));
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			
			if(p.x < 0  || p.y < 0 || p.x >= h || p.y >= l || isVisited[p.x][p.y]) {
				continue;
			}
			
			System.out.print(arr[p.x][p.y] + " ");
			
			isVisited[p.x][p.y] = true;
			
			stack.push(new Point(p.x, p.y-1));
			stack.push(new Point(p.x, p.y+1));
			stack.push(new Point(p.x-1, p.y));
			stack.push(new Point(p.x+1, p.y));
		}
	}
	
	public static void main(String args[]) {
		int [][] grid = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
		};
		DFSInMatrix d = new DFSInMatrix();
		d.dfs(grid);
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}