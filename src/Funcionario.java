public class Funcionario extends Usuario {
    public Funcionario(String nome, String nomeUsuario, String senha, int cadastro, double salario, int vendas) {
        super(nome, nomeUsuario, senha);
        this.cadastro = cadastro;
        this.salario = salario;
        this.vendas = vendas;
    }

    public int getCadastro() {
        return cadastro;
    }
    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getVendas() {
        return vendas;
    }
    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    private static int cadastro;
    private double salario;
    private int vendas;

    public String calcularPagamento() {
        double pagamento;
        double comissao = 0.01;
        if (this instanceof Gerente) {
            comissao = 0.02;
        }
        pagamento = (comissao * this.getVendas()) + this.getSalario();
        return "\nPagamento mensal do funcionário de cadastro " + this.getCadastro() + ", pagamento: " + pagamento;
    }

    @Override
    public String opcoesDeEscolha() {
        return super.opcoesDeEscolha() +  ("""
                4  - Vender veículo
                5  - Procurar cliente
                6  - Ver pagamento
                """);
    }
}
