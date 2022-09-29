package com.androidiots.coding.in_place_reversal_of_linkedlist


internal class ListNode(value: Int) {
    var value = 0
    var next: ListNode? = null

    init {
        this.value = value
    }
}

internal object ReverseSubList {
    private fun reverse(head: ListNode, p: Int, q: Int): ListNode {
        var current:ListNode? = head
        var previous:ListNode? = null
        var next:ListNode? = null
        while (current != null){
            next = current.next
            if(current.value == p){

            }
            previous = current
            current = next
        }
        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next = ListNode(5)
        var result: ListNode? = reverse(head, 2, 4)
        print("Nodes of the reversed LinkedList are: ")
        while (result != null) {
            print(result.value.toString() + " ")
            result = result.next
        }
    }
}