package Assignment9b;

/*
 * Name: SeyedParham Hamzei / Course: CS211 / Date: 1/8/2024 
 * Reasons for doing this: Adding frog to the table with different toString, movement, and color. 
 * 		   				   The movement should be "Moves randonly 3 steps in one directions"
 */ 
import java.awt.Color;

public class Frog implements Animal {
	
	//Fields:
	private int counter = 0;
	private int direction;
	
	// Constructor:
	public Frog() {
		super();
	}
	
    public String toString() {
        return "F";
    }


    public int getMove() {
    	
    	//Check how many steps left and use counter-- to get it to zero
    	if (counter > 0)
    	{
    		counter--;
    		return direction;
    	}
    	else
    	{
    		double r = Math.random();
    		
    		if (r < 0.25)
            {
            	counter++;
            	direction = NORTH;
            }
            else if (r < 0.5)
            {
            	counter++;
            	direction = SOUTH;
            }
            else if (r < 0.75)
            {
            	counter++;
            	direction = EAST;
            }
            else
            {
            	counter++;
                direction = WEST;
            }
    		
    		//We want to of the same step 3 times back to back
    		counter = 2;
    		return direction;
    	}
        
        //Generate one random move
        
        
    }

    // millions of options here
	public Color getColor() {
		return Color.YELLOW;
	}
}

/* 
 * First way of solving:
 
 		if(counter == 0)
        {
        if (r < 0.25)
        {
        	counter++;
        	direction = NORTH;
        }
        else if (r < 0.5)
        {
        	counter++;
        	direction = SOUTH;
        }
        else if (r < 0.75)
        {
        	counter++;
        	direction = EAST;
        }
        else
        {
        	counter++;
            direction = WEST;
        }
        }
        
        //Move it in one direction for 3 steps and reset
        else if(counter == 1)
        {
        	counter++;
        	return direction;
        }
        
        else if(counter == 2)
        {
        	counter++;
        	return direction;
        }
        
        counter++;
    	 //Reset
    	if(counter > 3)
        {
        	counter = 0;
        }
    	return direction;
*/
