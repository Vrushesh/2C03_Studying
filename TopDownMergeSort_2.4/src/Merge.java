
public class Merge {

	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo){
			return;
		}
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
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
	
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++){
			if (i > mid){
				a[k] = aux[j++];
			}else if(j > hi){
				a[k] = aux[i++];
			}else if(less(aux[j],aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
		}
	}
	
	public static void main(String[] args){
		String[] a = {"B","E","G","N","U","A","K"};
		sort(a);
		show(a);
	}
}
