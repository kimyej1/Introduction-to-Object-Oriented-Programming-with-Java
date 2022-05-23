
public class InvalidPetException extends RuntimeException {
	
    public InvalidPetException() 
    {
        this("Your pet is invalid!");
    }

    public InvalidPetException(String s) 
    {
        super(s);
    }
}
//public class InvalidPetException {
//
//	
//	// Constructors
//	public InvalidPetException()
//	{
//		System.out.println("Your pet is invalid!");
//	}
//	
//	public InvalidPetException(String s)
//	{
//		System.out.println(s);
//	}
//}
