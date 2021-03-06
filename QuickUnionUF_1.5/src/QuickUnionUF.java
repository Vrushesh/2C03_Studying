
public class QuickUnionUF {

	private int[] id;
	private int count;
	
	public QuickUnionUF(int n){
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++){
			id[i] = i;
		}
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		while (p != id[p]){
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j){
			return ;
		}
		
		id [i] = j;
		
		count --;
	}
	
	public static void main(String[] args){
		
	} 
}
