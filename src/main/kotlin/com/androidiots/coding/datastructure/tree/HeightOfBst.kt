package com.androidiots.coding.datastructure.tree

fun findHeight(root: Node): Int {

    return findNodeHeight(currentNode = root)
}

private fun findNodeHeight(currentNode: Node): Int {
    var leftChildHeight = 0
    var rightChildHeight = 0
    if (currentNode.leftChild != null) {
        leftChildHeight = findNodeHeight(currentNode = currentNode.leftChild!!)
    }
    if (currentNode.rightChild != null) {
        rightChildHeight = findNodeHeight(currentNode = currentNode.rightChild!!)
    }
    return if (currentNode.leftChild != null && currentNode.rightChild != null) {
        if (leftChildHeight > rightChildHeight) {
            leftChildHeight + 1
        } else {
            rightChildHeight + 1
        }
    } else if (currentNode.leftChild != null) {
        leftChildHeight + 1
    } else if (currentNode.rightChild != null) {
        rightChildHeight + 1
    } else {
        0
    }


}