public class RetornoRecursao {
	//propriedades da classe
	private int ChaveDoMeio = 0;
	private No FilhoDoMeio = null;
	
	//constructors using fields e getter setters	
	
	public RetornoRecursao() {
		super();
	}
	public RetornoRecursao(int ChaveDoMeio, No FilhoDoMeio) {
		super();
		this.ChaveDoMeio = ChaveDoMeio;
		this.FilhoDoMeio = FilhoDoMeio;
	}
	public int getChaveDoMeio() {
		return ChaveDoMeio;
	}
	public void setChaveDoMeio(int chaveDoMeio) {
		ChaveDoMeio = chaveDoMeio;
	}
	public No getFilhoDoMeio() {
		return FilhoDoMeio;
	}
	public void setFilhoDoMeio(No filhoDoMeio) {
		FilhoDoMeio = filhoDoMeio;
	}
	
}
