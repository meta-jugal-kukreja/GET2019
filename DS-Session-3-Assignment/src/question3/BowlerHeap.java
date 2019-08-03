package question3;

/**
 * This class represents the heap of the bowlers
 * @author Jugal
 * Dated 08/03/2019
 */
public class BowlerHeap {
	
	private Bowler[] bowlersList;
	private int numberOfBowlers;
	private int size;
	
	/**
	 * Constructor to initialize the data members
	 * @param numberOfBowlers
	 */
	public BowlerHeap(int numberOfBowlers) {
		
		this.numberOfBowlers = numberOfBowlers;
		this.size = 0;
		bowlersList = new Bowler[this.numberOfBowlers + 1];
	}
	
	/**
	 * Returns the parent of the bowler at position
	 * @param position is the element's position whose parent is to be determined
	 * @return {int} position of the parent
	 */
	int returnParent(int position) 
    { 
        return position / 2; 
    } 

	/**
	 * Returns the left child of the bowler at position
	 * @param position is the element's position whose left child is to be determined
	 * @return {int} position of the left child
	 */
	int returnLeftChild(int position) 
    { 
        return (2 * position); 
    } 
	
	/**
	 * Returns the right child of the bowler at position
	 * @param position is the element's position whose right child is to be determined
	 * @return {int} position of the right child
	 */
	int returnRightChild(int position) 
    { 
        return ((2 * position) + 1); 
    }
	
	/**
	 * This method swaps the values the bowlersList array at two positions
	 * @param position1 is the first position
	 * @param position2 is the second position
	 */
	void swapBowlers(int position1, int position2)
	{
		Bowler temp = bowlersList[position1];
		bowlersList[position1] = bowlersList[position2];
		bowlersList[position2] = temp;
	}
	
	/**
	 * This method checks whether an element is at leaf of the heap or not
	 * @param position is the element's position which is to be checked
	 * @return {boolean}
	 */
	boolean isLeaf(int position) 
    { 
        if (position > (size / 2) && position < size) { 
            return true; 
        } 
        return false; 
    } 
	
	/**
	 * This method heapifies the heap at a particular position
	 * @param position is the position at which heapify is to be performed
	 */
	void maxHeapify(int position) 
    { 
        if (isLeaf(position)) 
            return; 
        
        if ((bowlersList[position].getNumberOfBallLeft() < bowlersList[returnLeftChild(position)].getNumberOfBallLeft()) ||  
            (bowlersList[position].getNumberOfBallLeft() < bowlersList[returnRightChild(position)].getNumberOfBallLeft())) 
        { 
            if (bowlersList[returnLeftChild(position)].getNumberOfBallLeft() > bowlersList[returnRightChild(position)].getNumberOfBallLeft()) 
            { 
                swapBowlers(position, returnLeftChild(position)); 
                maxHeapify(returnLeftChild(position)); 
            } 
            else 
            { 
                swapBowlers(position, returnRightChild(position)); 
                maxHeapify(returnRightChild(position)); 
            } 
        } 
    } 
	
	/**
	 * This method inserts a bowler in the heap
	 * @param bowler is the bowler to be inserted
	 */
	void insertBowler(Bowler bowler) 
    { 
		bowlersList[++size] = bowler; 
        int current = size; 
        while ((current != 1) && (bowlersList[current].getNumberOfBallLeft() > bowlersList[returnParent(current)].getNumberOfBallLeft())) 
        { 
            swapBowlers(current, returnParent(current)); 
            current = returnParent(current); 
        }

    } 

	/**
	 * This method extracts the bowler which has the maximum number of balls
	 * @return {Bowler}
	 */
	Bowler extractBowler() 
    { 
        Bowler poppedBowler = bowlersList[1]; 
        bowlersList[1] = bowlersList[size--]; 
        maxHeapify(1);
        return poppedBowler; 
    } 
	
}
