import Veiculos.Veiculo;

public class Gerente extends Funcionario {
    public Gerente(String nome, String nomeUsuario, String senha, int cadastro, double salario, int vendas) {
        super(nome, nomeUsuario, senha, cadastro, salario, vendas);
    }

    public void cadastrarVeiculos(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
    }
    public void removerVeiculos(String modelo) {
        for (Veiculo veiculo : Veiculo.getVeiculos()) {
            if(veiculo.getModelo().equals(modelo)) {
                Veiculo.removeVeiculo(veiculo);
            }
        }
    }
    public boolean alterarPrecoVeiculo(String modelo, double preco) {
        for (Veiculo veiculo : Veiculo.getVeiculos()) {
            if(veiculo.getModelo().equals(modelo)) {
                veiculo.setPreco(preco);
                return true;
            }
        } return false;
    }
    public void cadastrarUsuario(Usuario usuario) {
        Usuario.addUsuario(usuario);
    }
    public void removeUsuario(String nomeUsuario) {
        for (Usuario usuario: Usuario.getUsarios()) {
            if(usuario.getUser().equals(nomeUsuario)) {
                Usuario.removeUsuario(usuario);
            }
        }
    }
    public Usuario verUsuario(String nomeUsuario) {
        for (Usuario usuario: Usuario.getUsarios()) {
            if(usuario.getUser().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    public static String verPagamentoVendedor(int cadastro) {
        for (Usuario usuario: Usuario.getUsarios()) {
            if(usuario instanceof Vendedor) {
                return Funcionario.calcularPagamento((Funcionario) usuario);
            }
        }
        return null;
    }
}
