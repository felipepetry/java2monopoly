public class Baralho extends CasaDoTabuleiro{

    private int cartaInd;
    private Cartas[] cartas;

    public Baralho(String legenda){
        super("uma carta de sorte ou revés!");
        cartaInd = -1;
        cartas[0] = new Cartas(0, "aosdoasd");
        cartas[1] = new Cartas(0, "aosdoasd");
        cartas[2] = new Cartas(0, "aosdoasd");
        cartas[3] = new Cartas(0, "aosdoasd");
        cartas[4] = new Cartas(0, "aosdoasd");
        cartas[5] = new Cartas(0, "aosdoasd");
        cartas[6] = new Cartas(0, "aosdoasd");
        cartas[7] = new Cartas(0, "aosdoasd");
        cartas[8] = new Cartas(0, "aosdoasd");
        cartas[9] = new Cartas(0, "aosdoasd");
        cartas[10] = new Cartas(0, "aosdoasd");
        cartas[11] = new Cartas(0, "aosdoasd");
        cartas[12] = new Cartas(0, "aosdoasd");
        cartas[13] = new Cartas(0, "aosdoasd");
        cartas[14] = new Cartas(0, "aosdoasd");
        cartas[15] = new Cartas(0, "aosdoasd");
        cartas[16] = new Cartas(0, "aosdoasd");
        cartas[17] = new Cartas(0, "aosdoasd");
        cartas[18] = new Cartas(0, "aosdoasd");
        cartas[19] = new Cartas(0, "aosdoasd");
        cartas[20] = new Cartas(0, "aosdoasd");
        cartas[21] = new Cartas(0, "aosdoasd");
        cartas[22] = new Cartas(0, "aosdoasd");
        cartas[23] = new Cartas(0, "aosdoasd");
        cartas[24] = new Cartas(0, "aosdoasd");
        cartas[25] = new Cartas(0, "aosdoasd");
        cartas[26] = new Cartas(0, "aosdoasd");
        cartas[27] = new Cartas(0, "aosdoasd");
        cartas[28] = new Cartas(0, "aosdoasd");
        cartas[29] = new Cartas(0, "aosdoasd");
    }

    public int getCartaInd(){
        return cartaInd;
    }

    public void updateCartaInd(){
        cartaInd++;
        if(cartaInd == 30) cartaInd = 0;//embaralha
    }

}