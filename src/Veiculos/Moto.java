package Veiculos;

public class Moto extends Veiculo {
    boolean sidecar;

    public Moto(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela, boolean sidecar) {
        super(fabricante, novo, modelo, ano, cor, kmRodados, preco, precoTabela);
        this.sidecar = sidecar;
    }

    @Override
    public String toString() {
        return "\n\nFabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco + "\nPode ter sidecar: " + sidecar;
    }
}
