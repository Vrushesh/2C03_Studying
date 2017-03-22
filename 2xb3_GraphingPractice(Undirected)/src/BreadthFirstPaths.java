public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;	//mark source
		queue.enqueue(s);	//enqueue it
		while (!queue.isEmpty()){
			int v = queue.dequeue();	//get next vertex
			for(int w : G.adj(v)){	
				if(!marked[w]){		//if the vertex is not marked
					edgeTo[w] = v;	//save the last edge on the shortest path
					marked[w] = true;	//mark it as the path is known
					queue.enqueue(w);	//add it to queue
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)){
			return null;
		}
		
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
	
		path.push(s);
		return path;
	}
}
