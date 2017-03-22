

public class BubbleSort {
	public static boolean  less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void sort(Comparable[] num){
		int j;
		boolean sorted = true;
		while(sorted){
			sorted = false;
			for(j = 0; j < num.length-1; j++){
				if (less(num[j+1], num[j])){
					exch(num, j, j+1);
					sorted = true;
				}
			}
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for( int i = 1; i < a.length; i++){
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
}
