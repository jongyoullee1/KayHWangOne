/*======================================
  class MergeSortTester
  ALGORITHM:
  We divide the given array in two halves, and recursively run the sort function on those sub-arrays.
  These sub-arrays recursively get divided until they reach a length one, at which point they are merged together.
  In merging, the elements are sorted into correct ascending order. These smaller units continue to merge with their
  counterparts until finally the two halves are merged, in sorted order.
  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlog(n))
  Mean execution times for dataset of size n:
  Batch size: 5
  n=1       time: 1438675 nanoseconds
  n=10      time: 2164602 nanoseconds
  n=100     time: 3943333 nanoseconds
  ...
  n=1,000,000  time: 3536034947 nanoseconds
  ANALYSIS:
  The increase in times between the small cases of n and the really large case of n was reasonable.
  1000000=10000*100. If this algorithm ran in n^n time, the runtime for n=1000000 would be 10000 times
  the size of n=100. However, the runtime for n=1000000 was merely approx. 1000 times the length of
  n=100's time. This runtime supports our claim that merge sort runs in nlogn time.
  ======================================*/

public class MergeSortTester 
{
    
    /******************************
     * execution time analysis 
     * To measure time, we used nanoTime(). We started the timer, then ran our function, then ended the 
     timer right after the function completed. We then subtracted the start time from the stop time to
     get the elapsed time. We then ran MergeSort with many values of n to obtain our results.
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
    
    public static void getTime(int[] a, boolean first){
	long total = (long)0;
	for(int x = 0; x < 5; x++){
	    long startTime = System.nanoTime();  
	    MergeSort Tester = new MergeSort();
	    Tester.sort(a);
	    long stopTime = System.nanoTime();
	    long elapsedTime = stopTime - startTime;
	    total = total + elapsedTime;
	    Tester.mess(a);
	}
	long avg = total / (long)5.0;
	//For some reason, the first test we do is fudged up by something we haven't yet figured out. This boolean check lets us disregard the first test
	if (first){
	}
	else{
	    System.out.println( avg  + " nanoseconds taken for an array of length: " + a.length);
	}
    }
    
    public static void main( String[] args ) {
	int[] Test10B = GenArr(1,100);
	getTime(Test10B,true);
	int[] Test1 = GenArr(1,100);
	getTime(Test1,false);
	int[] Test10 = GenArr(10,100);
	getTime(Test10,false);
	int[] Test100 = GenArr(100,100);	
	getTime(Test100,false);
	int[] Test1000 = GenArr(1000,100);
	getTime(Test1000,false);
	int[] Test10000 = GenArr(10000,100);
	getTime(Test10000,false);
	int[] Test100000 = GenArr(100000,100);
	getTime(Test100000,false);
	int[] Test1000000 = GenArr(1000000,100);
	getTime(Test1000000,false);
	int[] Test10000000 = GenArr(10000000,100);
	getTime(Test10000000,false);


    }//end main

}//end class
