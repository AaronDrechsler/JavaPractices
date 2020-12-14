/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
public class SortAscending {
	/**
	 * method to sort an array of integers either descending or ascending
	 */
	public static int[] sortAscending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					final int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
