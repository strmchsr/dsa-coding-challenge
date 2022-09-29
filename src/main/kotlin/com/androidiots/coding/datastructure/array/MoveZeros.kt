package com.androidiots.coding.datastructure.array


/*
  We will keep read and write markers and point them to the end of the array. Let’s take an overview of the algorithm:

While moving the read pointer towards the start of the array:

If the value at the read pointer is 0, decrement the read pointer.
If the value at the read pointer is non-zero, set the value at the write pointer equal to the value at the read pointer, and decrement the write and read pointers.
Once, the read pointer reaches the 0^{th}
0
th

 index, start assigning zeros to all the values from the write pointer back to the 0^{th}
0
th

 index.

 */
class MoveZeros {

    fun moveZeroToLeft(input : IntArray){

    }

}