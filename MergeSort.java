/*======================================
Shaik Abiden, Sebastian Dittgen
APCS2 pd9
HW11 -- Wrapping It Up
2016-03-10

  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  Similar to how we did so in class, I'd solve the shuffled deck problem recursively by breaking down the work into halves.
  The code would have a base case of one card, which, when you do have one card left, you return that card back up.
  Once this is done, the initial function call recieves the two single cards and sorts them by comparing the first card and
  returns its pile back up. When the function recieves large halves to compare, it would do so by comparing the first two cards
  of each pile, putting them aside, and moving on until you have none left or one stack left, in which case you just pile the stack on.
  If this is done so correctly, the deck should become sorted through a assembly line sort of way.


  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int alen = a.length;
	int blen = b.length;
	int aindx = 0;
	int bindx = 0;
	int[] retarr = new int[alen + blen];
	int cntr = retarr.length;
  
	for(int x = 0; x < cntr; x++){
	    if (aindx >= alen){
		retarr[x] = b[bindx] ;
		bindx++;
	    }
	    else if (bindx >= blen){
		retarr[x] = a[aindx];
		aindx++;
	    }
	    else{
		if(b[bindx] < a[aindx]){
		    retarr[x] = b[bindx] ;
		    bindx++;
		}
		else{
		    retarr[x] = a[aindx] ;
		    aindx++;
		} 
	    }
	}
	return retarr;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ){
	if (arr.length == 1){
	    return arr;
	}
	else{
	    int middle = arr.length / 2;
	    int[] arr1 = new int[middle];
	    int[] arr2 = new int[arr.length - middle];
	    int indx1 = 0;
	    int indx2 = 0;
	    for(int x = 0; x < middle; x++){
		arr1[indx1] = arr[x];
		indx1++;
	    }
	    for(int y = middle; y < arr.length; y++){
		arr2[indx2] = arr[y];
		indx2++;
	    }		
	    return merge(sort(arr1),sort(arr2));	     
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );

    }//end main()

}//end class MergeSort
