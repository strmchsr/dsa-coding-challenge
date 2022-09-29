package com.androidiots.coding.datastructure.array

object CheckMaxMin {

    fun maxMin(arr : IntArray):IntArray{

        var maxIdx = arr.size -1
        var minIdx = 0
        val maxElement = arr[maxIdx]+1

        for (idx in arr.indices){
            if(idx % 2 == 0){
                arr[idx] += (arr[maxIdx] % maxElement) * maxElement
                maxIdx--
            } else {
                arr[idx] += (arr[minIdx] % maxElement) * maxElement
                minIdx++
            }
        }

        for (idx in arr.indices){
            arr[idx] = arr[idx]/maxElement
            print("${arr[idx] },")
        }


        return arr
    }
}

fun main() {
    CheckMaxMin.maxMin(intArrayOf(1,5,7,8))
}

/*
This solution is very smart. We actually store two elements at one index mathematically. The original element is stored as the remainder, while the max/min element is stored as the multiplier. The following line achieves this;

arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
Here, arr[maxId] is stored as the multiplier. Whereas, arr[i] is stored as the remainder. For example in the array, [1, 2, 3, 4, 5, 6, 7, 8, 9], the maxElem which is any element greater than the maximum element in the array, in this case, is 10 and 91 is stored at index 0. With 91, we can get the original element, 1, using the expression 91%10 as well as the new element, 9, using the expression 91/10.

This allows us to swap the numbers in place without losing any data or using any extra space. To get the final array, we simply divide each element by maxElem as done in the last for loop.

It should be noted that very large or very small values such as Integer.MAX_VALUE or Integer.MIN_VALUE can potentially cause issues with the mathematical formula we are using in this solution. This would result in loss of data.
 */