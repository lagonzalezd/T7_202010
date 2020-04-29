package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEncadenada<I> implements Iterable<I> {
	
	//primer Nodo
	private Node first;
	//tamanio de la lista
	private int n;

	// clase nodo de base
	private class Node {
		private I item;
		private Node next;
	}

	/**
	 * Constructor
	 */
	public ListaEncadenada() {
		first = null;
		n = 0;
	}

	/**
	 * Está vacío?
	 * @return true si está vacío; false de lo contrario
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Retorna el numero de elementos de la lista.
	 * @return el numero de elementos de la esta lista
	 */
	public int size() {
		return n;
	}

	/**
	 * Agrega un elemento.
	 * @param item a ser agregado
	 */
	public void add(I item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}


	/**
	 * Returns an iterator that iterates over the items in the bag.
	 */
	public Iterator<I> iterator()  {
		return new iterador();  
	}

	private class iterador implements Iterator<I> {
		
		private Node current;

		public iterador() {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public I next() {
			if (!hasNext()) throw new NoSuchElementException();
			I item = current.item;
			current = current.next; 
			return item;
		}
	}
}
