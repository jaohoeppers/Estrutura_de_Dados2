package Arvores;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Arvores.listas_lineares.ListaEncadeada;

public class ArvoreBinaria {

    private class Nodo {
        private int chave;
        private Nodo dir, esq, ant;

        public Nodo(int item) {
            this.chave = item;
            dir = esq = ant = null;
        }
    }

    Nodo raiz = null;

    public void inserir(int chave) {
        raiz = inserirDado(raiz, chave);
    }

    private Nodo inserirDado(Nodo raiz, int chave) {
        if (raiz == null) {
            raiz = new Nodo(chave);
            return raiz;
        }
        if (chave < raiz.chave) {
            raiz.esq = inserirDado(raiz.esq, chave);
        } else if (chave > raiz.chave) {
            raiz.dir = inserirDado(raiz.dir, chave);
        }
        return raiz;
    }

    public void mostrarEmOrdem() {
        mostrarOrdenado(raiz);
    }

    private void mostrarOrdenado(Nodo raiz) {
        if (raiz != null) {
            mostrarOrdenado(raiz.esq);
            System.out.print(raiz.chave + " | ");
            mostrarOrdenado(raiz.dir);
        }
    }

    public void mostrarEmOrdemDecrescente() {
        mostrarDecrescente(raiz);
    }

    private void mostrarDecrescente(Nodo raiz) {
        if (raiz != null) {
            mostrarDecrescente(raiz.dir);
            System.out.println(raiz.chave + " | ");
            mostrarDecrescente(raiz.esq);
        }
    }

