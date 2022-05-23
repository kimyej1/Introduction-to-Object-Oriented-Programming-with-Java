
public class Dog extends Pet{

	// Variables
	private double droolRate;
	
	// Constructors
	public Dog(String name, double health, int painLevel, double droolRate)
	{
		super(name, health, painLevel);
		
		if(droolRate <= 0)
			this.droolRate = 0.5;
		else
			this.droolRate = droolRate;
	}
	
	public Dog(String name, double health, int painLevel)
	{
		this(name, health, painLevel, 5.0);
		
	}
	
	// Getters
	public double getDroolRate() {
		return droolRate;
	}
	
	// Methods
	@Override
	public int treat() {
		// TODO Auto-generated method stub
		this.heal();
		
		double time;
		if(this.droolRate < 3.5)
			time = (getPainLevel()*2)/getHealth();
		else if(this.droolRate <= 7.5)
			time = getPainLevel()/getHealth();
		else
			time = getPainLevel()/(getHealth()*2);
		
		return (int)Math.ceil(time);
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		super.speak();
		
		String bark = "bark ";
		bark = bark.repeat(getPainLevel());
		
		if(this.getPainLevel() <= 5)
			System.out.println(bark);
		else
			System.out.println(bark.toUpperCase());
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(super.equals(o))
		{
			if(o instanceof Dog)
			{
				Dog dog = (Dog) o;
				return this.droolRate == dog.droolRate;
			}
			return false;
		}
		return false;
	}
}
