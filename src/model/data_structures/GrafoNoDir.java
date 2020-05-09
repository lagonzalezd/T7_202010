package model.data_structures;

import java.util.NoSuchElementException;

public class GrafoNoDir<K extends Comparable, C> {

    private static final String NEWLINE = System.getProperty("line.separator");

    private final int vertices;
    private int arcos;
    private ListaEncadenada<Integer>[] adj;


    public GrafoNoDir(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.vertices = vertices;
        this.arcos = 0;
        adj = (ListaEncadenada<Integer>[]) new ListaEncadenada[vertices];
        for (int v = 0; v < vertices; v++) {
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
    public GrafoNoDirigido(K in) {
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
     * @param G the graph to copy
     * @throws IllegalArgumentException if {@code G} is {@code null}
     */
    public GrafoNoDir(GrafoNoDir G) {
        this.vertices = G.darVertices();
        this.arcos = G.darArcos();
        if (vertices < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

        // update adjacency lists
        adj = (ListaEncadenada<Integer>[]) new ListaEncadenada[vertices];
        for (int v = 0; v < this.vertices; v++) {
            adj[v] = new ListaEncadenada<Integer>();
        }

        for (int v = 0; v < G.darVertices(); v++) {
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
     * @return the number of edges in this graph
     */
    public int darArcos() {
        return arcos;
    }

    /**
     * @return the number of vertices in this graph
     */
    public int darVertices() {
        return vertices;
    }



    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= this.vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (this.vertices - 1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        arcos++;
        adj[v].add(w);
        adj[w].add(v);
    }


    /**
     * @param v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * @param v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
}
