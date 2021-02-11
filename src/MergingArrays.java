import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author name Aaron Drechsler
 * 
 */
public class MergingArrays {

	/**
	 * @param a integer array
	 * @param b integer array
	 * @return a merged array, sorted in ascending order
	 */
	public static int[] mergingArray(final int[] a, final int[] b) {
		return mergingArray(a, b, Mode.ASC, false);
	}

	/**
	 * @param a    integer array
	 * @param b    integer array
	 * @param mode choose ascending or descending mode
	 * @return a merged array in ascending or descending order
	 */
	public static int[] mergingArray(final int[] a, final int[] b, Mode mode) {
		return mergingArray(a, b, mode, false);
	}

	/**
	 * merges and sorts two integer arrays into a new array
	 * 
	 * @param copyA an array of integers
	 * @param copyB an array of integers
	 * @param mode  which order to sort
	 * @param duplicate removes duplicate if true
	 * @return a new sorted array in ascending or descending order
	 */
	public static int[] mergingArray(final int[] a, final int[] b, final Mode mode, boolean duplicate) {
		/**
		 * returns nothing if there is nothing to do
		 */
		if (a == null || b == null) {
			return null;
		}


		final int[] copyA = Arrays.copyOf(a, a.length);
		final int[] copyB = Arrays.copyOf(b, b.length);
		int indexJ = 0;
		int temp = 0;
		int count = 0;

		/**
		 * get`s the length of both arrays combined
		 */
		int[] c = new int[copyA.length + copyB.length];
		int[] d = new int[c.length];

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
			}
		}
		
		
		if (duplicate == true) {
			if (c.length == 0) {
				return c;
			} else {
				int lengthAfterRemove = c.length;
				for (int i = 0; i < c.length-1; i++) {
					/*
					 * If the current element is equal to the next element, then skip the current
					 * element because it's a duplicate.
					 */
					int currentElement = c[i];
					if (currentElement != c[i + 1]) {
						d[indexJ++] = currentElement;
					}else {
						lengthAfterRemove--;
					}
				}
				d[indexJ++] = c[c.length - 1];
				int[] e = new int[lengthAfterRemove];
				for(int i = 0; i < lengthAfterRemove; i++) {
					e[i] = d[i];
				}
				return e;
			}
		} else {
			return c;
		}
	}
	public static void main(String args[]) {
		System.out.println(Arrays.toString(mergingArray(new int[] {1,2,2,1}, new int[] {1,1,1,1}, Mode.ASC, false)));
	}
	
	static enum Mode {
		ASC, DESC;
	}
}
