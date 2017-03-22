import java.util.Arrays;


public class Triplicates {

	public static void main(String[] args){
		String[] arr1 = {"me","you","I","6lack","drake"};
		String[] arr2 = {"me","6lack","drake","6lack","french"};
		String[] arr3 = {"me","hi","hello","drake","salut"};
		System.out.println(findTriplets(arr1,arr2,arr3));        
	}

	public static String findTriplets(String[] arr1, String[] arr2, String[] arr3){
		
		//Assumption: sort will take nlogn time
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);

		int trackA = 0;
		int trackB = 0;
		int trackC = 0;

		while(trackA < arr1.length & trackB < arr2.length & trackC < arr3.length){

			//if all three have the same "name"
			if(arr1[trackA] == arr2[trackB] && arr1[trackA] == arr3[trackC]){
				return arr1[trackA];
			}
			
			//if A's current "name" is lexographically smaller than B or C, move on to the next one
			//since they are sorted and no name in B or C will be as small
			if(arr1[trackA].compareTo(arr2[trackB]) < 0 || arr1[trackA].compareTo(arr3[trackC]) < 0){
				trackA++;
			}
			
			//like previous, if B's current "name" is smaller than A or C, move on to the next one
			if(arr2[trackB].compareTo(arr1[trackA]) < 0 || arr2[trackB].compareTo(arr3[trackC]) < 0){
				trackB++;            
			}

			//like previous, if C's current "name" is smaller than A or B, move on to the next one
			if(arr3[trackC].compareTo(arr1[trackA]) < 0 || arr3[trackC].compareTo(arr2[trackB]) < 0){
				trackC++;        
			}

		}
		return "No Triplets";
	}
}