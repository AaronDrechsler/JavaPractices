import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumOfArrayTest {

	/** 
	 * test SumOfArray method with normal array inputs 
	 */
	@Test
	void testSumOfArray() {
		assertEquals(10, SumOfArray.sumOfArray(new int[] { 1, 2, 3, 4 }));
		assertEquals(2, SumOfArray.sumOfArray(new int[] { 1, 2, 3, -4 }));
		assertEquals(50, SumOfArray.sumOfArray(new int[] { 11, 12, 13, 14 }));
	}
	/** 
	 * test SumOfArray method with big or small array inputs 
	 */
	@Test
	void testSumWithBiggerOrSmallerArrays() {
		assertEquals(3193, SumOfArray.sumOfArray(new int[] { 120, 200, 435, 342, 786, 321, 989 }));
		assertEquals(0, SumOfArray.sumOfArray(new int[] {}));
	}

	/**
	 * test SumOfArray method with negative array inputs 
	 */
	@Test
	void testSumOfArrayWithNegativeArrays() {
		assertEquals(-50, SumOfArray.sumOfArray(new int[] { -11, -12, -13, -14 }));
		assertEquals(-10, SumOfArray.sumOfArray(new int[] { -1, -2, -3, -4 }));
	}

}
