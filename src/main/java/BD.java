import java.util.HashMap;
import java.util.Map;

public class BD implements IBD{
    private static Map<String, Usuario> usuarios = new HashMap<>();

    protected static Usuario getUsuario(String cpf) {
        return usuarios.get(cpf);
    }

    protected static void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
    }
}