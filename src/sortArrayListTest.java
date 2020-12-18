import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class sortArrayListTest {

	@Test
	void test() {
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron", "Anja", "Chris", "Jakob")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("Chris", "Aaron", "Jakob", "Anja"))));
		assertEquals(new ArrayList<String>(Arrays.asList("AARON", "ANJA", "CHRIS", "JAKOB")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("CHRIS", "AARON", "JAKOB", "ANJA"))));
		assertEquals(new ArrayList<String>(Arrays.asList("aaron", "anja", "chris", "jakob")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("chris", "aaron", "jakob", "anja"))));
		assertEquals(new ArrayList<String>(Arrays.asList("AAA", "BBB", "aaa", "bbb")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("AAA", "aaa", "BBB", "bbb"))));
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron", "Bbibel", "aaron", "bbibel")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("bbibel", "Bbibel", "Aaron", "aaron"))));
		
	}
	void testWithNumbers() {
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron1", "Anja2", "Chris1", "Jakob2")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("Chris1", "Aaron1", "Jakob2", "Anja2"))));
		assertEquals(new ArrayList<String>(Arrays.asList("1", "2", "3", "4")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("1", "4", "3", "2"))));	
		assertEquals(new ArrayList<String>(Arrays.asList("Aaron1", "Aaron2", "Aaron3", "Aaron4")), sortArrayList.sortArrayList(new ArrayList<String>(Arrays.asList("Aaron4", "Aaron2", "Aaron1", "Aaron3"))));
	}

}
