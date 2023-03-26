import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.estadoRecursos(); // Muestra el estado actual de los recursos

        boolean detener = false;
        while (!detener && maquina.vasos > 0 && (maquina.agua >= 180 || maquina.cafe >= 20 || maquina.crema >= 70)) {
            System.out.println("Seleccione el tipo de café que desea servir:");
            System.out.println("1. Café americano");
            System.out.println("2. Café expreso");
            System.out.println("3. Capuchino");
            System.out.println("4. Detener la máquina");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    maquina.servirAmericano();
                    break;
                case 2:
                    maquina.servirExpreso();
                    break;
                case 3:
                    maquina.servirCapuchino();
                    break;
                case 4:
                    detener = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione una opción válida.");
                    break;
            }

            if (!detener) {
                maquina.estadoRecursos(); // Muestra el estado actual de los recursos después de servir el café
                if (maquina.vasos == 0 || (maquina.agua < 180 && maquina.cafe < 20 && maquina.crema < 70)) {
                    System.out.println("No hay suficientes recursos para servir más café.");
                    detener = true;
                }
            }
        }
    }
}


