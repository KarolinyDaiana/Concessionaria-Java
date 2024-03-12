import Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {

    //final é constante, n muda
    private ArrayList<Veiculo> meusVeiculos = new ArrayList<>();
    private final static ArrayList<Usuario> usuarios = new ArrayList<>();
    private String nome;
    private String user;
    private String senha;

    public Usuario(String nome, String user, String senha){
        this.nome = nome;
        this.user = user;
        this.senha = senha;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public static Usuario login(String user, String senha){
        for (Usuario usuario: usuarios) {
            if(usuario.user.equals(user) && usuario.senha.equals(senha)) {
                return usuario;
            }
        } return null;
    }

    public String opcoesDeEscolha() {
        return ("""
                1  - Ver veículos em estoque
                2  - Ver detalhes de um veículo
                3  - Ver meus veículos
                """);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +", nome de usuário: " + user + ", senha: " + senha;
    }
    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    //editar em um for que recebe usuarioNovo: lista.set(lista.indexOf(this), novoUsuario)

    public static void removeUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public static ArrayList<Usuario> getUsarios(){
        return usuarios;
    }
    public static Usuario procurarCliente(String nomeCliente) {
        for (Usuario clienteProcurado : usuarios) {
            if(clienteProcurado.getNome().equals(nomeCliente)) {
                return clienteProcurado;
            }
        }
        return null;
    }

    public void addMeusVeiculos(Veiculo veiculo) {
        meusVeiculos.add(veiculo);
    }
    public ArrayList<Veiculo> verMeusVeiculos() {
        return meusVeiculos;
    }

}
