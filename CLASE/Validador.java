import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        System.out.println("📝 Registro de usuarios:");

        while (true) {
            System.out.print("\nIngrese nombre: ");
            String nombre = sc.nextLine();
            if (!Validador.validarNombre(nombre)) {
                System.out.println("⚠️ Nombre inválido. Solo letras y mínimo 2 caracteres.");
                continue;
            }

            System.out.print("Ingrese correo electrónico: ");
            String correo = sc.nextLine();
            if (!Validador.validarCorreo(correo)) {
                System.out.println("⚠️ Correo inválido.");
                continue;
            }

            System.out.print("Ingrese contraseña: ");
            String pwd = sc.nextLine();
            if (!Validador.validarContraseña(pwd)) {
                System.out.println("⚠️ Contraseña insegura. Debe tener mínimo 8 caracteres, 2 mayúsculas, 3 minúsculas, 1 número y 1 carácter especial.");
                continue;
            }

            usuarios.add(new Usuario(nombre, correo, pwd));
            System.out.println("✅ Usuario registrado con éxito.");

            System.out.print("\n¿Desea registrar otro usuario? (s/n): ");
            if (!sc.nextLine().equalsIgnoreCase("s")) break;
        }

        System.out.println("\n📋 Usuarios registrados:");
        usuarios.forEach(System.out::println);
    }
}
