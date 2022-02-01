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

    }

    public void colorationDisplay() {
        // Public method to display a graph and coloration
        for (int i = 0; i < this.NofVertices; i++) {

        }
    }

    private void addNeighbor(int vertex, int neighbor) {
        // Private method to add neighbor to a vertex (add edge between two vertices
        // given as arguments)

    }

    private void readFile(String path) {
        // Private method to read file and build a graph

    }

    private Boolean canColor(int c, int v) {
        // Method to test if the vertex v can be colored with color c

        return true;
    }

    public Boolean Coloring(int vertex) {

        return false;
    }

    public static void main(String[] args) {
        // Main method
        if (args.length == 2) { // check if 2 arguments are given

        }
    }

}