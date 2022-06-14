public class BDProxy implements IBD {

    public static Usuario getUsuario(String cpf) {
        if (ValidaCPF.isCpfValido(cpf)){
            return BD.getUsuario(cpf);
        }
        return null;
    }

    public static String addUsuario(Usuario usuario) {
        if (ValidaCPF.isCpfValido(usuario.getCpf()) && !ValidaSQLInjection.isSQLInjection(usuario.getNome())){
            BD.addUsuario(usuario);
            return "Usuário válido";
        }
        return null;
    }




}
