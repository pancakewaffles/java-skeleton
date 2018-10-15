package answers;

import java.util.PriorityQueue;

public class Question6 {
	private static Node[] vertices;
	public static void main(String[] args) {
		System.out.println(shortestServerRoute(3,1, new int[][] { new int[] {0,7,4} , new int[] {7,0,2} , new int[] {4,2,0} } ));
	}
	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		// TODO Auto-generated method stub
		vertices = new Node[numServers];
		for(int i =0;i<vertices.length;i++) {
			vertices[i] = new Node();
			vertices[i].index = i;
			vertices[i].distance = Integer.MAX_VALUE;
		}
		vertices[0].distance = 0;
		PriorityQueue<Node> toexplore = new PriorityQueue<Node>();
		for(int i =0;i<vertices.length;i++) {
			toexplore.add(vertices[i]);
		}
		
		while(!toexplore.isEmpty()) {
			Node v = toexplore.poll();
			System.out.println("removed server: "+ v.index);
			for(int i = 0;i<numServers;i++) {
				if(v.index != i && times[v.index][i] >= 0) {
					vertices[i].distance = Math.min(v.distance + times[v.index][i], vertices[i].distance);
				}
				
			}
		}
		return vertices[targetServer].distance;
		
	}

}

class Node implements Comparable {
	public int index;
	public int distance;

	@Override
	public int compareTo(Object o) {
		Node n2 = (Node) o;
		if(distance < n2.distance) return -1;
		if(distance > n2.distance) return 1;
		return 0;
	}
}
