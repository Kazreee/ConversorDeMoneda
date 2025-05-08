import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        String menu = """
                ****************************************************
                1) Dolar =>> Peso Argentino
                2) Peso argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real brasileño =>> Dolar
                5) Dolar =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Salir
                Elija una opcion valida:
                ****************************************************
                """;

        while (true) {
            System.out.println(menu);
            int opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor");
                break;
            }

            System.out.println("Ingrese el valor que desee convetir: ");
            double cantidad = lectura.nextDouble();


            switch (opcion) {
                case 1:
                    conversor.conversor("USD", "ARS", cantidad);
                    break;
                case 2:
                    conversor.conversor("ARS", "USD", cantidad);
                    break;
                case 3:
                    conversor.conversor("USD", "BRL", cantidad);
                    break;
                case 4:
                    conversor.conversor("BRL", "USD", cantidad);
                    break;
                case 5:
                    conversor.conversor("USD", "COP", cantidad);
                    break;
                case 6:
                    conversor.conversor("COP", "USD", cantidad);
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        }
        lectura.close();
    }
}