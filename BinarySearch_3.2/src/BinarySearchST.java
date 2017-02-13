
public class BinarySearchST <Key extends Comparable<Key>, Value>{
	
	//HALF DONE
	private Key[] keys; 
	private Value[] vals;
	private int n;
	
	public BinarySearchST(int cap){
		keys = (Key[]) new Comparable[cap];
		vals = (Value[]) new Object[cap];
	}
	
	public int size(){
		return n;
	}
	
	public Value get(Key key){
		if (isEmpty()){ 
			return null;
		}
		int i = rank(key);
		if(i < n && keys[i].compareTo(key) == 0){
			return vals[i];
		}else{
			return null;
		}
	}
	
	public void put(Key key, Value val){
		int i = rank(key);
		if(i < n && keys[i].compareTo(key) == 0){
			vals[i] = val;
			return;
		}
		for (int j = n; j > i; j--){
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;
	}

	private boolean isEmpty() {
		return n == 0;
	}

	private int rank(Key key) {
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi){
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			}else if (cmp > 0){	
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return lo;
	}
	
	public Key min(){
		return keys[0];
	}
	
	public Key max(){
		return keys[n - 1];
	}
	
	public Key select(int k){
		return keys[k];
	}
	
	public Key ceiling(Key key){
		int i = rank(key);
		return keys[i];
	}
	
	public Key floor(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

	 public void delete(Key key) {
	        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
	        if (isEmpty()) return;

	        // compute rank
	        int i = rank(key);

	        // key not in table
	        if (i == n || keys[i].compareTo(key) != 0) {
	            return;
	        }

	        for (int j = i; j < n-1; j++)  {
	            keys[j] = keys[j+1];
	            vals[j] = vals[j+1];
	        }

	        n--;
	        keys[n] = null;  // to avoid loitering
	        vals[n] = null;
	    } 
	
	
	//import queue
	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> queue = new Queue<Key>();
		for (int i = rank(lo); i < rank(hi); i++){
			queue.enqueue(keys[i]);
		}
		if (contains(hi)){
			queue.enqueue(keys[rank(hi)]);
		}
		return queue;
	}
}
