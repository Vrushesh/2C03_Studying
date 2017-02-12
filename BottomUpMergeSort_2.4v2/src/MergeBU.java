
public class MergeBU{

	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		int n = a.length;
		aux = new Comparable[n];
		for (int len = 1; len < n;len *= 2){
			for(int lo = 0; lo < n - len; lo += len+len){
				merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n-1));
			}
		}
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

