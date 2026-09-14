public class Deque {
	//propriedades da classe 
	private No cabeca = null;
	
	//métodos da classe
	public void entrarPelaEsquerda(int numero) {
		cabeca = new No(numero, cabeca);
	}
	
	public void entrarPelaDireita(int numero) {
		//Cenario facil: fila vazia
		if (cabeca == null) {
			cabeca = new No(numero, cabeca);
			return; 	//rápido 
		} 
		
		//cenario dificil: deque não vazio
		No ultimo = cabeca;
		while (ultimo.getProximo() != null) { //procurando o ultimo (ou seja o cara que aponta pra nulo)
			ultimo = ultimo.getProximo();
		}
		ultimo.setProximo(new No(numero, null)); //vai até o último e adiciona o número lá, leno 
	}
	
	public void sairPelaEsquerda() { //sem parametro pq ele vai sair independente do número
		//Muito fácil: deque vazio
		if (cabeca == null) {
			return;
		}
		
		//fácil: deque não vazio
		System.out.println(cabeca.getNumero());
		cabeca = cabeca.getProximo();
	}
	
	public void sairPelaDireita() {
		//Muito fácil: deque vazio
		if (cabeca == null) {
			return;
		}	
		
		//fácil: deque com UM nó 
		if (cabeca.getProximo() == null) {
			System.out.println(cabeca.getNumero());
			cabeca = null; //atribuindo
			return;
		}
		
		//dificil: deque tem mais de um nó
		No penultimo = cabeca;
		while (penultimo.getProximo().getProximo() != null) { //procurando o penultimo, ou seja o cara que o PRÓXIMO aponta pra nulo 
			penultimo = penultimo.getProximo();
		}
		System.out.println(penultimo.getProximo().getNumero()); // penultimo.getProximo = ultimo  ou seja, pega o número
		penultimo.setProximo(null); //torna o penultimo em ultimo
	}
	
	public void imprimir() {
		No ponteiro = cabeca;
		
		while (ponteiro != null) {
			System.out.println(ponteiro.getNumero());
			ponteiro = ponteiro.getProximo();
		}
	}
}
