/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
public class MergingArrays {
	/**
	 * merges and sorts two integer arrays of equal size into a new array
	 */
	public static int[] mergingArray(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
			count++;
		}

		for (int j = 0; j < b.length; j++) {
			c[count++] = b[j];
		}

		//sorts the array ascending
		int temp = 0;
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
	}
}	
