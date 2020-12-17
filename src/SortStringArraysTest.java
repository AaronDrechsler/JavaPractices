import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortStringArraysTest {

	
	@Test
	void SortStringArray() {
		assertArrayEquals(new String = "asd", SortStringArrays.sortStringArray( new String[] {"3","2","4","a","a","1"}));
	}
	@Test
	void SortStringArraysWithNothing() {
		assertArrayEquals(new String[] {""}, SortStringArrays.sortStringArray( new String[] {""}));
	}
	@Test
	void SortStringArrays() {
		assertArrayEquals(new String[] {"A","B","C","D"}, SortStringArrays.sortStringArray( new String[] {"A","B","D","C"}));
		assertArrayEquals(new String[] {"700","800","900", "1000"}, SortStringArrays.sortStringArray( new String[] {"700","1000","800","900"}));
		assertArrayEquals(new String[] {"1973", "2673", "3974", "4928", "5637"}, SortStringArrays.sortStringArray( new String[] {"1973", "2673", "3974", "4928", "5637"}));


	}
	
	@Test
	void SortStringArraysBigOrSmall() {
		assertArrayEquals(new String[] {"900", "1000"}, SortStringArrays.sortStringArray( new String[] {"1000","900"}));
		assertArrayEquals(new String[] {"700", "800", "900", "1000"}, SortStringArrays.sortStringArray( new String[] {"700","1000","800","900"}));
		assertArrayEquals(new String[] {"1973", "2673", "3974", "4928","5637"}, SortStringArrays.sortStringArray( new String[] {"1973", "2673", "3974", "4928", "5637"}));
	}

	
	//	Test mit Buchstaben
	// 	was ist ein String
		//	Strings, which are widely used in Java programming, are a sequence of characters. In the Java programming language, strings are objects.
		//		The Java platform provides the String class to create and manipulate strings.
	//	Fall von nichts im Array
	
}
