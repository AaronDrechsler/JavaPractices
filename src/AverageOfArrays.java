
public class AverageOfArrays {
	/**
	 * method that accepts an array of integers and returns the average of all
	 * integers in the array
	 */
	public static double averageOfArray(final int[] array) {
		double sum = 0;
		double maxValue = Double.NaN;
		//looping thru array
		for (final int num : array) 
		{
			sum = sum + num;
			//checks if numbers total of the array is 0, if yes then it returns 0
			if (Double.isNaN(sum)) 
			{
				return maxValue;
			}
		}
		//checks if the length of the array is 0  
		if (array.length == 0) 
		{
			return 0;
		}
		return sum / array.length;
	}
}
