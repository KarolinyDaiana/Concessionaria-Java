public class Funcionario extends Usuario {
    public Funcionario(String nome, String nomeUsuario, String senha, int cadastro, double salario, double comissao, int vendas) {
        super(nome, nomeUsuario, senha);
        this.cadastro = cadastro;
        this.salario = salario;
        this.comissao = comissao;
        this.vendas = vendas;
    }

    private int cadastro;
    private double salario;
    private double comissao;
    private int vendas;

}
