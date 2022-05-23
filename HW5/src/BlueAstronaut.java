import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
	
	@Override
	public void completeTask() {
		// TODO Auto-generated method stub
		
		if(this.numTasks != 0)
		{
			if(this.isFrozen() == false)
			{
				if(this.taskSpeed > 20)
				{
					this.numTasks -= 2;
				} else
				{
					this.numTasks -= 1;
				}
				
				if(this.numTasks < 0)
				{
					this.numTasks = 0;
				}		
				if(this.numTasks == 0)
				{
					System.out.println("I have completed all my tasks");
					this.setSusLevel((int)(this.getSusLevel() / 2));
				}
			}
		}
		/*
		 * A BlueAstronaut that is frozen cannot complete tasks.

		 * After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time),
		 * Print out ¡°I have completed all my tasks¡±
		 * 
		 * Then reduce BlueAstronaut¡¯s susLevel by 50% (round down)
		 * Does not return anything.
		 */
		
	}

	
	/*
	 * All variables must be not allowed to be directly modified outside the class in which they are declared, 
	 * unless otherwise stated in the description of the variable. 
	 * 
	 * Hint: there is a specific visibility modifier that can do this!
	 * 
	 * The Blue class must have these variables. 
	 * Do NOT redeclare any instance variables created in the Player class
	 * 
	 * numTasks - the number of tasks that needs to be completed as an integer number
	 * taskSpeed - the speed at which the astronaut is completing each task as a positive, nonzero integer number
	 */
	
	private int numTasks;
	private int taskSpeed;

	
	public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed)
	{
		super(name, susLevel);
		this.numTasks = numTasks;
		try {
			if(taskSpeed > 0)
				this.taskSpeed = taskSpeed;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public BlueAstronaut(String name)
	{
		this(name, 15, 6, 10);
	}
	
	/*
	 * Do not create any other methods than those specified. 
	 * Any extra methods will result in point deductions. 
	 * All methods must have the proper visibility to be used where it is specified they are used.
	 */
	
	public void emergencyMeeting()
	{
		if(this.isFrozen() == false)
		{
			Player[] players = Player.getPlayers();
			
			Arrays.sort(players);
			Player suspicious = players[players.length-1];
			
				
			if(suspicious.compareTo(players[players.length-2]) == 0)
			{
				//  If two players have the same highest susLevel, no player will be voted off.
				
			{
				if (this.equals(players[players.length-1]))
				{
					suspicious = players[players.length-2];
					if(suspicious.compareTo(players[players.length-3]) == 0)
					{
						//  If two players have the same highest susLevel, no player will be voted off.
						
					} else
					{
						if (this.equals(players[players.length-1]))
						{
							
						} else
						{
							suspicious.setFrozen(true);
							
						}
							
					}
				} else
				{
					suspicious.setFrozen(true);
					
				}

			}
			super.gameOver();
		}
		}
		/*
		 * A Player that is frozen cannot call an emergency meeting.
		 * 
		 * Holds a meeting and votes out (freezes) the most suspicious individual of the Player objects, 
		 * only considering Players that are not frozen
		 * 
		 * The player that has the highest susLevel will be accused of being the impostor and will be voted off 
		 * (This could be them!)
		 * 
		 * If two players have the same highest susLevel, no player will be voted off.
		 * Hint: think of an easy way to do this without having to iterate through the entire array. 
		 * Check the Java API for Arrays for a method you can use.
		 * 
		 * Make sure to change the frozen variable of the player to true when voting off players 
		 * (don¡¯t call freeze!)

		 */
	}
	
	
	public boolean equals(Object o)
	{
		if (o instanceof BlueAstronaut) 
		{
			 BlueAstronaut player = (BlueAstronaut) o;
	            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
	                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == player.numTasks
	                    && this.taskSpeed == player.taskSpeed;
	    } else
	    {
	    	return false;
	    }
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String frozen;
		if(this.isFrozen() == true)
			frozen = "frozen";
		else
			frozen = "not frozen";
		
		String reName;
		
		if(this.getSusLevel() > 15)
		{
			reName = this.getName().toUpperCase();
			frozen =frozen.toUpperCase();
			return "MY NAME IS " + reName + ", AND I HAVE A SUSLEVEL OF " + this.getSusLevel() + 
					". I AM CURRENTLY " + frozen + ". I HAVE " + this.numTasks + " LEFT OVER.";
		} else
		{
			reName = this.getName();
			return "My name is " + reName + ", and I have a suslevel of " + this.getSusLevel() + 
					". I am currently " + frozen + ". I have " + this.numTasks + " left over.";
		}
		
		
		
		
	}
}
