
public class JavaPractices {
	/**
	 * @author name Aaron Drechsler method that accepts an array of integers and
	 *         returns the sum of all integers in the array
	 */
	public static int sumOfArray(int[] array) {
		int sum = 0;

		for (int num : array) {
			sum = sum + num;
		}

		return sum;
	}

	/**
	 * method that accepts an array of integers and returns the average of all
	 * integers in the array
	 */
	public static double averageOfArray(final int[] array) {
		double sum = 0;
		double maxValue = Double.NaN;
		for (final int num : array) 
		{
			sum = sum + num;
				if (Double.isNaN(sum)) 
				{	
					return maxValue;
				}
		}
		return sum / array.length;
	}
	/**
	 * method to sort an array of integers either descending or ascending
	 */
	public static int[] sortAscending(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * merges and sorts two integer arrays of equal size into a new array
	 */
	static int[] mergingArray(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
			count++;
		}

		for (int j = 0; j < b.length; j++) {
			c[count++] = b[j];
		}

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
