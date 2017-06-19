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

    public int getSaldo(){
        return saldo;
    }

    public void updateSaldo(int valor){
        saldo = saldo + valor;
    }

    public void andar(int posicao){
        this.posicao += posicao;

        if(this.posicao >= 40) this.posicao = this.posicao - 40;
    }

    public void transfere(int valor, Jogador jogador){
        if(saldo - valor >= 0) updateSaldo(-valor);

        else{
            updateSaldo(-saldo);
            valor = saldo;
        }

        jogador.updateSaldo(valor);
    }

    public void vaiPreso(){
        posicao = 32;
        preso = true;
    }

    public boolean verificaQuebrado(){
        if(saldo <= 0) return true;
        return false;
    }

}