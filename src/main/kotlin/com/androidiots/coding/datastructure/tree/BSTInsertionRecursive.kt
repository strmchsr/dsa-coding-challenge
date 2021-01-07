package com.androidiots.coding.datastructure.tree

class BSTInsertionRecursive {
    private var root: Node? = null
    fun setRoot(value: Int?, leftChild : Node? = null, rightChild:Node?=null) {
        if(value == null){
            root = null
            return
        }
        root = Node(value = value, leftChild = leftChild, rightChild = rightChild)
    }

    fun getRoot(): Node? {
        return root
    }

    private fun isEmpty(): Boolean {
        return root == null
    }

    fun insert(value: Int): Boolean {
        root = insertRecursively(currentNode = root, value = value)
        return true
    }

    private fun insertRecursively(currentNode: Node?, value: Int): Node {
        if (currentNode == null) {
            return Node(value = value, leftChild = null, rightChild = null)
        }
        if (currentNode.value == value) {
            return currentNode
        }
        if (value > currentNode.value) {
            currentNode.rightChild = insertRecursively(currentNode = currentNode.rightChild, value = value)
        } else {
            currentNode.leftChild = insertRecursively(currentNode = currentNode.leftChild, value = value)
        }
        return currentNode
    }

    /*
     for testing
     */
    fun printBST(current: Node?) {
        if (current == null) {
            return
        }
        println(" ${current?.value} , ")
        printBST(current?.leftChild)
        printBST(current?.rightChild)
    }
}