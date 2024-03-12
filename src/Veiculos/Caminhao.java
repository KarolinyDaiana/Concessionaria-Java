package Veiculos;

public class Caminhao extends Veiculo {
    double comprimento;
    double altura;
    double pesoSuportado;
    public Caminhao(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela, double comprimento, double altura, double pesoSuportado) {
        super(fabricante, novo, modelo, ano, cor, kmRodados, preco, precoTabela);
        this.comprimento = comprimento;
        this.altura = altura;
        this.pesoSuportado = pesoSuportado;
    }

    @Override
    public String toString() {
        return "\n\nFabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco + "\nComprimento: " + comprimento +
                "\nAltura: " + altura + "\nPeso suportado: " + pesoSuportado;
    }
}
