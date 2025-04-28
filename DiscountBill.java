package Assignment9a;

	/*
	 * Name: SeyedParham Hamzei / Course: CS211 / Date: 1/4/2024 
	 * Reasons for doing this: Trying to see if the user is using discount (Check how many item, how much discount, and the discount percent)
	 */ 
	public class DiscountBill extends GroceryBill
	{
		//fields
		private Boolean preferred;
		private int discountCount;
		private double discountAmount;
		//constructor
		//constructs discount bill for given cleck
		public DiscountBill(Employee clerk, boolean preferred)
		{
			super(clerk);
			this.preferred = preferred;
			this.discountCount = 0;
			this.discountAmount = 0;
		}
		
		//returns the number of items that were discounted, if any
		public int getDiscountCount()
		{
			return discountCount;
		}
		
		//returns the total discount for this list of items, if any
		public double getDiscountAmount()
		{
			return discountAmount;
		}
		
		public double getDiscountPercent()
		{
			return discountAmount / super.getTotal() * 100;
		}
		
		//returns the cost of these items
		//adjust the amount reported by getTotal for preferred customers
		public double getTotal() 
		{
			return super.getTotal() - this.discountAmount;
		}
		
		public void add(Item i)
		{
			super.add(i);
			
			if(preferred && i.getDiscount() > 0)
			{
				discountCount ++;
				discountAmount += i.getDiscount();
			}
		}
	}
