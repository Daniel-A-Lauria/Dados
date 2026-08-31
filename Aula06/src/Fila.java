public class Fila {
	//propriedades da classe
	private No cabeca = null;
	
	//metódos da classe
	public void entrar(int numero){
		cabeca = new No(numero, cabeca);
	}
	
	public void sair() {
		//caso fácil: fila vazia
		if (cabeca == null) {
			System.out.println("A fila está vazia!");
			return;
		}
		
		//caso médio: fila só tem um único nó
		if (cabeca.getProximo() == null) {
			System.out.println(cabeca.getNumero());
			cabeca = null;
			return; 
		}
		
		//caso díficil: fila tem mais de um nó
		No ponteiro = cabeca;
		while (ponteiro.getProximo().getProximo() != null) { //repróximo tem que ser nulo pra parar no penúltimo
			ponteiro = ponteiro.getProximo();
		}
		System.out.println(ponteiro.getProximo().getNumero());
		ponteiro.setProximo(null);
	}
}
