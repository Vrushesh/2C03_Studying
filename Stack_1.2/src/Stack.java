import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	
	private  Node first;
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
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		n++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove(){}
	}

	public static void main(String[] args){
		
		Stack<String> s = new Stack<String>();
		
		s.push("Vrushesh.");
		s.push("is");
		s.push("name");
		s.push("my");
		s.push("Hi,");
		
		for (String i: s){
			System.out.print(i + " ");
		}
		System.out.println("");
		
		s.pop();
		s.pop();
		s.pop();
		
		for (String i: s){
			System.out.print(i + " ");
		}
	}
}
