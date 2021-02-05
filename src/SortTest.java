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
	 * Test for Sort. We test the main method first to ensure it works, because the others rely on it.
	 * This is not necessarily a good concept because and API has to have a consistent outer view that is
	 * frozen with tests and any under the hood changes are not breaking the API. But when you assume something
	 * about the implementation (two methods use a third) and optimize tests away, you are not longer
	 * properly testing your API for accidental changes.
	 * 
	 * @author rschwietzke
	 */
	public class SortTest 
	{
		/**
		 * Ensure null handling for all APIs all all combinations. This is how it is supposed to be tested when
		 * the inner workings are not known!
		 */
		@Test
		public void nullHandling()
		{
			assertNull(Sort.sort(null));

			assertNull(Sort.sort(null, Sort.Mode.ASC));
			assertNull(Sort.sort(null, Sort.Mode.DESC));

			assertNull(Sort.sort(null, Sort.Mode.ASC, false));
			assertNull(Sort.sort(null, Sort.Mode.DESC, false));
			assertNull(Sort.sort(null, Sort.Mode.ASC, true));
			assertNull(Sort.sort(null, Sort.Mode.DESC, true));
		}

		/**
		 * Check that an empty array works fine and also verify that we don't get our own array
		 * back, because the method states that it returns a new arrays
		 */
		@Test
		public void emptyHandling()
		{
			final String[] EMPTY = new String[0];

			{
				// assertArrayEquals checks only the content for equality but not for identity, some
				// for the array itself, not identity check!
				assertArrayEquals(EMPTY, Sort.sort(EMPTY));
				assertFalse(EMPTY == Sort.sort(EMPTY));
			}

			{
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.ASC));
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.DESC));

				assertFalse(EMPTY == Sort.sort(EMPTY, Sort.Mode.ASC));
				assertFalse(EMPTY == Sort.sort(EMPTY,  Sort.Mode.DESC));
			}

			{
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.ASC, false));
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.DESC, false));
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.ASC, true));
				assertArrayEquals(EMPTY, Sort.sort(EMPTY, Sort.Mode.DESC, true));

				assertFalse(EMPTY == Sort.sort(EMPTY, Sort.Mode.ASC, false));
				assertFalse(EMPTY == Sort.sort(EMPTY, Sort.Mode.DESC, false));
				assertFalse(EMPTY == Sort.sort(EMPTY, Sort.Mode.ASC, true));
				assertFalse(EMPTY == Sort.sort(EMPTY, Sort.Mode.DESC, true));
			}
		}

		/**
		 * Ok, let's start with some real testing. How do we deal with one item array. is taken from here
		 * https://www.baeldung.com/parameterized-tests-junit-5 and uses some cool JUnit5 features.
		 */
		@ParameterizedTest
		@MethodSource
		public void oneItem(final String[] s, final boolean fake)
		{
			{
				// assertArrayEquals checks only the content for equality but not for identity, some
				// for the array itself, not identity check!
				assertArrayEquals(s, Sort.sort(s));
				assertFalse(s == Sort.sort(s));
			}

			{
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.ASC));
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.DESC));

				assertFalse(s == Sort.sort(s, Sort.Mode.ASC));
				assertFalse(s == Sort.sort(s,  Sort.Mode.DESC));
			}

			{
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.ASC, false));
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.DESC, false));
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.ASC, true));
				assertArrayEquals(s, Sort.sort(s, Sort.Mode.DESC, true));

				assertFalse(s == Sort.sort(s, Sort.Mode.ASC, false));
				assertFalse(s == Sort.sort(s, Sort.Mode.DESC, false));
				assertFalse(s == Sort.sort(s, Sort.Mode.ASC, true));
				assertFalse(s == Sort.sort(s, Sort.Mode.DESC, true));
			}
		}

		/**
		 * This is the data provideer for the method above
		 * @return a stream of data
		 */
		private static Stream<Arguments> oneItem()
		{
			// we need to run that trick here and keep the fake boolean as well to avoid that java unrolls the
			// loop into variable arguments aka T... values, that is only needed for array arguments and a 
			// very much edge-case https://github.com/junit-team/junit5/issues/1665
			return Stream.of(
					Arguments.of(new String[] {null}, true),
					Arguments.of(new String[] {""}, true),
					Arguments.of(new String[] {"A"}, true));
		}

		/**
		 * For longer arrays of strings, we will use more dedicated test methods
		 */
		@ParameterizedTest
		@MethodSource
		public void sort_oneparam(final String[] s, final String[] expected, final boolean fake)
		{
			{
				// assertArrayEquals checks only the content for equality but not for identity, hence
				// we also have to make sure that we are not getting our original array back
				final String[] result = Sort.sort(s);
				assertArrayEquals(expected, result);
				assertFalse(s == result);
			}
		}
		// data for the method before
		private static Stream<Arguments> sort_oneparam()
		{
			return Stream.of(
					Arguments.of(new String[] {null, "T"}, new String[] {null, "T"}, true),
					Arguments.of(new String[] {"ia", null}, new String[] {null, "ia"}, true),
					Arguments.of(new String[] {"A", ""}, new String[] {"", "A"}, true),
					Arguments.of(new String[] {"a", "A"}, new String[] {"A", "a"}, true),
					Arguments.of(new String[] {"A", "a"}, new String[] {"A", "a"}, true),
					Arguments.of(new String[] {"A", "A"}, new String[] {"A", "A"}, true), // that failed initially 
					Arguments.of(new String[] {"x", "x", "x"}, new String[] {"x", "x", "x"}, true),
					Arguments.of(new String[] {"B", "A"}, new String[] {"A", "B"}, true),
					Arguments.of(new String[] {"A", "B", "C"}, new String[] {"A", "B", "C"}, true),
					Arguments.of(new String[] {"C", "B", "A"}, new String[] {"A", "B", "C"}, true),
					Arguments.of(new String[] {"A", "C", "x", "B"}, new String[] {"A", "B", "C", "x"}, true), // we found here a problem too
					Arguments.of(new String[] {"k", "C", "x", "f"}, new String[] {"C", "f", "k", "x"}, true),
					Arguments.of(new String[] {"a", "k", "z"}, new String[] {"a", "k", "z"}, true),
					Arguments.of(new String[] {"foo", "bar", "alle", "a"}, new String[] {"a", "alle", "bar", "foo"}, true)
					);
		}
		
		/**
		 * We could also use a different sort implementation to validate ours, but we deal with null in a very specific
		 * way, hence we are the only impl. right now that says null in an array is permitted. But as an example, here
		 * we go but excluding null. We cover here basically the full range of values for the sort(src, mode).
		 */
		@ParameterizedTest
		@MethodSource
		public void sort_twoparam_notnull(final String[] src, final boolean fake)
		{
			{
				// because we will see our initial array changed, we have to make a copy first
				final String[] copy = Arrays.copyOf(src, src.length);
				
				// sort ASC
				final String[] result = Sort.sort(copy, Sort.Mode.ASC);
				final String[] expected = copy; // just to make the naming nice, this does not copy anything!!!
				Arrays.sort(expected);

				assertArrayEquals(expected, result);
				assertTrue(copy != result); // we just turned around the logic to make this more expressive
			}
			
			{
				// because we will see our initial array changed, we have to make a copy first
				final String[] copy = Arrays.copyOf(src, src.length);
				
				// sort DESC
				final String[] result = Sort.sort(copy, Sort.Mode.DESC);
				Arrays.sort(copy); // this is not ASC sorted, so we have to reverse it!!!
				
				// this is simple code to reverse it, Java does not have an Arrays.reverse
				final List<String> l = Arrays.asList(copy);
				Collections.reverse(l);
				final String[] expected = l.toArray(new String[] {}); 	// java does not do anything with that empty array, just for the compile
																		// to know the type, which helps us to avoid the cast

				assertArrayEquals(expected, result);
				assertTrue(copy != result);
			}
		}
		// data for the method before
		private static Stream<Arguments> sort_twoparam_notnull()
		{
			return Stream.of(
					Arguments.of(new String[] {}, true),
					Arguments.of(new String[] {"jsad"}, true),
					Arguments.of(new String[] {"A", ""}, true),
					Arguments.of(new String[] {"a", "A"}, true),
					Arguments.of(new String[] {"A", "a"}, true),
					Arguments.of(new String[] {"A", "A"}, true),
					Arguments.of(new String[] {"x", "x", "x"}, true),
					Arguments.of(new String[] {"B", "A"}, true),
					Arguments.of(new String[] {"A", "B", "C"}, true),
					Arguments.of(new String[] {"C", "B", "A"}, true),
					Arguments.of(new String[] {"A", "C", "x", "B"}, true),
					Arguments.of(new String[] {"k", "C", "x", "f"}, true),
					Arguments.of(new String[] {"a", "k", "z"}, true),
					Arguments.of(new String[] {"foo", "bar", "alle", "a"}, true)
					);
		}
		
		/**
		 * And the missing null tests
		 */
		@ParameterizedTest
		@MethodSource
		public void sort_twoparam_null(final String[] src, final String[] expected, final Sort.Mode mode)
		{
			{
				final String[] result = Sort.sort(src, mode);
				assertArrayEquals(expected, result);
				assertTrue(src != result);
			}
		}
		// data for the method before
		private static Stream<Arguments> sort_twoparam_null()
		{
			return Stream.of(
					Arguments.of(new String[] {null}, new String[] {null}, Sort.Mode.ASC),
					Arguments.of(new String[] {null}, new String[] {null}, Sort.Mode.DESC),

					Arguments.of(new String[] {"as", null}, new String[] {null, "as"}, Sort.Mode.ASC),
					Arguments.of(new String[] {"as", null}, new String[] {"as", null}, Sort.Mode.DESC),

					Arguments.of(new String[] {null, null}, new String[] {null, null}, Sort.Mode.ASC),
					Arguments.of(new String[] {null, null}, new String[] {null, null}, Sort.Mode.DESC),

					Arguments.of(new String[] {null, "as", null}, new String[] {null, null, "as"}, Sort.Mode.ASC),
					Arguments.of(new String[] {null, "as", null}, new String[] {"as", null, null}, Sort.Mode.DESC)
					);
		}
		
		/**
		 * And now the large final test. We are not testing all the combinations, but should do that. This is rather a demo
		 * than a full 100% covering test. It focuses on the deduplication mostly. We are not trying all the combinations, rather
		 * rely on a strong mix of tests in the hope to find most problems.
		 */
		@ParameterizedTest
		@MethodSource
		public void sort_threeparams_dedup(final String[] src, final String[] expected, final Sort.Mode mode, final boolean deduplicate)
		{
			{
				final String[] result = Sort.sort(src, mode, deduplicate);
				assertArrayEquals(expected, result);
				assertTrue(src != result);
			}
		}
		// data for the method before
		private static Stream<Arguments> sort_threeparams_dedup()
		{
			return Stream.of(
					// single param, nothing to deduplicate
					Arguments.of(new String[] {null}, new String[] {null}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {null}, new String[] {null}, Sort.Mode.DESC, true),
					Arguments.of(new String[] {"A"}, new String[] {"A"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"aaa"}, new String[] {"aaa"}, Sort.Mode.DESC, true),

					// something to deduplicate, make sure we do that only when we tell the method to do that
					Arguments.of(new String[] {"aaa", "aaa"}, new String[] {"aaa", "aaa"}, Sort.Mode.ASC, false),
					Arguments.of(new String[] {"aaa", "aaa"}, new String[] {"aaa", "aaa"}, Sort.Mode.DESC, false),

					// make sure dedup works
					Arguments.of(new String[] {"aaa", "aaa"}, new String[] {"aaa"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"aaa", "aaa"}, new String[] {"aaa"}, Sort.Mode.DESC, true),
					Arguments.of(new String[] {null, null, null, null}, new String[] {null}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {null, null, null, null, null}, new String[] {null}, Sort.Mode.DESC, true),
					
					// exclude problems with sort order and dedup
					Arguments.of(new String[] {"aaa", "bbb", "aaa"}, new String[] {"aaa", "bbb"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"aaa", "bbb", "aaa"}, new String[] {"bbb", "aaa"}, Sort.Mode.DESC, true),

					// check that we get null out
					Arguments.of(new String[] {"aaa", null, "aaa", null}, new String[] {null, "aaa"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"aaa", null, null, "cc"}, new String[] {null, "aaa", "cc"}, Sort.Mode.ASC, true),

					// don't mix up upper and lowercase
					Arguments.of(new String[] {"ZZ", null, "zz", null}, new String[] {null, "ZZ", "zz"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"zz", null, "ZZ", null}, new String[] {"zz", "ZZ", null}, Sort.Mode.DESC, true),
					
					// check that we also find problems with more than two duplicates
					Arguments.of(new String[] {"ww", "ww", "ww", "aaa", "xxx"}, new String[] {"aaa", "ww", "xxx"}, Sort.Mode.ASC, true),
					Arguments.of(new String[] {"TT", "tt", "ww", "tt", "tt"}, new String[] {"TT", "tt", "ww"}, Sort.Mode.ASC, true)
					);
		}

}
