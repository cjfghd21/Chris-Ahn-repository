/**
 * The purpose of this class is to model a television
 * 3/8/2020
 * @author Cheolhong Ahn
 *
 */
public class Television {
	
	final String MANUFACTURER;    // name of the manufacturer of the television
	final int SCREEN_SIZE;        // screen size of the tv
	boolean powerON;              // boolean for toggling the power between on and off
	int channel;                  // int variable to hold value of the channel the tv is showing
	int volume;                   // int varaible to hold the value representing the loudness 
	
	
	/**
	  	constructor that takes brand and size and sets respectively, initializing the power to false, volume 20 
		and channel to 2;
		@param brand  the brand of television
		@param size   the size of the screen
	*/
	public Television(String brand, int size)  
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerON = false;
		volume = 20;
		channel = 2;
	}
	
	
	/**
	 * change the state of the power
	 */
	public void power() 	 
	{
		powerON = !powerON;
	}
	/**
	 * increase volume by one
	 */
	public void increaseVolume()  
	{
		volume++;
	}
	
	/**
	 * decrease volume by one
	 */
	
	public void decreaseVolume() 
	{
		volume--;
	}
	
	
	/**
	 * @param stations  change the channel
	 */
	public void setChannel (int stations)
	{
		channel = stations;
	}

	
	/**
	 * @return the current channel
	 */
	public int getChannel()
	{
		return channel;
	}

	/**
	 * @return the current volume
	 */
	public int getVolume()
	{
		return volume;
	}
	
	
	/**
	 * 
	 * @return the manufacturer of the television
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
	
	/** 
	 * @return the size of the screen
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}

}
