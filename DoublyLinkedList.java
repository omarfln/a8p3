package prob4;

public class DoublyLinkedList {
	
		Node header;
		DoublyLinkedList(){
			header = new Node();
		}
		//adds to the end of the list
		public void addLast(String item){
			Node toAdd = new Node();
			toAdd.value = item;
			if(header.next == null){
				toAdd.previous=header;
				header.next=toAdd;
				toAdd.next=null;
			}
			else{
				Node currptr = header;
				while (currptr.next!= null)
					currptr=currptr.next;
				currptr.next = toAdd;
				toAdd.previous = currptr;
			}
			toAdd.next=null;



		}
		public boolean remove(String item){
			Node curr = header.next;
			while (curr !=null){
				if (curr.value.equals(item)) {
					Node prev = curr.previous;
					Node next = curr.next;
					prev.next = next;
					if (next != null) {
						next.previous = prev;
					}
				}
				curr =curr.next;
			}
			return false;


			//Implement
		}
		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			toString(sb, header);
			return sb.toString();
			
		}
		private void toString(StringBuilder sb, Node n) {
			if(n==null) return;
			if(n.value != null) sb.append(" " + n.value);
			toString(sb, n.next);
		}
		
		class Node {
			String value;
			Node next;
			Node previous;
			
			public String toString() {
				return value == null ? "null" : value;
			}
		}
	
		public static void main(String[] args){
			DoublyLinkedList list = new DoublyLinkedList();
			list.addLast("Bob");
			list.addLast("Harry");
			list.addLast("Steve");
			list.remove("Harry");
			//list.remove("Steve");
			//list.remove("Bob");

			System.out.println(list);
		}
}
