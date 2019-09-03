package question1;

/**
 * This class represents a stack and operations associated with it 
 * @author Jugal
 * Dated 07/31/2019
 */
public class MyStack {
	
	int top = -1;
	int STACK_MAX_SIZE = 100;
	String[] stack = new String[STACK_MAX_SIZE];
	
	/**
	 * This method pushes an element to the stack
	 * @param element is the element to be pushed
	 */
	void push(String element)
	{
		if(top == -1)
		{
			top = 0;
		}
		else
		{
			top++;
		}
		stack[top] = element;
	}
	
	/**
	 * This method pops an element ffrom the stack
	 */
	String pop()
	{
		String poppedString;
		if(top == -1)
		{
			throw new AssertionError();
		}
		else
		{
			poppedString = stack[top];
			top--;
		}
		return poppedString;
	}

	/**
	 * This method returns the element which is at the top of the stack
	 * @return {char} element at the top of the stack
	 */
	String peek()
	{
		if(top == -1)
		{
			throw new AssertionError();
		}
		else
		{
			return stack[top];
		}
	}
	
	/**
	 * This method checks whether the stack is empty or not
	 * @return {boolean}
	 */
	boolean isEmpty()
	{
		if(top == -1)
			return true;
		return false;
	}
	
	/**
	 * This methods empties the stack
	 */
	void emptyStack()
	{
		top = -1;
	}
}
