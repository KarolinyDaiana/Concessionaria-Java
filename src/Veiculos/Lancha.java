package Veiculos;

public class Lancha extends Veiculo {

    double capacidade;
    double velocidade;
    double altura;

    public Lancha(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela, double capacidade, double velocidade, double altura) {
        super(fabricante, novo, modelo, ano, cor, kmRodados, preco, precoTabela);
        this.capacidade = capacidade;
        this.velocidade = velocidade;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "\nFabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco + "\nCapacidade: " + capacidade +
                "\nVelocidade: " + velocidade + "\nAltura: " + altura;
    }
}
