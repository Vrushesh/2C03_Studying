import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node first = null;
	private Node last = null;
	private int n;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return n;
	}
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		n++;
	}
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		n--;
		if(isEmpty()){
			last = null;
		}
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseQueueIterator();
	}
	
	private class ReverseQueueIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args){
		Queue<String> q = new Queue<String>();
		
		q.enqueue("This");
		q.enqueue("is");
		q.enqueue("a");
		q.enqueue("FIFO");
		q.enqueue("Queue");
		
		for (String i: q){
			System.out.print(i + " ");
		}
		System.out.println("");
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		for (String i: q){
			System.out.print(i + " ");
		}
	}
}
