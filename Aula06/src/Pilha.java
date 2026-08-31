public class Pilha {
	//propriedades da classe 
	private No cabeca = null;
	
	//metodo da classe 
	public void push(int numero) {
		cabeca = new No(numero, cabeca);
	}
	public void pop() {
		//caso muito fácil: pilha vazia
		if (cabeca == null) {
			return;
		}
		//caso facil: pilha não vazia
		System.out.println(cabeca.getNumero());
		cabeca = cabeca.getProximo();
	}
}
