import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RemoveFromStringTest {

	@Test
	void testWithNormalCharacters() {
		assertEquals(new HashSet<String>(Arrays.asList("Aaron", "Anja", "Chris", "Jakob")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("Chris","Chris", "Aaron", "Aaron", "Jakob", "Jakob", "Anja", "Anja"))));
		assertEquals(new HashSet<String>(Arrays.asList("AARON", "ANJA", "APPLE", "CHRIS", "JAKOB", "SERVER")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("CHRIS", "AARON", "JAKOB", "ANJA", "APPLE", "SERVER", "AARON", "JAKOB", "ANJA", "APPLE", "SERVER"))));
		assertEquals(new HashSet<String>(Arrays.asList("aaron", "anja", "apple", "chris", "jakob", "server")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("chris", "aaron", "jakob", "anja", "apple", "server", "chris", "aaron", "jakob", "anja", "apple", "server"))));
		assertEquals(new HashSet<String>(Arrays.asList("AAA", "BBB", "aaa", "bbb")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("AAA", "aaa", "BBB", "bbb", "BBB", "bbb"))));
		assertEquals(new HashSet<String>(Arrays.asList("Aaron", "Bbibel", "aaron", "bbibel")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("bbibel", "Bbibel", "Aaron", "aaron"))));
		assertEquals(new HashSet<String>(Arrays.asList("Aaron", "Bbibel", "aaron", "bbibel")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("bbibel", "Bbibel", "Aaron", "aaron", "Bbibel", "Aaron"))));

	}
	@Test
	void testWithNumbers() {
		assertEquals(new HashSet<String>(Arrays.asList("FOS20T1", "FOS20T2", "FOS20T3", "FOS20T4")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("FOS20T4", "FOS20T2", "FOS20T1", "FOS20T3", "FOS20T2", "FOS20T1"))));
		assertEquals(new HashSet<String>(Arrays.asList("Aaron1", "Anja2", "Chris1", "Jakob2")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("Chris1", "Aaron1", "Jakob2", "Anja2", "Aaron1", "Jakob2"))));
		assertEquals(new HashSet<String>(Arrays.asList("AudiA3", "AudiA4", "AudiA6", "AudiA9")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("AudiA6", "AudiA3", "AudiA4", "AudiA9", "AudiA6", "AudiA3"))));	
		assertEquals(new HashSet<String>(Arrays.asList("AudiA13", "AudiA14", "AudiA16", "AudiA19")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("AudiA16", "AudiA13", "AudiA14", "AudiA19", "AudiA14", "AudiA19"))));	
	}
	@Test
	void testWithJustNumbers() {
		assertEquals(new HashSet<String>(Arrays.asList("11", "21", "31", "41")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("41", "21", "11", "31", "21", "11"))));
		assertEquals(new HashSet<String>(Arrays.asList("1", "2", "3", "4")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("1", "4", "3", "2", "1", "4"))));	
		assertEquals(new HashSet<String>(Arrays.asList("Aaron1", "Aaron2", "Aaron3", "Aaron4")), RemoveFromString.findDuplicates(new HashSet<String>(Arrays.asList("Aaron4", "Aaron2", "Aaron1", "Aaron3", "Aaron2", "Aaron1", "Aaron3"))));
	}

}
