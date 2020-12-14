import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergingArraysTest {

	/** 
	 * test MergingArray method with normal array inputs 
	 */
	@Test
	void testMergingArray() {
		assertArrayEquals(new int[] { 1,2,3,4,5,6,7,8 },
				MergingArrays.mergingArray(new int[] { 4, 3, 2, 1 }, new int[] { 8, 7, 6, 5 }));

		assertArrayEquals(new int[] { 100, 200, 300, 400, 500, 600, 700, 800 },
				MergingArrays.mergingArray(new int[] { 400, 300, 200, 100 }, new int[] { 800, 700, 600, 500 }));

		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1, 1 },
				MergingArrays.mergingArray(new int[] { 0, 0, 0, 0 }, new int[] { 0, 0, 1, 1 }));
	}

}
