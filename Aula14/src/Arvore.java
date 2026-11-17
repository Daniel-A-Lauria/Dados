public class Arvore {
	//propriedades da classe
	private No raiz = null;
	
	//metodo construtor cheio da classe
	public Arvore(int tamanho) {
		raiz = new No(tamanho);
	}
	
	//metodos da classe
	public void inserir(int numero) {
		RetornoRecursao retorno = inserir(raiz, numero, null);
		
		if (retorno != null) { //arvore b não cresce pra baixo, cresce pra cima
			No novaRaiz = new No(raiz.getChaves().length);
			novaRaiz.setFolha(false);
			novaRaiz.setQtdChaves(1);
			novaRaiz.setChave(0, retorno.getChaveDoMeio());
			novaRaiz.setFilho(0, raiz);
			novaRaiz.setFilho(1, retorno.getFilhoDoMeio());
			raiz = novaRaiz;
		}
	}
	
	private RetornoRecursao inserir(No raiz, int numero, No filho) {
		//Caso díficil: não é uma folha, tem de procurar a folha certa pra inserir
		if ((! raiz.isFolha()) && (filho == null)) {
			int indiceFilho = 0;
			boolean encontrei = false;
		
			//procurar o filho certo pra descer
			for (int i = 0 ; i < raiz.getQtdChaves() ; i++) {
				if (raiz.getChave(i) > numero) {
					indiceFilho = i;
					encontrei = true;
					break;
				}
			}
			
			if (! encontrei) {
				indiceFilho = raiz.getQtdChaves();
			}
			
			//recursao de decida da arvore
			RetornoRecursao retorno = inserir(raiz.getFilho(indiceFilho), numero, filho);
			//recursao de subida da arvore
			if (retorno != null) {
				retorno = inserir(raiz, retorno.getChaveDoMeio(), 
						 				retorno.getFilhoDoMeio());
			}
			return retorno;
		}
		
		//caso fácil: é folha e não esta cheia
		if (! raiz.estaCheia()) {
			raiz.inserir(numero, filho);
			return null;
		}
		
		//caso díficil: é folha e esta cheia
		int IndiceDoMeio = (raiz.getQtdChaves() / 2);
		int ChaveDoMeio = raiz.getChave(IndiceDoMeio);
		
		No novoNo = new No(raiz.getChaves().length);
		novoNo.setFolha(raiz.isFolha());
		
		int novoIndice = 0;
		for(int i = (IndiceDoMeio + 1) ; i < raiz.getQtdChaves() ; i++) {
			novoNo.setChave(novoIndice, raiz.getChave(i));
			novoNo.setFilho(novoIndice, raiz.getFilho(i));
			raiz.setChave(i, 0);
			raiz.setFilho(i, null);
			novoIndice++;
		}
		novoNo.setFilho(novoIndice, raiz.getFilho(raiz.getQtdChaves()));
		raiz.setFilho(raiz.getQtdChaves(), null);
		raiz.setChave(IndiceDoMeio, 0);
		
		//ver se é par ou impar para ver quantos valores sobraram em cada lado
		novoNo.setQtdChaves(IndiceDoMeio - ((raiz.getQtdChaves() % 2) == 0 ? 1 : 0));
		raiz.setQtdChaves(IndiceDoMeio);
		
		if (numero < ChaveDoMeio) {
			raiz.inserir(numero, filho);
		} else {
			novoNo.inserir(numero, filho);
		}
		
		return new RetornoRecursao(ChaveDoMeio, novoNo);
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if (raiz == null) return;
		
		System.out.println(indentacao + raiz.imprimirChaves());
		for (No objFilho : raiz.getFilhos()) {
			imprimir(objFilho, indentacao + "___");
		}
	}
}
