public class Arvore {
	//propriedades da classe
	private No raiz = null;
	
	//métodos da classe
	private int getAlturaDoNo(No raiz) {
		if (raiz == null) return 0;
		return raiz.getAltura();
	}
	
	private int getMaximoEntreDoisNumeros(int a, int b) {
		return (a > b) ? a : b;
	}
	
	private int getBalanco(No raiz) {
		if (raiz == null) return 0;
		return (getAlturaDoNo(raiz.getEsquerda()) - getAlturaDoNo(raiz.getDireita())); //positivo = inclinado pra esquerda, negativo = inclina pra direita
	}
	
	No rotacionarEsquerda(No raizVelha) {
		//correção dos ponteiros
		No raizNova = raizVelha.getDireita();
		raizVelha.setDireita(raizNova.getEsquerda());
		raizNova.setEsquerda(raizVelha);
		//correção das alturas
		raizVelha.setAltura(getMaximoEntreDoisNumeros(
				getAlturaDoNo(raizVelha.getEsquerda()), 
				getAlturaDoNo(raizVelha.getDireita())) +1);
		raizNova.setAltura(getMaximoEntreDoisNumeros(
				getAlturaDoNo(raizNova.getEsquerda()),
				getAlturaDoNo(raizNova.getDireita())) +1);
		//retorno da raiz nova
		return raizNova;
	}
	
	No rotacionarDireita(No raizVelha) {
		//correção dos ponteiros
		No raizNova = raizVelha.getEsquerda();
		raizVelha.setEsquerda(raizNova.getDireita());
		raizNova.setDireita(raizVelha);
		//correção das alturas
		raizVelha.setAltura(getMaximoEntreDoisNumeros(
				getAlturaDoNo(raizVelha.getEsquerda()), 
				getAlturaDoNo(raizVelha.getDireita())) +1);
		raizNova.setAltura(getMaximoEntreDoisNumeros(
				getAlturaDoNo(raizNova.getEsquerda()),
				getAlturaDoNo(raizNova.getDireita())) +1);
		//retorno da raiz nova
		return raizNova;
	}
	
	public void inserir(int numero) {
		raiz = inserir(raiz, numero);
	}
	
	private No inserir(No raiz, int numero) {
		//caso fácil: arvore vazia
		if (raiz == null) {
			return new No(numero, null, null, 1);
		}
		
		//caso dificil: arvore NÃO vazia
		if (numero < raiz.getNumero()) {
			raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
		} else {
			raiz.setDireita(inserir(raiz.getDireita(), numero));
		}
		
		//correções de balanceamento
		raiz.setAltura(1 + getMaximoEntreDoisNumeros(
						getAlturaDoNo(raiz.getEsquerda()),
						getAlturaDoNo(raiz.getDireita())));
		
		int balanco = getBalanco(raiz);
		
		//inclinação à esquerda, inserção de número menor à esquerda
		if ((balanco > 1) && (numero < raiz.getEsquerda().getNumero())) {
			raiz = rotacionarDireita(raiz);
		}
		
		//inclinação à direita, inserção de numero menor à direita
		if ((balanco <-1) && (numero > raiz.getDireita().getNumero())) {
			raiz = rotacionarEsquerda(raiz);
		}
		
		//inclinação à esquerda, inserção de numero maior à direita
		if ((balanco > 1) && (numero > raiz.getEsquerda().getNumero())) {
			raiz.setEsquerda(rotacionarEsquerda(raiz.getEsquerda()));
			raiz = rotacionarDireita(raiz);
		}
		
		//inclinação à direita, inserção de numero menor à direita
		if ((balanco <-1) && (numero < raiz.getDireita().getNumero())) {
			raiz.setDireita(rotacionarDireita(raiz.getDireita()));
			raiz = rotacionarEsquerda(raiz);	
		}
		return raiz;
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if (raiz == null) return;
		
		System.out.println(indentacao + raiz.getNumero());
		imprimir(raiz.getEsquerda(), indentacao + "___");
		imprimir(raiz.getDireita(), indentacao + "___");
	}
}
