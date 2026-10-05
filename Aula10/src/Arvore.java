public class Arvore {
	//propriedades da classe
	private No raiz = null;
	
	//métodos da classe
	public void inserir(int numero) {
		raiz = inserir(raiz, numero);
	}
	
	private No inserir(No raiz, int numero) {
		//cenário fácil: árvore vazia
		if (raiz == null) {
			return new No(numero, null, null);
		}
		//cenário difícil: arvore não vazia
		boolean sorteio = (((int) (2 * Math.random())) == 0);
		
		
		if (sorteio) { //50/50 entre esquerda e direita
			raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
		} else {
			raiz.setDireita(inserir(raiz.getDireita(), numero));
		}
		return raiz;
	}
	
	public void navegarPreOrdem() {
		System.out.print("Pré ordem: ");
		navegarPreOrdem(raiz);
		System.out.println("");

	}
	
	private void navegarPreOrdem(No raiz) {
		if (raiz == null) return;
		
		System.out.print(raiz.getNumero());
		navegarPreOrdem(raiz.getEsquerda());
		navegarPreOrdem(raiz.getDireita());
	}
	
	public void navegarEmOrdem() {
		System.out.print("Em ordem:  ");
		navegarEmOrdem(raiz);
		System.out.println();
	}
	
	private void navegarEmOrdem(No raiz) {
		if (raiz == null) return;
		
		navegarEmOrdem(raiz.getEsquerda());
		System.out.print(raiz.getNumero());
		navegarEmOrdem(raiz.getDireita());
	}
	
	public void navegarPosOrdem() {
		System.out.print("Pós ordem: ");
		navegarPosOrdem(raiz);
		System.out.println(" ");

	}
	
	private void navegarPosOrdem(No raiz) {
		if (raiz == null) return;
		
		navegarPosOrdem(raiz.getEsquerda());
		navegarPosOrdem(raiz.getDireita());
		System.out.print(raiz.getNumero());
	}
}
