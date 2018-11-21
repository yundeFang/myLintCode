package com.ade.T36.ReverseLinkedList2;

import util.ListNode;

public class Solution {
	 /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if ( head == null || m >= n || m < 0 || n < 0)
    		return head;
    	
    	ListNode Head = new ListNode(0);
    	Head.next = head;
    	int i = 1;
    	int headNum = m - 1;
    	int tailNum = n;
    	ListNode headNode = new ListNode(0), tailNode = new ListNode(0), tmpNode = new ListNode(0);
    	tmpNode = head;
    	
    	while ( i <= tailNum ) {
    		//m节点的上一节点
    		if ( i == headNum ) headNode = tmpNode;
    		if ( i == tailNum ) tailNode = tmpNode;
    		i++;
    		tmpNode = tmpNode.next;
    	}
    	if (m == 1 ) headNode = Head;
    	//m节点
    	ListNode mNode = headNode.next;
    	//n节点
    	ListNode nNode = tailNode;
    	//n节点的下一节点    	
    	tailNode = tailNode.next;
    	ListNode t1Node = mNode;
    	tmpNode = mNode.next;
    	
    	for (i = m; i < n; i++) {
    		if (tmpNode == null) {
                return null;
            }
    		ListNode next = tmpNode.next;
    		tmpNode.next = t1Node;
    		t1Node = tmpNode;
    		tmpNode = next;
		}
    	
    	mNode.next = tailNode;
    	headNode.next = nNode;
    	return Head.next;
    }
    

    public static void main(String[] args) {
		Solution s = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);

		node1.next=node2;
		node2.next=node3;
		node3.next=null;
		ListNode
		node = s.reverseBetween(node1, 1, 2);
		
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
