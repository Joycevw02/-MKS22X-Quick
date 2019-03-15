import java.util.*;
import java.io.*;
public class Quick{
  public static int partition (int[] data, int start, int end){
   //If end is equal to the start, return start
  if(end == start){
       return start;
  }

  //Set the pivot to a random index within the given range
  int pivot = (int)(Math.random() * 10) % (end -start + 1) + start;
  //Swap the value at the start with the pivot value
  int temp =  data[start];
  data[start] = data[pivot];
  data[pivot] = temp;
  pivot = start;
  //The tempStart and the tempEnd marks the spots where we are checking
  int tempStart = start + 1;
  int tempEnd = end;
  //Side keeps track of where an equal value moves - if its a odd number, it moves
  //to the left and if its an even number, it moves to the right
  int side = 0;

  //While there are still number in the range...
  while(tempStart != tempEnd){
  //If the value at the tempStart is greater than the pivot, swap the tempEnd
  //value and the tempStart value, you decrease the value of tempEnd
    if(data[tempStart] > data[pivot]){
      temp = data[tempStart];
      data[tempStart] = data[tempEnd];
      data[tempEnd] = temp;
      tempEnd --;
    }
   //If it is equal, then check the side. If its even, move it to the greater side
   //and if its odd, move it to the smaller side
    else if(data[tempStart] == data[pivot]){
      if (side % 2 == 0){
        temp = data[tempStart];
        data[tempStart] = data[tempEnd];
        data[tempEnd] = temp;
        tempEnd --;
      }
      else{
        tempStart ++;
      }
    }
   //Else (if its is less than the pivot), shift tempStart up one
    else {
      tempStart ++;
    }
  }

  //After it is sorted into the two sides, move the pivot into the correct place
  for(int i = start; i < end + 1; i ++){
    if(data[i] > data[pivot]){
     temp = data[i - 1];
     data[i - 1] = data[pivot];
     data[pivot] = temp;
     return i - 1;
   }
  }

  //If it gets to this point, then the pivot should be the last point
  temp = data[end];
  data[end] = data[pivot];
  data[pivot] = temp;

  return end;
  }

  public static int quickselect(int[] data, int k){
    if (k < 0 || k >= data.length){
      throw new IllegalArgumentException();
    }
    //Set the pivot value from partition
    int pivot = partition(data, 0, data.length - 1);
    //While pivot isn't equal to k....
    while (pivot != k){
      //If the pivot is greater than k, partition on the lower section
      if (pivot > k){
        pivot = partition(data, 0, pivot - 1);
      }
      //Else (meaning pivot is greater than k), partition on the higher section
      else{
        pivot = partition(data, pivot + 1, data.length - 1);
      }
    }
    //If the function gets here, then pivot should be equal to k, so return the
    //value at the pivot
    return data[pivot];
  }

  public static void quicksort(int[] data){
    sorthelp(data, 0, data.length - 1);
  }

  private static void sorthelp(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int pivot = partition(data, lo, hi);
    sorthelp(data, lo, pivot - 1);
    sorthelp(data, pivot + 1, hi);
  }
}
