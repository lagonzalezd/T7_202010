package model.data_structures;

public class NodoHash<K extends Comparable<K>,V > {
	/**
	 * Elemento Generico que se almacena en el nodo.
	 */
	private K e;
	private V v;
	 private NodoHash left, right;  // links to left and right subtrees
     private boolean color;     // color of parent link
     private int size;          // subtree count
     
	/**
	 * Referencia para el siguiente nodo de la lista.
	 */
	private NodoHash siguiente;
	
	/**
	 * 	M�todo Constructor
	 * @param t2. Elemento que se almacenera en nodo.
	 */
	public NodoHash(K t2,V t3,boolean color, int size)
	{
		e=t2;
		v=t3;
		this.color=color;
		this.size=size;
		left= null;
		right=null;
	}
	
	/**
	 * Se cambia la referencia del siguiente nodo del actual nodo.
	 * @param newnode. Nueva referencia de nodo.
	 */
	
	public void cambiarSiguiente(NodoHash newnode)
	{
		siguiente=newnode;
	}
	
	/**
	 * Retorna la referencia que se tiene como nodo siguiente.
	 * @return Nodo siguiente del actual.
	 */
	
	public NodoHash<K,V> darSiguiente()
	{
		return siguiente;
	}
	
	/**
	 * Retorna el elemento gen�rico almacenado en el nodo.
	 * @return Elemento Gen�rico.
	 */
	public K darE()
	{
		return e;
	}
	
	/**
	 * Permite modificar el elemento contenido en el nodo.
	 * @param e
	 */
	
	public void cambiarE(K e)
	{
		this.e=e;
	}
    

	/**
	 * Retorna el elemento gen�rico almacenado en el nodo.
	 * @return Elemento Gen�rico.
	 */
	public V darv()
	{
		return v;
	}
	
	/**
	 * Permite modificar el elemento contenido en el nodo.
	 * @param e
	 */
	
	public void cambiarV(V v)
	{
		this.v=v;
	}

	public NodoHash getLeft() {
		return left;
	}

	public void setLeft(NodoHash left) {
		this.left = left;
	}

	public NodoHash getRight() {
		return right;
	}

	public void setRight(NodoHash right) {
		this.right = right;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

}
