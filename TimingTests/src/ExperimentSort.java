import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class ExperimentSort {

	public static int[] inputs = {10,100,1000,10000,100000,1000000,10000000};
	public static double[] times;
	
	public static void main(String[] args){
	
		times = new double[7];
		
		Random random = new Random();
		/*for (int j = 0; j < inputs.length-2;j++){
			Integer[] array = new Integer[inputs[j]];
			for(int i = 0;i < inputs[j];i++){
				Integer newNumber = new Integer(random.nextInt(10000));
				array[i] = newNumber;
			}
			Stopwatch stopwatch = new Stopwatch ();
			double startTime= stopwatch.elapsedTime();
			SelectionSort.sort(array);
			double endTime = stopwatch.elapsedTime();
			times[j] = endTime - startTime;
			System.out.println("Total execution time: " + times[j]);
		}
		
		StdDraw.setXscale(-1000,100500);
		StdDraw.setYscale(-0.20, 15);
		StdDraw.line(-100, 0, 100500, 0);
		StdDraw.line(0, -1, 0, 20);
		
		for (int i = 0; i < inputs.length - 1;i++){
			StdDraw.line(inputs[i], times[i], inputs[i+1],times[i + 1]);
		}*/
		
		Integer[] array1 = new Integer[100000];
		Integer[] array2 = new Integer[100000];
		for(int i = 0; i < array1.length ; i++){
			array1[i] = 100000 - i;
			array2[i] = 100000 - i;
		}
		
	
		Stopwatch stopwatch = new Stopwatch ();
		double startTime= stopwatch.elapsedTime();
		SelectionSort.sort(array1);
		double endTime = stopwatch.elapsedTime();
		System.out.println("Total execution time for SelectionSott: " + (endTime - startTime));
		

		Stopwatch stopwatch2 = new Stopwatch ();
		double startTime2= stopwatch2.elapsedTime();
		InsertionSort.sort(array2);
		double endTime2 = stopwatch2.elapsedTime();
		System.out.println("Total execution time for InsertionSort: " + (endTime2 - startTime2));
		/*
		Integer[] array2 = new Integer[10000];
		for(int i = 0; i < array2.length ; i++){
			array2[i] = 10000 - i;
		}
		
		Stopwatch stopwatch2 = new Stopwatch ();
		double startTime2 = stopwatch.elapsedTime();
		InsertionSort.sort(array2);
		double endTime2 = stopwatch.elapsedTime();
		System.out.println("Total execution time: " + (endTime2 - startTime2));*/
	}
}
