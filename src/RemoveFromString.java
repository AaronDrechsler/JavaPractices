import java.util.Arrays;

public class RemoveFromString {
	public static String removeFromStringArray(String[] s) {
	int[] array = new int[s.length];
	// turns String array into Integer array 
	for (int i = 0; i < s.length; i++) {
		array[i] = Integer.parseInt(s[i]);
	}
	// sorts array ascending 
	for (int i = 0; i < array.length; i++) {
		for (int j = i + 1; j < array.length; j++) {
			if (array[i] > array[j]) {
				final int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	// turns array into String array
	String finalA = Arrays.toString(array);
	return finalA;
	}

public static void main(String args[]) {
		System.out.print(removeFromStringArray(new String[] {"3","5","4"}));
	}
}