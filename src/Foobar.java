
public class Foobar {
	/**
 	@author aaron
	Output the numbers 1 to 100. 
	When the number is divisible by 3 print foo, by 5 print bar, 
	and when divisible by 3 and 5, print foobar.
 */
	static void foobar() 
	{
		for (int a = 1; a < 101; a++) 
		{
			if (a % 3 == 0 && a % 5 == 0) 
			{
				System.out.println(a + " foobar");
			} 
			else if (a % 3 == 0) 
			{
				System.out.println(a + " foo");
			} 
			else if (a % 5 == 0) 
			{
				System.out.println(a + " bar");
			} 
			else 
			{
				System.out.println(a);
			}
		}
	
	}
}
