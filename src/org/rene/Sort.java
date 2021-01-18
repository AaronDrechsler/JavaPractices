package org.rene;

import java.util.Arrays;

/**
 * Sorting utility class to sort data structures
 * 
 * @author rschwietzke
 */
public class Sort 
{
	/**
	 * Sorts a string array and returns a new array with the sorted strings.
	 * Sorting is ascending. Duplicates are kept.
	 * 
	 * Null will be cause the method to return null
	 * 
	 * @param s an array of strings
	 * @return a new array with sorted strings in ascending order
	 */
	public static String[] sort(final String[] s)
	{
		return sort(s, Mode.ASC, false);
	}
	
	/**
	 * Sorts a string array and returns a new array with the sorted strings.
	 * Mode defines how to sort. Duplicates are kept.
	 * 
	 * Null will be cause the method to return null
	 * 
	 * @param s an array of strings
	 * @param mode how to sort the array ASC or DESC
	 * 
	 * @return a new array with sorted strings in desired order
	 */
	public static String[] sort(final String[] s, final Mode mode)
	{
		return sort(s, mode, false);		
	}

	/**
	 * Sorts an array in either ascending or descending order. If desired it will
	 * skip duplicates. Null as fields field element is permitted and always considered
	 * smallest. If s is null, the returned array will be null too
	 * 
	 * @param s the array to sort
	 * @param mode in which order to sort
	 * @param deduplicate true if we want to remove duplicate values
	 * @return a new array with the elements sorted as desired
	 */
	public static String[] sort(final String[] s, final Mode mode, final boolean deduplicate)
	{
		// nothing to do? return nothing as result
		if (s == null)
		{
			return null;
		}
		
		// get us a copy of the data first (the array, not the content)
		// use the convience method of Java for that
		// final String[] result = Arrays.copyOf(s, s.length);
		
		// Alternatively we can copy manually
		final String[] result = new String[s.length];
		for (int i = 0; i < s.length; i++)
		{
			result[i] = s[i];
		}
		
		// run a simple bubble sort, do that manually and don't use the build in libs
		for (int i = 0; i < result.length - 1; i++)
		{
			for (int j = i + 1; j < result.length; j++)
			{
				// get us the data
				final String a = result[i];
				final String b = result[j];
				
				// problem is, the content of the array might be null, hence we are not able to just call
				// compareTo
				if (a == null || b == null) 
				{
					// we cannot compare null with compareTo, hence we deal with that here separately
					if ((mode == Mode.ASC && b == null) || (mode == Mode.DESC && a == null))
					{
						result[i] = b;
						result[j] = a;
					}
					
					continue; // continue inner loop from here, skip the rest
				}
				
				// both are not null
				
				// take the sort order into account
				final int compareResult = a.compareTo(b);
				
				// depending on how to sort, we have to see if they have to change the order
				if ((mode == Mode.ASC && compareResult > 0) || (mode == Mode.DESC && compareResult < 0))
				{
					// switch position
					result[i] = b;
					result[j] = a;
				}
			}
		}
		
		// end here when we are not have to deduplicate, if we have short arrays, we can also leave here
		if (deduplicate == false || result.length < 2)
		{
			return result;
		}
			
		
		// ok, we have a sorted array with at least two entries, not we have to deduplicate it
		// we need a new array to deduplicate into first
		final String[] dedupResult = new String[result.length];
		dedupResult[0] = result[0]; // we can set the first position, because we know that we have at least one entry
		
		int dedupPos = 0;
		for (int i = 1; i < result.length; i++)
		{
			// get us the elements to compare with each other
			final String a = dedupResult[dedupPos];
			final String b = result[i];

			boolean toCopy = false;
			if (a != null)
			{
				// set toCopy true when a does not equal b
				toCopy = a.equals(b) == false;
			}
			else if (b != null)
			{
				// a might have been null, 
				toCopy = b.equals(a) == false;	
			}
			else
			{
				// here we have a == null and b == null, hence they are the same, hence we don't do anything
			}
				
			// if we have to copy, copy it and move the pointer further
			if (toCopy)
			{
				dedupPos++;
				dedupResult[dedupPos] = b;
			}
		}
			
		// in case we have had to skip elements when copying, we have to shorten the result array
		return dedupPos < dedupResult.length - 1 ? Arrays.copyOfRange(dedupResult, 0, dedupPos + 1) : dedupResult;
	}
	
	/**
	 * Defines our sorting order as parameter to be used
	 * 
	 * @author rschwietzke
	 */
	static enum Mode
	{
		ASC, DESC;
	}
}
