
public class Pond {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Frog frog1 = new Frog("Peepo");
		Frog frog2 = new Frog("Pepe", 10, 15);
		Frog frog3 = new Frog("Peepaw", 4.6, 5);
		Frog frog4 = new Frog("Peepepo");
		
		Fly fly1 = new Fly(1, 3);
		Fly fly2 = new Fly(6);
		Fly fly3 = new Fly(3, 5.2);
		
		frog4.setSpecies("1331 Frogs");
		System.out.println(frog1.toString());
//		System.out.println("frog1.tongueSpeed = " + frog1.getTongueSpeed() + ", fly2.speed = " + fly2.getSpeed());
		frog1.eat(fly2);
		System.out.println(fly2.toString());
		
		frog1.grow(8);
//		System.out.println("frog1.tongueSpeed = " + frog1.getTongueSpeed() +  ", fly2.speed = " + fly2.getSpeed());
		frog1.eat(fly2);
		System.out.println(fly2.toString());
		System.out.println(frog1.toString());
		System.out.println(frog4.toString());
		
		frog3.grow(4);
		System.out.println(frog3.toString());
		System.out.println(frog2.toString());
	
	}
}




/*                        
    Running: test_grow_1_param_young_frog  
   Running: test_grow_1_param_young_frog                       
        Failed: Frog had initial age 5 and initial tongue speed 
        
                                                               
        
              Running: test_grow_1_param_old_frog                         
        Failed: Frog had initial age 31 and initial tongue speed
        
 20. It was grown by 8 months and did not have proper final tongue speed.                                                       
     expected:<12> but was:<11>                                 
        Finished: test_grow_1_param_old_frog   
                     
 */