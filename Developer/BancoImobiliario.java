import java.util.Scanner;
import java.util.Arrays;

public class BancoImobiliario{
	
	public static void main(String args[]){
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Informe o número de jogadores: ");
		int num = in.nextInt();
		
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
		int posicao;
		
		while(true){
			System.out.print("Agora é a vez de " + osJogadores[cont].getNome() + ". ");
			
			while(true){
				System.out.println("Digite 'd' para lançar os dados: ");
				char verifica = in.next().charAt(0);

				while(verifica != 'd'){	
					System.out.print("Digite 'd' para lançar os dados: ");
					verifica = in.next().charAt(0);	
				}

				dado1.setValor();
				System.out.println("\fO valor do primeiro dado foi " + dado1.getValor());
				dado2.setValor();
				System.out.println("O valor do segundo dado foi " + dado2.getValor());
				soma = soma + dado1.somaValores(dado2);

				if(dado1.verificaValores(dado2)) break;
			}

			osJogadores[cont].andar(soma);
			posicao = osJogadores[cont].getPosicao();
			System.out.println("Você caiu na posição " + posicao + ". Nessa posição se encontra " + asCasasDoTabuleiro[posicao].getLegenda());
			//System.out.println(((Propriedades)asCasasDoTabuleiro[cont]).getAluguel());
			//instance of
			cont++;
			if(cont == num) cont = 0;
		}
	}
}