package Grafos;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
class Aresta{
    int origem;
    int destino;
    int peso;

    public Aresta(int origem, int destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}
public class ListaAdjacencia {

    private boolean testeConexao = true;
    private int nVertices;
    private List<List<Aresta>>adjacencias;
    private boolean direcionado;

    public ListaAdjacencia(int nVertices, boolean direcionado){
        this.nVertices = nVertices;
        this.direcionado = direcionado;
        this.adjacencias = new ArrayList<>(nVertices);
        for(int i=0;i<nVertices;i++){
            adjacencias.add(new ArrayList<>());
        }
    }

    public void AdicionaAresta(int u, int v, int peso){
        Aresta aresta = new Aresta(u,v,peso);
        adjacencias.get(u).add(aresta);
        if (!direcionado){
            Aresta arestainvertida = new Aresta(v,u,peso);
            adjacencias.get(v).add(arestainvertida);
        }
    }

    public void AdicionaAresta(int u,int v){
        AdicionaAresta(u,v,1);
    }

    public void mostrarListaAdjcencias(){
        for (int i=0;i<nVertices;i++){
            System.out.print("Vertice "+i+": ");
            for (Aresta aresta:adjacencias.get(i)){
                System.out.print("("+aresta.destino+", Peso: "+aresta.peso+")");
            }
            System.out.println();
        }
    }

    public void RemoverAresta(int u,int v){
        List<Aresta>arestasU = adjacencias.get(u);
        for (Aresta aresta : arestasU){
            if (aresta.destino == v){
                arestasU.remove((aresta));
                break;
            }
        }
        if (!direcionado){
            List<Aresta>arestasV = adjacencias.get(v);
            for (Aresta aresta : arestasV){
                if (aresta.destino == u){
                    arestasV.remove(aresta);
                    break;
                }
            }
        }
    }

    public void RemoverVertice(int vertice){
        for (int i = 0; i < nVertices; i++) {
            List<Aresta> arestas = adjacencias.get(i);
            arestas.removeIf(aresta -> aresta.origem == vertice || aresta.destino == vertice);
        }
        adjacencias.remove(vertice);
//        System.out.println("antes --: "+nVertices);
        nVertices--;
//        System.out.println("depois --: "+nVertices);
    }

    public boolean verificaConexo(int inicio, int fim) {
        boolean[] visitado = new boolean[nVertices];
        return buscProfVC(inicio, fim, visitado);
    }

    private boolean buscProfVC(int atual, int fim, boolean[] visitado) {
        if (atual == fim) {
            return true;
        }

        visitado[atual] = true;

        for (Aresta aresta : adjacencias.get(atual)) {
            if (!visitado[aresta.destino]) {
                if (buscProfVC(aresta.destino, fim, visitado)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean verificaCompleto() {
        int totalArestas = 0;
        for (int i = 0; i < nVertices; i++) {
            totalArestas += adjacencias.get(i).size();
        }
//        return totalArestas == (nVertices * (nVertices - 1)) / 2;
        return totalArestas == (nVertices * (nVertices - 1));
    }



    private boolean euleriano () {
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean semiEuleriano () {
        int cont = 0;
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() % 2 != 0) {
                cont++;
            }
        }
        return cont == 2;
    }
    public void Euleriano() {
        if (euleriano())
            System.out.println("é Euleriano");
        else if (semiEuleriano()) {
            System.out.println("é semi-Euleriano");
        }
        else System.out.println("não é Euleriano");
    }

    private boolean hamiltoniano() {
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() < nVertices - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean semiHamiltoniano() {
        int cont = 0;
        for (int i = 0; i < nVertices; i++) {
            if (adjacencias.get(i).size() < nVertices - 1) {
                cont++;
            }
        }
        return cont == 2;
    }

    public void Hamiltoniano() {
        if (hamiltoniano())
            System.out.println("é Hamiltoniano");
        else if (semiHamiltoniano()) {
            System.out.println("é semi-Hamiltoniano");
        }
        else System.out.println("não é Hamiltoniano");
    }


    public boolean saoAdjacentes(int u, int v){
        for (Aresta aresta : adjacencias.get(u)){
            if (aresta.destino == v){
                return true;
            }
        }
        return false;
    }

    public void mostrarListaAdjacenciasDoVertice(int vertice){
        System.out.print("Vertice "+vertice+": ");
        for (Aresta aresta : adjacencias.get(vertice)){
            System.out.print("("+aresta.destino+", Peso: "+aresta.peso+")");
        }
        System.out.println();
    }

    public void buscaEmLargura(int verticeInicial) {
        boolean[] visitado = new boolean[nVertices];
        //Fila para busca em largura
        Queue<Integer> fila = new LinkedList<>();

        visitado[verticeInicial] = true;
        fila.add(verticeInicial);

        System.out.println("Resultado da busca em largura a partir do vértice " + verticeInicial + ":");
        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();
            System.out.print(verticeAtual + " ");

            for (Aresta aresta : adjacencias.get(verticeAtual)) {
                int vizinho = aresta.destino;
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
        System.out.println();
    }

    public void buscaEmProfundidade(int verticeInicial) {
        boolean[] visitado = new boolean[nVertices];
        Stack<Integer> pilha = new Stack<>();

        visitado[verticeInicial] = true;
        pilha.push(verticeInicial);

        System.out.println("Resultado da busca em profundidade a partir do vértice " + verticeInicial + ":");
        while (!pilha.isEmpty()) {
            int verticeAtual = pilha.pop();
            System.out.print(verticeAtual + " ");

            for (Aresta aresta : adjacencias.get(verticeAtual)) {
                int vizinho = aresta.destino;
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    pilha.push(vizinho);
                }
            }
        }
        System.out.println();
    }

    public void MetodoDijkstra(int origem){

        int[] distancia = new int[nVertices];

        for(int i=0; i<nVertices; i++){
            distancia[i] = Integer.MAX_VALUE;
        }

        distancia[origem] = 0;
        Set<Integer> visitados = new HashSet<>();

        while(true){
            int u = -1;
            for(int i=0; i<nVertices; i++){
                if(!visitados.contains(i) && (u == -1 || distancia[i] < distancia[u])){
                    u = i;
                }
            }

            if(u == -1) break;
            visitados.add(u);

            for(Aresta aresta : adjacencias.get(u)){
                int v = aresta.destino;
                int peso = aresta.peso;

                if(distancia[u] + peso < distancia[v]){
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        for(int i=0; i<nVertices; i++){
            System.out.println("A menor distancia do vertice: " + origem + " para o vertice: " + i + " é de: " + distancia[i]);
        }

    }

    public void MetodoDijkstraInicioFim(int origem, int destino){

        int[] distancia = new int[nVertices];

        for(int i=0; i<nVertices; i++){
            distancia[i] = Integer.MAX_VALUE;
        }

        distancia[origem] = 0;
        Set<Integer> visitados = new HashSet<>();

        while(true){
            int u = -1;
            for(int i=0; i<nVertices; i++){
                if(!visitados.contains(i) && (u == -1 || distancia[i] < distancia[u])){
                    u = i;
                }
            }

            if(u == -1) break;
            visitados.add(u);

            for(Aresta aresta : adjacencias.get(u)){
                int v = aresta.destino;
                int peso = aresta.peso;

                if(distancia[u] + peso < distancia[v]){
                    distancia[v] = distancia[u] + peso;
                }
            }
        }
        System.out.println("A menor distancia do vertice: " + origem + " para o vertice: " + destino + " é de: " + distancia[destino]);
    }

}
