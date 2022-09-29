package com.androidiots.coding.in_place_reversal_of_linkedlist

internal object ReverseLinkedList {
    fun reverse(head: ListNode): ListNode {
        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val head = ListNode(2)
        head.next = ListNode(4)
        head.next!!.next = ListNode(6)
        head.next!!.next!!.next = ListNode(8)
        head.next!!.next!!.next!!.next = ListNode(10)
        var result: ListNode? = reverse(head)
        print("Nodes of the reversed LinkedList are: ")
        while (result != null) {
            print(result.value.toString() + " ")
            result = result.next
        }
    }
}