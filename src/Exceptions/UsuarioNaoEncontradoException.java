package Exceptions;

public class UsuarioNaoEncontradoException extends Exception {
    /// exceptions obriga a tratar a exception
    // runtime exception nao
    public UsuarioNaoEncontradoException(String usuario) {
        super("Usuário " + usuario + " não encontrado");
    }
    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado");
    }

}
