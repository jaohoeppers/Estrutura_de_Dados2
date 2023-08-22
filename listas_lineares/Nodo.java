package Arvores.listas_lineares;

public class Nodo {
private int preco;
private int quant;
private int dado;
private Nodo prox;

public Nodo(int dado) {
	this.dado=dado;
	this.prox=null;
}

public int getDado() {
	return dado;
}

public void setDado(int dado) {
	this.dado = dado;
}

public Nodo getProx() {
	return prox;
}

public void setProx(Nodo prox) {
	this.prox = prox;
}

public int getPreco() {
	return preco;
}

public void setPreco(int preco) {
	this.preco = preco;
}

public int getQuant() {
	return quant;
}

public void setQuant(int quant) {
	this.quant = quant;
}
	
}