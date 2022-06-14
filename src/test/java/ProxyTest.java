import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ProxyTest {

    @Test
    public void usuarioValido() {
        Usuario usuario = new Usuario("Ford Prefect", "89082448670");
        assertEquals("Usuário válido", BDProxy.addUsuario(usuario));
    }

    @Test
    public void cpfTem10digitos() {
        try{
            Usuario usuario = new Usuario("Ford Prefect", "8908244867");
            BDProxy.addUsuario(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("CPF Inválido", e.getMessage());
    }
    }

    @Test
    public void cpfDigito10Invalido() {
        try{
            Usuario usuario = new Usuario("Ford Prefect", "89082448600");
            BDProxy.addUsuario(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
        assertEquals("CPF Inválido", e.getMessage());
    }
    }

    @Test
    public void cpfDigito11Invalido() {
        try{
            Usuario usuario = new Usuario("Ford Prefect", "89082448671");
            BDProxy.addUsuario(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("CPF Inválido", e.getMessage());
        }
    }

    @Test
    public void cpfDigitos10e11Invalidos() {
        try{
            Usuario usuario = new Usuario("Ford Prefect", "89082448699");
            BDProxy.addUsuario(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
        assertEquals("CPF Inválido", e.getMessage());
        }
    }

    @Test
    public void cpfTotalmenteInvalido() {
        try {
            Usuario usuario = new Usuario("Ford Prefect", "00000000000");
            BDProxy.addUsuario(usuario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CPF Inválido", e.getMessage());
        }
    }

    @Test
    public void temSQLInjection() {
        try {
            Usuario usuario = new Usuario("'DROP database", "89082448670");
            BDProxy.addUsuario(usuario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("SQL Injection", e.getMessage());
        }
    }
}
