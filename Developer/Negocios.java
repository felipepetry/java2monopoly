package bancoImobiliario;

public class Negocios extends CasaDoTabuleiro{
	
	private int preco;
	private int taxa;
	private int hipoteca;
	private Jogador proprietario;

	public Negocios(String legenda, int preco, int taxa, int hipoteca){
		super(legenda);
		this.preco = preco;
		this.taxa = taxa;
		this.hipoteca = hipoteca;
		proprietario = null;
	}
	
	public int getPreco(){
		return preco;
	}

	public int getTaxa(){
		return taxa;
	}

	public int getHipoteca(){
		return hipoteca;
	}

	public Jogador getProprietario(){
		return proprietario;
	}
	
	public void setProprietario(Jogador proprietario){
		this.proprietario = proprietario;
	}

	public String toString(){
		String toString = "s";
		
		return toString;
	}
}