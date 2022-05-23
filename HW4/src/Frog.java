
public class Frog extends Pond {

	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet = false;
	private static String species = "Rare Pepe";
	
	public Frog(String name, int age, double tongueSpeed)
	{
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
	}
	
	public Frog(String name, double ageInYears, double tongueSpeed)
	{
		this(name, (int)(ageInYears * 12), tongueSpeed);
	}
	
	public Frog(String name)
	{
		this(name, 5, 5);
	}
	
	public void grow(int month)
	{
		
		if(this.age < 7 && this.age > 1)
		{
			this.isFroglet = true;
		} else
		{
			this.isFroglet = false;
		}
		
		if(this.age < 12)
		{
			for(int i=1; i<= month; i++)
			{
				this.tongueSpeed += 1;
			}
		}
		this.age += month;
		if(this.age >= 30)
		{
			this.tongueSpeed -= (this.age - 30);
			
			if(this.tongueSpeed < 5)
				this.tongueSpeed = 5;
		}
	}
	
	public void grow()
	{		
		if(this.age < 12)
		{
			this.tongueSpeed += 1;
		}
		this.age += 1;
		if(this.age >= 30)
		{
			this.tongueSpeed -= (this.age - 30);
			
			if(this.tongueSpeed < 5)
				this.tongueSpeed = 5;
		}
	}
	
	public void eat(Fly fly)
	{
		if(fly.isDead() == false)
		{
			if(this.tongueSpeed > fly.getSpeed())
			{
				if(fly.getMass() >= this.age * 0.5)
				{
					this.grow();
				}
				fly.setMass(0);
			}
		}
	}
	
	

	@Override
	public String toString() {
		
		if(this.isFroglet == true)
		{
			return "My name is "+ name + " and I¡¯m a rare froglet! I¡¯m " + age + " months old and my tongue has a speed of " + String.format("%.2f", (float)tongueSpeed) + ".";
		} else
		{
			return "My name is " + name + " and I¡¯m a rare frog. I¡¯m " + age + " months old and my tongue has a speed of " + String.format("%.2f", (float)tongueSpeed) + ".";
		}
	}

	static String getSpecies() {
		return species;
	}

	public void setSpecies(String spec) {
		species = spec;
	}

	public double getTongueSpeed() {
		return tongueSpeed;
	}

	
	
	
}
