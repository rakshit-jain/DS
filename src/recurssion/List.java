package recurssion;

public class List {

	private List(){
	}
	private List next;
	private int data;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(List next) {
		this.next = next;
	}
	
	public List getNext() {
		return next;
	}
	public static List getHead(int listLength){
		List head = null;
		if(listLength>0){
			List list = new List();
			list.setData(0);
			list.setNext(null);
			head= list;
			for(int i=1 ; i<listLength; i++){
				List next = new List();
				next.setData(i);
				next.setNext(null);
				list.setNext(next);
				list= list.getNext();
			}
		}
		
		return head;
	}
	
	public static void printList(List head){
		while(head!=null){
			System.out.println(head.getData());
			head = head.next;
		}
	}
}
