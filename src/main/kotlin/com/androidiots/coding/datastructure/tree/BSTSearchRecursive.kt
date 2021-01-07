package com.androidiots.coding.datastructure.tree

class BSTSearchRecursive {

    fun search(root:Node?,value:Int){
        if(root == null){
            println("$value not found in the tree")
        }
        searchRecursively(currentNode = root, value = value)
    }
    private fun searchRecursively(currentNode:Node?, value:Int){
        if(currentNode == null){
            println("$value not found in the tree")
            return
        }
        if (value == currentNode.value){
            println("\uD83D\uDE03 $value found in the tree")
            return
        }
        if(value>currentNode.value){
            searchRecursively(currentNode = currentNode.rightChild, value = value)
        } else {
            searchRecursively(currentNode = currentNode.leftChild, value = value)
        }

    }
}