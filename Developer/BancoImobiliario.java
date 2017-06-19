import java.util.Scanner;

public class BancoImobiliario{

    static Scanner in = new Scanner (System.in);
    static CasaDoTabuleiro[] asCasasDoTabuleiro = CasaDoTabuleiro.generateCasasDoTabuleiro();

    public static void main(String args[]){

        System.out.println("Informe o número de jogadores: ");
        int jogadores = in.nextInt();

        //Inicializa os objetos
        Jogador[] osJogadores = new Jogador[jogadores];

        for(int cont = 0; cont < jogadores; cont++){
            System.out.print("\fInforme o nome do jogador " + (cont + 1) + ": ");
            osJogadores[cont] = new Jogador(in.next());
        }

        int atual = -1;
        int soma;
        int posicao;

        //Loop onde o jogo é executado
        while(true){

            while(true){
                if (atual == jogadores - 1) atual = -1;
                atual++;
                if(osJogadores[atual] != null) break;
            }

            System.out.print("Agora é a vez de " + osJogadores[atual].getNome() + ". ");

            soma = lancaDado();

            if(soma == 0){
                System.out.println("Você foi preso! A cadeia fica na posição 32.");
                osJogadores[atual].vaiPreso();
                continue;
            }

            osJogadores[atual].andar(soma);
            posicao = osJogadores[atual].getPosicao();
            System.out.println("Você caiu na posição " + (posicao + 1) + ". Nessa posição se encontra " + asCasasDoTabuleiro[posicao].getLegenda());

            acaoJogador(asCasasDoTabuleiro[posicao], osJogadores[atual], soma);

            if(osJogadores[atual].verificaQuebrado()) osJogadores[atual] = null;
        }
    }

    public static int lancaDado(){

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
            System.out.println("O valor do primeiro dado foi " + dado1.getValor());
            dado2.generateValor();
            System.out.println("O valor do segundo dado foi " + dado2.getValor());
            soma = soma + dado1.somaValores(dado2);

            if(dado1.verificaValores(dado2)) break;
            else dado++;

            if(dado == 3){
                soma = 0;
                break;
            }
        }
        return soma;
    }

    public static char validaCompra(){

        char compra = in.next().charAt(0);

        while(compra != 's' && compra != 'n'){
            System.out.println("Digite 's' para sim e 'n' para não.");
            compra = in.next().charAt(0);
        }

        return compra;
    }

    public static boolean verificaCategoria(CasaDoTabuleiro casa, Jogador jogador){
        if(((Propriedades)casa).getContCasas() == 5) return false;

        int[] verifica;

        if(((Propriedades)casa).getCategoria() == 1) verifica = new int[] {1, 3, 4};
        else if (((Propriedades)casa).getCategoria() == 2) verifica = new int[] {6, 8, 9};
        else if (((Propriedades)casa).getCategoria() == 3) verifica = new int[] {11, 13, 14};
        else if (((Propriedades)casa).getCategoria() == 4) verifica = new int[] {17, 19};
        else if (((Propriedades)casa).getCategoria() == 5) verifica = new int[] {21, 23};
        else if (((Propriedades)casa).getCategoria() == 6) verifica = new int[] {26, 28, 29};
        else if (((Propriedades)casa).getCategoria() == 7) verifica = new int[] {31, 33, 34, 36};
        else verifica = new int[] {38, 39};

        for(int cont = 0; cont < verifica.length; cont++){
            if(((Propriedades)asCasasDoTabuleiro[cont]).getProprietario() != jogador) return false;
            if(((Propriedades)asCasasDoTabuleiro[cont]).getContCasas() < ((Propriedades)casa).getContCasas()) return false;
        }

        return true;
    }

    public static void acaoJogador(CasaDoTabuleiro posicao, Jogador jogador, int soma){

        //Caso o jogador caia em uma casa da categoria de Propriedades

        if(posicao instanceof Propriedades){
            if(((Propriedades)posicao).getProprietario() == null){
                System.out.println("Você quer comprar essa propriedade?\n" + ((Propriedades)posicao) + "\nDigite 's' para sim e 'n' para não.");

                if(validaCompra() == 's'){
                    (jogador).updateSaldo(-((Propriedades)posicao).getPreco());
                    ((Propriedades)posicao).setProprietario(jogador);
                }
            }

            else if(((Propriedades)posicao).getProprietario() != jogador){
                System.out.println("Você deve pagar " + ((Propriedades)posicao).getAluguelAtual() + " reais de aluguel para " + ((Propriedades)posicao).getProprietario());
                jogador.transfere(((Propriedades)posicao).getAluguelAtual(), ((Propriedades)posicao).getProprietario());
            }
			
			else{
                System.out.println("Você quer hipotecar essa propriedade por " + ((Propriedades)posicao).getHipoteca() + " reais?\nDigite 's' para sim e 'n' para não.");
                if(validaCompra() == 's') ((Propriedades)posicao).hipoteca(jogador);

                else if(verificaCategoria(posicao, jogador)){
                    System.out.println("Você quer adicionar uma casa à sua propriedade? Você tem ");
                }
			}
        }

        //Caso o jogador caia em uma casa da categoria de Negócios

        else if(posicao instanceof Negocios){

            if(((Negocios)posicao).getProprietario() == null){
                System.out.println("Você quer comprar esse negócio?\n" + ((Negocios)posicao) + "\nDigite 's' para sim e 'n' para não.");

                if(validaCompra() == 's'){
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
                System.out.println("Você quer hipotecar essa propriedade por " + ((Negocios)posicao).getHipoteca() + " reais?\nDigite 's' para sim e 'n' para não.");
                if(validaCompra() == 's') ((Negocios)posicao).hipoteca(jogador);
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