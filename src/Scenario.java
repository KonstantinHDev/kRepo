

public class Scenario {

	// Simple scenario
	public static void main(String[] args) {
		
		// print start and resulting list
		boolean print = true;
		// use task value from task
		boolean taskValues = true;
		
		// count of intervals
		int intervallCount = 10;
		// random generated number from 0 to intervallMaximum ( example 0 - 50 )
		int intervallMaximum = 100;
		// random generated number range (example 0 - 15)
		int intervallRange = 15;
		
		
		System.out.println("Started");
		MergeTask task = new MergeTask();
		
		long start = System.currentTimeMillis();
		
		if(taskValues) {
			task.insert(new int[]{ 4,8 });
			task.insert(new int[]{ 14,23 });
			task.insert(new int[] {26, 45});
			task.insert(new int[]{ 2,19 });
			task.insert(new int[]{ 25,30 });
		}else {
			randomizeList(task, intervallCount , intervallMaximum , intervallRange );
			System.out.println("Zeit zur random initialisierung: " + (System.currentTimeMillis() - start));
		}		
		
		System.out.println("Anzahl der endelemente: " + task.getInputList().size());
		
		if(print){
			task.print();
		}
		
		long startMerge = System.currentTimeMillis();
		task.mergeQuick();

		if(print){
			task.print();
		}
		
		System.out.println("Zeit zum mergen: " + (System.currentTimeMillis() - startMerge));
		System.out.println("Anzahl der resultierenden Intervalle: " + task.getInputList().size());
		System.out.println("Finished");		
	}
	
	// just for testing and scenario build option
	public static void randomizeList(MergeTask task, int listCount, int distanceMax,  int listRange) {
		for(int i = 0; i < listCount; i++) {
	 		int[] add = new int[2];
			int min = generateRandomInt(0, distanceMax);
			int max = generateRandomInt(min, min + listRange);
			add[0] = min;
			add[1] = max;
			task.insert(add);
		}
	}
	
	// just for testing and scenario build option
	public static int generateRandomInt(int min, int max) {
		return (int)(Math.random() * (max - min) ) + min;
	}
}
