package com.androidiots.coding.datastructure.array

/**
 *
Imagine that you're a teacher who's just graded the final exam in a class. You
have a list of student scores on the final exam in a particular order (not
necessarily sorted), and you want to reward your students. You decide to do so
fairly by giving them arbitrary rewards following two rules:
All students must receive at least one reward.

Any given student must receive strictly more rewards than an adjacent
student (a student immediately to the left or to the right) with a lower
score and must receive strictly fewer rewards than an adjacent student with
a higher score.


Write a function that takes in a list of scores and returns the minimum number
of rewards that you must give out to students to satisfy the two rules.


You can assume that all students have different scores; in other words, the
scores are all unique.
= [8, 4, 2, 1, 3, 6, 7, 9, 5]
25
<span class="CodeEditor-promptComment">// you would give out the following rewards: [4, 3, 2, 1, 2, 3, 4, 5, 1]</span>

 Approach
 1. Naive 


 */


fun minRewards(scores: List<Int>): Int {
    var startingIndex = 1
    var rewards = mutableListOf<Int>()
    scores.forEach { _ ->
        rewards.add(1)
    }

    for (i in startingIndex until scores.size){
        if (scores[i-1]<scores[i]){
            rewards[i] = rewards[i-1]+1
        }
    }

    for (index in  scores.size -2 downTo 0){
        if(scores[index]>scores[index+1]){
             rewards[index] = maxOf(rewards[index], rewards[index+1]+1)
        }
    }
    var sum = 0
    println(rewards)
    rewards.forEach { item ->
        sum+=item
    }
    return sum
}

fun main() {
    println("Min rewards for scores (8,4,2,1,3,6,7,9,5) is ${minRewards(listOf(8,4,2,1,3,6,7,9,5))}")
}