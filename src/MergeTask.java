import java.util.ArrayList;

/**
 * 
 * @author Konstantin Hermann
 * MergeTask handles a list of input intervals defined in an int array containing a start and an end value.
 * Merge possibility to fusion all subsets to a resulting list.
 */
public class MergeTask {
	
	private ArrayList<int[]> input;
	
	/**
	 * Constructor creating a empty input list
	 */
	public MergeTask() {
		input = new ArrayList<int[]>();
	}
	
	/**
	 * Validates if the insertion is successful
	 * @param insertion contains min and max value of array length 2
	 * @return True if validated and added to the input list.
	 */
	public boolean insert(int[] insertion) {
		boolean result = true;
		result = validateInput(insertion);
		
		if(result) {
			result = input.add(insertion);
		}else {
			// error handling. decide what is possible or not and how to carry on.
			// For me just don´t add the insertion
		}
		
		return result;
	}
	
	/**
	 * Validates requirement for merge input
	 * @param insertion
	 * @return validation successful if insertion has only 2 values and the first value is lower/equal than the second value.
	 */
	public boolean validateInput(int[] insertion) {
		/** uglify for short code version
		if(insertion.length != 2) {
			return false;
		}
		return insertion[0] <= insertion[1]);
		*/
		
		boolean result = false;
		
		if (insertion == null ) {
			// close if clause
		}
		// requirement of 2 parameter
		else if(insertion.length == 2) {
			// first have to be lower/equal
			if(insertion[0] <= insertion[1]) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * Merges all values with a subset off all intervals inside the input list.
	 * Replaces the current input values which are processed in an stacker.
	 * Input list will be overwritten for the merged list.
	 */
	public boolean merge(){
		if(input.size() < 2 ) {
			return false;
		}
		
		// Merge console output
		System.out.println("-------------");
		System.out.println("merge");
		System.out.println("-------------");
		
		ArrayList<int[]> output = new ArrayList<int[]>();		
		// run through input untill list is empty

		
		// if list is checked, redo
		while(input.size() > 0) {
			for(int i = 1; i < input.size() ; i ++) {
				
				// if subset detected, merge values, remove from current list and		 
				// rewrite current interval with a new start/end interval
				if(isSubset(input.get(0), input.get(i))) {
					input.set(0, mergeLists(input.get(0), input.get(i)));
					input.remove(i);
					
					// cause a interval removed, decrease iterator
					i--;
				}
			}
			// list finished, replace checked input value into a output list
			output.add(input.get(0));
			input.remove(0);
		}
		// replaced merged list with input list
		input = output;
		return true;
	}
	
	/**
	 * Merges two intervals
	 * @param value1 first interval
	 * @param value2 second interval
	 * @return merged interval with the smallest interval start and the highest interval end
	 */
	private int[] mergeLists(int[] value1, int[] value2) {
		int minVal1= value1[0];
		int maxVal1= value1[1];
		int minVal2= value2[0];
		int maxVal2= value2[1];
		return new int[]{ Math.min(minVal1, minVal2), Math.max(maxVal1, maxVal2) };
	}
	
	/**
	 * Checks two intervals are a subset
	 * @param value1 first interval to check
	 * @param value2 second interval to check
	 * @return Returns if a subset is established
	 */
	public boolean isSubset(int[] value1, int[] value2 ) {
		/** uglify for short code version
		return (
			containsValue(value2[0] , value1[0], value1[1]) ||
			containsValue(value2[1] , value1[0], value1[1]) ||
			containsValue(value1[0] , value2[0], value2[1]) ||
			containsValue(value1[1] , value2[0], value2[1) 
		)
		*/
		
		// only for readability ( not necessary, could be used direct by array call )
		// else uglify version for code reduction could be used		
		int minVal1= value1[0];
		int maxVal1= value1[1];
		int minVal2= value2[0];
		int maxVal2= value2[1];
		
		// value between interval returns true
		// check min and max value from the first interval for the second interval and otherwise
		if(  containsValue(minVal2 , minVal1, maxVal1) ) {
			return true;
		}
		else if( containsValue(maxVal2 , minVal1, maxVal1 ) ) {
			return true;
		}
		else if( containsValue(minVal1 , minVal2, maxVal2 ) ){
			return true;
		}
		else if( containsValue(maxVal1 , minVal2, maxVal2 ) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks of param value is between start interval and end interval
	 * @param value to check
	 * @param from start interval
	 * @param to end interval
	 * @return True if interval contains value
	 */
	public boolean containsValue(int value, int from, int to) {
		return (value >= from && value <= to);
	}
	
	/**
	 * @return the current ArrayList of intervals defined as int[]
	 */
	public ArrayList<int[]> getInputList(){
		return input;
	}
	
	/**
	 * Symple console output of the current input list
	 */
	public void print() {
		for(int[] interval : input) {
			System.out.println("Intervall min: " + interval[0] + ", Interval max: " + interval[1]);
		}
	}
}
