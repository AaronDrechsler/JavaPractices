import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AverageOfArraysTest {
	/** 
	 * test AverageOfArray method with normal array inputs 
	 */
	@Test
	void testAverageOfArray() {
		assertTrue(2.5d == AverageOfArrays.averageOfArray(new int[] { 1, 4, 3, 2 }));
		assertTrue(0.5d == AverageOfArrays.averageOfArray(new int[] { 1, 0, 1, 0 }));
		assertTrue(10d == AverageOfArrays.averageOfArray(new int[] { 10, 10, 10, 10 }));
	}
	
	/** 
	 * test AverageOfArray method with negative array inputs 
	 */
	@Test
	void testAverageArrayWithNegativeArrays() {
		assertTrue(-0.5 == AverageOfArrays.averageOfArray(new int[] { -1, -0, -1, -0 }));
		assertTrue(-10 == AverageOfArrays.averageOfArray(new int[] { -10, -10, -10, -10 }));
	}
	
	/** 
	 * test AverageArray method with big or small array inputs 
	 */
	@Test
	void testAverageArrayWithBiggerOrSmallerArrays() {
		double maxValue = Double.NaN;
		assertTrue(415 == AverageOfArrays.averageOfArray(new int[] { 12, 20, 435, 342, 786, 321, 989 }));
		assertTrue(maxValue == AverageOfArrays.averageOfArray(new int[] {}));
	}

}
