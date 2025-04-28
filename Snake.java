package Assignment9b;

/*
 * Name: SeyedParham Hamzei / Course: CS211 / Date: 1/8/2024 
 * Reasons for doing this: Adding snake to the table with different toString, movement, and color. 
 * 		   				   The movement should be "Moves south 1 step, east 1 step, south 1 step, west 2 step,..."
 */ 

import java.awt.Color;

public class Snake implements Animal {
	
	//fields:
    private int highestStep = 0;
    private int stepNumber = 0;
    private int stepDirection = WEST;
    
	// Constructor:
    public Snake() {
    	super();
    }


    public String toString() {
        return "S";
    }

    public int getMove() {
        
    	if(stepNumber == 0)
    	{
    		//Changing to WEST and EAST
    		if(stepDirection == WEST)
    		{
    			stepDirection = EAST;
    		}
    		else
    		{
    			stepDirection = WEST;
    		}
    		
    		//Other way of writing if statement:
    		//stepDirection = stepDirection == WEST? EAST: WEST;
    		
    		//Add steps
    		highestStep++;
    		
    		stepNumber = highestStep;
    		return SOUTH;
    	}
    	
    	else
    	{
    		stepNumber--;
    		return stepDirection;
    	}
    }
    
	public Color getColor() {
		return Color.GREEN;
	}
}

