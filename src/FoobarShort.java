
public class FoobarShort {
	public static void main(String args[]) 
	{
		for (int i = 1; i <= 100; i++) 
		{
			System.out.print(i + " ");
			
			if (i % 3 == 0) 
			{
				System.out.print("foo");
			} 
			
			if (i % 5 == 0) 
			{
				System.out.print("bar");
			} 
			
			System.out.println();
		}

	}
}
