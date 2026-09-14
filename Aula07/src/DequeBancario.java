public class DequeBancario {
	//propriedades da classe 
	private No filaNormal = null;
	private No filaPreferencial = null;
	
	//metodos da classe
	public void entrar(boolean normal, int numero) {
		if (normal) {
			filaNormal = new No(numero, filaNormal);
		} else {
			filaPreferencial = new No(numero, filaPreferencial);
		}
	}
	
	private No sair(No fila) {
		//caso super fácil: fila vazia
		if (fila == null) {
			return null;
		}
		//caso fácil: só um nó 
		if (fila.getProximo() == null) {
			System.out.println(fila.getNumero());
			return null;
		}
		
		//caso díficil: mais de um nó
		No penultimo = fila;
		while (penultimo.getProximo().getProximo() != null) {
			penultimo = penultimo.getProximo();
		}
		System.out.println(penultimo.getProximo().getNumero());
		penultimo.setProximo(null); 
		return fila;
	}
	
	private int contador = 0;
	public void atender() {
		//caso muito fácil: ambas filas vazias
		if ((filaNormal == null) && (filaPreferencial == null)) {
			contador = 0;
			return;
		}
		//caso fácil: só tem uma fila normal
		if (filaPreferencial == null) {
			filaNormal = sair(filaNormal);
			contador = 0;
			return;
		}
		//caso fácil: só tem uma fila preferencial
		if (filaNormal == null) {
			filaPreferencial = sair(filaPreferencial);
			contador = 0;
			return;
		}
		//caso díficil: tem dos dois
		if (contador < 3) { // 3x1  
			filaPreferencial = sair(filaPreferencial);
			contador++;
		} else {
			filaNormal = sair(filaNormal);
			contador = 0;
		}
	}
}
