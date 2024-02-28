public class Gerente extends Funcionario {
    public Gerente(String nome, String nomeUsuario, String senha, int cadastro, double salario, double comissao, int vendas) {
        super(nome, nomeUsuario, senha, cadastro, salario, comissao, vendas);
    }

    public void cadastrarVeiculos(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
    }
    public void removerVeiculos(Veiculo veiculo) {
        Veiculo.removeVeiculo(veiculo);
    }
    
    public boolean alterarPrecoVeiculo(String modelo, double preco) {
        for (Veiculo veiculo : Veiculo.getVeiculos()) {
            if(veiculo.getModelo().equals(modelo)) {
                veiculo.setPreco(preco);
                return true;
            }
        } return false;
    }
}