    public void mostrarPorNivel() {
        if (raiz == null) {
            System.out.println("Arvore vazia");
            return;
        }
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();
            for (int i = 0; i < tamanhoNivel; i++) {
                Nodo nodoAtual = fila.poll();
                if (nodoAtual != null) {
                    System.out.println(nodoAtual.chave + "");
                    fila.add(nodoAtual.esq);
                    fila.add(nodoAtual.dir);
                } else {
                    System.out.println("-");
                }
            }
            System.out.println();// nova linha para separar os niveis
        }
    }

    public void remover(int chave) {
        raiz = removerItem(raiz, chave);
    }

    private Nodo removerItem(Nodo raiz, int chave) {
        if (raiz == null) {
            // nó nao encontrado, nao faz nada
            return null;
        }
        if (chave < raiz.chave) {
            // chave a ser removida esta a esquerda
            raiz.esq = removerItem(raiz.esq, chave);
        } else if (chave > raiz.chave) {
            raiz.dir = removerItem(raiz.dir, chave);
        } else {
            // encontramos o nó a ser removido
            if (raiz.esq == null) {
                // caso em que o no nao possui filho a esquerda
                return raiz.dir;
            } else if (raiz.dir == null) {
                // caso em que o nó nao possui filha a direita
                return raiz.esq;
            } else {
                // caso em que o nó possui ambos os filhos
                // nó sucessor será o menor da subarvore da direita
                Nodo sucessor = encontrarSucessor(raiz.dir);
                raiz.chave = sucessor.chave;
                raiz.dir = removerItem(raiz.dir, sucessor.chave);
            }
        }
        return raiz;
    }

    private Nodo encontrarSucessor(Nodo nodo) {
        while (nodo.esq != null) {
            nodo = nodo.esq;
        }
        return nodo;
    }

    //questao a)
    public int mostrarMaiornumero() {
        return maiornumero(raiz);
    }

    public int maiornumero(Nodo raiz) {
        while (raiz.dir != null) {
            raiz = (raiz.dir);
        }
        return raiz.chave;
    }

    //questao b)
    public int mostrarMenornumero() {
        return menornumero(raiz);
    }

    public int menornumero(Nodo raiz) {
        while (raiz.esq != null) {
            raiz = raiz.esq;
        }
        return raiz.chave;
    }

    //questao c)
    public void mostrarNosfolha() {
        nosfolha(raiz);
    }

    public void nosfolha(Nodo raiz) {
        if (raiz != null) {
            nosfolha(raiz.esq);
            nosfolha(raiz.dir);
            if (raiz.esq == null && raiz.dir == null) {
                System.out.println(raiz.chave);
            }
        }
    }

    public void mostrarAncestral(int chave) {
        ancestral(raiz, chave);
    }

    public void ancestral(Nodo raiz, int chave) {
        if (raiz != null) {
            ancestral(raiz.esq, chave);
            if (raiz.esq != null) {
                if (raiz.esq.chave == chave) {
                    System.out.println(raiz.chave);
                }
            }
            ancestral(raiz.dir, chave);
            if (raiz.dir != null) {
                if (raiz.dir.chave == chave) {
                    System.out.println(raiz.chave);
                }
            }
        }
    }

    //questao d)
    public void mostrarAncestrais(int chave) {
        Queue<Nodo> lista2 = ancestrais(raiz, chave);
        while (!lista2.isEmpty()) {
            System.out.println(lista2.poll().chave);
        }
    }

    Queue<Nodo> lista = new LinkedList<>();

    public Queue<Nodo> ancestrais(Nodo raiz, int chave) {
        if (chave < raiz.chave) {
            lista = (ancestrais(raiz.esq, chave));
        } else if (chave > raiz.chave) {
            lista = (ancestrais(raiz.dir, chave));
        }
        lista.add(raiz);
        return lista;
    }

    //questao e)
    public void mostrarDescendentes(int chave) {
        descendentes(raiz, chave);
    }

    public void descendentes(Nodo raiz, int chave) {
        if (chave < raiz.chave) {
            descendentes(raiz.esq, chave);
        } else if (chave > raiz.chave) {
            descendentes(raiz.dir, chave);
        } else {
            mostrarDecrescente(raiz);
        }

    }

    //questao f)
    public void mostrarSubarvoredireita(int chave) {
        subArvoredireita(raiz, chave);
    }

    public void subArvoredireita(Nodo raiz, int chave) {
        if (chave < raiz.chave) {
            subArvoredireita(raiz.esq, chave);
        } else if (chave > raiz.chave) {
            subArvoredireita(raiz.dir, chave);
        } else {
            if (raiz.dir != null) {
                System.out.println(raiz.dir.chave);
                if (raiz.dir.dir != null) {
                    System.out.println(raiz.dir.dir.chave);
                }
                if (raiz.dir.esq != null) {
                    System.out.println(raiz.dir.esq.chave);
                }
            }
        }
    }

    //questao g)
    public void mostrarSubarvoreesquerda(int chave) {
        subArvoreesquerda(raiz, chave);
    }

    public void subArvoreesquerda(Nodo raiz, int chave) {
        if (chave < raiz.chave) {
            subArvoreesquerda(raiz.esq, chave);
        } else if (chave > raiz.chave) {
            subArvoreesquerda(raiz.dir, chave);
        } else {
            if (raiz.esq != null) {
                System.out.println(raiz.esq.chave);
                if (raiz.dir.dir != null) {
                    System.out.println(raiz.esq.dir.chave);
                }
                if (raiz.dir.esq != null) {
                    System.out.println(raiz.esq.esq.chave);
                }
            }
        }
    }

    //questao h)
    public void mostrarComolistaencadeada() {
        ListaEncadeada lista2 = new ListaEncadeada();
        lista2 = listaencadeada(raiz);
        lista2.mostraLista();
    }

    ListaEncadeada listae = new ListaEncadeada();

    public ListaEncadeada listaencadeada(Nodo raiz) {
        if (raiz != null) {
            listaencadeada(raiz.dir);
            listae.inserir(raiz.chave);
            listaencadeada(raiz.esq);
        }
        return listae;
    }

    //questao i)
    public void mostrarPares() {
        mostrapares(raiz);
    }

    public void mostrapares(Nodo raiz) {
        if (raiz != null) {
            mostrapares(raiz.dir);
            if ((raiz.chave % 2) == 0) {
                System.out.println(raiz.chave);
            }
            mostrapares(raiz.esq);
        }
    }

    //questao j)
    public int mostrarNivel(int chave) {
        return mostraNivel(raiz, chave);
    }

    int cont = 0;

    public int mostraNivel(Nodo raiz, int chave) {
        if (raiz != null) {
            if (chave == raiz.chave) {
                return cont++;
            } else if (chave < raiz.chave) {
                cont = mostraNivel(raiz.esq, chave);
                cont++;
            } else if (chave > raiz.chave) {
                cont = mostraNivel(raiz.dir, chave);
                cont++;
            }
            return cont;
        }
        return cont++;
    }

    //questao k)
    public int mostrarAltura() {
        return alturaIterativa(raiz);
    }

    public int mostraAltura(Nodo raiz) {
        if (raiz != null) {
            if (mostraAltura(raiz.dir) > cont) {
                cont = mostraAltura(raiz.dir);
                cont++;
            } else if (mostraAltura(raiz.esq) > cont) {
                cont = mostraAltura(raiz.esq);
                cont++;
            }
            return cont;
        }
        return cont++;
    }

    public int alturaIterativa(Nodo root) {
        if (root == null)
            return -1;
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(root);
        int altura = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            altura++;
            while (size > 0) {
                Nodo node = queue.remove();
                if (node.esq != null)
                    queue.add(node.esq);
                if (node.dir != null)
                    queue.add(node.dir);
                size--;
            }
        }
        return altura;
    }

    //questao m)
    public void inserirNaorecursivo(int chave) {
        raiz = naoRecursivo(raiz, chave);
    }
    public Nodo naoRecursivo(Nodo raiz, int chave) {
        if (raiz == null) {
            raiz = new Nodo(chave);
            return raiz;
        }
        Nodo atual = raiz;
        Nodo anterior = null;
        while (true) {
            anterior = atual;S
            if (chave < atual.chave) {
                atual = atual.esq;
                if (atual == null) {
                    anterior.esq = new Nodo(chave);
                    return raiz;
                }
            }else{
                atual = atual.dir;
                if (atual == null) {
                    anterior.dir = new Nodo(chave);
                    return raiz;
                }
            }
        }
    }
}
//    public int maiornumero1(Nodo raiz, int num){
//        int maioresq;
//        int maiordir;
//        if (raiz != null) {
//            maioresq=maiornumero1(raiz.esq, num);
//            if (raiz.chave>num) {
//                num=raiz.chave;
//            }
//            maiordir=maiornumero1(raiz.dir, num);
//            if (raiz.chave>num) {
//                num=raiz.chave;
//            }
//            if (maiordir>num) {
//                num = maiordir;
//            } else if (maioresq > num) {
//                num = maioresq;
//            }
//        }
//        return num;
//    }
