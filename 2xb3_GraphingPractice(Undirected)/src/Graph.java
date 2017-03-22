public class Graph {
	
	private int E;
	private int V;
	private Bag<Integer>[] adj;
	
	public Graph(int V){
		this.V = V;
		this.E = 0;
		this.adj = (Bag<Integer>[]) new Bag[V]; //Create array of lists
		
		//initialize all lists to empty
		for (int v = 0; v < V; v++){  
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Graph(In in){
		this(in.readInt()); //Read V and construct graph
		int E = in.readInt(); //Read E
		
		for (int i = 0; i < E; i++){
			int v = in.readInt();	//read a vertex
			int w = in.readInt(); 	//read another vertex
			addEdge(v,w);	//add edge connecting the two vertices
		}
	}
	
	public int V(){
		return this.V;
	}
	
	public int E(){
		return this.E;
	}
	
	public void addEdge(int v, int w){
		//add each vertex to the opposites list
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public static int degree(Graph G,int v){
		int degree = 0;
		//counts how many edges are connected to vertex v
		for (int w : G.adj(v)){
			degree++;
		}
		return degree;
	}
	
	public static int maxDegree(Graph G,int v){
		int max = 0;
		//go through each vertex's degree and find the max
		for (int i = 0; i < G.V; i++){
			if (degree(G,i) > max){
				max = degree(G,i);
			}
		}
		return max;
	}
	
	public static int avgDegree(Graph G){
		//calculated based off theory 
		return 2*G.E()/G.V();
	}
	
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for (int v = 0; v < G.V(); v++){
			for(int w : G.adj(v)){
				if (v == w){
					count++;
				}
			}
		}
		return count/2; //each edge gets counted twice (for)
	}
	
	public String toString(){
		String s = V + " vertices" + E + " edges\n";
		for (int v = 0; v < V; v++){
			s += v + ": ";
			for (int w : this.adj(v)){
				s += w + " ";
			}
		}
		return s;
	}
}
