package problem1;

import static org.junit.Assert.*;
import org.junit.Test;

public class inSetTest {
		
		//These methods test isMember method
		@Test
		public void testIsMember1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet setObject = new InSet(setArray);
			assertEquals(true, setObject.isMember(6));
		}
		@Test
		public void testIsMember2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet setObject = new InSet(setArray);
			assertEquals(false, setObject.isMember(20));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsMember3()
		{
			int[] setArray = {};
			InSet setObject = new InSet(setArray);
			assertEquals(false, setObject.isMember(20));
		}
		
		//These methods test size method
		@Test
		public void testSize1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet setObject = new InSet(setArray);
			assertEquals(9, setObject.size());
		}
		@Test
		public void testSize2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet setObject = new InSet(setArray);
			assertEquals(9, setObject.size());
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testSize3()
		{
			int[] setArray = {};
			InSet setObject = new InSet(setArray);
			assertEquals(7, setObject.size());
		}
		
		//These methods test isSubSet method
		@Test
		public void testIsSubSet1()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			int[] subSetArray = {1,6,8,7,10};
			InSet set1 = new InSet(setArray);
			InSet set2 = new InSet(subSetArray);
			assertEquals(true, set1.isSubSet(set2));
		}
		@Test
		public void testIsSubSet2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			int[] subSetArray = {1,6,8,7,20};
			InSet set1 = new InSet(setArray);
			InSet set2 = new InSet(subSetArray);
			assertEquals(false, set1.isSubSet(set2));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsSubSet3()
		{
			int[] setArray = {};
			int[] subSetArray = {1,6,8,7,10};
			InSet set1 = new InSet(setArray);
			InSet set2 = new InSet(subSetArray);
			assertEquals(false, set1.isSubSet(set2));
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testIsSubSet4()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			int[] subSetArray = {};
			InSet set1 = new InSet(setArray);
			InSet set2 = new InSet(subSetArray);
			assertEquals(false, set1.isSubSet(set2));
		}
		
		//These methods test getComplement method
		@Test(expected=AssertionError.class) //negative test case
		public void testGetComplement1()
		{
			int[] setArray = {};
			InSet setObject = new InSet(setArray);
			assertEquals(false, setObject.getComplement());
		}
		@Test 
		public void testGetComplement2()
		{
			int[] setArray = {1,3,6,8,4,9,25,7,10};
			InSet setObject = new InSet(setArray);
			int[] complementedArray = setObject.getComplement();
			assertEquals(2, complementedArray[0]);
		}

		//These methods test union method
		@Test
		public void testUnion1()
		{
			int[] setArray1 = {1,3,4,5,6};
			int[] setArray2 = {1,2,3,7};
			InSet set1 = new InSet(setArray1);
			InSet set2 = new InSet(setArray2);
			int expectedValue = 2;
			int actualValue = set1.union(set2).get(5);
			assertEquals(expectedValue, actualValue);
		}
		@Test(expected=AssertionError.class) //negative test case
		public void testUnion2()
		{
			int[] setArray1 = {1,3,4,5,6};
			int[] setArray2 = {};
			InSet set1 = new InSet(setArray1);
			InSet set2 = new InSet(setArray2);
			int expectedValue = 0;
			int actualValue = set1.union(set2).get(5);
			assertEquals(expectedValue, actualValue);
		}
}
