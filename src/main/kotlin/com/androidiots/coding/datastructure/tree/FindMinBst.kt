package com.androidiots.coding.datastructure.tree

fun findMin(root: Node): Int? {
    var minValue: Int?= 0
    if (root.leftChild == null) {
        return root.value
    }

    var currentMinNode : Node?= root
    while (currentMinNode?.leftChild != null) {
        minValue = currentMinNode?.leftChild?.value
        currentMinNode = currentMinNode.leftChild
    }
    return minValue
}
