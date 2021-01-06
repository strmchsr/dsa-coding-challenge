package com.androidiots.coding.datastructure.tree

class BSTInsertionIterative {
    private var root: Node? = null
    fun setRoot(value: Int) {
        root = Node(value = value, leftChild = null, rightChild = null)
    }

    fun getRoot(): Node? {
        return root
    }

    private fun isEmpty(): Boolean {
        return root == null
    }

    fun insert(value: Int): Boolean {
        if (isEmpty()) {
            setRoot(value = value)
            return true
        }
        if (value == root?.value) {
            return false
        }

        var currentNode = root
        while (currentNode != null) {
            if (value == currentNode.value) {
                return false
            }
            var leftChild = currentNode.leftChild
            var rightChild = currentNode.rightChild
            if (value > currentNode?.value) {
                if (rightChild == null) {
                    rightChild = Node(value = value, leftChild = null, rightChild = null)
                    currentNode.rightChild = rightChild
                    return true
                }
                currentNode = currentNode.rightChild
            } else {
                if (leftChild == null) {
                    leftChild = Node(value = value, leftChild = null, rightChild = null)
                    currentNode.leftChild = leftChild
                    return true
                }
                currentNode = currentNode.leftChild
            }
        }
        return false
    }

    /*
     for testing
     */
    fun printBST(current: Node?) {
        if (current == null) {
            return
        }
        print(" ${current?.value} , ")
        printBST(current?.leftChild)
        printBST(current?.rightChild)
    }
}