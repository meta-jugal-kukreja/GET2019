package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyStringTest {

	private MyStringOperations stringObject;

	@Before
	public void initialize() {
		stringObject = new MyStringOperations();
	}

	// These methods test stringCompare methods
	@Test
	public void stringCompareTest1() {
		assertEquals(1, stringObject.stringCompare("ABCD", "ABCD"));
	}
	@Test
	public void stringCompareTest2() {
		assertEquals(0, stringObject.stringCompare("ABC", "ABCD"));
	}

	// These methods test stringReverse methods
	@Test
	public void stringReverseTest1() {
		assertEquals("DCBA", stringObject.stringReverse("ABCD"));
	}
	@Test
	public void stringReverseTest2() {
		assertEquals("CBA", stringObject.stringReverse("ABC"));
	}

	// These methods test stringReverseCharacters methods
	@Test
	public void stringReverseCharactersTest1() {
		assertEquals("abcd", stringObject.stringReverseCharacters("ABCD"));
	}
	@Test
	public void stringReverseCharactersTest2() {
		assertEquals("ABC", stringObject.stringReverseCharacters("abc"));
	}

	// These methods test findLargestWord methods
	@Test
	public void findLargestWordTest1() {
		assertEquals("World", stringObject.findLargestWord("Hello World"));
	}
	@Test
	public void findLargestWordTest2() {
		assertEquals("Hello", stringObject.findLargestWord("Hi Hello"));
	}
}
