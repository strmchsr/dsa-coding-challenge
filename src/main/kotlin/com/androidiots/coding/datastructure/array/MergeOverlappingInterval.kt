package com.androidiots.coding.datastructure.array


/**
 * sort the array by starting time
 */
fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    // Write your code here.
    //    sort the array by starting time
    var sortedIntervals = intervals.toMutableList().sortedWith(Comparator { o1, o2 -> o1[0].compareTo(o2[0]) })
    sortedIntervals = sortedIntervals.map {
        it.toMutableList()
    }
    val mergedInterval = mutableListOf<MutableList<Int>>()
    var currentInterval = sortedIntervals[0]
    mergedInterval.add(currentInterval)
    for (nextInterval in sortedIntervals){
        val (currentIntervalStart, currentIntervalEnd) = currentInterval
        val (nextIntervalStart, nextIntervalEnd) = nextInterval

        if(currentIntervalEnd>=nextIntervalStart) {
            currentInterval[1] = maxOf(currentIntervalEnd,nextIntervalEnd)
        } else {
            currentInterval = nextInterval
            mergedInterval.add(currentInterval)
        }
    }
    return mergedInterval
}
