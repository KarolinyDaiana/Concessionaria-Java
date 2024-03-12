import Veiculos.Veiculo;

import java.util.ArrayList;

public class Venda {
    private final static ArrayList<Venda> vendas = new ArrayList<>();

    private Veiculo veiculo;
    private Usuario funcionario;
    private Usuario cliente;
    private double valor;
    private String metodoPagamento;
    private int parcelas;

    public Venda(Veiculo veiculo, Usuario funcionario, Usuario cliente, double valor, String metodoPagamento, int parcelas) {
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.parcelas = parcelas;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Usuario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Usuario getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public int getParcelas() {
        return parcelas;
    }
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public static ArrayList verVendas() {
        return vendas;
    }

    @Override
    public String toString() {
        return "Veículo : " + veiculo.getModelo() + "\nCliente: " + cliente.getNome() +
                "\nFuncionario: " + funcionario.getNome()  + "\nValor total: " + valor +
                "\nParcelas: " + parcelas  + "\nMétodo de pagamento: " + metodoPagamento;
    }

}
