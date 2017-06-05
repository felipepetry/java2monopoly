package bancoImobiliario;

import java.util.Scanner;
import java.util.Arrays;

public class BancoImobiliario{
	
	public static void main(String args[]){
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Informe o número de jogadores: ");
		int num = in.nextInt();
		
		//Inicializa os objetos
		Jogador[] osJogadores = new Jogador[num];
		CasaDoTabuleiro[] asCasasDoTabuleiro = CasaDoTabuleiro.generateCasasDoTabuleiro();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		
		for(int cont = 0; cont < num; cont++){
			System.out.print("\fInforme o nome do jogador " + (cont + 1) + ": ");
			osJogadores[cont] = new Jogador(in.next());
		}
		
		int cont = 0;
		int soma;
		int posicao;
		
		//Loop onde o jogo é executado
		while(true){
			if(cont == num) cont = 0;
			//if(osJogadores[cont].verificaPreso()) cont++;
			if(cont == num) cont = 0;
			System.out.print("Agora é a vez de " + osJogadores[cont].getNome() + ". ");
			
			soma = lancaDado();
			
			if(soma == -1) osJogadores[cont].vaiPreso();
			
			osJogadores[cont].andar(soma);
			posicao = osJogadores[cont].getPosicao();
			System.out.println("Você caiu na posição " + (posicao + 1) + ". Nessa posição se encontra " + asCasasDoTabuleiro[posicao].getLegenda());
			
			acaoJogador(asCasasDoTabuleiro[posicao], osJogadores[cont], soma);
			
			cont++;
		}
	}
	
	public static int lancaDado(){
		
		Scanner in = new Scanner(System.in);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		int soma = 0;
		int dado = 0;
		
		while(true){
			System.out.println("Digite 'd' para lançar os dados: ");
			char verifica = in.next().charAt(0);

			while(verifica != 'd'){	
				System.out.print("Digite 'd' para lançar os dados: ");
				verifica = in.next().charAt(0);	
			}
			dado1.generateValor();
			System.out.println("\fO valor do primeiro dado foi " + dado1.getValor());
			dado2.generateValor();
			System.out.println("O valor do segundo dado foi " + dado2.getValor());
			soma = soma + dado1.somaValores(dado2);
			
			if(dado1.verificaValores(dado2)) break;
			else dado++;

			if(dado == 3){
				soma = -1;
				break;
			}
		}
		return soma;
	}
	
	public static void acaoJogador(CasaDoTabuleiro posicao, Jogador jogador, int soma){
		Scanner in = new Scanner (System.in);
		
		if(posicao instanceof Propriedades){
			if(((Propriedades)posicao).getProprietario() == null){
				System.out.println("Você quer comprar essa propriedade?\n" + ((Propriedades)posicao) + "\nDigite 's' para sim e 'n' para não.");
				char compra = in.next().charAt(0);
				
				while(compra != 's' && compra != 'n'){
					System.out.println("Digite 's' para sim e 'n' para não.");
					compra = in.next().charAt(0);
				}
				
				if(compra == 's'){ 
					(jogador).updateSaldo(-((Propriedades)posicao).getPreco());
					((Propriedades)posicao).setProprietario(jogador);
					//System.out.println(jogador.getSaldo());
				}	
			}
			
			else if(((Propriedades)posicao).getProprietario() != jogador){
				System.out.println("Você deve pagar " + ((Propriedades)posicao).getAluguelAtual() + " reais de aluguel para " + ((Propriedades)posicao).getProprietario());
				jogador.transfere(((Propriedades)posicao).getAluguelAtual(), ((Propriedades)posicao).getProprietario());
				//System.out.println(jogador.getSaldo());
			}
			
			/*else{
				CATEGORIA DAS PROPRIEDADES
			}*/
		}
		
		else if(posicao instanceof Negocios){
			if(((Negocios)posicao).getProprietario() == null){
				System.out.println("Você quer comprar esse negócio?\n" + ((Negocios)posicao) + "\nDigite 's' para sim e 'n' para não.");
				char compra = in.next().charAt(0);
				
				while(compra != 's' && compra != 'n'){
					System.out.println("Digite 's' para sim e 'n' para não.");
					compra = in.next().charAt(0);
				}
				
				if(compra == 's'){
					(jogador).updateSaldo(-((Negocios)posicao).getPreco());
					((Negocios)posicao).setProprietario(jogador); 
				}
			}

			else if(((Negocios)posicao).getProprietario() != jogador){
				System.out.println("Você deve pagar " + ((Negocios)posicao).getTaxa() + " * " + soma + " reais de taxa para " + ((Negocios)posicao).getProprietario());
				jogador.transfere(((Negocios)posicao).getTaxa() * soma, ((Negocios)posicao).getProprietario());
				System.out.println(jogador.getSaldo());
			}
			
			else{
				System.out.println("Esse negócio já foi adquirido por você");
			}
		}

		/*else if(posicao instanceof VaiParaPrisao){
		}
		else if(posicao instanceof Prisao){
		}
		else if(posicao instanceof Cartas){
		}
		else{
		}*/	
	}
}