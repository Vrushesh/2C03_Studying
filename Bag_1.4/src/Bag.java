import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	Node first = null;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator();
	}	
	
	private class BagIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
