package model.data_structures;

import java.util.NoSuchElementException;

public class GrafoNoDirigido  {
	
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private ListaEncadenada<Integer>[] adj;

	/**
	 * Initializes an empty graph with {@code V} vertices and 0 edges.
	 * param V the number of vertices
	 *
	 * @param  V number of vertices
	 * @throws IllegalArgumentException if {@code V < 0}
	 */
	public GrafoNoDirigido(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (ListaEncadenada<Integer>[]) new ListaEncadenada[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ListaEncadenada<Integer>();
		}
	}

	/**  
	 * Initializes a graph from the specified input stream.
	 * The format is the number of vertices <em>V</em>,
	 * followed by the number of edges <em>E</em>,
	 * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
	 *
	 * @param  in the input stream
	 * @throws IllegalArgumentException if {@code in} is {@code null}
	 * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
	 * @throws IllegalArgumentException if the number of vertices or edges is negative
	 * @throws IllegalArgumentException if the input stream is in the wrong format
	 */
	public GrafoNoDirigido(In in) {
		if (in == null) throw new IllegalArgumentException("argument is null");
		try {
			this.V = in.readInt();
			if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
			adj = (ListaEncadenada<Integer>[]) new ListaEncadenada[V];
			for (int v = 0; v < V; v++) {
				adj[v] = new ListaEncadenada<Integer>();
			}
			int E = in.readInt();
			if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
			for (int i = 0; i < E; i++) {
				int v = in.readInt();
				int w = in.readInt();
				validateVertex(v);
				validateVertex(w);
				addEdge(v, w); 
			}
		}
		catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid input format in Graph constructor", e);
		}
	}


	/**
	 * Initializes a new graph that is a deep copy of {@code G}.
	 *
	 * @param  G the graph to copy
	 * @throws IllegalArgumentException if {@code G} is {@code null}
	 */
	public GrafoNoDirigido(GrafoNoDirigido G) {
		this.V = G.V();
		this.E = G.E();
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

		// update adjacency lists
		adj = (ListaEncadenada<Integer>[]) new ListaEncadenada[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ListaEncadenada<Integer>();
		}

		for (int v = 0; v < G.V(); v++) {
			// reverse so that adjacency list is in same order as original
			Pila<Integer> reverse = new Pila<Integer>();
			for (int w : G.adj[v]) {
				reverse.push(w);
			}
			for (int w : reverse) {
				adj[v].add(w);
			}
		}
	}

	/**
	 * Returns the number of vertices in this graph.
	 *
	 * @return the number of vertices in this graph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in this graph.
	 *
	 * @return the number of edges in this graph
	 */
	public int E() {
		return E;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}

	/**
	 * Adds the undirected edge v-w to this graph.
	 *
	 * @param  v one vertex in the edge
	 * @param  w the other vertex in the edge
	 * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}


	/**
	 * Returns the vertices adjacent to vertex {@code v}.
	 *
	 * @param  v the vertex
	 * @return the vertices adjacent to vertex {@code v}, as an iterable
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	/**
	 * Returns the degree of vertex {@code v}.
	 *
	 * @param  v the vertex
	 * @return the degree of vertex {@code v}
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
}
