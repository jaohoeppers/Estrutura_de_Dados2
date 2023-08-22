package Arvores.listas_lineares;

public class pilha {
	private Nodo topo;
	private int tamanho=0;
	private int limite=0;
	
	public pilha(int limite) {
		this.limite=limite;
	}
	
	
	public Nodo getTopo() {
		return topo;
	}


	public void setTopo(Nodo topo) {
		this.topo = topo;
	}


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	public boolean estaVazio() {
		return tamanho == 0;
	}
	
	public boolean temEspaco() {
		return limite > tamanho;
	}


	public void push(int dado) {
		if(temEspaco()) {
			Nodo novo=new Nodo(dado);
			novo.setProx(topo);
			topo=novo;
			tamanho++;
		}else {
			System.out.println("pilha cheia");
		}
	}
	
	public void pop() {
		if(!estaVazio()) {
			System.out.println(topo.getDado()+"foi retirado");
			topo=topo.getProx();
			tamanho--;
			}else {
				System.out.println("pilha esta vazia");
			}
	}

}
