package Grafos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrizAdjacencia {
    private int[][]G;
    private int numVertices;
    private boolean ponderado;
    private boolean direcionado;
    private int peso;

    public MatrizAdjacencia(int numVertices, boolean ponderado, boolean direcionado){
        this.numVertices = numVertices;
        this.ponderado = ponderado;
        this.direcionado = direcionado;
        this.peso = peso;
        G = new int[numVertices][numVertices];
    }

    public void inserirAresta(int vertice1, int vertice2){

        if (!ponderado){
            G[vertice1][vertice2] = 1;
            if (!direcionado){
                G[vertice2][vertice1] = 1;
            }
        }else{
            System.out.println("Grafo ponderado. necessita peso de aresta");
        }
    }

    public void inserirAresta1(int vertice1, int vertice2, int peso){

        if (ponderado){
            G[vertice1][vertice2] = peso;
            if (!direcionado){
                G[vertice2][vertice1] = peso;
            }
        }else{
            System.out.println("Grafo nao ponderado. arestas nao possuem peso");
        }
    }

    public void removerAresta(int vertice1, int vertice2){
        G[vertice2][vertice1] = 0;
        if (!direcionado){
            G[vertice1][vertice2] = 0;
        }
    }

    public void mostrarMatrizAdjacencia(){
        for (int i = 0;i<numVertices;i++){
            for (int j = 0;j<numVertices;j++){
                System.out.print(G[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean verificaAdjacencia(int vertice1, int vertice2){
        if (G!=null){
            return (G[vertice1][vertice2] != 0) && (G[vertice2][vertice1] != 0);
        }
        return false;
    }

//    public void buscaEmLargura(int verticeInicial) {
//        boolean[] visitado = new boolean[numVertices];
//        //Fila para busca em largura
//        Queue<Integer> fila = new LinkedList<>();
//
//        visitado[verticeInicial] = true;
//        fila.add(verticeInicial);
//
//        System.out.println("Resultado da busca em largura a partir do vértice " + verticeInicial + ":");
//        while (!fila.isEmpty()) {
//            int verticeAtual = fila.poll();
//            System.out.print(verticeAtual + " ");
//
//            for (Aresta aresta : adjacencias.get(verticeAtual)) {
//                int vizinho = aresta.destino;
//                if (!visitado[vizinho]) {
//                    visitado[vizinho] = true;
//                    fila.add(vizinho);
//                }
//            }
//        }
//        System.out.println();
//    }

//    public void buscaEmProfundidade(int verticeInicial) {
//        boolean[] visitado = new boolean[numVertices];
//        Stack<Integer> pilha = new Stack<>();
//
//        visitado[verticeInicial] = true;
//        pilha.push(verticeInicial);
//
//        System.out.println("Resultado da busca em profundidade a partir do vértice " + verticeInicial + ":");
//        while (!pilha.isEmpty()) {
//            int verticeAtual = pilha.pop();
//            System.out.print(verticeAtual + " ");
//
//            for (Aresta aresta : adjacencias.get(verticeAtual)) {
//                int vizinho = aresta.destino;
//                if (!visitado[vizinho]) {
//                    visitado[vizinho] = true;
//                    pilha.push(vizinho);
//                }
//            }
//        }
//        System.out.println();
//    }
}
