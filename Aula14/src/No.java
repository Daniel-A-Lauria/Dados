public class No {
	//propriedades da classe 
	private int[] chaves = null;
	private No[] filhos = null;
	private boolean folha = true;
	private int qtdChaves = 0;
	
	//metodo construto cheio da classe
	public No(int tamanho) {
		chaves = new int[tamanho];
		filhos = new No[tamanho + 1];
		
	}

	//getters setters
	public int[] getChaves() {
		return chaves;
	}

	public void setChaves(int[] chaves) {
		this.chaves = chaves;
	}

	public No[] getFilhos() {
		return filhos;
	}

	public void setFilhos(No[] filhos) {
		this.filhos = filhos;
	}

	public boolean isFolha() {
		return folha;
	}

	public void setFolha(boolean folha) {
		this.folha = folha;
	}

	public int getQtdChaves() {
		return qtdChaves;
	}

	public void setQtdChaves(int qtdChaves) {
		this.qtdChaves = qtdChaves;
	}
	
	//metodos da classe
	public int getChave(int indice) {
		return chaves[indice];
	}
	
	public void setChave(int indice, int valor) {
		chaves[indice] = valor;	
	}
	public No getFilho(int indice) {
		return filhos[indice];
	}
	public void setFilho(int indice, No valor) {
		filhos [indice] = valor;
	}
	
	public boolean estaCheia() {
		return (qtdChaves == chaves.length);
	}
	
	public void inserir(int valor, No filho) {
		int lugarCerto = 0;
		boolean encontrei = false;
		
		//for de achar o local certo de inserção
		for (int i = 0 ; i < qtdChaves ; i++) {
			if (chaves[i] > valor) {
				lugarCerto = i;
				encontrei = true;
				break;
			}
		}
		//caso o número ser maior que os outros da lista
		if (! encontrei) {
			lugarCerto = qtdChaves;
		}
		//empurrando os valores velhos pra fentre até o lugar certo estar livre
		for (int i = (qtdChaves - 1) ; i >= lugarCerto; i--) {
			chaves[i + 1] = chaves[i];
			filhos[i + 2] = filhos[i + 1];
		}
		chaves[lugarCerto] = valor;
		filhos[lugarCerto + 1] = filho;
		
		qtdChaves++; //aumentar o contador de chaves na folha
		}
	
		public String imprimirChaves() {
			String retorno = "";
			
			for (int i = 0 ; i < qtdChaves ; i++) {
				retorno += (", " + chaves[i]);
			}
			if (retorno.length() > 0) retorno = retorno.substring(2);
			
			return retorno;
		}
	}
