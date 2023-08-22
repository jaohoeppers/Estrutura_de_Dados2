package Arvores.listas_lineares;

import Arvores.listas_lineares.Nodo;
public class ListaEncadeada {
	private Nodo inicio;
	private Nodo fim;


	public ListaEncadeada() {
		inicio = null;
		fim = null;

	}

	public boolean vazia() {
		return inicio == null;

	}

	public Nodo getinicio() {
		return inicio;
	}

	public Nodo getfim() {
		return fim;
	}


	public void mostraLista() {
		if (vazia()) {
			System.out.println("Lista Vazia");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			System.out.println(aux.getDado() + " ");
			aux = aux.getProx();
		}
		System.out.println();
	}

	public void deleteComValor(int valor) {
		if (vazia()) return;
		if (inicio.getDado() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;

		while (aux != null) {

			if (aux.getProx().getDado() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
		System.out.println("nodo nao encontrado");

	}

	public void inserir(int dado) {
		if (inicio == null) {
			inicio = new Nodo(dado);
		} else {
			Nodo novonodo = new Nodo(dado);
			Nodo aux = inicio;

			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			aux.setProx(novonodo);

		}

	}
}

	
