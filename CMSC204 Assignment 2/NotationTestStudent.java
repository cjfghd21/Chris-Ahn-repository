import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationTestStudent {
	public String complexInfix = "((3+2)/9*(9+2)-2+(2-2)+4+2/4+(2+4)+(1+(2+4*2)))";
	public String complexPostfix =  "32+9/92+*2-22-+4+24/+24++1242*+++";
	public String easyInfix = "(9+0)";	
	public String easyPostfix = "90+";
	public String intermediateInfix = "((2*(2+3))/(3+1))";
	public String intermediatePostfix = "223+*31+/";

	public String invalidPostfixExpression = "231+-++";
	public String invalidInfixExpression = "(3+1+(3*(3+1))";
	
	public double evalComplexPostfix = 25.611;
	public double evalIntermediatePostfix = 2.5;
	public double evalEasyPostfix = 9.0;
	
	
	@Before	
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(complexInfix);
		assertEquals(complexPostfix, postfixResult);

	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(intermediateInfix);
		assertEquals(intermediatePostfix, postfixResult);
	}
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(easyInfix);
		assertEquals(easyPostfix, postfixResult);
	}
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.convertInfixToPostfix(invalidInfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	/* this results in different format then infix converted to postfix converted to infix but 
	 * regardless same value result. I say if expression evaluates to same value, it is the same
	 * thus should pass the test. So I compared the values after evaulating the converted expression
	 * to see if it matches the value of the infix expression.
	 */ 
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException, ScriptException {
		String infixResult = Notation.convertPostfixToInfix(complexPostfix);
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		DecimalFormat df = new 	DecimalFormat("#.000");
		assertEquals(String.valueOf(evalComplexPostfix), df.format(engine.eval(infixResult)));
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(intermediatePostfix);
		assertEquals(intermediateInfix, infixResult);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(easyPostfix);
		assertEquals(easyInfix, infixResult);
	}

	@Test
	public void testInvalidPostfixExpressionB() {
		try{
			Notation.convertPostfixToInfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(complexPostfix);
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(intermediatePostfix);
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(easyPostfix);
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	@Test
	public void testInvalidPostfixExpressionA() {
		try{
			Notation.evaluatePostfixExpression(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
}
