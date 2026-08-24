package defaultpack;

public class Lista {
	//propriedades da classe
	private No cabeca = null; //declaração do ponteiro
	
	//métodos da classe
	//inserção dos nós na lista
	public void inserir(int numero) {
		//caso fácil, lista vazia
		if (cabeca == null) {
			cabeca = new No(numero, null);
			return;
		}
		//caso dificil, lista possui elementos
		No ultimo = cabeca;
		while (ultimo.getProximo() != null) {
			ultimo = ultimo.getProximo(); //apontando o ponteiro pra frente até chegar no último
		}
		ultimo.setProximo(new No (numero, null));
	}
	//exclusão dos nós
	public void excluir (int numero) {
		//caso mega facil: lista vazia 
		if (cabeca == null) {
			return;
		}
		//caso fácil: excluir o primeiro nó da lista 
		if (cabeca.getNumero() == numero) {
			cabeca = cabeca.getProximo();
			return;
		}
		//caso díficil: excluir nó no meio ou final da lista
		No anterior = cabeca;
		while (((anterior.getProximo() != null) && //chegou no fim e não achou nada
				anterior.getProximo().getNumero() != numero)) { // olhar isso 
					anterior = anterior.getProximo();
				}
				
				if (anterior.getProximo() == null) {
					//caso onde foi tentada a exclusão de um número que não existe
					return;
				}
				
				//caso da exclusão propriamente dita no meio ou fim
				anterior.setProximo(anterior.getProximo().getProximo());
	}

	//print dos nós
	public void imprimir() {
		No ponteiro = cabeca;
		while (ponteiro != null) {
			System.out.println(ponteiro.getNumero());
			ponteiro = ponteiro.getProximo();
		}
	}

}
