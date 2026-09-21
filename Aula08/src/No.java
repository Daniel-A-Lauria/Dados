public class No { //representação das colunas da matriz
	//propriedades da classe
	private int numero = 0;
	private No proximo = null;
	
	//constructors e getter setter
	public No() {
		super();
	}
	public No(int numero, No proximo) {
		super();
		this.numero = numero;
		this.proximo = proximo;
	}
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
