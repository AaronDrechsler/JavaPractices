
public class FoobarString {
	public static void main(String args[]) 
	{
		for (int i = 1; i <= 100; i++) 
		{
			String result = i + " ";
			
			if (i % 3 == 0) 
			{
				result = result + "foo";
			} 
			
			if (i % 5 == 0) 
			{
				result = result + "bar";
			} 
			
			System.out.println(result);
		}

	}
}
