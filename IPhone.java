package Quiz_Ch9b;
/*
 * Name: SeyedParham Hamzei / Course: CS211 / Date: 1/4/2024 
 * Reasons for doing this: Trying to find the MarketValue and Profit for a IPhone base on year
 */ 
public class IPhone implements Asset{
	
	//Fields:
	public static final double ANNUAL_DEPRECIATION = 0.2; // fraction decline each year
	private double originalCost = 0; // in US dollars, fixed for each object
	private int currentAge = 0;  // in years
	
	//constructors:
	public IPhone(double originalCost, int currentAge)
	{
		this.originalCost = originalCost;
		this.currentAge = currentAge;
	}
	
	//a zero parameter constructor that calls this(0,0) for IPhone(originalCost, currentAge)
	public IPhone()
	{
		this(0,0);
	}
	
	//market value that depreciates each year by amount given by ANNUAL_DEPRECIATION
    public double getMarketValue()
    {
    	double MarketValue = 0;
    	double DEPRECIATION = 1 - ANNUAL_DEPRECIATION;
    	MarketValue = originalCost * (Math.pow(DEPRECIATION, currentAge));
    	return MarketValue;
    }

    //profit that is market value minus original cost.
    public double getProfit()
    {
    	double Profit = 0;
    	Profit =  getMarketValue() - originalCost;
    	return Profit;
    }


	
	public String toString() 
	{
		return "IPhone ( 5 years old )";
	}
}
