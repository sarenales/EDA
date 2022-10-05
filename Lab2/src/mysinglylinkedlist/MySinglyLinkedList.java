package mysinglylinkedlist;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T extends Comparable<T>> {

	private LinearNode<T> first;
	private LinearNode<T> last;
	private int size;

	private class LinearNode<T> {
		T info;
		LinearNode<T> next;
	

		public LinearNode(T info) {
			this.info = info;
		}
	}
	
	public MySinglyLinkedList() {
		size = 0;
	}

	/*
	 * M�TODOS YA IMPLEMENTADOS EN CLASE
	 */

	//Returns true if this list contains no elements, false otherwise.
	public boolean isEmpty() {
		return (first == null);
	}

	//Appends the specified element to the front of this list.
	public void addFirst(T elem) {
		LinearNode<T> newNode = new LinearNode<T>(elem);
		newNode.next = first;
		first = newNode;
		if(last==null) last = newNode;
		size++;
	}

	//Returns true if this list contains the specified element, false otherwise.
	public boolean contains(Object o) {
		T elem = (T)o;
		LinearNode<T> actual = first;
		while (actual != null) {
			if (elem.equals(actual.info))
				return true;
			actual = actual.next;
		}
		return false;
	}

	/*
	 * M�TODOS A IMPLEMENTAR EN EL LABORATORIO 2
	 */
	
	//Removes the element at the first position in this list. 
    //Returns the removed element, or an exception if the list is empty
	public T removeFirst() throws NoSuchElementException {
		//TO DO
		LinearNode<T> actual=this.first;
		LinearNode<T> eliminado;
		
		if(actual==null) {
			throw new NoSuchElementException();
		}
		eliminado=actual;
		actual=actual.next;
		
		
		return   eliminado.info;
	}
	
	//Appends the specified element to the end of this list.
	public void addLast(T elem) {
		//TO DO
		LinearNode<T> newNode = new LinearNode<T>(elem);
		if(this.first==null) {
			first = newNode;
			last = newNode;
		}else {
			last.next=newNode;
			//newNode.prev=last;
			last=last.next;
		}
	}
	
	//Inserts the specified element in the correct position.
	//Pre: the elements of the list are ordered
	public void addOrdered(T elem) {
		//TO DO
		LinearNode<T> actual=this.first;
		LinearNode<T> newNode = new LinearNode<T>(elem);
		boolean introducido= false;
		
		if(size==1) {
			
			if(actual.info.compareTo(elem)==1) {
				
				addFirst(newNode.info);
				
			}else if(actual.info.compareTo(elem)==-1) {
				
				addLast(newNode.info);
			}
			
		}else if(actual==null){
			
			addLast(elem);
			
		}else {
			
			while(actual!=null || introducido!=true) {
				
				
			
				if(actual.next.info.compareTo(elem) ==1) {
				
					actual.next=newNode;
					actual=actual.next.next;
					introducido=true;
				
				}else {
					actual=actual.next;
					
				}
			}
		}	
	}
	
	//Returns a string representation of this collection. The string representation
    // consists of a list of the collection's elements, enclosed in square 
    // brackets ("[]"). Adjacent elements are separated by the characters ", " 
    // (comma and space). 
	@Override
	public String toString() {
		return "MySinglyLinkedList [first=" + first + ", last=" + last + ", size=" + size + "]";
	}

	/*
	 * OTROS M�TODOS (IMPLEMENTACI�N OPCIONAL)
	 */
	
	/*
	

    //Returns the number of elements in this list. 	
	public int size(){}
	
	//Returns the index of the first occurrence of the specified element in this
    // list, or -1 if this list does not contain the element.
	public int indexOf(Object o) {}
	
    //Removes the first occurrence of the specified element from this list, if it is 
    //present. Returns true if it has been removed, false otherwise.
	public boolean remove(Object o){}
	
	//Removes the element at the last position in this list. 
    //Returns the removed element, or throws an exception if list is empty
	public T removeLast() throws NoSuchElementException {}
	
	//Returns the first element in the list, or throws an exception if list is empty
	public T getFirst() throws NoSuchElementException {}
	
	//Returns the last element in the list, or throws an exception if list is empty
	public T getLast() throws NoSuchElementException {}
	
    //Replaces the element at the specified position in this list with the specified element. 
    // Returns the replaced element	
	public T set(int index, T elem) throws IndexOutOfBoundsException{}	
	
	
	*/


}
