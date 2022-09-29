package com.androidiots.coding.linkedlist

class DoublyLinkedList<T> {
   var headNode:Node<T>? = null
   var tailNode:Node<T>? = null
   var size = 0

   fun isEmpty():Boolean{
      if(headNode == null && tailNode == null){
         return true
      }
      return false
   }

   fun insertAtHead(data:T){
      val newNode = Node(data = data, nextNode = null, prevNode = null)
      if(headNode!=null){
         newNode.prevNode = null
         newNode.nextNode = headNode
         headNode?.prevNode = newNode
      } else {
         this.tailNode = newNode
      }
      this.headNode = newNode
      size++
   }

   fun insertAtEnd(data: T){
      if(isEmpty()){
         insertAtHead(data)
      } else {
         val newNode = Node(data = data, nextNode = null, prevNode = null)
         newNode.prevNode = this.tailNode
         tailNode?.nextNode = newNode
         this.tailNode = newNode
      }

      size++
   }

   fun printList(){
      if(isEmpty()){
         println("List is Empty")
      }

      var temp = headNode
      print("List : null <- ")
      while (temp?.nextNode != null){
         print("${temp.data.toString()} <-> ")
         temp = temp.nextNode
      }

      print("${temp?.data.toString()} -> null")
   }
}