package Veiculos;

import java.util.ArrayList;

public class Veiculo {

    private final static ArrayList<Veiculo> veiculos = new ArrayList<>();

    String fabricante;
    boolean novo;
    String modelo;
    int ano;
    String cor;
    double kmRodados;
    double preco;
    double precoTabela;

    int estoque;

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public double getKmRodados() {
        return kmRodados;
    }
    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {return estoque;}
    public void setEstoque(int estoque) {this.estoque = estoque;}

    public static void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
    public static void removeVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public static ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Veiculo(String fabricante, boolean novo, String modelo, int ano, String cor, double kmRodados, double preco, double precoTabela) {
        this.fabricante = fabricante;
        this.novo = novo;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.kmRodados = kmRodados;
        this.preco = preco;
        this.precoTabela = precoTabela;
    }

    public static Veiculo veiculosEmEstoque() {
        for (Veiculo veiculo: veiculos) {
            if(veiculo.getEstoque() > 0) {
                return veiculo;
            }
        } return null;
    }
    public static Veiculo procurarVeiculo(String modelo) {
        for (Veiculo veiculo: veiculos) {
            if(veiculo.getModelo().equals(modelo)) {
                return veiculo;
            }
        } return null;
    }

    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\nModelo: "+ modelo + "\nAno: " + ano + "\nCor: " + cor +
                "\nKm rodados:" + kmRodados + "\nPreço: " + preco;
    }
}
