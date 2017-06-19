public class Propriedades extends CasaDoTabuleiro{

    private int preco;
    private int categoria;
    private int aluguelAtual;
    private int aluguel;
    private int aluguelCasa1;
    private int aluguelCasa2;
    private int aluguelCasa3;
    private int aluguelCasa4;
    private int aluguelHotel;
    private int casa;
    private int hotel;
    private int hipoteca;
    private int contCasas;
    private Jogador proprietario;

    public Propriedades(String legenda, int preco, int categoria, int aluguel, int aluguelCasa1, int aluguelCasa2, int aluguelCasa3, int aluguelCasa4, int aluguelHotel, int casa, int hotel, int hipoteca){
        super(legenda);
        this.preco = preco;
        this.categoria = categoria;
        this.aluguel = aluguel;
        this.aluguelCasa1 = aluguelCasa1;
        this.aluguelCasa2 = aluguelCasa2;
        this.aluguelCasa3 = aluguelCasa3;
        this.aluguelCasa4 = aluguelCasa4;
        this.aluguelHotel = aluguelHotel;
        this.casa = casa;
        this.hotel = hotel;
        this.hipoteca = hipoteca;
        aluguelAtual = aluguel;
        contCasas = 0;
        proprietario = null;
    }

    public int getPreco(){
        return preco;
    }

    public int getCategoria(){
        return categoria;
    }

    public int getAluguelAtual(){
        return aluguelAtual;
    }

    public int getAluguelCasa1(){
        return aluguelCasa1;
    }

    public int getAluguelCasa2(){
        return aluguelCasa2;
    }

    public int getAluguelCasa3(){
        return aluguelCasa3;
    }

    public int getAluguelCasa4(){
        return aluguelCasa4;
    }

    public int getAluguelHotel(){
        return aluguelHotel;
    }

    public int getCasa(){
        return casa;
    }

    public int getHotel(){
        return hotel;
    }

    public int getHipoteca(){
        return hipoteca;
    }

    public int getContCasas(){
        return contCasas;
    }

    public Jogador getProprietario(){
        return proprietario;
    }

    public void setAluguelAtual(int aluguel){
        aluguelAtual = aluguel;
    }


    public void setProprietario(Jogador proprietario){
        this.proprietario = proprietario;
    }

    public String toString(){
        String toString = "O preço da propriedade é " + preco + " reais, e a sua hipoteca é de " + hipoteca + " reais. ";
        toString += "Os seus aluguéis são de:\n" + aluguel + " para nenhuma casa, ";
        toString += aluguelCasa1 + " para uma casa, ";
        toString += aluguelCasa2 + " para duas casas, ";
        toString += aluguelCasa3 + " para três casas, ";
        toString += aluguelCasa4 + " para quatro casas e ";
        toString += aluguelHotel + " para um hotel.\n";
        toString += "O preço de cada casa é " + casa + " e preço de cada hotel é " + hotel + ".";
        return toString;
    }

    public void updateContCasas(){
        contCasas++;
    }

    public void hipoteca(Jogador jogador){
        proprietario = null;
        jogador.updateSaldo(hipoteca);
    }

}