package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		int newCapacity = elements.length * 2;
		E[] newElements = (E[]) new Object[newCapacity];
		newElements = Arrays.copyOf(elements, newCapacity);

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}

		elements[size++] = e;
		return true; 
	}

	public E get(int i) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i];
		}
	}

	public E set(int i, E e) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i] = e;
		}
	}

	public void add(int i, E e) {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		} else {
			if (size == elements.length) {
				growSize();
			}
			for (int j = size; j > i; j--) {
				elements[j] = elements[j - 1];
			}

			elements[i] = e;
			size++;
		}
	}

	public E remove(int i) {
		E elementRemove = elements[i];
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}

			size--;
		}
		return elementRemove;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + " ");
		}

		System.out.println();
	}

	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			remove(elements[i]);
		}

		size = 0;
		System.out.println("finish");

	}

	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> arrayList_clone = new MyArrayList<>();
		arrayList_clone.elements = Arrays.copyOf(this.elements, this.elements.length);
		arrayList_clone.size = this.size;
		return arrayList_clone;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o != null && o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(E e) {
		if (contains(e)) {
			int indexE = indexOf(e);
			remove(indexE);
			return true;
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<>();
		myArr.add(1);
		myArr.add(2);
		myArr.add(3);
		myArr.add(4);
		myArr.add(5);
		System.out.println(myArr.size());
		System.out.println(myArr.isEmpty());
		//System.out.println(myArr.get(-1));
		System.out.println(myArr.get(4));
		System.out.println(myArr.set(3,DEFAULT_CAPACITY));
		System.out.println(myArr.add(DEFAULT_CAPACITY));
		System.out.println(myArr.remove(2));
		System.out.println(myArr.indexOf(4));
		System.out.println(myArr.lastIndexOf(myArr));
		myArr.clear();
		System.out.println(myArr.toArray());
		System.out.println(myArr.clone());
		System.out.println(myArr.contains(6));
		System.out.println(myArr.remove(7));
		
	}
}
