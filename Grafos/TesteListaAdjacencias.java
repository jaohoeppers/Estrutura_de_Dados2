package Grafos;

public class TesteListaAdjacencias {

    public static void main(String[] args) {
        ListaAdjacencia grafo = new ListaAdjacencia(6,false);
        ListaAdjacencia grafo2 = new ListaAdjacencia(4,false);
        ListaAdjacencia grafo3 = new ListaAdjacencia(3,false);

        System.out.println("Adicionando as arestas");

        //Adicionar arestas ao grafo
        grafo.AdicionaAresta(0,1);
        grafo.AdicionaAresta(0,2);
        grafo.AdicionaAresta(1,2);
        grafo.AdicionaAresta(1,5);
        grafo.AdicionaAresta(2,1);
        grafo.AdicionaAresta(3,2);
        grafo.AdicionaAresta(4,5);
        grafo.AdicionaAresta(5,0);
        grafo.AdicionaAresta(1,4);
        grafo.AdicionaAresta(3,4);

        //Mostrar lista de adjacencis

        grafo.mostrarListaAdjcencias();

        System.out.println("+*******************************************+");
        System.out.println("Removendo a aresta 0-1");

        //removendo
        grafo.RemoverAresta(0,1);
        grafo.mostrarListaAdjcencias();

        System.out.println("+*******************************************+");
        System.out.println("Removendo vertice 4");
        System.out.println("Antes");
        grafo.mostrarListaAdjcencias();
        System.out.println("Depois");
        grafo.RemoverVertice(4);
        grafo.mostrarListaAdjcencias();

        System.out.println("+*******************************************+");
        System.out.println("verificando se o grafo é conexo");

//        System.out.println("Vertice 0 e Vertice 1: "+grafo.verificaConexo(0,1));
//        System.out.println("Vertice 4 e Vertice 2: "+grafo.verificaConexo(4,2));
//        System.out.println("Vertice 3 e Vertice 4: "+grafo.verificaConexo(3,4));
//        System.out.println("Vertice 0 e Vertice 2: "+grafo.verificaConexo(0,2));
//        System.out.println("Vertice 3 e Vertice 2: "+grafo.verificaConexo(3,2));
//        System.out.println("Vertice 2 e Vertice 0: "+grafo.verificaConexo(2,0));

        System.out.println("+*******************************************+");
        System.out.println("verificando se o grafo é completo");

        System.out.println(grafo.verificaCompleto());

        System.out.println("+*******************************************+");
        System.out.println("Criando grafo2");

        grafo2.AdicionaAresta(0,1,7);
        grafo2.AdicionaAresta(1,2,6);
        grafo2.AdicionaAresta(2,3,8);
        grafo2.AdicionaAresta(0,2,1);
        grafo2.AdicionaAresta(3,1,5);
        grafo2.AdicionaAresta(0,3,6);
        grafo2.mostrarListaAdjcencias();

        System.out.println("+*******************************************+");
        System.out.println("verificando se o grafo2 é completo");

        System.out.println(grafo2.verificaCompleto());

        System.out.println("+*******************************************+");
        System.out.println("Algoritmo de dijkstra com grafo2");

        grafo2.MetodoDijkstraInicioFim(0,3);

        System.out.println("+*******************************************+");
        System.out.println("Verifica grafo Euleriano");

        grafo.Euleriano();

        System.out.println("+*******************************************+");
        System.out.println("Criando grafo3");

        grafo3.AdicionaAresta(0,1);
        grafo3.AdicionaAresta(1,2);
        grafo3.AdicionaAresta(0,2);

        grafo3.mostrarListaAdjcencias();

        System.out.println("+*******************************************+");
        System.out.println("Verifica grafo3 Euleriano");

        grafo3.Euleriano();

        System.out.println("+*******************************************+");
        System.out.println("Verifica grafo Hamiltoniano");

        grafo.Hamiltoniano();

        System.out.println("+*******************************************+");
        System.out.println("Verifica grafo3 Hamiltoniano");

        grafo3.Hamiltoniano();

    }
}
