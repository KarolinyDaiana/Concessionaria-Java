import java.util.ArrayList;

public abstract class Usuario {

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

    @Override
    public String toString() {
        return "Nome: " + nome +", nome de usuário: " + user + ", senha: " + senha;
    }

    // não deveria ser assim, era cadastro
    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public static void removeUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
    public static ArrayList<Usuario> getUsarios(){
        return usuarios;
    }
}
