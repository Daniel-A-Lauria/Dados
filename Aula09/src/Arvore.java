public class Arvore {
	//propriedades da classe
	private No raiz = null;
	
	//métodos da classe
	public void inserir(int numero) { //método fake que chama o real
		raiz = inserir(raiz, numero); //raiz "nova" / raiz "velha"
	}
	
	private No inserir(No raiz, int numero) { //a raiz aqui não é a raiz "verdadeira", ela é um paramêtro, pois qualquer nó pode ser uma raiz 
		//cenário fácil: árvore vazia
		if (raiz == null) {
			return new No(numero, null, null, null, null, null); //deixa os nós nulos, menos a raiz
		}
		
		//cenário díficil: arvore não vazia
		int sorteio = (1 + ((int) (5 * Math.random()))); //sorteira entre os 5 filhos 
		
		if (sorteio == 1) { //daria pra fazer vetor ao invés de tanto else if 
			raiz.setFilho1(inserir(raiz.getFilho1(), numero)); //LINHA MAIS DIFICIL DO SEMESTRE
			//chamando a si mesmo, se fingir que a raiz da arvore é o filho1, vai adotar o mesmo comportamento de uma arvore 
			//vai pra linha 12, vê que filho1 = null, e faz um novo nó com seus próprios filhos, daí volta pra essa linha 
			//isso pode se repetir, pra fazer um terceiro nó
		} else if (sorteio == 2) {
			raiz.setFilho2(inserir(raiz.getFilho2(), numero));
		} else if (sorteio == 3) {
			raiz.setFilho3(inserir(raiz.getFilho3(), numero));
		} else if (sorteio == 4) {
			raiz.setFilho4(inserir(raiz.getFilho4(), numero));
		} else {
			raiz.setFilho5(inserir(raiz.getFilho5(), numero));
		}
		return raiz;
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if (raiz == null) return;
		
		System.out.println(indentacao + raiz.getNumero());
		imprimir(raiz.getFilho1(), indentacao + "---");
		imprimir(raiz.getFilho2(), indentacao + "---");
		imprimir(raiz.getFilho3(), indentacao + "---");
		imprimir(raiz.getFilho4(), indentacao + "---");
		imprimir(raiz.getFilho5(), indentacao + "---");
	}
}

