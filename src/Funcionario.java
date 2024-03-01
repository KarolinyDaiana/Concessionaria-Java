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

    private int cadastro;
    private double salario;
    private double comissao;
    private int vendas;

    public static String calcularPagamento(Funcionario funcionario) {
        double pagamento = 0;
        if(funcionario instanceof Vendedor) {
            pagamento = (0.001 * funcionario.getVendas()) + funcionario.getSalario();
        } else if (funcionario instanceof Gerente) {
            pagamento = (0.001 * funcionario.getVendas()) + funcionario.getSalario();
        }
        return "\nPagamento mensal do funcionário de cadastro " + funcionario.getCadastro() + ", pagamento: " + pagamento;
    }

}
