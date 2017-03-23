import java.util.ArrayList;

public class SequentialSearchST<Key, Value> {
	private Node first;

	private class Node{
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Value get(Key key){
		for (Node x = first; x != null; x = x.next){
			if (key.equals(x.key)){
				return x.val;
			}
		}
		return null;
	}

	public void put(Key key, Value val){
		for (Node x = first; x != null; x = x.next){
			if (key.equals(x.key)){
				x.val = val;
				return;
			}
		}

		first = new Node(key, val, first);
	}

	public int size(){
		int counter = 0;
		for (Node x = first; x != null; x = x.next){
			counter++;
		}
		return counter;
	}

	public Iterable<Key> keys(){
		ArrayList<Key> result = new ArrayList<Key>();
		for (Node x = first; x.next != null; x = x.next){
			result.add(x.key);
		}
		return result;
	}


//	public Iterable<Key> keys(Key lo, Key hi){
		//toImplement
//	}

	public void delete(Key key){
		if (first == null) return;
		
		for (Node x = first; x.next != null; x = x.next){
			if (x.next != null && key.equals(x.next.key)){
				Node toRemove = x.next;
				if (x.next.next != null){
					x.next = x.next.next;
				}else{
					x.next = null;
				}
				toRemove.next = null;
			}
		}
	}
}
