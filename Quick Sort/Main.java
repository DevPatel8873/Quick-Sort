//Dev Patel
//Honors data Structures
//Quicksort sorting lab

class Main {
  //Global iteration variable 
  public static int iterations = 0;
  
  public static void main(String[] args) {  
    //Creates array of 1000 or 2000 random integers
    // *I changed the length of the array from 1000 to 2000 using the method

    
    int[] testArr1 = createArr(1, 250, 2000);
    //Creates sorted array
    int[] testArr2 = quickSortRec(testArr1, 0, testArr1.length);
    //Creates a reverse sorted array
    int[] testArr3 = reverseArr(testArr2);

    System.out.println("Randomized Array " + testArr1.length + " elements Comparisions: " + iterations);
    iterations = 0;
    testArr2 = quickSortRec(testArr2, 0, testArr2.length);
    
    System.out.println("Sorted Array " + testArr1.length + " elements Comparisions: " + iterations);
    iterations = 0;
    testArr2 = quickSortRec(testArr3, 0, testArr3.length);
    
    System.out.println("Reverse Sorted Array " + testArr1.length + " elements Comparisions: " + iterations);

   


    
  }
  
  //Returns array of random integers in the bounding and of length len
  public static int[] createArr(int lowBound, int highBound, int len)
  {
    int[] arr = new int[len];
    for(int i = 0; i < len; i++)
    {
      arr[i] = (int)(Math.random() * highBound) + lowBound;
    }
    return arr;
  }

  //Prints inputted array
  public static void printArr(int[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
  }
  //Reverses inputted array
  public static int[] reverseArr(int[] arr)
  {
    int[] reversedArr = new int[arr.length];
    for(int i = 0; i < arr.length;i++)
    {
      reversedArr[reversedArr.length - 1 - i] = arr[i];
    }
    return reversedArr;
  }
  //Quick sort algorithm for one iteration
  public static int quickSort(int[] arr, int lowBound, int highBound)
  {
    //Stores the pivot value
    int pivotVal = arr[lowBound];
    int newLow = lowBound;
    //Iterates through the sub array making comparisons to the pivot value
    for(int i = lowBound; i < highBound; i++)
    {
      iterations++;
      //if the element is smaller than the pivot value then in swaps the element and the sub arrays lower bound
      if(arr[i] < pivotVal)
      {
        //Swaps arr[i] and arr[newLow]
        int temp = arr[newLow];
        arr[newLow] = arr[i];
        arr[i] = temp;

        newLow++;
      }
    }
    //Swaps pivotVal and arr[newLow]
    int temp = arr[newLow];
    arr[newLow] = pivotVal;
    pivotVal = temp;

    return(newLow);
  }
  //Recursive quick sort returns the sorted array
  public static int[] quickSortRec(int[] arr, int lowBound, int highBound)
  {
    if(lowBound < highBound)
    {
      int pivot = quickSort(arr, lowBound, highBound);
      quickSortRec(arr, lowBound, pivot);
      quickSortRec(arr, pivot + 1, highBound);
    }
    return arr;
  }
}