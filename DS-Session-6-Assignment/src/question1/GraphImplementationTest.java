package question1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of GraphImplementation class
 * @author Jugal
 * Dated 08/09/2019
 */
public class GraphImplementationTest {

	private static GraphImplementation graph;

	//This method initializes the graph before the tests begin
	@Before
	public void initialize()
	{
		graph = new GraphImplementation(3);
		graph.addEdgeToTheGraph(0, 1, 1);
		graph.addEdgeToTheGraph(0, 2, 2);
		graph.addEdgeToTheGraph(1, 2, 3);
	}
	
	//Test methods
	@Test
	public void testIsConnected()
	{
		assertEquals(true, graph.isConnected());
	}
	
	@Test
	public void testGetReachableVertices()
	{
		List<Integer> reachableVertives = graph.getReachableVertices(0);
		assertEquals((Integer)0, reachableVertives.get(0));
		assertEquals((Integer)1, reachableVertives.get(1));
		assertEquals((Integer)2, reachableVertives.get(2));
	}
	
	@Test
	public void testGetMST()
	{
		int[][] mst = graph.getMST();
		assertEquals((Integer)1, (Integer)mst[0][1]);
		assertEquals((Integer)2, (Integer)mst[0][2]);
	}
	
	@Test
	public void testGetShortestPath()
	{
		assertEquals((Integer)2, (Integer)graph.getShortestPath(0, 2));
		assertEquals((Integer)1, (Integer)graph.getShortestPath(0, 1));
		assertEquals((Integer)3, (Integer)graph.getShortestPath(1, 2));
	}

}
