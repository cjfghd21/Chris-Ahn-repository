
import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		
		
		String title , rating;
		int soldTickets;
		char again;
		
		Scanner userInput = new Scanner(System.in);
		Movie movieOne = new Movie();
		
		do
		{
			System.out.println("Enter the name of a movie");
			title = userInput.next();
			movieOne.setTitle(title);
			userInput.nextLine();
		
			System.out.println("Enter the rating of the movie");
			rating = userInput.next();
			movieOne.setRating(rating);
		
			System.out.println("Enter the number of tickets sold for this moive");
			soldTickets = userInput.nextInt();
			userInput.nextLine();
		
			movieOne.setSoldTickets(soldTickets);
			System.out.println(movieOne.toString());
		
			System.out.println("Do yo want to enter another? (y or n)");
			again = userInput.next().charAt(0);
			System.out.print("\n");
		
		} while (again == 'y' || again == 'Y');
	
		userInput.close();
		System.out.println("Good Bye");
	}
	
}
