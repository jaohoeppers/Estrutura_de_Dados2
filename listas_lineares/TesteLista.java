package Arvores.listas_lineares;

public class TesteLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaEncadeada lista1=new ListaEncadeada();
		
		lista1.inserir(8);
		lista1.inserir(6);
		lista1.inserir(5);
		lista1.mostraLista();
		
		lista1.inserir(2);
		lista1.mostraLista();
		
		
		lista1.deleteComValor(6);
		lista1.mostraLista();
		/*
		
		ListaCircular lista2=new ListaCircular();
		
		lista2.inserindo(8);
		lista2.inserindo(6);
		lista2.inserindo(5);
		System.out.println(lista2.mostrarLista());
		
		lista2.inserindo(2);
		System.out.println(lista2.mostrarLista());
		
		
		pilha p1 = new pilha(3);
		
		p1.push(4);
		p1.push(7);
		p1.push(1);
		p1.push(3);
		System.out.println("Topo="+p1.getTopo());
		
		p1.pop();
		System.out.println("Topo="+p1.getTopo());
		
		f1.remover();
		f1.remover();
		f1.remover();
		f1.remover();
		
		Fila f1 =new Fila(3);
		f1.inserir(5);
		f1.inserir(7);
		f1.inserir(1);
		f1.inserir(10);
		
		Fila pares=new Fila(3);
		Fila imp=new Fila(3);
		Fila teste=new Fila(1);
		
		teste.separador(f1, pares, imp);
		*/
		
		
		
	}

}
