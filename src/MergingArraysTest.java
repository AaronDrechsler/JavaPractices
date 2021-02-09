import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.assertArrayEquals;
	import static org.junit.jupiter.api.Assertions.assertFalse;
	import static org.junit.jupiter.api.Assertions.assertNull;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.stream.Stream;

	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.Arguments;
	import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author name Aaron Drechsler method that accepts an array of integers and
 *         returns the sum of all integers in the array
 */
class MergingArraysTest {

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
	
	
	/**
	 * test MergingArray method with single digit array inputs
	 */
	@ParameterizedTest
	@MethodSource
	void basicTest(final int[] a, final int[] b, boolean fake) 
	{
		{
			assertArrayEquals(a, MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,false));
			assertArrayEquals(a, MergingArrays.mergingArray(a, b, MergingArrays.Mode.ASC,true));
			assertArrayEquals(a, MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC,false));
			assertArrayEquals(a, MergingArrays.mergingArray(a, b, MergingArrays.Mode.DESC,true));
		}
	}
	
	/**
	 * data for basicTest method
	 * @return a stream of data
	 */
	private static Stream<Arguments> basicTest()
	{ 
		return Stream.of(
				Arguments.of(new int[] {1}, new int[] {1}, true),
				Arguments.of(new int[] {1,3,4,2,5}, new int[] {6,7,8,9}, true),
				Arguments.of(new int[] {9,8,7,6,5}, new int[] {4,3,2,1}, true),
				Arguments.of(new int[] {9,1,8,2,7}, new int[] {3,6,4,5}, true),
				Arguments.of(new int[] {2,5,3,8,4}, new int[] {6,7,8,9}, true),
				Arguments.of(new int[] {1,4,7,8,3}, new int[] {6,9,5,2}, true),
				Arguments.of(new int[] {1,1,1,1,1,1}, new int[] {1}, true),
				Arguments.of(new int[] {5,2,4,4,7,8}, new int[] {2,2,4,5,8}, true));

	}
		
}

