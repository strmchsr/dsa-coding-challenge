package com.androidiots.coding.datastructure.tree

fun findNodesAtKthDistance(root : Node, k : Int):ArrayList<Int>{
    return findNodes(currentNode = root, k = k,currArr = arrayListOf())
}

private fun findNodes(currentNode : Node?, k : Int, currArr : ArrayList<Int>) : ArrayList<Int>{
    if(currentNode == null){
        return currArr
    }
    if(k == 0){
        currArr.add(currentNode.value)
    } else {
        findNodes(currentNode = currentNode.leftChild,k = k-1, currArr)
        findNodes(currentNode = currentNode.rightChild,k = k-1, currArr)
    }


    return currArr
}