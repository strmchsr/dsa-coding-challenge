package com.androidiots.coding.datastructure.graph

import java.util.*


fun main(){
    var graph = Graph(5)
    graph.addEdge(0,1);
    graph.addEdge(0,4);
    graph.addEdge(1,2);
    graph.addEdge(3,4);

    graph.printGraph()
    println("BFS : ${BFS(graph)}")
}

fun BFS(graph: Graph): String? {
     var visited = BooleanArray(graph.vertices)
    var result = ""
    for (value in 0 until graph.vertices){
        if(!visited[value]){
            result += bfsVisit(value, graph, visited)
        }
    }
    return result
}

private fun bfsVisit(source: Int, graph: Graph, visited: BooleanArray): String {
    var result = ""
    var queue : Queue<Int> = LinkedList()
    queue.add(source)
    visited[source] = true

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        result += currentNode.toString()
        var adjacencyList = graph.adjacencyList[currentNode]
        var temp = adjacencyList.headNode
        while (temp != null) {
            if (!visited[temp.data]) {
                queue.add(temp.data)
                visited[temp.data] = true
            }

            temp = temp.nextNode
        }
    }
    return result
}