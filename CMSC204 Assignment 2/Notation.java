
/**
 * 
 * @author Cheolhong Ahn
 * 
 *
 */
public class Notation {

	/**
	 * This method evaluates the postfix string to see if it is valid postifx format.
	 * @param postfixExpr the postfix expression in String format
	 * @return	the evaluation of the postfix expression as double.
	 * @throws InvalidNotationFormatException if the postfix expression is invalid.
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		NotationStack<String> solution = new NotationStack<String>();
		String c;
		try
		{
			for (int i=0; i < postfixExpr.length();i++)
			{
				c = String.valueOf(postfixExpr.charAt(i));
			
				//ignore blank space
				if(c.equals(" "))
					continue;
				//operands are one digit number for this assignment
				else if(c.equals("0")||c.equals("1") || c.equals("2")|| c.equals("3")|| c.equals("4")||c.equals("5")||c.equals("6")
						||c.equals("7")||c.equals("8")||c.equals("9"))
				{
					solution.push(c);
				}
				//allowed operators are +-*/
				else if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/"))
				{
					double first = Double.parseDouble(solution.pop());
					if (solution.isEmpty())
						throw new InvalidNotationFormatException();
					double second = Double.parseDouble(solution.pop());
					double result;
					//Precedence
					switch (c) 
					{
						case "+":
							result = second + first;
							break;
						case "-":
							result = second - first;
							break;
						case "*":
							result = second * first;
							break;
						case "/":
							result = second / first;
							break;
						default:
							result = 0;
					}
					String resultStr = String.valueOf(result);
					solution.push(resultStr);
				}
			}
			if (solution.size() == 1)
				return Double.parseDouble(solution.pop());
			else
				throw new InvalidNotationFormatException();

		}
		catch (StackOverflowException ex)
		{
			ex.getMessage();
		}
		catch (StackUnderflowException ex)
		{
			ex.getMessage();
		}
		return 0;
	}
		
	/**
	 * This method converts postfix String expression into infix String expression
	 * @param postfix the postfix expression in string format to be converted
	 * @return the infix expression in String format
	 * @throws InvalidNotationFormatException  if the postfix expression is invalid.
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		NotationStack<String> solution = new NotationStack<String>(); 
		String c;
		try
		{
			for(int i=0; i<postfix.length();i++)
			{
				c = String.valueOf(postfix.charAt(i));
				//ignore blank space
				if(c.equals(" "))
					continue;
				//operands are single digits
				else if(c.equals("0")||c.equals("1") || c.equals("2")|| c.equals("3")|| c.equals("4")||c.equals("5")||c.equals("6")
						||c.equals("7")||c.equals("8")||c.equals("9"))
				{
					solution.push(c);
				}
				//allowed operators are +-*/
				else if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/"))
				{
					String first = solution.pop();
					if(solution.isEmpty())
						throw new InvalidNotationFormatException();
					String oper = c;
					String second = solution.pop();
					// since the user defined toString method of stack
					// prints from bottom element first
					String out = "(" + second + oper + first + ")";
					solution.push(out);
				}
				else
					throw new InvalidNotationFormatException();
			}
			if (solution.size() > 1)
				throw new InvalidNotationFormatException();
		}

		catch (StackOverflowException ex)
		{
			ex.getMessage();
		}
		catch (StackUnderflowException ex)
		{
			ex.getMessage();
		}
	
		
		return solution.toString();
		
		
		
	}

	/**
	 * This method converts infix String expression into postfix String expression
	 * @param infix the infix expression in String format to be converted
	 * @return the postfix expression in String format
	 * @throws InvalidNotationFormatException if the infix expression format is invalid.
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		NotationQueue<String> solution = new NotationQueue<String>();
		NotationStack<String> operator = new NotationStack<String>();
		String c;
		try 
		{	
			
			for(int i =0; i < infix.length();i++)
			{	
				c = String.valueOf(infix.charAt(i));
				if(c.equals(" "))
					continue;
				//operands are single digit number for this assignment	
				else if(c.equals("0")||c.equals("1") || c.equals("2")|| c.equals("3")|| c.equals("4")||c.equals("5")||c.equals("6")
						||c.equals("7")||c.equals("8")||c.equals("9"))
				{
					solution.enqueue(c);
				}
				else if(c.equals("(") )
					operator.push(c);
				//allowed operators
				else if (c.equals("+") ||c.equals("-")|| c.equals("*")|| c.equals("/"))
				{
					while(!operator.isEmpty()&& precedence(operator.top())>=precedence(c) && !operator.top().equals("("))
						 solution.enqueue(operator.pop());
					operator.push(c);
				}
				//loop and pop untill top is (, once popped all and top is not (, throws error
				else if(c.equals(")"))
				{	
					while(operator.size()> 1 &&!(operator.top().equals("(")))
						solution.enqueue(operator.pop());
					if(!operator.top().equals("("))
						throw new InvalidNotationFormatException();
					operator.pop();
					
						
				}
				else
					throw new InvalidNotationFormatException();
				
			}
			
			while(!operator.isEmpty())
			{	
				if (operator.top().equals("("))
					throw new InvalidNotationFormatException();
				solution.enqueue(operator.pop());
			}
		}

		catch (QueueOverflowException ex)
		{
			ex.getMessage();
		}
		catch (StackOverflowException ex)
		{
			ex.getMessage();
		}
		catch (StackUnderflowException ex)
		{
			ex.getMessage();
		}
	
		
		
		return solution.toString();
		
	}
	
	//defines the precedence of operators
	//left and right precedence is implemented within the above methods not here
	//by popping if current element is same precedence as top of stack
	public static int precedence(String op) {
		switch (op) 
		{
			case "+":
			case "-":
				return 0;
			case "*":
			case "/":
				return 1;

		}
		return 0;
	}
}

