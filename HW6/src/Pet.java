
public abstract class Pet {

	// Variables
	private String name;
	private double health;
	private int painLevel;
	
	// Constructor
	public Pet(String name, double health, int painLevel)
	{
		this.name = name;
		
		if(health > 1.0)
			this.health = 1.0;
		else if(health < 0.0)
			this.health = 0.0;
		else
			this.health = health;
		
		if(painLevel > 10)
			this.painLevel = 10;
		else if(painLevel < 1)
			this.painLevel = 1;
		else
			this.painLevel = painLevel;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getPainLevel() {
		return painLevel;
	}

	public void setPainLevel(int painLevel) {
		this.painLevel = painLevel;
	}
	
	// Methods
	abstract int treat();
	
	public void speak()
	{
		String msg = "Hello! My name is " + this.name;
		if(this.painLevel > 5)
			System.out.println(msg);
		else
			System.out.println(msg.toUpperCase());
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof Pet)
		{
			Pet pet = (Pet) o;
			return this.name == pet.name;
		}
		return false;
	}
	
	protected void heal()
	{
		this.setHealth(1.0);
		this.setPainLevel(1);
	}
	
}
