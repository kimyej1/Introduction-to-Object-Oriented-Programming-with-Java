import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
	
	private String skill;
	
	// Constructors
	public RedAstronaut(String name, int susLevel, String skill)
	{
		super(name, susLevel);
		this.skill = skill.toLowerCase();
	}
	
	public RedAstronaut(String name)
	{
		this(name, 15, "experienced");
	}

	
	@Override
	public void freeze(Player p) {		// Impostor that is frozen cannot attempt to freeze.
		// TODO Auto-generated method stub
		if(this.isFrozen() == false)
		{
			if (p instanceof Impostor)
			{
				// If the passed in Player is an Impostor, the method should end. 
			} else if(p instanceof Crewmate)
			{
				if(p.isFrozen())
				{
					// Freezing an already frozen Player should also do nothing.
				} else
				{
					if(this.getSusLevel() < p.getSusLevel())
					{
						// A freeze is successful if the RedAstronaut¡¯s susLevel is less than the Player¡¯s
						p.setFrozen(true);
					} else
					{
						// If the freeze is unsuccessful, the RedAstronaut¡¯s susLevel doubles
						this.setSusLevel(this.getSusLevel() * 2);
					}
				}
			}
			
			// After the freeze attempt, check if the game is over using the provided method in Player.java
			super.gameOver();	
		}
	}

	@Override
	public void sabotage(Player p) {		// Impostor that is frozen cannot sabotage. 
		// TODO Auto-generated method stub
		
		if(this.isFrozen() == false)
		{
			if(p instanceof Impostor)
			{
				
			} else if (p instanceof Crewmate)
			{
				if(p.isFrozen())
				{
					// sabotaging a frozen Player should do nothing.
				} else
				{
					if(this.getSusLevel() < 20)
					{
						p.setSusLevel((int)(p.getSusLevel() * 1.5));
						// they are able to increase the Crewmate¡¯s susLevel by 50%
					} else
					{
						p.setSusLevel((int)(p.getSusLevel() * 1.25));
					}
				}
			}
		}
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
				
			} else
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
		/*
		 * A Player that is frozen cannot call an emergency meeting.
		 * Holds a meeting and votes out (freezes) the most suspicious Player, 
		 * only considering Players that are not frozen
		 * 
		 * The player that has the highest susLevel (that is NOT the current impostor calling the meeting) 
		 * will be accused of being the impostor and will be voted off

		 * Hint: think of an easy way to do this without having to iterate through the entire array. 
		 * Check the Java API for Arrays for a method you can use
		 * 
		 * Make sure to change the frozen variable of the player to true when voting off players 
		 * (don¡¯t call the freeze method!)
		 */
	}
	
	
	
	
	public boolean equals(Object o)
	{
		if (o instanceof RedAstronaut) 
		{
			 RedAstronaut player = (RedAstronaut) o;
	            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
	                    && this.getSusLevel() == player.getSusLevel();
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
		
		String reName, reSkill;
		
		if(this.getSusLevel() > 15)
		{
			reName = this.getName().toUpperCase();
			reSkill = this.skill.toUpperCase();
			frozen =frozen.toUpperCase();
			return "MY NAME IS " + reName + ", AND I HAVE A SUSLEVEL OF " + this.getSusLevel() + 
					". I AM CURRENTLY " + frozen + ". I AM AN " + reSkill + " PLAYER!";
		} else
		{
			reName = this.getName();
			reSkill = this.skill;
			return "My name is " + reName + ", and I have a suslevel of " + this.getSusLevel() + 
					". I am currently " + frozen + ". I am an " + reSkill + " player!";
		}
		
		
		
	}
}
