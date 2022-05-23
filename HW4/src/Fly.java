
public class Fly extends Pond {

	private double mass;
	private double speed;
	
	public Fly(double mass, double speed)
	{
		this.mass = mass;
		this.speed = speed;
	}
	
	public Fly(double mass)
	{
		this(mass, 10);
	}
	
	public Fly()
	{
		this(5, 10);
	}

	public double getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString()
	{
		// 소수점 두자리로 만들기 
		
		if(mass == 0)
		{
			return "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f", (float)speed) + ".";
		} else
		{
			return "I’m a speedy fly with " + String.format("%.2f", (float)speed) + " speed and " + String.format("%.2f", (float)mass) + " mass.";
		}
	}
	
	public void grow(int addMass)
	{
		this.mass += addMass;
		
		for (int i = 1; i <= addMass; i++) 
		{ 
			if ((this.mass+i)<=20) 
			{ 
				this.speed +=1;
			} else 
			{ 
				this.speed -=0.5;
			}
		}
		
		
	}
	
	public boolean isDead()
	{
		if(this.mass == 0)
			return true;
		else
			return false;
	}
	/*
	 * Running: test_grow_boundary_fly                             
        Failed: Fly had initial mass 10.0 and in                
. It was grown by 45 mass units and did not have                
eed.         
	 */
	
}
