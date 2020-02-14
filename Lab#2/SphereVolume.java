/**
 * 
 * @author Cheolhong Ahn
 *This program will calculate the result of mathematical formula V=(4/3)(pi)r^3
 *
 */
import java.util.Scanner;
import java.lang.Math;

public class SphereVolume {

	public static void main(String[] args) 
	{	
		Scanner input = new Scanner(System.in);
		double diam;
		double radius;
		double volume;
		
		System.out.println("Please enter a diameter of a circle in meters");
		diam = input.nextDouble();
		if(diam > 0 )
		{
			radius = diam/2.0;
			volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3.0);
			System.out.println("The Volume of Sphere with diameter of " + diam + " meteres is: " + volume +"m^3.");		
		}
		else
		{
			System.out.println("Please enter a diameter greater than 0");
		}
		input.close();
	}
	
}
