package ejer3Alumnos;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> {

	private Node<T> first;
	private Node<T> last;
	private int size;


	public MyLinkedList() {
		size = 0;
	}

	/*
	 * MÉTODOS YA IMPLEMENTADOS EN CLASE
	 */

	//Removes the element at the last position in this list. 
	//Returns the removed element, or throws an exception if list is empty
	public T removeLast() throws NoSuchElementException {

		if(first==null) { //Lista vacía
			throw new NoSuchElementException();
		}
		else if(first.next==null){ //Lista de un único elemento
			T aux = first.info;
			first = null;
			last = null;
			size--;
			return aux;
		}
		else{T aux = last.info;
		last = last.prev;
		last.next.prev = null;
		last.next = null;
		size--;
		return aux;          
		}    
	}





	/*
	 * MÉTODOS A IMPLEMENTAR EN EL LABORATORIO 3
	 */

	//Returns an iterator over the elements in this list in proper sequence.
	public Iterator<T> iterator(){
		//TO DO
		return new IteradorParaMyLinkedList(); //CORREGIR SI NECESARIO
	}
	
	private class IteradorParaMyLinkedList implements Iterator<T>{

		private Node<T> guide = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (guide != null);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			guide = guide.next;
			return guide.prev.info;
		}
	}

	//Removes the first occurrence of the specified element from this list, if it is 
	//present. Returns true if it has been removed, false otherwise.
	public boolean remove(Object o){

		Node<T> actual=this.first;



		if(this.first==null)
			return false;


		if(this.first==this.last && !this.first.info.equals(o)) 
			return false;


			if(actual.info.equals(o)) {
				if(this.first.next==null) {
					this.first=null;
					this.last=null;
				}else {
					this.first.next.prev=null;
					this.first=this.first.next;
				}
				return true;



			}else {
				while(actual.next!=null){
					if(actual.next.info.equals(o)) {
						actual.next.next.prev=actual;
						actual.next=actual.next.next;
						return true;

					}
					actual=actual.next;
				}
			}


			return false; //CORREGIR SI NECESARIO
		}


		//Inserts the specified element in the correct position.
		//Pre: the elements of the list are in ascending order
		public void addOrdered(T elem) {
			
			Node<T> newNode = new Node<T>(elem);
			Node<T> primero = this.first;
			Node<T> ultimo = this.last;
			boolean introducido=false;
			
			if (this.first==null) {
				this.first=newNode;
				this.last=newNode;
			}else {
				if(this.first.info.compareTo(elem)>=0) {
					this.first=newNode;
					this.first.next=primero;
					primero.prev=this.first;
					
				}else if(this.last.info.compareTo(elem)<=0) {
					this.last=newNode;
					this.last.next=ultimo;
					ultimo.prev=this.last;
				}else {
					while(primero.next!=null && !introducido) {
						if(primero.next.info.compareTo(elem)>=0) {
							
							newNode.next=primero.next;
							primero.next.prev=newNode;
							primero.next=newNode;
							
							newNode.prev=primero;
							introducido=true;
						}else {
							primero=primero.next;
							
						}
					}
				}
				
			}
			
			
		}

		//Returns the last element in the list, or throws an exception if list is empty
		public T getLast() throws NoSuchElementException {

			if(this.first==null)
				throw new NoSuchElementException();
			
			
			return this.last.info; //CORREGIR SI NECESARIO
		}



		/*
		 * OTROS MÉTODOS (IMPLEMENTACIÓN OPCIONAL)
		 */

		/*


    //Returns the number of elements in this list. 	
	public int size(){}

	//Returns true if this list contains no elements, false otherwise.
	public boolean isEmpty() {}

    //Appends the specified element to the front of this list.
	public void addFirst(T elem) {	}

	//Appends the specified element to the end of this list.
	public void addLast(T elem) { }

	//Returns true if this list contains the specified element, false otherwise.
	public boolean contains(Object o) {	}

	//Returns the index of the first occurrence of the specified element in this
    // list, or -1 if this list does not contain the element.
	public int indexOf(Object o) {}


	//Removes the element at the first position in this list. 
    //Returns the removed element, or an exception if the list is empty
	public T removeFirst() throws NoSuchElementException { }

	//Removes the element at the last position in this list. 
    //Returns the removed element, or throws an exception if list is empty
	public T removeLast() throws NoSuchElementException {}

	//Returns the first element in the list, or throws an exception if list is empty
	public T getFirst() throws NoSuchElementException {}	


    //Replaces the element at the specified position in this list with the specified element. 
    // Returns the replaced element	
	public T set(int index, T elem) throws IndexOutOfBoundsException{}	

	//Returns a string representation of this collection. The string representation
    // consists of a list of the collection's elements in order, enclosed in square 
    // brackets ("[]"). Adjacent elements are separated by the characters ", " 
    // (comma and space). 
	@Override
	public String toString() {	}


		 */


	}
