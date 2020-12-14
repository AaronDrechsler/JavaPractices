
public class AverageOfArrays {
	/**
	 * method that accepts an array of integers and returns the average of all
	 * integers in the array
	 */
	public static double averageOfArray(final int[] array) {
		double sum = 0;
		double maxValue = Double.NaN;
		for (final int num : array) {
			sum = sum + num;
			if (Double.isNaN(sum)) {
				return maxValue;
			}
		}
		if (array.length == 0) {
			return 0;
		}
		return sum / array.length;
	}
}
