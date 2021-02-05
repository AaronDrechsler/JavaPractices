import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author name Aaron Drechsler
 * 
 */
public class MergingArrays {

	/**
	 * merges and sorts two integer arrays into a new array
	 * 
	 * @param copyA an array of integers
	 * @param copyB an array of integers
	 * @param mode  which order to sort
	 * @return a new sorted array in ascending or descending order
	 */
	public static int[] mergingArray(final int[] a, final int[] b, final Mode mode, boolean duplicate) {
		final int[] copyA = Arrays.copyOf(a, a.length);
		final int[] copyB = Arrays.copyOf(b, b.length);

		int temp = 0;
		int count = 0;

		/**
		 * returns nothing if there is nothing to do
		 */
		if (copyA == null && copyB == null) {
			return null;
		}

		/**
		 * get`s the length of both arrays combined
		 */
		int[] c = new int[copyA.length + copyB.length];

		for (int i = 0; i < copyA.length; i++) {
			c[count++] = copyA[i];
		}

		for (int j = 0; j < copyB.length; j++) {
			c[count++] = copyB[j];
		}

		/**
		 * sorts the array sorts with ASC mode
		 */
		if (mode == Mode.ASC) {
			for (int i = 0; i < c.length; i++) {
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] > c[j]) {
						temp = c[i];
						c[i] = c[j];
						c[j] = temp;

					}
				}	
			}
			return c;
		} else {
			/**
			 * sorts with DESC mode
			 */
			for (int i = 0; i < c.length; i++) {
				for (int j = i + 1; j < c.length; j++) {
					if (c[j] > c[i]) {
						temp = c[j];
						c[j] = c[i];
						c[i] = temp;
					}
				}
				return c;
			}
		}
		int[] result = new int[c.length];
		int indexJ = 0;
		if (duplicate = true) {
			for (int i = 0; i < c.length - 1; i++) {
				/*
				 * If the current element is equal to the next element, then skip the current
				 * element because it's a duplicate.
				 */
				int currentElement = c[i];
				if (currentElement != c[i + 1]) {
					result[indexJ++] = currentElement;
				}
			}
			result[indexJ++] = c[c.length - 1];
		}
		return result;

	}

	static enum Mode {
		ASC, DESC;
	}

	public static void main(String args[]) {
		int[] a = new int[] { 24, 3, 45, 11, 445 };
		int[] b = new int[] { 244, 32, 445, 411, 67445 };
		int[] d = new int[] { 24, 3, 45, 11, 445 };
		int[] c = new int[] { 24, 3, 45, 11, 445 };
		System.out.println(Arrays.toString(mergingArray(c,d, Mode.ASC, false)));

	}
}
