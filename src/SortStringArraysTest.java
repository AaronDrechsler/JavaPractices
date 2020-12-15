import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortStringArraysTest {

	@Test
	void SortStringArraysBigOrSmall() {
		assertEquals("[900, 1000]", SortStringArrays.sortStringArray( new String[] {"1000","900"}));
		assertEquals("[700, 800, 900, 1000]", SortStringArrays.sortStringArray( new String[] {"700","1000","800","900"}));
		assertEquals("[1973, 2673, 3974, 4928, 5637]", SortStringArrays.sortStringArray( new String[] {"1973", "2673", "3974", "4928", "5637"}));
		assertEquals("s.length", SortStringArrays.sortStringArray( new String[] {""}));
		assertEquals("[900, 1000]", SortStringArrays.sortStringArray( new String[] {"1000","900"}));
	}

}
