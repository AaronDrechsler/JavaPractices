import java.util.ArrayList;
import java.util.Arrays;

public class sortArrayList {
	public static ArrayList<String> sortArrayList(ArrayList<String> list) {

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					final String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
	

//	public static void main(String args[]) {
//		System.out.print(sortArrayList(new ArrayList<String>(Arrays.asList("Volvo", "Audi", "Toyota", "Aaron"))));
//	}

}
