public class Quick{
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.*/
 public int partition (int[] data, int start, int end){
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
  //
  for(int i = start; i < end + 1; i ++){
    if(data[i] > data[pivot]){
     temp = data[i - 1];
     data[i - 1] = data[pivot];
     data[pivot] = temp;
     return i - 1;
   }
  }
   temp = data[end];
   data[end] = data[pivot];
   data[pivot] = temp;

    return end;
  }
}
