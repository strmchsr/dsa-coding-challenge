package com.androidiots.coding

import com.androidiots.coding.datastructure.tree.BSTDeletion
import com.androidiots.coding.datastructure.tree.BSTInsertionRecursive
import com.androidiots.coding.datastructure.tree.BSTSearchRecursive

fun main(args: Array<String>) {
    var bst = BSTInsertionRecursive()
    bst.insert(2)
    bst.insert(8)
    bst.insert(3)
    bst.insert(9)
    bst.insert(12)
    bst.insert(7)
    bst.insert(5)
    bst.insert(3)
    bst.printBST(bst.getRoot())

    var bstSearchRecursive = BSTSearchRecursive()
    bstSearchRecursive.search(root = bst.getRoot(), value = 1)

    var bstDeletion = BSTDeletion(bst = bst)
    bstDeletion.delete(root = bst.getRoot(), value = 5)
    bst.printBST(bst.getRoot())
}
