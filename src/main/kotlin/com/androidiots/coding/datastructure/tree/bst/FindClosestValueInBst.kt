package com.androidiots.coding.datastructure.tree.bst

import kotlin.math.abs


fun findClosestValueInBst(tree: BST, target: Int): Int {
    // Write your code here.
    return findClosestValueHelper(tree,target, Int.MAX_VALUE)
}

fun findClosestValueHelper(tree: BST, target: Int, currentCloset: Int): Int {
    var closest = currentCloset
    if (abs(target - tree.value)< abs(target - closest)){
        closest = tree.value
    }
    return if(target < tree.value && tree.left != null){
        findClosestValueHelper(tree.left!!,target,closest)
    } else if(target > tree.value && tree.right != null){
        findClosestValueHelper(tree.right!!,target,closest)
    } else {
        closest
    }

}

fun main() {
    val tree = BST(10)
    tree.left = BST(5)
    tree.left!!.left = BST(2)
    tree.left!!.left!!.left = BST(1)
    tree.left!!.right = BST(5)
    tree.right = BST(15)
    tree.right!!.left = BST(13)
    tree.right!!.left!!.right = BST(14)
    tree.right!!.right = BST(22)

    val result = findClosestValueInBst(tree, 12)
}

