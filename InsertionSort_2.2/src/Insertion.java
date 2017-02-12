
public class Insertion {
	
	public static void sort(Comparable[] a){
		int n = a.length;
		for (int i = 1; i < n; i++){
			for (int j = i; j > 0 && less(a[j],a[j-1]);j--){
				exch(a, j, j-1);
			}
		}
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 1; i < a.length; i++){
			if (less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		String[] a = {"S","O","R","T","E","X","A","M","P","L","E"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
