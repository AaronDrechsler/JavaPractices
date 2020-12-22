
import java.util.*;
public class RemoveFromString {
	
	public static ArrayList<String> sortArrayList(ArrayList<String> list) {
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
		return list;
		}
	
		public static ArrayList<String> findDuplicates(ArrayList<String> list){
			ArrayList<String> items = new ArrayList<String>(list); 
			
			sortArrayList(items);
			
			ArrayList<String> duplicates = new ArrayList<String>(); 
		    Iterator<String> dupIter = items.iterator();
		    
		    while(dupIter.hasNext())
		    {
		    String dupWord = dupIter.next();
		    
		    if(duplicates.contains(dupWord))
		    {
		        dupIter.remove();
		    }else
		    {
		        duplicates.add(dupWord);
		    }
		    }
		    return duplicates;
		}
		 public static void main(String[] args) {
			 HashSet<String> sa = new HashSet<String>(Arrays.asList("Aaron", "Aaron"));
			 ArrayList<String> a= new ArrayList<String>(Arrays.asList("1", "3", "2", "2"));
			 System.out.print(sa);
			 System.out.print(findDuplicates(a));
			 
		 }
}
