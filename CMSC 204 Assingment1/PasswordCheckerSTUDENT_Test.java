
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Cheolhong Ahn
 *
 */
public class PasswordCheckerSTUDENT_Test {
	
	ArrayList<String> validAndInvalMixArray;
	ArrayList<String> validArray;

	
	@Before
	public void setUp() throws Exception {
		String[] validAndInvalMix = {"asdASD123!@#", "aSd12@!", "asd", "abcdefg" , "ABCDEFG" , "ABCDEFGabc", "ABCDEFabc!@#", "ABCDEFabc123" , "asbfr!@#!dsfsaASD", "asd!@#ASb1"
				,"ThisIsATest!", "HelloWorld", "QWERTY123!@#ab", "aaaBC123!@#"};
		String[] validPasswords = {"ABCabc123!@#", "123Hello!@#", "ValidPass153!@#", "asfjkn;12!@#45r9Atdsoi1", "asdku1@#!%aBsaxSD"};
		
		validAndInvalMixArray = new ArrayList<String>();
		validAndInvalMixArray.addAll(Arrays.asList(validAndInvalMix));
		
		validArray = new ArrayList<String>();
		validArray.addAll(Arrays.asList(validPasswords));
		
	}
	
	@After
	public void tearDown() throws Exception {
		validAndInvalMixArray = null;
		validArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * 
	 */
	@Test
	public void testIsValidPasswordLength() throws Throwable{
		assertTrue(PasswordCheckerUtility.isValidLength("LongEnough"));
	}
	
	@Test
	public void testInValidPasswordLength()  {	
		
		
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength("abc");
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());	
	}
	
	
	
	/**
	 * Test if the password has at least one upper-case alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPassowrdNoUpperAlpha() throws Throwable{
		assertTrue(PasswordCheckerUtility.hasUpperAlpha("HasUpper"));                                    //first case
	}
	@Test
	public void testInValidPasswordNoUpperAlpha()
	{	
		Throwable exception = Assertions.assertThrows(NoUpperAlphaException.class, new Executable() {    //second case
			@Override
		
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha("abc");
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws Throwable
	{
		assertTrue(PasswordCheckerUtility.hasLowerAlpha("ABCabc!@#545"));                               //first case
	}
	@Test
	public void testInValidPasswordNoLowerAlpha() 
	{
		Throwable exception = Assertions.assertThrows(NoLowerAlphaException.class, new Executable() {   //second case
			@Override
		
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidPassword("ABC1234");
			}			
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testNotWeakPassword() throws Throwable
	{
		assertFalse(PasswordCheckerUtility.isWeakPassword("Aab123!@#!@#!@#"));                               //first case
	}
	
	@Test
	public void testIsWeakPassword()
	{
		Throwable exception = Assertions.assertThrows(WeakPasswordException.class, new Executable() {   //second case
			@Override
		
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword("Aab12!@#");
			}			
		});
		assertEquals("The password is OK but weak - it contains fewer than 10 characters.", exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() throws Throwable
	{
		assertTrue(PasswordCheckerUtility.hasSameCharInSequence("Aab123!@#!@#"));                   //first case
	}
	@Test
	public void testInValidPasswordInvalidSequence() throws Throwable
	{	
		Throwable exception = Assertions.assertThrows(InvalidSequenceException.class, new Executable() {   //second case
			@Override
		
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence("aaabB12!@#");
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() throws Throwable
	{
		assertTrue(PasswordCheckerUtility.hasDigit("Aab!@#!123@#"));                 //first case
	}
	@Test
	public void testInValidPasswordNoDigit()
	{
		Throwable exception = Assertions.assertThrows(NoDigitException.class, new Executable() {   //second case
			@Override
		
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit("aabB!@#");
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() throws Throwable
	{
		assertTrue(PasswordCheckerUtility.isValidPassword("asdASD123!@#"));
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords()  {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(validAndInvalMixArray);
		assertEquals(results.size(), 10);
		assertEquals(results.get(0),"asd -> The password must be at least 6 characters long");
		assertEquals(results.get(1),"abcdefg -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2),"ABCDEFG -> The password must contain at least one lower case alphabetic character");
		assertEquals(results.get(3),"ABCDEFGabc -> The password must contain at least one digit");
		assertEquals(results.get(4),"ABCDEFabc!@# -> The password must contain at least one digit");
		assertEquals(results.get(5),"ABCDEFabc123 -> The password must contain at least one special character");
		assertEquals(results.get(6),"asbfr!@#!dsfsaASD -> The password must contain at least one digit");
		assertEquals(results.get(7),"ThisIsATest! -> The password must contain at least one digit");
		assertEquals(results.get(8),"HelloWorld -> The password must contain at least one digit");
		assertEquals(results.get(9),"aaaBC123!@# -> The password cannot contain more than two of the same character in sequence");
	}	
	@Test
	public void testGetValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(validArray);
		assertTrue(results.isEmpty());
	}
	
}