
import java.util.*;
public class RemoveFromString {
	
	public static HashSet<String> sortArrayList(ArrayList<String> list) {
		//loops thru the ArrayList
		for (int i = 0; i < list.size(); i++) 
		{
			for (int j = i + 1; j < list.size(); j++) 
			{
				// checks the letter value
				if (list.get(i).compareTo(list.get(j)) > 0) 
				{
					//switch`s the words
					final String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		HashSet newList = new HashSet(list);
		return newList;
		}
	
		public static HashSet<String> findDuplicates(HashSet<String> list){
			HashSet<String> items = new HashSet<String>(list); 
			HashSet<String> duplicates = new HashSet<String>();           
			for (String item : list) 
			{   
				if (items.contains(item)) 
					{   
					duplicates.add(item);              
					} 
				else 
					{ 
						items.add(item);               
					}
			}
			ArrayList newDuplicate = new ArrayList(duplicates);
			sortArrayList(newDuplicate);
			return duplicates;       
			}
}
