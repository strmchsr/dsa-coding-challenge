package com.androidiots.coding.datastructure.graph

import java.util.*

fun main(){
    var graph = Graph(5)
    graph.addEdge(0,1);
    graph.addEdge(0,4);
    graph.addEdge(1,2);
    graph.addEdge(3,4);

    graph.printGraph()
    println("rootBetweenNodes : ${rootBetweenNodes(graph , 4,3)}")
}
fun rootBetweenNodes(graph : Graph, source : Int, dest : Int): Boolean{
    val visited = BooleanArray(graph.vertices)
    return pathExist(graph, source, dest, visited)
}

private fun pathExist(graph : Graph, source : Int, dest : Int, visited : BooleanArray):Boolean{
    if(source == dest){
        return true
    }
    var queue : Queue<Int> = LinkedList()
    queue.add(source)
    visited[source] = true
    while (queue.isNotEmpty()){
        val currentNode = queue.poll()
        var temp = graph.adjacencyList[currentNode].headNode
        while (temp != null){
            if(temp.data == dest){
                return true
            }
            if(!visited[temp.data]){
                queue.add(temp.data)
                visited[temp.data] = true
            }
            temp = temp.nextNode
        }
    }

    return false
}