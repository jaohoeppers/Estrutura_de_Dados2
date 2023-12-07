package Grafos;

public class MainGrafos {

    public static void main(String[] args) {
        int numVertices = 3;
        MatrizAdjacencia grafo = new MatrizAdjacencia(numVertices, false, false);

        grafo.inserirAresta(0,1);
        grafo.inserirAresta(0,2);
        grafo.inserirAresta(1,2);

        grafo.mostrarMatrizAdjacencia();

        System.out.println(grafo.verificaAdjacencia(1,2));

        System.out.println();

        MatrizAdjacencia grafo2 = new MatrizAdjacencia(numVertices, true, true);

        grafo2.inserirAresta1(0,1,3);
        grafo2.inserirAresta1(1,2,5);
        grafo2.inserirAresta1(2,0,1);

        grafo2.mostrarMatrizAdjacencia();

        System.out.println(grafo2.verificaAdjacencia(1,2));

        System.out.println();

        MatrizAdjacencia grafo3 = new MatrizAdjacencia(numVertices, true, false);

        grafo3.inserirAresta1(0,1,3);
        grafo3.inserirAresta1(1,2,5);
        grafo3.inserirAresta1(2,0,1);

        grafo3.mostrarMatrizAdjacencia();

        System.out.println(grafo3.verificaAdjacencia(1,2));
    }
}
