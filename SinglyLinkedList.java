package lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		return this.head.getData();
	}

	public E last() {
		return this.tail.getData();
	}

	public void addFirst(E e) {
		Node<E> n = new Node<E>(e);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}

		size++;
	}

	public void addLast(E e) {
		Node<E> n = new Node<E>(e);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}

		size++;
	}

	public E removeFirst() {
		if (head == null) {
			return null;
		} else {
			E remove_E = head.getData();
			head = head.getNext();
			size--;
			return remove_E;
		}
	}

	public E removeLast() {
		if (head == null) { 
			return null;
		} else if (head.getNext() == null) { 
			E remove_E = head.getData();
			head = null;
			tail = null;
			size--;
			return remove_E;
		} else {

			Node<E> current = head;
			Node<E> previous = null;

			while (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}

			E remove_E = current.getData();
			previous.setNext(null);
			tail = previous;
			size--;
			return remove_E;
		}
	}

	public String toString() {
		if (head == null) {
			return "empty";
		} else {
			StringBuilder sb = new StringBuilder();

			Node<E> current = head;
			while (current != null) {
				sb.append(current.getData() + " --> ");
				current = current.getNext();
			}
			sb.append("null");
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);

		
		System.out.println("Size: " + list.size());
		System.out.println("Is Empty: " + list.isEmpty());
		System.out.println("First element: " + list.first());
		System.out.println("Last element: " + list.last());

		
		Integer removedValue = list.removeFirst();
		System.out.println("Removed first element: " + removedValue);
		System.out.println("Singly Linked List after removing first: " + list);

		
		removedValue = list.removeLast();
		System.out.println("Removed last element: " + removedValue);
		System.out.println("Singly Linked List after removing last: " + list);
	}

}
