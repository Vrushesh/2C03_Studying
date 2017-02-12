
public class Selection {
	
	public static void sort(Comparable[] a){
		int n = a.length;
		for (int i = 0; i < n; i++){
			int min = i;
			for (int j = i + 1; j < n; j++){
				if (less(a[j],a[min])){
					min = j;
				}
			}
			exch(a, i, min);
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
		String[] a = {"B","E","G","N","U","A","K"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
