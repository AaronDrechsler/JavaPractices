import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
class MergingArraysTest 
{
	// you can declare that here and set it to 0 size, no need to say {}
	private final int[] EMPTY = new int[0];
	
	@Test
	public void nullHandling() 
	{
		assertNull(MergingArrays.mergingArray(null, null));
		
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.ASC));
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.DESC));
		
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.ASC, true));
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.ASC, false));
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.DESC, true));
		assertNull(MergingArrays.mergingArray(null, null, MergingArrays.Mode.DESC, false));
		
	}
	
	@Test
	public void emptyHandling() 
	{
		{
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY));
			
			// Do you know why we do this?
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY));
		}
		
		{
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC));
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.DESC));

			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC));
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.DESC));
		}
		
		{
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, true));
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, false));
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.DESC, true));
			assertArrayEquals(EMPTY, MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, false));
		
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, true));
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, false));
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.DESC, true));
			assertFalse(EMPTY == MergingArrays.mergingArray(EMPTY, EMPTY, MergingArrays.Mode.ASC, false));
		}
	}
	
	
	/**
	 * test MergingArray method with single digit array inputs
	 */
	@ParameterizedTest
	@MethodSource
	void basicTest(final int[] a, final int[] b, final int[] expected, boolean fake) 
	{
		final int[] result = MergingArrays.mergingArray(a, b);
		{
			
			// this is the only real test and bascially it is nothing else than
			// assertArrayEquals(expected, MergingArrays.mergingArray(a, b));
			assertArrayEquals(expected, result);
			
			// that is not correct, because the real test is not done aka if the result is matching when 
			// sorting in different orders and with or without duplication!
			assertFalse(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,false));
			assertFalse(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,true));
			assertFalse(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC,false));
			assertFalse(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC, true));
		}
	}
	
	/**
	 * data for basicTest method
	 * @return a stream of data
	 */
	private static Stream<Arguments> basicTest()
	{ 
		return Stream.of(
				Arguments.of(new int[] {1}, new int[] {1}, new int [] {1,1}, true),
				Arguments.of(new int[] {1,3,4,2,5}, new int[] {6,7,8,9}, new int[] {1,2,3,4,5,6,7,8,9}, true),
				Arguments.of(new int[] {9,8,7,6,5}, new int[] {4,3,2,1}, new int[] {1,2,3,4,5,6,7,8,9}, true),
				Arguments.of(new int[] {9,1,8,2,7}, new int[] {3,6,4,5}, new int[] {1,2,3,4,5,6,7,8,9}, true),
				Arguments.of(new int[] {2,5,3,8,4}, new int[] {6,7,8,9}, new int[] {2,3,4,5,6,7,8,8,9}, true),
				Arguments.of(new int[] {1,4,7,8,3}, new int[] {6,9,5,2}, new int[] {1,2,3,4,5,6,7,8,9}, true),
				Arguments.of(new int[] {1,1,1,1,1,1}, new int[] {1}, new int [] {1,1,1,1,1,1,1}, true),
				Arguments.of(new int[] {1,1,1,1,1,1}, new int[] {1,1,1,1,1,1}, new int[] {1,1,1,1,1,1,1,1,1,1,1,1}, true),
				Arguments.of(new int[] {5,2,4,4,7,8}, new int[] {2,2,4,5,8}, new int[] {2,2,2,4,4,4,5,5,7,8,8}, true));

	}
	
	/**
	 * I don't understand this test. You have three parameters, but b and expected is always null... not 
	 * sure if this is planned and if so... what not having the same with b being the array with data and a with null...
	 * to finish the test idea correctly. 
	 * 
	 * The naming of the method has likely to change, because the test is not really about checking only one parameters, rather
	 * checking for a null result when one parameter is null.
	 */
	@ParameterizedTest
	@MethodSource
	public void one_parameter(final int[] a, final int[] b, final int[] expected, boolean fake) 
	{
		final int[] result = MergingArrays.mergingArray(a, b);
		{
			assertArrayEquals(expected, result);
			
			// you ensure that it is always null?!? If you want to test for null, you rather you use assertNull or assertNotNull
			assertTrue(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,false));
			assertTrue(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,true));
			assertTrue(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC,false));
			assertTrue(expected == MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC, true));
		}
	}
	
	private static Stream<Arguments> one_parameter()
	{
		return Stream.of(
				Arguments.of(new int[] {1,2,3,723,4,23}, null, null, true),
				Arguments.of(new int[] {18,133,158,100}, null, null, true),
				Arguments.of(new int[] {23,64,234,886,54}, null, null, true)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void all_parameters(final int[] a, final int[] b, final int[] expected, MergingArrays.Mode sortMode, boolean deduplicate) 
	{
		// safe the original content to see if we later modified it
		var a2 = a != null ? Arrays.copyOf(a, a.length) : null;
		var b2 = b != null ? Arrays.copyOf(b, b.length) : null;
		
		var result = MergingArrays.mergingArray(a, b, sortMode, deduplicate);
		
		// the result is right 
		assertArrayEquals(expected, result);
		
		// make sure we don't get our initial array back when we don't have null
		// we compare references here to ensure that we really have new objects as return value
		if (a != null)
		{
			assertTrue(a != result); 
		}
		if (b != null)
		{
			assertTrue(b != result);
		}
		
		// our original array have not been touched, in case of null, this also works
		assertArrayEquals(a2, a);
		assertArrayEquals(b2, b);
	}
	
	private static Stream<Arguments> all_parameters()
	{
		return Stream.of(
				// how do we handle null
				Arguments.of(null, null, null, MergingArrays.Mode.ASC, true),
				Arguments.of(new int[]{1}, null, new int[]{1}, MergingArrays.Mode.ASC, true),
				Arguments.of(null, new int[]{1}, new int[]{1}, MergingArrays.Mode.ASC, true),

				// what about empty arrays
				Arguments.of(new int[]{}, new int[]{}, new int[]{}, MergingArrays.Mode.ASC, true),
				Arguments.of(new int[]{5, 6}, new int[]{}, new int[]{5, 6}, MergingArrays.Mode.ASC, false),
				Arguments.of(new int[]{5, 6}, new int[]{}, new int[]{6, 5}, MergingArrays.Mode.DESC, false),
				Arguments.of(new int[]{}, new int[]{3, 4}, new int[]{3, 4}, MergingArrays.Mode.ASC, false),
				Arguments.of(new int[]{}, new int[]{3, 4}, new int[]{4, 3}, MergingArrays.Mode.DESC, false),
				
				// simple deduplication
				Arguments.of(new int[]{1}, new int[]{1}, new int[]{1}, MergingArrays.Mode.ASC, true),
				Arguments.of(new int[]{1}, new int[]{1}, new int[]{1, 1}, MergingArrays.Mode.ASC, false),
				
				// complex dedup
				Arguments.of(new int[]{1, 5, 10}, new int[]{5, 10, 15}, new int[]{1, 5, 10, 15}, MergingArrays.Mode.ASC, true),
				Arguments.of(new int[]{10, 1, 5}, new int[]{15, 5, 3, 1, 1}, new int[]{15, 10, 5, 3, 1}, MergingArrays.Mode.DESC, true),
				Arguments.of(new int[]{5, 5, 5, 6, 7}, new int[]{7, 6, 5, 5}, new int[]{5, 6, 7}, MergingArrays.Mode.ASC, true),
				Arguments.of(new int[]{5, 5, 5, 6, 7}, new int[]{7, 6, 5, 5}, new int[]{7, 6, 5}, MergingArrays.Mode.DESC, true),
				
				// sorting
				Arguments.of(new int[]{-10, -20, -5}, new int[]{10, 30, 50, 80, 1}, new int[]{-20, -10, -5, 1, 10, 30, 50, 80}, MergingArrays.Mode.ASC, false),
				Arguments.of(new int[]{-10, -20, -5}, new int[]{50, 30, 10, 80, 1}, new int[]{80, 50, 30, 10, 1, -5, -10, -20}, MergingArrays.Mode.DESC, false),

				// extreme values
				Arguments.of(new int[]{-8, -1018, Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE, 0, 981}, new int[]{Integer.MIN_VALUE, -1018, -8, 0, 981, Integer.MAX_VALUE}, MergingArrays.Mode.ASC, false),
				Arguments.of(new int[]{-8, -1018, Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE, 0, 981}, new int[]{Integer.MAX_VALUE, 981, 0, -8, -1018, Integer.MIN_VALUE}, MergingArrays.Mode.DESC, false)
				);
	}
}

