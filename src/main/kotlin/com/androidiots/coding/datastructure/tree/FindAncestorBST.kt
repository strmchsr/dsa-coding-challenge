package com.androidiots.coding.datastructure.tree

fun findAncestorBST(root: Node, k: Int): ArrayList<Int> {
    return findPath(currentNode = root, k = k, arr = arrayListOf())
}

private fun findPath(currentNode: Node?, k: Int, arr: ArrayList<Int>): ArrayList<Int> {
    if(currentNode == null){
        return arr
    }
    if (currentNode?.value == k) {
        return arr
    }
    arr.add(currentNode.value)
    if (currentNode.value > k) {
        findPath(currentNode = currentNode.leftChild, k = k, arr = arr)
    } else {
        findPath(currentNode = currentNode.rightChild, k = k, arr = arr)
    }
    return arr
}