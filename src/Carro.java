public class Carro extends Veiculo {

    int portas;
    String tracao;
    public Carro(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela, int portas, String tracao) {
        super(fabricante, novo, modelo, ano, cor, kmRodados, preco, precoTabela);
        this.portas = portas;
        this.tracao = tracao;
    }
    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco + "\nPortas: " + portas + "\nTração: " + tracao;
    }
}
