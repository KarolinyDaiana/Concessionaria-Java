import Exceptions.SenhaIncorretaException;
import Exceptions.UsuarioNaoEncontradoException;
import Veiculos.*;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static Usuario usuarioLogado;

    //toda constante estática é declarada com caixa alta
    public static void main(String[] args) {
        System.out.println("Concessionária Zeca Urubu!");

        Usuario user = new Cliente("karol", "karol", "senha");
        Usuario user2 = new Cliente("antonio", "antonio", "senha");
        Usuario gerente = new Gerente("ana", "ana", "senha", 123, 10, 10);
        Usuario vendedor = new Vendedor("pamela", "pamela", "senha", 321, 100,  456);
        Usuario vendedor2 = new Vendedor("renan", "renan", "senha", 456, 100,  234);

        Usuario.addUsuario(user);
        Usuario.addUsuario(user2);
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(vendedor);
        Usuario.addUsuario(vendedor2);

        Veiculo caminhao = new Caminhao("aa", true, "aaa", 1111, "aa", 111.1, 1111.1, 111, 3423, 123, 1211);
        Veiculo.addVeiculo(caminhao);

        Veiculo lancha = new Lancha("aa", true, "bbb", 1111, "aa", 111.1, 1111.1, 111, 111, 2222, 212);
        Veiculo.addVeiculo(lancha);

        inicio();

    }

    public static void inicio() {
        System.out.println("Bem vindo à concessionária da virada! \n");
        System.out.println("""
                ----------------------------------
                |1 | Login                       |
                |2 | Cadastro                    |
                |3 | Sair                        |    
                |4 | Ver veículos em estoque     |
                |5 | Ver detalhes de um veículo  |
                ----------------------------------
                """);
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1 -> login();
            case 2 -> cadastro();
            case 3 -> System.out.println("sair");
            case 4 -> verVeiculosEmEstoque();
            case 5 -> procurarModelo();
        }
    }
    //para saber onde colocar a exception
    //qual vai ser a implementação, vai ter toos os recursos necessarios?
    public static void login(){
        do {
            System.out.printf("\nDigite o nome de usuário: ");
            String nome = sc.next();
            System.out.printf("Digite a senha: ");
            String senha = sc.next();
            try {
                usuarioLogado = Usuario.login(nome, senha);
                menu();
            } catch (UsuarioNaoEncontradoException exception) {
                System.err.println(exception.getMessage());
                System.out.println("""
                        \nDeseja realizar o cadastro:
                        1- Sim
                        Outro- Não
                        """);
                int escolha = sc.nextInt();
                if(escolha == 1) {
                    cadastro();
                }
            } catch (SenhaIncorretaException exception) {
                System.err.println(exception.getMessage());

            }

        }while (usuarioLogado == null);

    }
    public static void cadastro(){
        System.out.printf("\nNome: ");
        String nome = sc.next();
        System.out.printf("\nNome de usuário: ");
        String nomeUsuario = sc.next();
        System.out.printf("\nSenha: ");
        String senha = sc.next();
        Usuario novoUsuario = new Cliente(nome, nomeUsuario, senha);
        Usuario.addUsuario(novoUsuario);
        usuarioLogado = novoUsuario;

        menu();
    }

    //pode colocar as opções no usuario
    public static void menu(){
        do {
            System.out.println(usuarioLogado.opcoesDeEscolha());
            System.out.println("0  - Logout");
            System.out.printf("Escolha: ");
            int escolha = sc.nextInt();

            switch(escolha){
                case 0 -> {
                    usuarioLogado = null;
                    inicio();
                }
                case 1 -> verVeiculosEmEstoque();
                case 2 -> procurarModelo();
                case 3 -> verMeusVeiculos();
                case 4 -> venderVeiculo();
                case 5 -> procurarCliente();
//            case 6 -> ver pagamento
                case 7 -> cadastrarVeiculoCarroMotoCaminhaoLancha();
                case 8 -> removerVeiculo();
                case 9 -> editarVeiculo();
//            case 10 ->
//            case 11 ->
//            case 12 ->
//            case 13 ->
//            case 14 ->
//            case 15 ->
                case 16 -> verPagamentosVendedores();
                case 17 -> verPagamentoVendedor();
            }
        } while (usuarioLogado != null);

    }

    private static void verMeusVeiculos() {
        System.out.println(usuarioLogado.verMeusVeiculos());
    }

    private static void venderVeiculo() {
        Usuario cliente;
        Usuario funcionario = null;
        Veiculo veiculo;
        do {
            veiculo = escolherVeiculo();
            if(veiculo == null) {
                System.out.println("Veiculo não encontrado!");
            }
        } while (veiculo == null);

        do {
            funcionario = escolherVendedor();
            if(funcionario == null) {
                System.out.println("Funcionário não encontrado!");
            }
        } while (funcionario == null);

        do {
            cliente = escolherCliente();
            if(cliente == null) {
                System.out.println("Cliente não encontrado!");
            } else {
                cliente.addMeusVeiculos(veiculo);
            }
        } while (cliente == null);

        System.out.println("\nValor da venda: ");
        double valorVenda = sc.nextDouble();
        System.out.println("\nParcelas: ");
        int parcelas = sc.nextInt();
        System.out.println("\nMétodo de pagamento: ");
        String metodoPagamento = sc.next();
        Venda novaVenda = new Venda(veiculo, funcionario, cliente, valorVenda, metodoPagamento, parcelas);
        System.out.println("\nCompra efetuada!\n" + novaVenda);
    }
    public static Veiculo escolherVeiculo() {
        System.out.println("\nModelo do veículo: ");
        String modelo = sc.next();
        return Veiculo.procurarVeiculo(modelo);
    }
    public static Usuario escolherVendedor() {
        System.out.println("\nNome do funcionário vendedor: ");
        String nomeFucnionario = sc.next();
        if (Usuario.procurarCliente(nomeFucnionario) instanceof Funcionario) {
            return Usuario.procurarCliente(nomeFucnionario);
        } else {
            return null;
        }
    }
    public static Usuario escolherCliente() {
        System.out.println("\nNome do cliente: ");
        String nomeCliente = sc.next();
        return Usuario.procurarCliente(nomeCliente);
    }
    private static void procurarCliente() {
        System.out.printf("\nNome de usuário do cliente: ");
        String nomeUsuario = sc.next();
        System.out.println(Usuario.procurarCliente(nomeUsuario));
    }
    private static void editarVeiculo() {
        System.out.println("\nModelo do veículo a ser editado: ");
        String modelo = sc.next();
        Veiculo veiculoEditado = Veiculo.procurarVeiculo(modelo);

        System.out.printf("Novo estado do veículo: ");
        String novo = sc.next();
        if(novo.equals("usado")) {veiculoEditado.setNovo(false);} else if(novo.equals("novo")){veiculoEditado.setNovo(false);}
        System.out.printf("Nova cor: ");
        String cor = sc.next();
        veiculoEditado.setCor(cor);
        System.out.printf("Nova kilometragem: ");
        double kmRodados = sc.nextInt();
        veiculoEditado.setKmRodados(kmRodados);
        System.out.printf("Novo preço: ");
        double preco = sc.nextInt();
        veiculoEditado.setPreco(preco);
    }
    private static void verPagamentosVendedores() {
        System.out.println(Gerente.verPagamentosVendedores());
    }
    private static void removerVeiculo() {
        System.out.println("\nModelo do veículo: ");
        String modelo = sc.next();
        Veiculo.removeVeiculo(modelo);
    }
    private static void cadastrarVeiculoCarroMotoCaminhaoLancha() {
        System.out.printf("\nFabricante: ");
        String fabricante = sc.next();
        System.out.printf("É um carro novo?: ");
        String novo = sc.next();
        Boolean estadoVeiculo;
        if(novo.equals("sim")) {estadoVeiculo = true;} else {estadoVeiculo = false;}
        System.out.printf("Modelo: ");
        String modelo = sc.next();
        System.out.printf("Ano: ");
        int ano = sc.nextInt();
        System.out.printf("Cor: ");
        String cor = sc.next();
        System.out.printf("Kilometragem: ");
        double kmRodados = sc.nextInt();
        System.out.printf("Preço: ");
        double preco = sc.nextInt();
        System.out.printf("Preço de tabela: ");
        double precoTabela = sc.nextInt();

        System.out.println("""
                Qual o veículos desejado?
                1 - Caminhão
                2 - Carro
                3 - Lancha
                4 - Moto
                """);
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1: {
                System.out.println("\nComprimento: ");
                double comprimento = sc.nextInt();
                System.out.println("Altura: ");
                double altura = sc.nextInt();
                System.out.println("Peso suportado: ");
                double pesoSuportado = sc.nextInt();
                Veiculo caminhao = new Caminhao(fabricante, estadoVeiculo, modelo, ano, cor, kmRodados, preco, precoTabela, comprimento, altura, pesoSuportado);
                Veiculo.addVeiculo(caminhao);
            }
            case 2: {
                System.out.println("\nQuantidade de portas: ");
                int portas = sc.nextInt();
                System.out.println("Tração: ");
                String tracao = sc.next();
                Veiculo carro = new Carro(fabricante, estadoVeiculo, modelo, ano, cor, kmRodados, preco, precoTabela, portas, tracao);
                Veiculo.addVeiculo(carro);
            }
            case 3: {
                System.out.println("\nCapacidade: ");
                double capacidade = sc.nextInt();
                System.out.println("Velocidade máxima atingida: ");
                double veloidade = sc.nextInt();
                System.out.println("Altura: ");
                double altura = sc.nextInt();
                Veiculo lancha = new Lancha(fabricante, estadoVeiculo, modelo, ano, cor, kmRodados, preco, precoTabela, capacidade, veloidade, altura);
                Veiculo.addVeiculo(lancha);
            }
            case 4: {
                System.out.println("\nTem sidecar? ");
                String sidecarInfo = sc.next();
                Boolean sidecar;
                if(sidecarInfo.equals("sim")) {sidecar = true;} else {sidecar = false;}
                Veiculo moto = new Moto(fabricante, estadoVeiculo, modelo, ano, cor, kmRodados, preco, precoTabela, sidecar);
                Veiculo.addVeiculo(moto);
            }
        }
    }
    private static void verPagamentoVendedor() {
        System.out.printf("Digite o cadastro do vendedor desejado: ");
        int cadastro = sc.nextInt();
        System.out.println(Gerente.verPagamentoVendedor(cadastro));
    }
    public static void verVeiculosEmEstoque() {
        System.out.println(Veiculo.getVeiculos());
    }
    public static void procurarModelo() {
        System.out.printf("Digite o modelo: ");
        String modelo = sc.next();
        Veiculo veiculo = Veiculo.procurarVeiculo(modelo);
        if(veiculo != null) {
            System.out.println(Veiculo.procurarVeiculo(modelo));
        } else {
            System.out.println("Veículo não encontrado");
        }
    }
}