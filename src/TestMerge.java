import static org.junit.Assert.*;

import org.junit.Test;

public class TestMerge {

	private MergeTask mt;

	public TestMerge() {
	}

	@Test
	public void testGetInputList() {
		mt = new MergeTask();
		assertTrue(mt.getInputList().size() == 0);
		assertTrue(mt.insert(new int[] { 2, 3 }));
		assertTrue(mt.getInputList().size() == 1);
	}

	@Test
	public void testInsert() {
		mt = new MergeTask();
		// possible insertions
		assertTrue(mt.insert(new int[] { 2, 3 }));
		assertTrue(mt.insert(new int[] { 0, 0 }));

		// not allowed
		assertFalse(mt.insert(new int[] { 3, 2 }));
		assertFalse(mt.insert(new int[] { 2, 3, 4 }));
		assertFalse(mt.insert(new int[] { 0 }));
		assertFalse(mt.insert(new int[] {}));
		assertFalse(mt.insert(null));
	}

	@Test
	public void testContainsValue() {
		mt = new MergeTask();
		assertTrue(mt.containsValue(1, 0, 2));
		assertFalse(mt.containsValue(1, 2, 4));
	}

	@Test
	public void testIsSubset() {
		mt = new MergeTask();
		int[] arr1 = new int[] { 26, 45 };
		int[] arr2 = new int[] { 35, 47 };
		int[] arr3 = new int[] { 10, 18 };
		assertTrue(mt.isSubset(arr1, arr2));
		assertFalse(mt.isSubset(arr1, arr3));
	}

	@Test
	public void testMerge() {
		mt = new MergeTask();

		// showcase
		// touple should be merged
		mt.insert(new int[] { 26, 45 });
		mt.insert(new int[] { 24, 30 });

		// second touple shouldn´t be merged
		mt.insert(new int[] { 1, 15 });
		
		assertTrue(mt.mergeQuick());
		assertTrue(mt.getInputList().size() == 2);
		assertTrue(mt.getInputList().get(0)[0] == 24);
		assertTrue(mt.getInputList().get(0)[1] == 45);
		
		mt = new MergeTask();
		assertFalse(mt.mergeQuick());
	}	
}
