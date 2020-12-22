import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class sortArrayListTest {

	@Test
	void testWithNormalCharacters() {
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron", "Anja", "Chris", "Jakob")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("Chris", "Aaron", "Jakob", "Anja"))));
		assertEquals(new ArrayList<String>(Arrays.asList("AARON", "ANJA", "APPLE", "CHRIS", "JAKOB", "SERVER")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("CHRIS", "AARON", "JAKOB", "ANJA", "APPLE", "SERVER"))));
		assertEquals(new ArrayList<String>(Arrays.asList("aaron", "anja", "apple", "chris", "jakob", "server")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("chris", "aaron", "jakob", "anja", "apple", "server"))));
		assertEquals(new ArrayList<String>(Arrays.asList("AAA", "BBB", "aaa", "bbb")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("AAA", "aaa", "BBB", "bbb"))));
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron", "Bbibel", "aaron", "bbibel")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("bbibel", "Bbibel", "Aaron", "aaron"))));
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron", "Bbibel", "aaron", "bbibel")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("bbibel", "Bbibel", "Aaron", "aaron"))));

	}
	
	@Test
	void testWithNumbers() {
		assertEquals(new ArrayList<String>(Arrays.asList("FOS20T1", "FOS20T2", "FOS20T3", "FOS20T4")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("FOS20T4", "FOS20T2", "FOS20T1", "FOS20T3"))));
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron1", "Anja2", "Chris1", "Jakob2")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("Chris1", "Aaron1", "Jakob2", "Anja2"))));
		assertEquals(new ArrayList<String>(Arrays.asList("AudiA3", "AudiA4", "AudiA6", "AudiA9")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("AudiA6", "AudiA3", "AudiA4", "AudiA9"))));	
		assertEquals(new ArrayList<String>(Arrays.asList("AudiA13", "AudiA14", "AudiA16", "AudiA19")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("AudiA16", "AudiA13", "AudiA14", "AudiA19"))));	
	}
	
	@Test
	void testWithJustNumbers() {
		assertEquals(new ArrayList<String>(Arrays.asList("11", "21", "31", "41")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("41", "21", "11", "31"))));
		assertEquals(new ArrayList<String>(Arrays.asList("1", "2", "3", "4")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("1", "4", "3", "2"))));		
		assertEquals(new HashSet<String>(Arrays.asList("01", "02", "03", "04")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("04", "02", "01", "03"))));
		assertEquals(new HashSet<String>(Arrays.asList()), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList())));	
	}

}
