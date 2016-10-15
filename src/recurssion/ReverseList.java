package recurssion;

public class ReverseList {

	public static List reverseList(List head){
		List next = null;
		List prev = null;
		while(head != null){
			next = head.getNext();
			head.setNext(prev);
			prev= head;
			head= next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		List head= reverseList(List.getHead(5));
		List.printList(head);
	}
}
