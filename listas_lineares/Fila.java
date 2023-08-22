package Arvores.listas_lineares;

public class Fila {
	

		private Nodo inicio=null;
		private Nodo fim;
		private int limite=0;
		private int tamanho=0;
		
		public Fila(int limite) {
			this.limite=limite;
		}
		
		public boolean estaVazio() {
			return tamanho == 0;
		}
		
		public boolean temEspaco() {
			return limite > tamanho;
		}
		
		public int getinicio(){
			if(!estaVazio()) {
				return inicio.getDado();
			}else {
				System.out.println("Fila esta vazia");
				return -1;
			}
		}
		
		public void inserir(int dado) {
			if(temEspaco()) {
				Nodo novo=new Nodo(dado);
				if(estaVazio()) {
					inicio=novo;
					fim=novo;
				}else {
					fim.setProx(novo);
					fim=novo;
				}
				tamanho++;
			}else
				System.out.println("fila cheia!");
		}
		
		/*public void remover() {
			if(!estaVazio()) {
				System.out.println("Removido"+inicio.getDado());
				inicio=inicio.getProx();
				tamanho--;
			}else {
				System.out.println("A fila esta vazia");
			}
		}*/
		public Integer remover() {
			if(estaVazio()) {
				return null;
			}
			int valor=inicio.getDado();
			inicio=inicio.getProx();
			tamanho--;
			if(estaVazio()) {
				fim=null;
			}
			return valor;
		}
		
		/*public void separador(Fila f,Fila pares,Fila imp) {
			
			Nodo novo=new Nodo(f.getinicio());
			
			for(int x=0;x<f.tamanho;x++) {
				
				
				if((novo.getDado()%2)==0) {
					pares.inserir(novo.getDado());
				}else {
					imp.inserir(novo.getDado());
				}
				novo=novo.getProx();
			}
			System.out.println(f);
			System.out.println(pares);
			System.out.println(imp);
		}*/
		public void separador(Fila f,Fila pares,Fila imp) {
			while(!f.estaVazio()) {
				int num=f.remover();
				if(num%2==0) {
				  pares.inserir(num);
				}else{
					imp.inserir(num);
				}
			}
		}
		
	}


