package problem1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class inSetTest {
	
	private InSet setObject;
	
	//This method creates object before the tests begin
		@Before
		public void initialize() {
			setObject = new InSet();
		}
		
		//These methods test isMember method
		@Test
		public void testIsMember1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			setObject.setSetOfIntegers(setArray);
			assertEquals(true, setObject.isMember(6));
		}
		@Test
		public void testIsMember2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			setObject.setSetOfIntegers(setArray);
			assertEquals(false, setObject.isMember(20));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsMember3()
		{
			int[] setArray = {};
			setObject.setSetOfIntegers(setArray);
			assertEquals(false, setObject.isMember(20));
		}
		
		//These methods test size method
		@Test
		public void testSize1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			setObject.setSetOfIntegers(setArray);
			assertEquals(9, setObject.size());
		}
		@Test
		public void testSize2()
		{
			int[] setArray = {1,3,6,8,4,9,25};
			setObject.setSetOfIntegers(setArray);
			assertEquals(7, setObject.size());
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testSize3()
		{
			int[] setArray = {};
			setObject.setSetOfIntegers(setArray);
			assertEquals(7, setObject.size());
		}
		
		//These methods test isSubSet method
		@Test
		public void testIsSubSet1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet set1 = new InSet();
			int[] subSetArray = {1,6,8,7,10};
			set1.setSetOfIntegers(subSetArray);
			setObject.setSetOfIntegers(setArray);
			assertEquals(true, setObject.isSubSet(set1));
		}
		@Test
		public void testIsSubSet2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet set1 = new InSet();
			int[] subSetArray = {1,6,8,7,20};
			set1.setSetOfIntegers(subSetArray);
			setObject.setSetOfIntegers(setArray);
			assertEquals(false, setObject.isSubSet(set1));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsSubSet3()
		{
			int[] setArray = {};
			InSet set1 = new InSet();
			int[] subSetArray = {1,6,8,7,20};
			set1.setSetOfIntegers(subSetArray);
			setObject.setSetOfIntegers(setArray);
			assertEquals(false, setObject.isSubSet(set1));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsSubSet4()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet set1 = new InSet();
			int[] subSetArray = {};
			set1.setSetOfIntegers(subSetArray);
			setObject.setSetOfIntegers(setArray);
			assertEquals(false, setObject.isSubSet(set1));
		}
		
		//These methods test getComplement method
		@Test(expected=AssertionError.class) //negative test case
		public void testGetComplement1()
		{
			int[] setArray = {};
			setObject.setSetOfIntegers(setArray);
			int[] expectedArray = {1,2,3};
			assertEquals(false, setObject.getComplement());
		}
		@Test 
		public void testGetComplement2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			setObject.setSetOfIntegers(setArray);
			int[] complementedArray = setObject.getComplement();
			assertEquals(2, complementedArray[0]);
		}

		//These methods test union method
		@Test
		public void testUnion1()
		{
			InSet set1 = new InSet();
			InSet set2 = new InSet();
			int[] setArray1 = {1,3,4,5,6};
			set1.setSetOfIntegers(setArray1);
			int[] setArray2 = {1,2,3,7};
			set2.setSetOfIntegers(setArray2);
			int[] expectedSet = {1,3,4,5,6,2,7};
			assertArrayEquals(expectedSet, setObject.union(set1, set2));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testUnion2()
		{
			InSet set1 = new InSet();
			InSet set2 = new InSet();
			int[] setArray1 = {1,3,4,5,6};
			set1.setSetOfIntegers(setArray1);
			int[] setArray2 = {};
			set2.setSetOfIntegers(setArray2);
			int[] expectedSet = {1,3,4,5,6,2,7};
			assertArrayEquals(expectedSet, setObject.union(set1, set2));
		}
}
