import java.util.Arrays;

public class BinarySearch {
	
	public static int indexOf(int[] a, int key){
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi){
			int mid = lo + (hi - lo)/2; 
			if (key < a[mid]){
				hi =  mid - 1;
			}else if (key > a[mid]){
				lo = mid + 1;
			}else{ 
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] a = {1,7,19,24,652,59846,6464123};
		System.out.println(indexOf(a, 1));
	}
}
