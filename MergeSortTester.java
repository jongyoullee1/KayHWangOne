/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 
  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{
    
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/

    //Generates a random array of n length with a range of values from 0 to ran
    public static int[] GenArr(int n, int ran){
	int[] retArr =  new int[n];
	for(int x = 0; x < retArr.length; x++){
	    retArr[x] = (int)(Math.random() * ran);
	}
	return retArr;
    }

    //Helper method for displaying an array
    //Credit goes to Mr.Brown's skeleton file
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
	

    
    public static void main( String[] args ) 
    {
	//This is just the Test for the Generator, this is the basis for the rest of the tests!
	int[] genTest = GenArr(10,100);
	printArray(genTest);
	MergeSort Tester = new MergeSort();
	printArray(Tester.sort(genTest));
	

    }//end main

}//end class
