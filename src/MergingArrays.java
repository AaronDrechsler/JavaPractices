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
	public static int[] mergingArray(final int[] a, final int[] b){
		return mergingArray(a, b, Mode.ASC, false);
	}
	
	/**
	 * @param a integer array
	 * @param b integer array
	 * @param mode choose ascending or descending mode
	 * @return a merged array in ascending or descending order
	 */
	public static int[] mergingArray(final int [] a, final int [] b, Mode mode) {
		return mergingArray(a, b, mode);
	}

	/**
	 * merges and sorts two integer arrays into a new array
	 * 
	 * @param copyA an array of integers
	 * @param copyB an array of integers
	 * @param mode  which order to sort
	 * @return a new sorted array in ascending or descending order
	 */
	public static int[] mergingArray(final int[] a, final int[] b, final Mode mode, boolean duplicate) {
		/**
		 * returns nothing if there is nothing to do
		 */
		if (a == null && b == null) {
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
		int[] result = new int[c.length];

		

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
				return result;
			}else {
				return c;
			}
		}

	static enum Mode {
		ASC, DESC;
	}

	public static void main(String args[]) {
		int[] a = null;
		int[] b = null;
		System.out.println(Arrays.toString(mergingArray(new int[] {11,11,11, 84,6,345,3}, new int[] {76, 34, 654, 123}, Mode.ASC, false)));
		System.out.println(Arrays.toString(mergingArray(null,null, Mode.DESC, true)));

		
	}
}
