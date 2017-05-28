import java.util.Arrays;

public class Jogador{
	
	private int posicao;
	private int saldo;
	private boolean preso;
	private boolean livre_prisao;
	private String nome;

	public Jogador(String nome){
		posicao = 0;
		saldo = 2458;
		preso = false;
		livre_prisao = false;
		this.nome = nome;
	}

	public String getNome(){
		return nome;
	}

	public int getPosicao(){
		return posicao;
	}

	public void andar(int posicao){
		this.posicao += posicao;
		
		if(this.posicao >= 40) this.posicao = this.posicao - 40;
	}
}