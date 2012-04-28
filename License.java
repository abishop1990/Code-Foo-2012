/*
 * IGN Code-Foo Problem #3
 *
 * This program calculates the best combination of letters
 * and numbers to create a license plate pattern that would
 * be optimal for a population.
 *
 * Written by Alan Bishop on 3/22/2012
 *
 */
 
 import java.util.*;
 
public class License
{
	public static void main(String [] args)
	{
		int pop, pl;
		//Start at a value of 1 for numbers, 0 for letters
		int l = 0, n = 1;
		Scanner in = new Scanner(System.in);
		
		//Get the population from the user
		System.out.print("Enter the population: ");
		pop = in.nextInt();
		
		//Validate number
		if(pop < 1)
		{
			System.err.println("Invalid population.");
			System.exit(1);
		}
		
		//Loop until the current number of plates meets our need
		pl = getNumber(l,n);
		while(pl < pop)
		{
			//If at the end of a diagonal go to next diagonal
			if(n == 0) { n = l +1; l = 0; }
			
			//Otherwise move down the diagonal
			else { --n; ++l; }
			
			pl = getNumber(l,n);
		}
		
		//Print the results
		System.out.println("Population: " + pop +
						   "\nNumber of Letters: " + l + 
						   "\nNumber of Numbers: " + n +
						   "\nNumber of Plates: " + pl +
						   "\nNumber of Excess Plates: " + (pl - pop));
	}
	
	public static int getNumber(int l, int n)
	{
		int num = 1;
		//Using a loop is more efficient than calling a power function
		for(int i = 1; i <= l; ++i) num *= 26;
		for(int i = 1; i <= n; ++i) num *= 10;
		return num;
	}

}