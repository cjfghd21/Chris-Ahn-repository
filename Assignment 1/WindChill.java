import java.util.Scanner;
import java.lang.Math;
/**
 * This program calculates wind chill from 
 * two values temperature(F) and wind speed (mph)
 * given from the user.
 * @author Cheolhong Ahn
 * 
 */
public class WindChill
{

	public static void main(String[] args)
	{	
		final double WIND_CHILL_VAL_ONE = 35.74;
		final double WIND_CHILL_VAL_TWO = 0.6215;
		final double WIND_CHILL_VAL_THREE = 35.75;
		final double WIND_CHILL_VAL_FOUR = 0.16;
		final double WIND_CHILL_VAL_FIVE = 0.4275;
		double windSpeed, temperature;
		String programmerName = "Cheolhong Ahn";
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("This program will calculate a wind chill from a temperature(F) and wind speed(mph) provided by the user");
		System.out.println("Please enter a temperature in Fahrenheit between -45 to 40 degrees inclusively.");
		temperature = userInput.nextDouble();
		System.out.println("Please enter a wind speed in mph between 5 and 60 inclusively.");
		windSpeed = userInput.nextDouble();
		
		if(temperature >= -45 && temperature <= 45 && windSpeed >= 5 && windSpeed <= 60)
		{	
			double windChill = WIND_CHILL_VAL_ONE + WIND_CHILL_VAL_TWO * temperature - WIND_CHILL_VAL_THREE * Math.pow(windSpeed, WIND_CHILL_VAL_FOUR) + WIND_CHILL_VAL_FIVE * temperature *  Math.pow(windSpeed, WIND_CHILL_VAL_FOUR);
			System.out.print("The wind chill is: " + windChill + " degrees Fahrenheit \n\n");
		}
		else
		{
			System.out.println("Please enter valid value of temperature(F) between -45 to 45 and windspeed betwee 5 to 60(mph)");
		}
		System.out.print("Programmer Name:" + programmerName);
		userInput.close();
	}
}
