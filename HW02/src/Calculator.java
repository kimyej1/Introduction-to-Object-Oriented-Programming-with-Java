import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.println("List of operations: add subtract multiply divide alphabetize\nEnter an operation:");
		String operation = scan.next().toLowerCase();
		
		switch(operation)
		{
			case "add":
				System.out.println("Enter two integers:");
				try {
					int add1 = scan.nextInt();
					int add2 = scan.nextInt();
					System.out.println("Answer: " + (add1 + add2));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case "subtract":
				System.out.println("Enter two integers:");
				try {
					int sbt1 = scan.nextInt();
					int sbt2 = scan.nextInt();
					System.out.println("Answer: " + (sbt1 - sbt2));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case "multiply":
				System.out.println("Enter two doubles:");
				try {
					double mtp1 = scan.nextDouble();
					double mtp2 = scan.nextDouble();
					System.out.printf("Answer: %.2f", (mtp1 * mtp2));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case "divide":
				System.out.println("Enter two doubles:");
				try {
					double dvd1 = scan.nextDouble();
					double dvd2 = scan.nextDouble();
					if(dvd2 != 0)
					{
						System.out.printf("Answer: %.2f", (dvd1 / dvd2));
						break;
					}
					else
					{
						System.out.println("Invalid input entered. Terminating...");
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case "alphabetize":
				System.out.println("Enter two words:");
				try {
					String alph1 = scan.next();
					String alph2 = scan.next();
					int alphCompare = (alph1.toLowerCase()).compareTo((alph2.toLowerCase()));
					if(alphCompare < 0)
						System.out.println("Answer: " + alph1 + " comes before " + alph2 + " alphabetically.");
					else if(alphCompare > 0)
						System.out.println("Answer: " + alph2 + " comes before " + alph1 + " alphabetically.");
					else
						System.out.println("Answer: Chicken or Egg.");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			default:
				System.out.println("Invalid input entered. Terminating...");
				break;
		}
		
		
		scan.close();
	}

}
