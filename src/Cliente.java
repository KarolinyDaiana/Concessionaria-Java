import java.util.ArrayList;

public class Cliente extends Usuario {
    public Cliente(String nome, String nomeUsuario, String senha) {
        super(nome, nomeUsuario, senha);
    }

    private static ArrayList<Veiculo> meusVeiculos = new ArrayList<>();

    private ArrayList<Veiculo> verMeusVeiculos() {
        return meusVeiculos;
    }
}
