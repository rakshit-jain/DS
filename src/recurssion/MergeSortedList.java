package recurssion;

public class MergeSortedList {

	public static void main(String[] args) {
		List head =  mergeList(List.getHead(3), List.getHead(5));
		List.printList(head);
	}
	
	public static List mergeList(List list1, List list2){
		List result = null;
		if(list1 == null){
			return list2;
		}
		if(list2 == null){
			return list1;
		}
		if(list1.getData() <= list2.getData()){
			result = list1;
			result.setNext(mergeList(list1.getNext(), list2));
		}else{
			result = list2;
			result.setNext(mergeList(list1, list2.getNext()));
		}
		return result;
	}
}

//1, 2, 
//1, 2
