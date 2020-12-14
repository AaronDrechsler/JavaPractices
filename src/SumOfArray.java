/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
public class SumOfArray {
	public static int sumOfArray(int[] array) {
		int sum = 0;

		for (int num : array) {
			sum = sum + num;
		}

		return sum;
	}

}
