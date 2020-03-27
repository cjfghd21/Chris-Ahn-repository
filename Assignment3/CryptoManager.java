/**
 * This driver class encrypts and decrypts given string values with cipher and bellaso methods and decrypts given cipher and bellaso 
 * @author Cheol
 *
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	public static boolean stringInBounds (String plainText) {
		char TestArray[];                          // declaring char array to store each letter of plainText to compare to ASCII value
		TestArray = new char[plainText.length()];
		int count=0;          //for tracking how many letters of the string plainText is within bounds, if all is within bounds
		                      //the count == plaintText.length()
		
		for (int i = 0; i < plainText.length(); i++)                  //assigns each letter of plaint text to char array
		{	
			TestArray[i] = plainText.charAt(i);	  
		}
		
		for (int i =0; i < plainText.length();i++)                      // checks to see if within bounds
		{
			if (TestArray[i] <= UPPER_BOUND && TestArray[i] >= LOWER_BOUND)
				count ++;
		}
		
		if (count == plainText.length())                              // if all letters are within bounds, return true
			return true;
		else 
			return false;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//assigns each letter of plain text to char array
		char TestArray[];
		TestArray = new char[plainText.length()];	
		for (int i = 0; i < plainText.length(); i++)    
		{	
			TestArray[i] = plainText.charAt(i);	  
		}
		
		for (int i =0; i < plainText.length();i++)   // this for loop offsets each letter of plainText to the key 
			                                         // and if the encrypted is outside of the range, range is subtracted to fit in the range
		{
			TestArray[i] += key;
			while (TestArray[i] > UPPER_BOUND)
			{	
				TestArray[i] -= RANGE;
			}
			
		}
		String result = new String(TestArray);      // string to hold encrypted
		return result;                             // return the string                
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// assigns plaintext letters to char array
		char TestArray[];
		int n = 0;
		TestArray = new char[plainText.length()];	
		for (int i = 0; i < plainText.length(); i++)    
		{	
			TestArray[i] = plainText.charAt(i);	  
		}
		
		for (int i=0; i < plainText.length();i++)                // loop untill all letters of plainText have been gone through
		{
			if ( n <bellasoStr.length())                        // adds the value of corresponding character in belllaso
			{
				TestArray[i] += bellasoStr.charAt(n);
				while (TestArray[i] > UPPER_BOUND)
				{	
					TestArray[i] -= RANGE;
				}
				
				n++;
			}
			else                                               // repeats the bellaso from the first character
			{
				n = 0;
				TestArray[i] += bellasoStr.charAt(n);
				while (TestArray[i] > UPPER_BOUND)
				{	
					TestArray[i] -= RANGE;
				}
				n++;
			}
		}
		String result = new String(TestArray);      // string to hold encrypted
		return result;     
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		char TestArray[];
		TestArray = new char[encryptedText.length()];	
		for (int i = 0; i < encryptedText.length(); i++)    
		{	
			TestArray[i] = encryptedText.charAt(i);	  
		}
		
		for (int i =0; i < encryptedText.length();i++)   // this for loop offsets each letter of plainText to the key by subtracting
			                                         // and if the encrypted is outside of the range, range is added to fit in the range
		{	
			if (TestArray[i] - key <=0)                     // chekcs if the value becomes negative and if it does
				                                            // adds the range first so that number doesn't end up negative in any process
			{
				while (TestArray[i] - key < LOWER_BOUND)
				{		
					TestArray[i] += RANGE;
				}
				TestArray[i] -= key;
			}
			else
			{
				TestArray[i] -= key;
				while (TestArray[i] < LOWER_BOUND)
				{	
					TestArray[i] += RANGE;
				}
				
			}
		}
		String result = new String(TestArray);      // string to hold decrypted
		return result;  
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		char TestArray[];
		int n = 0;
		TestArray = new char[encryptedText.length()];	
		for (int i = 0; i < encryptedText.length(); i++)    
		{	
			TestArray[i] = encryptedText.charAt(i);	  
		}
		
		for (int i=0; i < encryptedText.length();i++)
		{
			if ( n < bellasoStr.length())                        // adds the value of corresponding character in belllaso
			{	
				if (TestArray[i] - bellasoStr.charAt(n) <= 0)
				{
					while (TestArray[i] - bellasoStr.charAt(n) < LOWER_BOUND)
					{	
						TestArray[i] += RANGE;
					}
					TestArray[i] -= bellasoStr.charAt(n);
				}
				else
				{
					TestArray[i] -= bellasoStr.charAt(n);
					while (TestArray[i] < LOWER_BOUND)
					{	
						TestArray[i] += RANGE;
					}
				}
				n++;
			}
			else                                               // repeats the bellaso from the first character
			{	
				n = 0;
				if (TestArray[i] - bellasoStr.charAt(n) <= 0)
				{
					while (TestArray[i] - bellasoStr.charAt(n) < LOWER_BOUND)
					{	
						TestArray[i] += RANGE;
					}
					TestArray[i] -= bellasoStr.charAt(n);
				}
				else
				{
					TestArray[i] -= bellasoStr.charAt(n);
					while (TestArray[i] < LOWER_BOUND)
					{	
						TestArray[i] += RANGE;
					}
				}
				n++;
			}
		}
		String result = new String(TestArray);      // string to hold encrypted
		return result;  
	}
}
