public class Lista {
	//propriedade 
	private No cabeca = null;
	
	//métodos da classe
	public void inserir(int numero) {
		//cenario fácil: lista vazia
		if (cabeca == null) {
			cabeca = new No(numero, null); //não pode botar cabeca aqui, apontaria pra cabeca "antiga"
			cabeca.setProximo(cabeca);
			return;
		}
		
		//cenario díficil: lista não vazia
		No ultimo = cabeca;
		while (ultimo.getProximo() != cabeca) {
			ultimo = ultimo.getProximo();
		}
		ultimo.setProximo(new No(numero, cabeca));
	}
	
	public void excluir(int numero) {
		//cenario muito fácil: lista vazia
		if (cabeca == null) {
			return;
		}
		
		//cenario fácil: excluir o único
		if ((cabeca.getNumero() == numero) && (cabeca.getProximo() == cabeca)) {
			cabeca = null;
			return;
		}
		
		//cenario medio: excluir o primeiro
		if (cabeca.getNumero() == numero) {
			No ultimo = cabeca; 
			while (ultimo.getProximo() != cabeca) {
				ultimo = ultimo.getProximo();
			}
			cabeca = cabeca.getProximo();
			ultimo.setProximo(cabeca);
			return;
		}
		
		//cenário díficil: excluir no meio ou no fim
		No anterior = cabeca;
		while ((anterior.getProximo() != cabeca) &&
				(anterior.getProximo().getNumero() != numero)) {
			anterior = anterior.getProximo();
		}
		
		if (anterior.getProximo() == cabeca) {
			return; //cenário não foi encontrado
		}
		
		anterior.setProximo(anterior.getProximo().getProximo()); //pular de 1 pra 3 pra matar o 2
		
	}
	
	public void imprimir() {
		No ponteiro = cabeca;
		
		if (ponteiro == null) {
			return;
		}
		
		do {
			System.out.println(ponteiro.getNumero()); 
			ponteiro = ponteiro.getProximo();
		} while (ponteiro != cabeca); //vai vendo se o nmro é a cabeca até achar
		
	}
	
}
