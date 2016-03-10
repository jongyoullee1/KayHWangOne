/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 1438675nanoseconds
  n=10      time: 5164602nanoseconds
  n=100     time: 3943333nanoseconds
  ...
  n=1,000,000  time: 3536034947nanoseconds
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
  

    
    public static void main( String[] args ) 
    {
  //This is just the Test for the Generator, this is the basis for the rest of the tests!
  long startTime = System.nanoTime();   
  int[] genTest = GenArr(1000000,100);
  printArray(genTest);
  MergeSort Tester = new MergeSort();
  printArray(Tester.sort(genTest));
  long stopTime = System.nanoTime();
  long elapsedTime = stopTime - startTime;
  System.out.println(elapsedTime);
  

    }//end main

}//end class
