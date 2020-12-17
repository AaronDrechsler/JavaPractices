import java.util.Arrays;

public class SortStringArrays {
	public static String[] sortStringArray(String[] s) throws NumberFormatException 
	{
		int[] array = new int[s.length];
		String str = Arrays.toString(s);
		if( str.matches(".*\\d.*") != true)
		{
			stringArray(str);
		}

		else if(s.length<1)
		{
			String noStr = "";
			String[] noString = new String[] {noStr};
			return noString;
		}
		else
		{
			// turns String array into Integer array
				for (int i = 0; i < s.length; i++) 
			{
				array[i] = Integer.parseInt(s[i]);
			}
			
			// sorts array ascending 
			for (int i = 0; i < array.length; i++) 
			{
				for (int j = i + 1; j < array.length; j++) 
				{
					if (array[i] > array[j]) 
					{
						final int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}	
			} 
		}
		// turns integer array into String array
		String[] newStrArray = new String[array.length];
		 for (int i = 0; i < array.length; i++)
	            newStrArray[i] = String.valueOf(array[i]);
		 String a = Arrays.toString(newStrArray);
		 String[] b = new String[] {a};
		 return b;
	}
	
	// sorts the string alphabetical
	public static String sortString(String inputString) 
	{
		char tempArray[] = inputString.toCharArray();
		Arrays.parallelSort(tempArray);
		return new String(tempArray);
	}
	
	// converts and splits the string
	public static String stringArray(String inputString) 
	{
		String sortedString = sortString(inputString);
		String[] ab = sortedString.split("(?!^)");
		return Arrays.toString(ab);
	}
	
	public static void main(String args[]) throws NumberFormatException{		
			System.out.print(sortStringArray(new String[] {"b","a","x","e"}));
	
	}
	
}



