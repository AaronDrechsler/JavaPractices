import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class JavaPracticesTest {

	@Test
	/** test SumOfArray method with normal array inputs */
	void testSumOfArray() {
		assertEquals(10, JavaPractices.sumOfArray(new int[] { 1, 2, 3, 4 }));
		assertEquals(2, JavaPractices.sumOfArray(new int[] { 1, 2, 3, -4 }));
		assertEquals(50, JavaPractices.sumOfArray(new int[] { 11, 12, 13, 14 }));
	}

	@Test
	/** test SumOfArray method with big or small array inputs */
	void testSumWithBiggerOrSmallerArrays() {
		assertEquals(3193, JavaPractices.sumOfArray(new int[] { 120, 200, 435, 342, 786, 321, 989 }));
		assertEquals(0, JavaPractices.sumOfArray(new int[] {}));
	}

	@Test
	/** test SumOfArray method with negative array inputs */
	void testSumOfArrayWithNegativeArrays() {
		assertEquals(-50, JavaPractices.sumOfArray(new int[] { -11, -12, -13, -14 }));
		assertEquals(-10, JavaPractices.sumOfArray(new int[] { -1, -2, -3, -4 }));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	/** test AverageOfArray method with normal array inputs */
	void testAverageOfArray() {
		assertEquals(2.5, JavaPractices.averageOfArray(new int[] { 1, 4, 3, 2 }));
		assertEquals(0.5, JavaPractices.averageOfArray(new int[] { 1, 0, 1, 0 }));
		assertEquals(10, JavaPractices.averageOfArray(new int[] { 10, 10, 10, 10 }));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	/** test AverageOfArray method with negative array inputs */
	void testAverageArrayWithNegativeArrays() {
		assertEquals(-0.5, JavaPractices.averageOfArray(new int[] { -1, -0, -1, -0 }));
		assertEquals(-10, JavaPractices.averageOfArray(new int[] { -10, -10, -10, -10 }));
	}

	@SuppressWarnings("deprecation")
	@Test
	/** test AverageArray method with big or small array inputs */
	void testAverageArrayWithBiggerOrSmallerArrays() {
		double maxValue = Double.NaN;
		assertEquals(415, JavaPractices.averageOfArray(new int[] { 12, 20, 435, 342, 786, 321, 989 }));
		assertEquals(maxValue, JavaPractices.averageOfArray(new int[] {}));
	}

	@Test
	/** test SortAscending method with normal array inputs */
	void testSortAscending() {
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, JavaPractices.sortAscending(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 0, 0, 1, 1 }, JavaPractices.sortAscending(new int[] { 1, 1, 0, 0 }));
		assertArrayEquals(new int[] { 10, 20, 30, 40 }, JavaPractices.sortAscending(new int[] { 40, 30, 20, 10 }));
	}

	@Test
	/** test SortAscending method with negative array inputs */
	void testSortAscendingWithNegativeArrays() {
		assertArrayEquals(new int[] { -40, -30, -20, -10 }, JavaPractices.sortAscending(new int[] { -40, -30, -20, -10 }));
		assertArrayEquals(new int[] { -4, -3, -2, -1 }, JavaPractices.sortAscending(new int[] { -4, -3, -2, -1 }));
	}

	@Test
	/** test SortAscending method with big or small array inputs */
	void testSortAscendingWithBiggerOrSmallerArrays() {
		assertArrayEquals(new int[] {}, JavaPractices.sortAscending(new int[] {}));
		assertArrayEquals(new int[] { 123, 345, 456, 667, 777, 884, 885, 889, 2342, 5677 },
				JavaPractices.sortAscending(new int[] { 345, 123, 667, 456, 777, 884, 889, 885, 5677, 2342 }));
	}

	@Test
	/** test MergingArray method with normal array inputs */
	void testMergingArray() {
		assertArrayEquals(new int[] { 1,2,3,4,5,6,7,8 },
				JavaPractices.mergingArray(new int[] { 4, 3, 2, 1 }, new int[] { 8, 7, 6, 5 }));

		assertArrayEquals(new int[] { 100, 200, 300, 400, 500, 600, 700, 800 },
				JavaPractices.mergingArray(new int[] { 400, 300, 200, 100 }, new int[] { 800, 700, 600, 500 }));

		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1, 1 },
				JavaPractices.mergingArray(new int[] { 0, 0, 0, 0 }, new int[] { 0, 0, 1, 1 }));
	}

	@Test
	/** test MergingArray method with negative array inputs */
	void testMergingArrayWithNegativeArrays() {
		assertArrayEquals(new int[] { -10, -9, -8, -7, -6, -5, -4, -3, -2, -1 },
				JavaPractices.mergingArray(new int[] { -1, -2, -3, -4, -5 }, new int[] { -6, -7, -8, -9, -10 }));

		assertArrayEquals(new int[] { -1000, -900, -899, -788, -677, -566, -455,-344, -233, -122 }, JavaPractices
				.mergingArray(new int[] { -122, -233, -344, -455, -566 }, new int[] { -677, -788, -899, -900, -1000 }));
	}

	@Test
	/** test MergingArray method with big or small array inputs */
	void testMergingArrayWithBiggerOrSmallerArrays() {
		assertArrayEquals(new int[] {}, JavaPractices.mergingArray(new int[] {}, new int[] {}));
		assertArrayEquals(new int[] { 123, 245, 323, 432, 578, 608, 798, 878, 945, 1001, 1202, 4999, 5623, 9999 },
				JavaPractices.mergingArray(new int[] { 123, 245, 323, 432, 578, 608, 798 },
						new int[] { 878, 945, 1001, 1202, 4999, 5623, 9999 }));
		
	}

}
