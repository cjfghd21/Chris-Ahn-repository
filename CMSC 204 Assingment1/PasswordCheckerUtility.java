
import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 * @author Cheolhong Ahn
 * * 
 * This is a Utility class that takes in passwords and validates it. This class will throw exceptions accordingly based on the validation result. 
 * Assignment 1 
 * CMSC 204
 * 
 */
public class PasswordCheckerUtility extends java.lang.Object {
	
	public PasswordCheckerUtility()   //default constructor
	{
	}
	
	
	
	/**
	 * This method compares two passwords and throws exception if two passwords are not equal.
	 * @param password	This is first userinput password
	 * @param passwordConfirm	This is second userinput password
	 * @throws UnmatchedException	Thrown if passwords are not equal.
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	/*
	
	 */
	/**
	 * This method compares two passwords
	 * @param password	first password user inputs
	 * @param passwordConfirm	second password user inputs
	 * @return returns true if two passwords are equal otherwise returns false
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * This method checks the length of the password
	 * @param password user input password
	 * @return true  if the length of password is greater than or equal to 6
	 * @throws LengthException thrown if the length of the password is less than 6
	 */
	public static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() >= 6)
			return true;
		else
			throw new LengthException();
	}
	
	/**
	 * This method checks if password has upper case alphabet.
	 * @param password user input password.
	 * @return true	if password has upper case alphabet.
	 * @throws NoUpperAlphaException	thrown if password does not have upper case alphabet.
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		Pattern upper_case = Pattern.compile("[A-Z ]");
		if (!upper_case.matcher(password).find()) 
			throw new NoUpperAlphaException();
		else
			return true;
	}
	
	/**
	 * This method checks if password has lower case alphabet.
	 * @param password user input password.
	 * @return true	 if password has lower case alphabet.
	 * @throws NoLowerAlphaException thrown if password does not have lower case alphabet.
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		Pattern lower_case = Pattern.compile("[a-z ]");
		if (!lower_case.matcher(password).find()) 
			throw new NoLowerAlphaException();
		else
			return true;
	}
	
	/**
	 * This method checks if password has digit
	 * @param password user input password
	 * @return true	if the password has digit.
	 * @throws NoDigitException thrown if password does not have digit.
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		Pattern digit= Pattern.compile("[0-9 ]");
		if (!digit.matcher(password).find()) 
			throw new NoDigitException();
		else
			return true;
	}
	
	/**
	 * This method checks if password has special character.
	 * @param password user input password
	 * @return true if the password has special character.
	 * @throws NoSpecialCharacterException thrown if password does not have special character.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		Pattern special = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		if (!special.matcher(password).find()) 
			throw new NoSpecialCharacterException();
		else 
			return true;
	}
	
	/**
	 * This method checks if password has three repeated character
	 * @param password user input password
	 * @return true if there is no invalid sequence
	 * @throws InvalidSequenceException thrown if there is invalid sequence: repeats same character three times in a row
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException
	{
		int k = password.length();
		for (int i = 0; i < k -2; i++)
		{
			char temp = password.charAt(i);
			if (temp == password.charAt(i+1) && temp == password.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}	
	

	/**
	 * This method checks if the password is valid. Password is valid if all of above method returns true. Otherwise, throw appropriate exception.
	 * @param password user input password
	 * @return true if password meets all the conditions.
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(
		isValidLength(password)&&
		hasUpperAlpha(password)&&	
		hasLowerAlpha(password)&&
		hasDigit(password)&&
		hasSpecialChar(password)&&
		hasSameCharInSequence(password)
		)
			return true;
		else
			return false;
	}
	
	/**
	 * This method checks if password is between six and nine characters.
	 * @param password user input password
	 * @return true if the length is between 6 and 9 inclusive.flase otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length()>=6 && password.length() <= 9)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the password is weak password based on result of hasBetweenSixAndNineChars method.
	 * @param password user input password
	 * @return false if the hasBetweenSixAndNineChars method is false.
	 * @throws WeakPasswordException thrown if the hasBetweenSixAndNineChars method is true.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		if(hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException();
		}
		return false;
	}
	
	/**
	 * This method takes ArrayList of passwords from a file and returns any invalid passwords with reason.
	 * @param passwords the ArrayList of passwords that user selected from a file.
	 * @return ArrayList of invalid passwords with reason.
	 */
	static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList <String>invalids = new ArrayList<String>();
		for (int i = 0; i < passwords.size(); i++) 
		{
			try 
			{ 
				isValidPassword(passwords.get(i));
			}
			catch(Exception ex)
			{
				invalids.add(passwords.get(i) + " -> " + ex.getMessage());
			}
			
		
		}
		return invalids;
	}
	
}
