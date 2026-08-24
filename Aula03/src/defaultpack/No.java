package defaultpack;

public class No {
	// Propriedades da classe
	private int numero = 0;
	private No proximo = null;  //ponteiro 
	
	//constructor using fields deselect all 
	public No() {
		super();
	}
	//select all
	public No(int numero, No proximo) {
		super();
		this.numero = numero;
		this.proximo = proximo;
	}
	//getter setters 
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
	
}
