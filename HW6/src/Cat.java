
public class Cat extends Pet {

	// Variables
	private int miceCaught;
	
	// Constructors
	public Cat(String name, double health, int painLevel, int miceCaught)
	{
		super(name, health, painLevel);
		
		if(miceCaught < 0)
			this.miceCaught = 0;
		else
			this.miceCaught = miceCaught;
	}
	
	public Cat(String name, double health, int painLevel)
	{
		this(name, health, painLevel, 0);
	}

	// Getters
	public int getMiceCaught() {
		return miceCaught;
	}
	
	// Methods
	@Override
	public int treat() {
		// TODO Auto-generated method stub
		this.heal();
		
		double time;
		if(this.miceCaught < 4)
			time = (getPainLevel()*2)/getHealth();
		else if(this.miceCaught <= 7)
			time = getPainLevel()/getHealth();
		else
			time = getPainLevel()/(getHealth()*2);
		
		return (int)Math.ceil(time);
	}
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		super.speak();
		
		String meow = "meow ";
		meow = meow.repeat(this.miceCaught);
		
		if(this.getPainLevel() <= 5)
			System.out.println(meow);
		else
			System.out.println(meow.toUpperCase());
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(super.equals(o))
		{
			if(o instanceof Cat)
			{
				Cat cat = (Cat) o;
				return this.miceCaught == cat.miceCaught;
			}
			return false;
		}
		return false;
	}
}
