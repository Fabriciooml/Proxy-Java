import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ValidaSQLInjection {

    public static boolean isSQLInjection(String campo) {
        List<String> comandosSQL = Arrays.asList("update", "delete", "create", "alter", "insert", "join", "drop", "select");
        for (String comando : comandosSQL) {
            if (campo.toLowerCase().contains(comando)){
                throw new IllegalArgumentException("SQL Injection");
            }
        }
        return false;
    }

}
