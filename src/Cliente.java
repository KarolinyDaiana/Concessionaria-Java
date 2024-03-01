import Veiculos.Veiculo;

import java.util.ArrayList;

public class Cliente extends Usuario {
    public Cliente(String nome, String nomeUsuario, String senha) {
        super(nome, nomeUsuario, senha);
    }

    private static ArrayList<Veiculo> meusVeiculos = new ArrayList<>();

    private static void addMeusVeiculos(Veiculo veiculo) {
        meusVeiculos.add(veiculo);
    }
    private ArrayList<Veiculo> verMeusVeiculos() {
        return meusVeiculos;
    }
}
