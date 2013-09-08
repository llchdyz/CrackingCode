package Graph;

import java.util.Arrays;
import java.util.Iterator;

import StackandQueue.Queue;
import Bag.Bag;

public class unDirectedGraph implements Iterable<Integer> {
	private int V;
	private Bag<Integer>[] adj;
	private int order = 1;
	graphIterator it = null;
	private int[] paths;
	
	@SuppressWarnings("unchecked")
	public unDirectedGraph(int v){
		this.V = v;
		adj =  (Bag<Integer>[]) new Bag[this.V];
		
		for (int i = 0; i < this.V; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public void setOrder(int o){
		this.order = o;
	}
	
	public int[] getIteratorPath(){
		if (it == null){
			System.out.println("Must use iterator first");
			return null;
		}
		paths = it.edgeTo;
		return paths;
	}
	@Override
	public Iterator<Integer> iterator() {
		it = new graphIterator();
		
		return it;
	}
	
	public class graphIterator implements Iterator<Integer>{
		private Queue<Integer> queue;
		private Iterator<Integer> it = null;
		private boolean[] visited;
		private int[] edgeTo;
		
		public graphIterator(){
			queue = new Queue<Integer>();
			visited = new boolean[V];
			edgeTo = new int[V];
			Arrays.fill(edgeTo, -1);
			int unvisited;
			
			while ((unvisited = this.hasUnVisited()) != -1){
				if (order == 1){
					
					dfs(unvisited);
					
				} else {
					bfs(unvisited);
				}
			}
			it = queue.iterator();
		}
		
		private int hasUnVisited(){
			for (int i = 0; i < V; i++){
				if (!visited[i]){
					System.out.println("Start Point is: " + i);
					return i;
				}
			}
			return -1;
		}
		
		private void dfs(int v){
			visit(v);

			for (int w : adj(v)){
				if (!visited[w]){
					edgeTo[w] = v;
					dfs(w);
				}
			}
		} 
		
		private void bfs(int v){
			Queue<Integer> q = new Queue<>();
			visit(v);
			q.enqueue(v);
			
			while (!q.isEmpty()){
				Integer vt = q.dequeue();

				for (int w : adj(vt)){
					if (!visited[w]){
						visit(w);
						edgeTo[w] = vt;
						q.enqueue(w);
					}
				}
			}
		}
		
		private void visit(int v){
			System.out.println("Visit " + v);
			queue.enqueue(v);
			visited[v] = true;
		}
		public int[] getPaths(){
			return edgeTo;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return it.hasNext();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return it.next();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args){
		unDirectedGraph graph = new unDirectedGraph(10);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 9);
		graph.addEdge(9, 3);
		graph.addEdge(3, 7);
		graph.addEdge(8, 7);
		graph.addEdge(1, 6);
		graph.addEdge(0, 5);
		
		Iterator<Integer> it =  graph.adj(1).iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		graph.setOrder(2);
		Iterator<Integer> itg = graph.iterator();
		
		while(itg.hasNext()){
			System.out.println(itg.next());
		}
		
		System.out.println("Path is: ");
		for (int i : graph.getIteratorPath()){
			System.out.println(i);
		}
	}
}
