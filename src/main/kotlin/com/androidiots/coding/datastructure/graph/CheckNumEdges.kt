package com.androidiots.coding.datastructure.graph

import java.util.*

fun main(){
    val g = Graph(9)
    g.addEdge(0, 2)
    g.addEdge(0, 5)
    g.addEdge(2, 3)
    g.addEdge(2, 4)
    g.addEdge(5, 3)
    g.addEdge(5, 6)
    g.addEdge(3, 6)
    g.addEdge(6, 7)
    g.addEdge(6, 8)
    g.addEdge(6, 4)
    g.addEdge(7, 8)


    g.printGraph()
    println("Number of edges: " + numEdges(g))
}
fun numEdges(graph: Graph): Int {
   var count = 0
    var popedSet = mutableSetOf<Int>()
    for (value in 0 until graph.vertices){
        count += numberOfEdges(graph, value, popedSet)
    }
    return count
}

private fun numberOfEdges(graph: Graph, source : Int, poppedSet : MutableSet<Int>): Int{
    var stack = Stack<Int>()
    stack.push(source)
    var count = 0

    while (stack.isNotEmpty()){
        val currentNode = stack.pop()
        poppedSet.add(currentNode)
        var temp = graph.adjacencyList[currentNode].headNode
        while (temp != null){
            if(temp.data != source && !poppedSet.contains(temp.data)){
                count += 1
            }
            temp = temp.nextNode
        }
    }


    return count
}