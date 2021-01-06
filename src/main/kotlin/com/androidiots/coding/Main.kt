package com.androidiots.coding

import com.androidiots.coding.datastructure.tree.BSTInsertionIterative
  fun main(args : Array<String>){
    var bst = BSTInsertionIterative()
    bst.insert(2)
    bst.insert(8)
    bst.insert(3)
    bst.insert(9)
    bst.insert(12)
    bst.insert(7)
    bst.insert(5)
    bst.insert(3)
    bst.printBST(bst.getRoot())
  }
