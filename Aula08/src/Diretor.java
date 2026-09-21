public class Diretor {
	//propriedades
	private int resto = 0; //resto da divisão
	private No proximoNo = null;
	private Diretor proximoDiretor = null;
	
	//construtor get sets, é uma class BLL 
	public Diretor() {
		super();
	}
	public Diretor(int resto, No proximoNo, Diretor proximoDiretor) {
		super();
		this.resto = resto;
		this.proximoNo = proximoNo;
		this.proximoDiretor = proximoDiretor;
	}
	public int getResto() {
		return resto;
	}
	public void setResto(int resto) {
		this.resto = resto;
	}
	public No getProximoNo() {
		return proximoNo;
	}
	public void setProximoNo(No proximoNo) {
		this.proximoNo = proximoNo;
	}
	public Diretor getProximoDiretor() {
		return proximoDiretor;
	}
	public void setProximoDiretor(Diretor proximoDiretor) {
		this.proximoDiretor = proximoDiretor;
	}
	
	
}
