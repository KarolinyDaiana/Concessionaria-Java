import Veiculos.Caminhao;
import Veiculos.Lancha;
import Veiculos.Veiculo;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static Usuario usuarioLogado;

    public static void main(String[] args) {
        System.out.println("Concessionária Zeca Urubu!");

        Usuario user = new Cliente("karol", "karol", "senha");
        Usuario gerente = new Gerente("ana", "ana", "senha", 123, 10, 10);
        Usuario vendedor = new Vendedor("pamela", "pamela", "senha", 321, 100,  10);

        Usuario.addUsuario(user);
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(vendedor);

        Veiculo caminhao = new Caminhao("aa", true, "aaa", 1111, "aa", 111.1, 1111.1, 111, "metros", "altura", 1211);
        Veiculo.addVeiculo(caminhao);

        Veiculo lancha = new Lancha("aa", true, "bbb", 1111, "aa", 111.1, 1111.1, 111, 111, 2222, 212);
        Veiculo.addVeiculo(lancha);

        inicio();

    }

    public static void inicio() {
        System.out.println("Bem vindo à concessionária da virada! \n");
        System.out.println("""
                1 - Login
                2 - Cadastro
                3 - Sair
                4 - Ver veículos em estoque
                5 - Ver detalhes de um veículo
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

    public static void login(){
        do {
            System.out.printf("\nDigite o nome de usuário: ");
            String nome = sc.next();
            System.out.printf("Digite a senha: ");
            String senha = sc.next();

            usuarioLogado = Usuario.login(nome, senha);
            menu(usuarioLogado);
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

        menu(usuarioLogado);
    }
    public static void menu(Usuario usuario){
        System.out.println("""
                1  - Ver veículos em estoque
                2  - Ver detalhes de um veículo
                3  - Ver meus veículos
                """);
        if(usuario instanceof Funcionario) {
            System.out.println("""
                4  - Vender veículo
                5  - Procurar cliente
                6  - Ver pagamento
                """);
            if (usuario instanceof Gerente) {
                System.out.println("""
                     
                        7  - Cadastrar veículos
                        8  - Remover veículos
                        9  - Editar veículos
                        10 - Alterar preço do veículo
                        11 - Cadastrar vendedor/cliente
                        12 - Remover vendedor/cliente
                        13 - Editar vendedor/cliente
                        14 - Ver vendedores
                        15 - Ver clientes
                        16 - Ver pagamento dos seus vendedores
                        17 - Ver pagamento de um vendedor
                        """);
            }
        }
        System.out.printf("Escolha: ");
        int escolha = sc.nextInt();

        switch(escolha){
            case 1 -> verVeiculosEmEstoque();
            case 2 -> procurarModelo();
//            case 3 -> ver meus veiculos
//            case 4 -> vender veiculo
//            case 5 -> procurar cliente
//            case 6 -> ver pagamento
//            case 7 ->
//            case 8 ->
//            case 9 ->
//            case 10 ->
//            case 11 ->
//            case 12 ->
            case 17 -> verPagamentoVendedor();
        }
    }

    private static void verPagamentoVendedor() {
        System.out.printf("Digite o cadastro do vendedor desejado: ");
        int cadastro = sc.nextInt();
        System.out.println(Gerente.verPagamentoVendedor(cadastro));
    }

    public static void verVeiculosEmEstoque() {
        System.out.println(Veiculo.veiculosEmEstoque());
    }
    public static void procurarModelo() {
        System.out.printf("Digite o modelo: ");
        String modelo = sc.next();
        System.out.println(Veiculo.procurarVeiculo(modelo));
    }
}