import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Usuario user = new Cliente("karol", "karol", "senha");
        Gerente userr = new Gerente("karsol", "karol", "senha", 123, 11.1, 2, 1);

        System.out.println("Usuario: " + user);
        Usuario.addUsuario(user);
        Usuario.addUsuario(userr);

        Usuario usuarioLogado = Usuario.login("karol", "senha");

        Veiculo caminhao = new Caminhao("aa", true, "aaa", 1111, "aa", 111.1, 1111.1, 111, "metros", "altura", 1211);
        System.out.println(caminhao);

        Veiculo lancha = new Lancha("aa", true, "bbb", 1111, "aa", 111.1, 1111.1, 111, "capacidade", "velocidade", "1212");
        Veiculo.addVeiculo(lancha);
        userr.alterarPrecoVeiculo("bbb", 12);
        System.out.println(lancha);

        inicio();

    }

    public static void inicio() {
        System.out.println("Bem vindo à concessionária da virada! \n");
        System.out.println("""
                1 - Login
                2 - Cadastro
                3 - Sair
                """);
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1 -> login();
            case 2 -> cadastro();
            case 3 -> System.out.println("sair");
        }
    }

    public static void login(){
        System.out.println("Login");
    }
    public static void cadastro(){
        System.out.println("Cadastro");
    }
    public void menuCliente(){}
    public void menuVendedor(){}
    public void menuGerente(){}
}