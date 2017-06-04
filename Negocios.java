public class Negocios extends CasaDoTabuleiro{
	
	private int preco;
	private int taxa;
	private Jogador proprietario;

	public Negocios(String legenda, int preco, int taxa){
		super(legenda);
		this.preco = preco;
		this.taxa = taxa;
		proprietario = null;
	}
	
	public int getPreco(){
		return preco;
	}

	public int getTaxa(){
		return taxa;
	}

	public Jogador getProprietario(){
		return proprietario;
	}

	public String toString(){
		String toString = s;
		
		return toString;
	}
}