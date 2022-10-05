package arraylist;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MiArrayList<T> {
	// atributos
	private T[] elementos;
	private static final int CAPACIDAD_INICIAL = 10;
	private int tamanio; //nº de elementos válidos que contiene el arraylist

	//Constructs an empty list with an initial capacity of ten. 
       public MiArrayList() {
   		elementos = (T[]) (new Object[CAPACIDAD_INICIAL]);
   		tamanio = 0;
       }
	
       //Returns true if this list contains no elements, false otherwise. 
	public boolean isEmpty() {
		//TO DO
		if(tamanio==0) return true;
		return false; //CORREGIR SI ES NECESARIO
	}
	
       //Returns the number of elements in this list. 
	public int size(){
		 return tamanio; 
	}
	
	//Returns the element at the specified position in this list. 
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0  || index >= tamanio) {  
			throw new IndexOutOfBoundsException();
			}
		return elementos[index] ;
	}
	
	//Returns the index of the first occurrence of the specified element in this
      // list, or -1 if this list does not contain the element. 
	public int indexOf(Object o) {
		T elem = (T)o;
		//TO DO
		
		for(int i=0;i<=tamanio;i++) {
			if(elementos[i].equals(elem)) return i;
		}
		return -1; //CORREGIR SI ES NECESARIO
	}
	
      //Returns true if this list contains the specified element, false otherwise. 
	public boolean contains(Object o){
		//TO DO
		for(int i=0;i<=tamanio;i++) {
			if(elementos[i].equals(o)) return true;
		}
		return false; //CORREGIR SI ES NECESARIO
	}
	
       //Appends the specified element to the end of this list. Returns true.
	public boolean add(T elem) {
		if (tamanio == elementos.length) {  //Aumentar capacidad en un 50%
			int nuevaCapacidad = (int)(elementos.length*1.5);
			T[] nuevoArray = (T[])(new Object[nuevaCapacidad]);
			for(int i=0; i<tamanio; i++) {
				nuevoArray[i]=elementos[i];
			}
			elementos = nuevoArray;
		}
		elementos[tamanio] = elem;
		tamanio++;
		return true;
	}
	
      //Inserts the specified element at the specified position in this list. 
	public void add(int index, T elem) throws IndexOutOfBoundsException {
		
		T[] aux =(T[])(new Object[tamanio]);		
		//TO DO 	
		if (index < 0  || index >= tamanio) {  
			throw new IndexOutOfBoundsException();
			}
		
		elementos[index]=elem;
		
		for(int i=index;i<=tamanio;i++) {
			elementos[i+1]=aux[i];			
		}
		
		
	}	
	
      //Removes the first occurrence of the specified element from this list, if it is 
      //present. Returns true if it has been removed, false otherwise.
	public boolean remove(Object o){
		//TO DO
		T[] aux =(T[])(new Object[tamanio]);	
		aux=elementos;
		
		for(int i=0;i<=tamanio;i++) {
			if(elementos[i].equals(o)) {
				for(int j=i;j<=tamanio;j++) {
					elementos[j]=aux[i+j-1];
				}
				
				tamanio--;
				return true;
			}
			
		}
				
		return false; //CORREGIR SI ES NECESARIO
	}	

	//Removes the element at the specified position in this list. 
      //Returns the removed element.
       public T remove(int index) throws IndexOutOfBoundsException{
   		//TO DO
    	   T[] aux =(T[])(new Object[tamanio]);	
    	  aux=elementos;
    	   
    	   if (index < 0  || index >= tamanio) {  
   			throw new IndexOutOfBoundsException();
   			}
    	   for(int i=0;i<=tamanio;i++) {
    		   if(i==index) {
    			   for(int j=i; j<=tamanio;j++) {
    				   elementos[j]=aux[i+j-1];
    			   }
    			   tamanio--;
    			   return  elementos[i];
    		   }
    	   }
    	   return null;
    	   
   		
       }

      //Replaces the element at the specified position in this list with the specified
      //element. Returns the replaced element
	public T set(int index, T elem) throws IndexOutOfBoundsException {
		
		   T[] aux =(T[])(new Object[tamanio]);	
	    	  aux=elementos;
	    	  
	    	   
	    	   if (index < 0  || index >= tamanio) {  
	   			throw new IndexOutOfBoundsException();
	   			}
	    	   
	    	   for(int i=0;i<=tamanio;i++) {
	    		   if(i==index) {
	    			   elementos[i]=elem;
	    			   for(int j=i+1; j<=tamanio;j++) {
	    				   elementos[j]=aux[j+1];
	    			   }
	    			   
	    			   return  elementos[i];
	    		   }
	    	   }
	    	   return  null;
	}	
	
	//Returns a string representation of this collection. The string representation
      // consists of a list of the collection's elements in order, enclosed in square 
      // brackets ("[]"). Adjacent elements are separated by the characters ", " 
      // (comma and space). 
	@Override
	public String toString() {
		return "MiArrayList [elementos=" + Arrays.toString(elementos) + ", tamanio=" + tamanio + "]";
	}


}