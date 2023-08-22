package Arvores.listas_lineares;

public class exercicios {
	
	//implementar os seguintes metodos
	//
	//1 contar nodos da lista LC
	//2 inserir no final LC
	//3 deletar ultimo LE
	//4 deletar primeiro LE 
	//5 buscar um valor e caso encontre retornar a posição na lista LE e LC
	
	public static void main(String[] args) {
		
		
///////////////////1
		
		ListaCircular lista2=new ListaCircular();
		
		lista2.inserindo(8);
		lista2.inserindo(6);
		lista2.inserindo(5);
		//System.out.println(lista2.contarNodos()+" Nodos");
		
		lista2.inserindo(2);
	//	System.out.println(lista2.contarNodos()+" Nodos");
	
/////////////////2
		
		lista2.inserirFinal(20);
		System.out.println(lista2.mostrarLista());
		
////////////////3
		
		
	
}	

}
