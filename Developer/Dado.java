import java.util.concurrent.ThreadLocalRandom;

public class Dado{
	
	private int valor;

	public Dado(){
		valor = ThreadLocalRandom.current().nextInt(1, 7);
	}

	public int getValor(){
		return valor;
	}

	public void setValor(){
		valor = ThreadLocalRandom.current().nextInt(1, 7);
	}

	public int somaValores(Dado outroDado){
		return valor + outroDado.getValor();
	}

	public boolean verificaValores(Dado outroDado){
		if(valor == outroDado.getValor()) return false;
		else return true;
	}
}