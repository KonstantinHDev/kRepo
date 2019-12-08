

public class Scenario {

	// Simple scenario
	public static void main(String[] args) {
		System.out.println("Started");
		MergeTask task = new MergeTask();

		task.insert(new int[]{ 4,8 });
		task.insert(new int[]{ 14,23 });
		task.insert(new int[] {26, 45});
		task.insert(new int[]{ 2,19 });
		task.insert(new int[]{ 25,30 });
		task.print();

		task.merge();
		task.print();
		System.out.println("Finished");		
	}
}
