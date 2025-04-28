package Quiz;

/*
 * Name: SeyedParham Hamzei / Course: CS211 / Date: 1/5/2024 
 * Reasons for doing this: To show the marketer's salary and advertise
 */ 

public class Marketer extends Employee 
{
	//Add a $10.000 to the salary of Marketer 
	public double getSalary()
	{
		return super.getSalary() + 10000;	// $50,000.00
	}
	
	//Add a string but using toString method because Iverson does not like "System.out"
	public String toString()
	{
		return "Act now, while supplies last!";	//toString (System.out.println(bob);)
	}
	
	//This code passes 2 out of 3 tests in Practic-IT
	//use the code below instead of the toString method to pass all of the tests
	
	/*
	public void advertise()
	{
		System.out.println("Act now, while supplies last!");
	}
	 */
}
