
public class Quick {

	public static void sort(Comparable[] a){
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo){
			return ;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j -1);
		sort(a, j+1, hi);
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
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true){
			while (less(a[++i],v)){
				if (i == hi){
					break;
				}
			}
			while(less(v,a[--j])){
				if (j == lo){
					break;
				}
			}
			if (i >= j){
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	public static void main(String[] args){
		String[] a = {"B","E","G","N","U","A","K"};
		sort(a);
		show(a);
	}
}
