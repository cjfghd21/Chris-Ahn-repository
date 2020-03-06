import java.util.Random;
import java.util.Scanner;
/**
 * Assignment 2
 * 
 * This is a driver that uses Toy class to purchase birthday gifts. 
 * This program will prompt user to enter a child's name age and select toy
 * then the program will tell the user if the toy is appropriate for the age
 * user has option to cancel order if not age appropriate or go ahead with the order
 * user has option to add card and/or balloon at extra cost
 * at end of each child's gift, the detail of order for this child will be printed out
 * program will ask if the user wants another order then will print the full amount when order is complete
 * program will display random 1~100000 order number and programmer name
 * 
 * @author Cheol
 */

public class Birthday {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String childName;              // name of child
		String toy;                    // what toy
		String cancelOrder;            // yes or no to check if order is canceled
		String choice;                 // yes or no to check if card or balloon is added
		int age;                       // age of the child
		double total = 0;              // total cost of the order
		System.out.println( "\tBIRTHDAY GIFTS\t");
		Toy gift;                      // instance of Toy
		
		
		// do while loop to add another toy
		do
		{
			// do while loop for re-ordering due to age appropriation.
			do            
			{
				cancelOrder= "no";   
				System.out.println("Please enter the name of the child");
				childName = userInput.nextLine();
				System.out.println("Please enter the age of this child");
				age = userInput.nextInt();
				System.out.println("Please Choose a toy: a plushie, blocks, or a book");
				toy = userInput.next();
				// while loop validation to test user input is either plushie blocks or book
				while(!(toy.equalsIgnoreCase("plushie")|| toy.equalsIgnoreCase("blocks")|| toy.equalsIgnoreCase("book")))
				{
						System.out.println("Invalid choice\n"+ "Please Choose a toy:plushie,blocks, or a book");
						toy = userInput.next();
				}
				gift = new Toy(toy, age);
				// checks if the gift is age appropriate.
				if (gift.ageOK())
				{
					System.out.println("Good choice!");
				}
				
				else         // when not age appropriate, asks user if the user wants to cancel order
				{	System.out.println("This toy is not age-appropraite for the child\n" + "Do you want to cancel the order? yes or no: ");
					cancelOrder = userInput.next();
					userInput.nextLine();
				}				
			}while(cancelOrder.equalsIgnoreCase("yes"));    
			
			// asks user whether to add card. if yes, adds price of card to the gift.
			System.out.println("Do you want to add a card to the gift? Yes or No");
			choice = userInput.next();
			if (choice.equalsIgnoreCase("yes"))
			{
				gift.addCard(choice);
	
			}
			// asks user whether to add balloon. If yes, adds price of balloon to the gift.
			System.out.println("Do you want to add a Balloon to the gift? Yes or No");
			choice = userInput.next();
			if (choice.equalsIgnoreCase("yes"))
			{
				gift.addBalloon(choice);
			}
			// prints out the order of this gift.
			System.out.println("Gift for " + childName + gift );
			total += gift.getCost();
			System.out.println("Do you want to add another toy? yes or no");
			choice = userInput.next();
			userInput.nextLine();
		}while (choice.equalsIgnoreCase("yes"));
		
		//prints the total cost of gifts and random 1~100000 order number.
		System.out.println("The total cost of your order is $" + total);
		Random r = new Random();
		int orderNumber = r.nextInt(100000) + 1;
		System.out.println("The order number is: " + orderNumber);
		System.out.println("Programmer Nmae: Cheolhong Ahn");
		userInput.close();	
	}

}
