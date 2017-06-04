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
		int soma = 0;
		int dado = 0;
		int posicao;
		
		//Loop onde o jogo é executado
		while(true){
			if(cont == num) cont = 0;
			//if(osJogadores[cont].verificaPreso()) cont++;
			if(cont == num) cont = 0;
			System.out.print("Agora é a vez de " + osJogadores[cont].getNome() + ". ");
			soma = 0;
			
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
					osJogadores[cont].vaiPreso();
					break;
				}
			}

			dado = 0;
			osJogadores[cont].andar(soma);
			posicao = osJogadores[cont].getPosicao();
			System.out.println("Você caiu na posição " + (posicao + 1) + ". Nessa posição se encontra " + asCasasDoTabuleiro[posicao].getLegenda());
			
			if(asCasasDoTabuleiro[posicao] instanceof Propriedades){
				if(((Propriedades)asCasasDoTabuleiro[posicao]).getProprietario() == null){
					System.out.println("Você quer comprar essa propriedade?\n" + ((Propriedades)asCasasDoTabuleiro[posicao]) + "\nDigite 's' para sim e 'n' para não.");
					char compra = in.next().charAt(0);
					
					while(compra != 's' && compra != 'n'){
						System.out.println("Digite 's' para sim e 'n' para não.");
						compra = in.next().charAt(0);
					}
					
					if(compra == 's'){ 
						(osJogadores[cont]).updateSaldo(-((Propriedades)asCasasDoTabuleiro[posicao]).getPreco());
						((Propriedades)asCasasDoTabuleiro[posicao]).setProprietario(osJogadores[cont]);
						//System.out.println(osJogadores[cont].getSaldo());
					}	
				}
				
				else if(((Propriedades)asCasasDoTabuleiro[posicao]).getProprietario() != osJogadores[cont]){
					System.out.println("Você deve pagar " + ((Propriedades)asCasasDoTabuleiro[posicao]).getAluguelAtual() + " reais de aluguel para " + ((Propriedades)asCasasDoTabuleiro[posicao]).getProprietario());
					osJogadores[cont].transfere(((Propriedades)asCasasDoTabuleiro[posicao]).getAluguelAtual(), ((Propriedades)asCasasDoTabuleiro[posicao]).getProprietario());
					//System.out.println(osJogadores[cont].getSaldo());
				}
				
				/*else{
					CATEGORIA DAS PROPRIEDADES
				}*/
			}
			
			else if(asCasasDoTabuleiro[posicao] instanceof Negocios){
				if(((Negocios)asCasasDoTabuleiro[posicao]).getProprietario() == null){
					System.out.println("Você quer comprar esse negócio?\n" + ((Negocios)asCasasDoTabuleiro[posicao]) + "\nDigite 's' para sim e 'n' para não.");
					char compra = in.next().charAt(0);
					
					while(compra != 's' && compra != 'n'){
						System.out.println("Digite 's' para sim e 'n' para não.");
						compra = in.next().charAt(0);
					}
					
					if(compra == 's'){
						(osJogadores[cont]).updateSaldo(-((Propriedades)asCasasDoTabuleiro[posicao]).getPreco());
						((Propriedades)asCasasDoTabuleiro[posicao]).setProprietario(osJogadores[cont]); 
					}
				}

				else if(((Negocios)asCasasDoTabuleiro[posicao]).getProprietario() != osJogadores[cont]){
					System.out.println("Você deve pagar " + ((Negocios)asCasasDoTabuleiro[posicao]).getTaxa() + " * " + soma + " reais de taxa para " + ((Negocios)asCasasDoTabuleiro[posicao]).getProprietario());
					osJogadores[cont].transfere(((Negocios)asCasasDoTabuleiro[posicao]).getTaxa() * soma, ((Negocios)asCasasDoTabuleiro[posicao]).getProprietario());
					//System.out.println(osJogadores[cont].getSaldo());
				}
			}

			/*else if(asCasasDoTabuleiro[posicao] instanceof Vagas){

			}

			else if(asCasasDoTabuleiro[posicao] instanceof Prisao){

			}

			else if(asCasasDoTabuleiro[posicao] instanceof Cartas){

			}

			else{

			}*/	
			cont++;
		}
	}
}