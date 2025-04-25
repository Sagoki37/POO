import java.util.regex.*;

public class Validador {

    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,}$");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean validarContraseña(String pwd) {
        if (pwd.length() < 8) return false;

        int mayus = contar("[A-Z]", pwd);
        int minus = contar("[a-z]", pwd);
        int nums = contar("\\d", pwd);
        int especiales = contar("[!@#$%^&*(),.?\":{}|<>]", pwd);

        return mayus >= 2 && minus >= 3 && nums >= 1 && especiales >= 1;
    }

    private static int contar(String regex, String texto) {
        Matcher matcher = Pattern.compile(regex).matcher(texto);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
