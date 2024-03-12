package Veiculos;

public class Caminhao extends Veiculo {
    String comprimento;
    String altura;
    double pesoSuportado;
    public Caminhao(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela, String comprimento, String altura, double pesoSuportado) {
        super(fabricante, novo, modelo, ano, cor, kmRodados, preco, precoTabela);
        this.comprimento = comprimento;
        this.altura = altura;
        this.pesoSuportado = pesoSuportado;
    }

    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco + "\nComprimento: " + comprimento +
                "\nAltura: " + altura + "\nPeso suportado: " + pesoSuportado;
    }
}
