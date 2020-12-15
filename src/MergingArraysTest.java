import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
class MergingArraysTest {

	/**
	 * test MergingArray method with normal array inputs
	 */
	@Test
	void testMergingArray() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
				MergingArrays.mergingArray(new int[] { 4, 3, 2, 1 }, new int[] { 8, 7, 6, 5 }));

		assertArrayEquals(new int[] { 100, 200, 300, 400, 500, 600, 700, 800 },
				MergingArrays.mergingArray(new int[] { 400, 300, 200, 100 }, new int[] { 800, 700, 600, 500 }));

		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1, 1 },
				MergingArrays.mergingArray(new int[] { 0, 0, 0, 0 }, new int[] { 0, 0, 1, 1 }));
	}

	@Test
	void testMergingArrayWithNegativeArrays() {
		assertArrayEquals(new int[] { -10, -9, -8, -7, -6, -5, -4, -3, -2, -1 },
				MergingArrays.mergingArray(new int[] { -1, -2, -3, -4, -5 }, new int[] { -6, -7, -8, -9, -10 }));

		assertArrayEquals(new int[] { -1000, -900, -899, -788, -677, -566, -455, -344, -233, -122 }, MergingArrays
				.mergingArray(new int[] { -122, -233, -344, -455, -566 }, new int[] { -677, -788, -899, -900, -1000 }));
	}

	/**
	 * test MergingArray method with big or small array inputs
	 */
	@Test
	void testMergingArrayWithBiggerOrSmallerArrays() {
		assertArrayEquals(new int[] {}, MergingArrays.mergingArray(new int[] {}, new int[] {}));
		assertArrayEquals(new int[] { 123, 245, 323, 432, 578, 608, 798, 878, 945, 1001, 1202, 4999, 5623, 9999 },
				MergingArrays.mergingArray(new int[] { 123, 245, 323, 432, 578, 608, 798 },
						new int[] { 878, 945, 1001, 1202, 4999, 5623, 9999 }));

	}

}
