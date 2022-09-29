package com.androidiots.coding.datastructure.array

fun calendarMatching(
    calendar1: List<List<String>>,
    dailyBounds1: List<String>,
    calendar2: List<List<String>>,
    dailyBounds2: List<String>,
    meetingDuration: Int
): List<List<String>> {
    var updatedCal1 = updateCalendars(calendar1, dailyBounds1)
    var updatedCal2 = updateCalendars(calendar2, dailyBounds2)
    var mergedCal = mergeCalendar(updatedCal1, updatedCal2)
    var flattend = flattened(mergedCal)

    return findAvailableSlot(flattend,meetingDuration)
}

/**
 *
 */
fun updateCalendars(calendar: List<List<String>>, dailyBounds: List<String>): List<List<Int>> {
    var updatedCal = calendar.toMutableList()
    updatedCal.add(0, listOf("0:00", dailyBounds[0]))
    updatedCal.add(listOf(dailyBounds[1], "23:59"))

    //convert the string time to minutes
    return updatedCal.map { item -> item.map { t -> timeToMinutes(t) } }
}

fun mergeCalendar(calendar1: List<List<Int>>, calendar2: List<List<Int>>): List<List<Int>> {
    var mergedCal = mutableListOf<List<Int>>()
    var i = 0
    var j = 0
    while (i < calendar1.size && j < calendar2.size) {
        val meeting1 = calendar1[i]
        val meeting2 = calendar2[j]
        if (meeting1[0] < meeting2[0]) {
            mergedCal.add(meeting1)
            i++
        } else {
            mergedCal.add(meeting2)
            j++
        }
    }
    while (i < calendar1.size) {
        mergedCal.add(calendar1[i])
        i++
    }
    while (j < calendar2.size) {
        mergedCal.add(calendar1[j])
        j++
    }
    return mergedCal
}

fun flattened(calendar: List<List<Int>>) : List<List<Int>>{
    var updatedCal = mutableListOf<List<Int>>()
    updatedCal.add(calendar[0])
    for (i in 1 until calendar.size){
        val currentMeeting = calendar[i]
        val previousMeeting = updatedCal[updatedCal.size-1]
        val (currentStart, currentEnd) = currentMeeting
        val (preStart, preEnd) = previousMeeting
        if(preEnd>=currentStart){
            val newPreviousMeeting = listOf(preStart, maxOf(preEnd,currentEnd))
            updatedCal[updatedCal.size-1] = newPreviousMeeting
        } else {
            updatedCal.add(currentMeeting)
        }

    }
    return updatedCal
}

fun findAvailableSlot(calendar: List<List<Int>>, duration : Int) : List<List<String>>{
    var availableSlots = mutableListOf<List<Int>>()
    var previousMeet = calendar[0]
    for (i in 1 until calendar.size){
        val (start, end ) = calendar[i]
        if (start - previousMeet[1] >=duration){
            availableSlots.add(listOf(previousMeet[1],start))
        }
        previousMeet = calendar[i]
    }
    return availableSlots.map { item -> item.map { t -> minutesToTime(t) } }
}

fun timeToMinutes(time: String): Int {
    var timeSplit = time.split(":")
    var hour: Int = timeSplit[0].toInt()
    var minutes: Int = timeSplit[1].toInt()
    return (hour * 60) + minutes
}

fun minutesToTime(minutes : Int): String{
    val hour = minutes/60
    val minute = minutes % 60
    var hrStr = hour.toString()
    if(hour < 10){
        hrStr = "0$hrStr"
    }

    var minStr = minute.toString()
    if(minute < 10){
        minStr = "0$minStr"
    }
    return "$hrStr:$minStr"
}

fun main() {
    val calendar1 = listOf<List<String>>(
        listOf("9:00", "10:30"),
        listOf("12:00", "13:00"),
        listOf("16:00", "18:00")
    )
    val dailyBounds1 = listOf("9:00", "20:00")
    val calendar2 = listOf<List<String>>(
        listOf("10:00", "11:30"),
        listOf("12:30", "14:30"),
        listOf("14:30", "15:00"),
        listOf("16:00", "17:00")
    )
    val dailyBounds2 = listOf("10:00", "18:30")
    val meetingDuration = 30
    val expected = listOf<List<String>>(
        listOf("11:30", "12:00"),
        listOf("15:00", "16:00"),
        listOf("18:00", "18:30")
    )
    val output = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration)
    println(output)
}
