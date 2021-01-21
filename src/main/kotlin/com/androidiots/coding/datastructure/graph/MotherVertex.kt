package com.androidiots.coding.datastructure.graph

import java.util.*
fun main(){
    val g = Graph(4)
    g.addEdge(0, 1)
    g.addEdge(1, 2)
    g.addEdge(3, 0)
    g.addEdge(3, 1)
    g.printGraph()
    println("Mother Vertex is: " + findMotherVertex(g))
}
fun findMotherVertex(graph: Graph): Int{

    for (value in 0 until graph.vertices){
        val visited = BooleanArray(graph.vertices)
        var isAllVisited = true
        DFS(graph,visited,value)
        for (isVisited in visited){
            if (!isVisited){
                isAllVisited = false
                break
            }
        }
        if(isAllVisited){
            return value
        }
    }

    return -1

}

private fun DFS(graph: Graph, visited : BooleanArray, source : Int){
    visited[source] = true
    var stack = Stack<Int>()
    stack.push(source)
    while (stack.isNotEmpty()){
        val currentVertex = stack.pop()
        var temp = graph.adjacencyList[currentVertex].headNode
        while (temp != null){
            if(!visited[temp.data]){
                visited[temp.data] = true
                stack.push(temp.data)
            }
            temp = temp.nextNode
        }
    }
}