package Arvores.listas_lineares;

public class ListaCircular {
	private Nodo inicio;
	private Nodo fim;
	
	public ListaCircular(){
		inicio=null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public Nodo getFim() {
		return fim;
	}

	public void setFim(Nodo fim) {
		this.fim = fim;
	}
	
/*	public void inserindo(int dado) {
		Nodo novoNodo = new Nodo(dado);
		if(inicio==null) {
			inicio=novoNodo;
			inicio.setProx(inicio);
			fim=inicio;
		}else {
			novoNodo.setProx(inicio);
			inicio=novoNodo;
			fim.setProx(inicio);
		}
	}*/
	public void inserindo(int dado) {
		if(inicio==null) {
			Nodo nodo = new Nodo(dado);
			inicio=nodo;
			inicio.setProx(inicio);
			fim=inicio;
		}else {
			Nodo nodo = new Nodo(dado);
			nodo.setProx(inicio);
			inicio=nodo;
			fim.setProx(inicio);
		}
	}
	
	/*public void inserirFinal(int dado) {
		Nodo novoNodo = new Nodo(dado);
		Nodo aux=inicio;
		if(inicio==null){
			inicio=novoNodo;
			fim=novoNodo;
			fim.setProx(inicio);
		}else{
			novoNodo.setProx(inicio);
			fim.setProx(novoNodo);
		}
	}*/
	public void inserirFinal(int dado) {
		if(inicio==null){
			Nodo nodo = new Nodo(dado);
			inicio=nodo;
			fim=nodo;
			fim.setProx(inicio);
		}else{
			Nodo nodo = new Nodo(dado);
			nodo.setProx(inicio);
			fim.setProx(nodo);
		}
	}
	public void altval(int desc) {
		Nodo aux=inicio;
		aux.setPreco(aux.getPreco()-((aux.getPreco()/100)*desc));
		aux=aux.getProx();
	}
	
	public String mostrarLista() {
		String lista="";
		if(inicio==null)return lista;
		Nodo aux=inicio;
		do {
			lista+=aux.getDado()+"\n";
			aux=aux.getProx();
		}while(aux!=inicio);
		return lista;
	}
	
	public int contarNodos() {
		int con =0;
		if(inicio==null)return con;
		
		Nodo aux=inicio;
		do {
			con++;
			aux=aux.getProx();
		}while(aux!=inicio);
		return con;
	}
	
	public void deleteComValor(int dado){
		if(inicio==null)return;
		if(inicio.getDado()==dado) {
			if(inicio==fim) {
				inicio=null;
			}
			inicio=inicio.getProx();
			fim.setProx(inicio);
			return;
		}
		Nodo aux=inicio;
		do {
			if(aux.getProx().getDado()==dado) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux=aux.getProx();
		}while(aux!=inicio);
		
	}	
	
}
