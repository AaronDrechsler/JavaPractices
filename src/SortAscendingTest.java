import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortAscendingTest {

	/** 
	 * test SortAscending method with normal array inputs 
	 */
	@Test
	void testSortAscending() {
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, SortAscending.sortAscending(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 0, 0, 1, 1 }, SortAscending.sortAscending(new int[] { 1, 1, 0, 0 }));
		assertArrayEquals(new int[] { 10, 20, 30, 40 }, SortAscending.sortAscending(new int[] { 40, 30, 20, 10 }));
	}
	
	/** 
	 * test SortAscending method with negative array inputs 
	 */
	@Test
	void testSortAscendingWithNegativeArrays() {
		assertArrayEquals(new int[] { -40, -30, -20, -10 }, SortAscending.sortAscending(new int[] { -40, -30, -20, -10 }));
		assertArrayEquals(new int[] { -4, -3, -2, -1 }, SortAscending.sortAscending(new int[] { -4, -3, -2, -1 }));
	}

	/** 
	 * test SortAscending method with big or small array inputs 
	 */
	@Test
	void testSortAscendingWithBiggerOrSmallerArrays() {
		assertArrayEquals(new int[] {}, SortAscending.sortAscending(new int[] {}));
		assertArrayEquals(new int[] { 123, 345, 456, 667, 777, 884, 885, 889, 2342, 5677 },
				SortAscending.sortAscending(new int[] { 345, 123, 667, 456, 777, 884, 889, 885, 5677, 2342 }));
	}

}
