package com.androidiots.coding.datastructure.tree

class BSTDeletion constructor(bst: BSTInsertionRecursive) {
    var binarySearchTree = bst
    fun delete(root: Node?, value: Int) {
        if (root == null) {
            println("😡 Nothing to delete")
        }
        deleteRecursively(currentNode = root, value = value, parentNode = null)

    }

    private fun deleteRecursively(parentNode: Node?, currentNode: Node?, value: Int) {
        if (currentNode == null) {
            println("😡 Nothing to delete")
            return
        }
        var leftChild = currentNode?.leftChild
        var rightChild = currentNode?.rightChild
        if (parentNode == null && currentNode.value == value) {// i
            if(leftChild == null && rightChild == null){ //s root node (tree with only root node )
                binarySearchTree.setRoot(null)
            } else if(leftChild == null){
                binarySearchTree.setRoot(value = rightChild?.value, leftChild = rightChild?.leftChild, rightChild = rightChild?.rightChild)
            } else if(rightChild == null){
                binarySearchTree.setRoot(value = leftChild?.value, leftChild = leftChild?.leftChild, rightChild = leftChild?.rightChild)
            }

            println("🥰 root is deleted")
            return
        } else if (parentNode == null) {
            if (value > currentNode.value) {
                deleteRecursively(parentNode = currentNode, currentNode = rightChild, value = value)
            } else {
                deleteRecursively(parentNode = currentNode, currentNode = leftChild, value = value)
            }
        } else if (value == currentNode.value && leftChild == null && rightChild == null) {// node is leaf node
            println("🥰 node is deleted")
            if (parentNode.leftChild?.value == value) {
                parentNode.leftChild = null
            } else {
                parentNode.rightChild = null
            }
            return
        } else if (value == currentNode.value && leftChild == null) {
            println("🥰 node is deleted")
            if (parentNode.leftChild?.value == value) {
                parentNode.leftChild = rightChild
            } else {
                parentNode.rightChild = rightChild
            }
            return
        } else if (value == currentNode.value && rightChild == null) {
            println("🥰 node is deleted")
            if (parentNode.leftChild?.value == value) {
                parentNode.leftChild = leftChild
            } else {
                parentNode.rightChild = leftChild
            }
            return
        } else {
            if (value == currentNode.value) {
                println("🥰 node is deleted")
                var leafNode = findLeastLeafNode(currentNode = rightChild!!)
                leafNode.leftChild = leftChild
                leafNode.rightChild = rightChild
                if (parentNode.leftChild?.value == value) {
                    parentNode.leftChild = leafNode
                } else {
                    parentNode.rightChild = leafNode
                }
            } else {
                if (value > currentNode.value) {
                    deleteRecursively(parentNode = currentNode, currentNode = rightChild, value = value)
                } else {
                    deleteRecursively(parentNode = currentNode, currentNode = leftChild, value = value)
                }
            }
        }
    }

    private fun findLeastLeafNode(currentNode: Node): Node {
        var leafNode = currentNode
        var node = currentNode
        while (leafNode.leftChild != null) {
            node = leafNode
            leafNode = leafNode.leftChild!!
        }
        node.leftChild = null
        return leafNode
    }

}