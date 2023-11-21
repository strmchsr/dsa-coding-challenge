package com.androidiots.coding.datastructure.tree.bst

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int): BST {
        var currentNode = this
        while (true) {
          if (value < currentNode.value && currentNode.left != null){
              currentNode = currentNode.left!!
          } else if(value >= currentNode.value && currentNode.right != null ){
              currentNode = currentNode.right!!
          } else if (value < currentNode.value){
              currentNode.left = BST(value)
              break
          } else if (value> currentNode.value){
              currentNode.right = BST(value)
              break
          }
        }
        return this
    }

    fun contains(value: Int): Boolean {
        var currentNode: BST? = this
        while (currentNode !== null) {
            if (value > currentNode.value ) {
                currentNode = currentNode.right
            } else if (value < currentNode.value ) {
                currentNode = currentNode.left
            } else {
                return true
            }
        }
        return false
    }

    fun remove(value: Int, parent: BST? = null): BST {
        var parentNode = parent
        var currentNode : BST? = this
        while (currentNode !== null){
            if (value < currentNode.value){
                parentNode = currentNode
                currentNode = currentNode.left
            } else if (value > currentNode.value){
                parentNode = currentNode
                currentNode = currentNode.right
            } else {
                if (currentNode.left !== null && currentNode.right !== null){
                    currentNode.value = currentNode.right!!.getMinValue()
                    currentNode.right!!.remove(currentNode.value, currentNode)

                } else if (parentNode == null){
                    if (currentNode.left !== null){
                        currentNode.value = currentNode.left!!.value
                        currentNode.right = currentNode.left!!.right
                        currentNode.left = currentNode.left!!.left
                    } else if(currentNode.right !== null){
                        currentNode.value = currentNode.right!!.value
                        currentNode.left = currentNode.right!!.left
                        currentNode.right = currentNode.right!!.right
                    } else {

                    }
                }
                else if(parentNode.left == currentNode){
                    parentNode.left = if (currentNode.left !== null) currentNode.left else currentNode.right
                } else if(parentNode.right == currentNode){
                    parentNode.right = if (currentNode.left !== null) currentNode.left else currentNode.right
                }
                break
            }
        }
        return this
    }

    private fun getMinValue():Int{
        return if (this.left == null){
            this.value
        } else {
            this.left!!.getMinValue()
        }
    }
}

fun main() {
    val root = BST(10)
    root.left = BST(5)
    root.left!!.left = BST(2)
    root.left!!.left!!.left = BST(1)
    root.left!!.right = BST(5)
    root.right = BST(15)
    root.right!!.left = BST(13)
    root.right!!.left!!.right = BST(14)
    root.right!!.right = BST(22)

    root.insert(12)
    println(root.right!!.left!!.left!!.value)
    assert(root.right!!.left!!.left != null)
    assert(root.right!!.left!!.left!!.value == 12)

    root.remove(10)
    println(root.contains(10))
    println(root.contains(15))
    println(root.value)
    assert(!root.contains(10))
    assert(root.value == 12)

    assert(root.contains(15))
}