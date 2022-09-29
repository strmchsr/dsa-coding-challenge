package com.androidiots.coding.datastructure.array

import java.util.*
import kotlin.collections.ArrayList

/*
Given a set of distinct numbers, find all of its permutations.

Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:

{1, 2, 3}
{1, 3, 2}
{2, 1, 3}
{2, 3, 1}
{3, 1, 2}
{3, 2, 1}
This problem follows the Subsets pattern and we can follow a similar Breadth First Search (BFS) approach. However, unlike Subsets, every permutation must contain all the numbers.

Let’s take the example-1 mentioned above to generate all the permutations. Following a BFS approach, we will consider one number at a time:

If the given set is empty then we have only an empty permutation set: []
Let’s add the first element (1), the permutations will be: [1]
Let’s add the second element (3), the permutations will be: [3,1], [1,3]
Let’s add the third element (5), the permutations will be: [5,3,1], [3,5,1], [3,1,5], [5,1,3], [1,5,3], [1,3,5]
Let’s analyze the permutations in the 3rd and 4th steps. How can we generate permutations in the 4th step from the permutations of the 3rd step?

If we look closely, we will realize that when we add a new number (5), we take each permutation of the previous step and insert the new number in every position to generate the new permutations. For example, inserting ‘5’ in different positions of [3,1] will give us the following permutations:

Inserting ‘5’ before ‘3’: [5,3,1]
Inserting ‘5’ between ‘3’ and ‘1’: [3,5,1]
Inserting ‘5’ after ‘1’: [3,1,5]


 */


object Permutation {

    fun findPermutation(input: IntArray): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        var permutations: Queue<List<Int>> = LinkedList()
        permutations.add(ArrayList())
        for (number in input) {
            val size = permutations.size
            for (i in 0 until permutations.size) {
                var oldPermutation = permutations.poll()
                for (i in 0..oldPermutation.size) {
                    var newPermutation = ArrayList(oldPermutation)
                    newPermutation.add(i, number)
                    if (newPermutation.size == input.size) {
                        result.add(newPermutation)
                    } else {
                        permutations.add(newPermutation)
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    println(Permutation.findPermutation(intArrayOf(1,3,5)))
}