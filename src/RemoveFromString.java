
import java.util.*;

public class RemoveFromString {

	public static ArrayList<String> sortArrayList(ArrayList<String> list) {
		// loops thru the ArrayList
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// checks the letter value
				if (list.get(i).compareTo(list.get(j)) > 0) {
					// switch`s the words
	
					final String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	public static ArrayList<String> findDuplicates(ArrayList<String> list) {
		ArrayList<String> items = new ArrayList<String>(list);

		sortArrayList(items);

		ArrayList<String> duplicates = new ArrayList<String>();
		Iterator<String> dupIter = items.iterator();

		while (dupIter.hasNext()) {
			String dupWord = dupIter.next();

			if (duplicates.contains(dupWord)) {
				dupIter.remove();
			} else {
				duplicates.add(dupWord);
			}
		}
		return duplicates;
	}
}
