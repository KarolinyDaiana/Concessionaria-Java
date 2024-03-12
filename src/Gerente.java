import Veiculos.Veiculo;

import java.util.LinkedList;

public class Gerente extends Funcionario {
    public Gerente(String nome, String nomeUsuario, String senha, int cadastro, double salario, int vendas) {
        super(nome, nomeUsuario, senha, cadastro, salario, vendas);
    }
    public void cadastrarVeiculos(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
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
        for (Usuario usuario : Usuario.getUsarios()) {
            if (usuario.getUser().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    public static String verPagamentoVendedor(int cadastro) {
        for (Usuario usuario: Usuario.getUsarios()) {
            if(usuario instanceof Vendedor vendedor && vendedor.getCadastro() == cadastro) {
                String pagamento = vendedor.calcularPagamento();
                if (pagamento != null){
                    return pagamento;
                }
            }
        }
        return "O usuário não é um vendedor";
    }
    public static String verPagamentosVendedores() {
        for (Usuario usuario : Usuario.getUsarios()) {
            if(usuario instanceof Vendedor vendedor) {
                System.out.println(vendedor.calcularPagamento());
            }
        }
        return null;
    }

    @Override
    public String opcoesDeEscolha() {
        return super.opcoesDeEscolha() + ("""
                7  - Cadastrar veículos
                8  - Remover veículos
                9  - Editar veículos
                16 - Ver pagamento dos seus vendedores
                17 - Ver pagamento de um vendedor
                """);
    }
}
