package com.androidiots.coding.datastructure.tree

fun findKthMax(root: Node, k: Int): Int? {
    var inOrderTraversal = arrayListOf<Int>()
    println("In order Traversal: ${inOrderTraversal(currentNode = root, arr = inOrderTraversal)}")

    return inOrderTraversal[inOrderTraversal.size - k]
}

fun inOrderTraversal(currentNode: Node?, arr: ArrayList<Int>): ArrayList<Int> {
    if (currentNode == null) {
        return arr
    }
    if (currentNode.leftChild != null) {
        inOrderTraversal(currentNode = currentNode.leftChild, arr = arr)
    }
    arr.add(currentNode.value)
    println("In order Traversal curr Array: $arr")
    if (currentNode.rightChild != null) {
        inOrderTraversal(currentNode = currentNode.rightChild, arr = arr)
    }

    return arr
}