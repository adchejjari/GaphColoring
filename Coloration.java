/*
    Author  : Adnane CHEJJARI
    coloration class : runs Coloration algorithm
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Coloration {
    private int NofVertices; // Nomber of vertices
    private int k; // k
    private int colors[]; // Array of colors
    private ArrayList<ArrayList<Integer>> adjacencyList; // Adjcency List

    public Coloration(String file, int ncolors) {
        // Public constructor, takes file path & k number as parameters
        this.k = ncolors;
        readFile(file);

    }

    public void colorationDisplay() {
        // Public method to display a graph and coloration
        for (int i = 0; i < this.NofVertices; i++) {

        }
    }

    private void addNeighbor(int vertex, int neighbor) {
        // Private method to add neighbor to a vertex (add edge between two vertices
        // given as arguments)
        adjacencyList.get(vertex - 1).add(neighbor); // add neighbor to vertex's adjacency list
        adjacencyList.get(neighbor - 1).add(vertex); // add vertex to neighbor's adjacency list

    }

    private void readFile(String path) {
        // Private method to read file and build a graph
        try {
            File gFile = new File(path);
            Scanner _scanner = new Scanner(gFile);
            if (_scanner.hasNextLine())
                this.NofVertices = _scanner.nextInt(); // read number of vertices on the first line
            colors = new int[this.NofVertices];
            adjacencyList = new ArrayList<ArrayList<Integer>>(NofVertices);
            for (int i = 0; i < this.NofVertices; i++) {
                adjacencyList.add(new ArrayList<Integer>());
            }
            while (_scanner.hasNextLine()) {
                int v = _scanner.nextInt();
                int n = _scanner.nextInt();
                addNeighbor(v, n);
            }
            _scanner.close();
        } catch (FileNotFoundException e) { // Handle error in case of error
            System.out.println("An error has occured while reading the file");
        }
    }

    private Boolean canColor(int c, int v) {
        // Method to test if the vertex v can be colored with color c
        for (int i = 0; i < adjacencyList.get(v).size(); i++) {
            if (adjacencyList.get(v).get(i) == c)
                return false;
        }
        return true;
    }

    public Boolean Coloring(int vertex) {
        // Recursif method for coloration, coloration starts from the vertex given as
        // parameter
        if (vertex == NofVertices) // if all vertices are colored, return true
            return true;
        for (int c = 1; c <= this.k; c++) { // loop over all colors
            if (canColor(c, vertex)) {
                colors[vertex] = c; // color graph if possible
                if (Coloring(vertex + 1)) // color next vertex
                    return true;
                colors[vertex] = 0; // If color c can't lead to a solution then remove it by assigning 0
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Main method
        if (args.length == 2) { // check if 2 arguments are given
            String file = args[0];
            int k = Integer.parseInt(args[1]);
            Coloration graph = new Coloration(file, k); // create coloration object
            if (graph.Coloring(0)) // start coloring
                graph.colorationDisplay();
        }
    }

}