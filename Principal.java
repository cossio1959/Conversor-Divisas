import java.util.Scanner;

public class Principal {

        public static void main(String[] args) {

            Scanner usuario = new Scanner(System.in);
            ConsultaDivisa consulta = new ConsultaDivisa();

            int opcion = 0;
            while (opcion != 9) {
                System.out.println("\n\n************************************\n" +
                        "!Bienvenido al Conversor de Divisas!\n" +
                        "MENU DE CONVERSIONES:\n" +
                        "Digite una opción\n\n" +
                        "1.- Dólar => Peso Argentino\n" +
                        "2.- Peso Argentino => Dólar\n" +
                        "3.- Dólar => Real Brasileño\n" +
                        "4.- Real Brasileño => Dólar\n" +
                        "5.- Dólar => Peso Colombiano\n" +
                        "6.- Peso Colombiano => Dólar\n" +
                        "7.- Dólar => Peso Chileno\n" +
                        "8.- Peso Chileno => Dólar\n" +
                        "9.- Salir\n");
                System.out.println("*****************************************");
                System.out.println("Elija una Opción:");
                opcion = usuario.nextInt();
                usuario.nextLine();
                switch (opcion) {
                    case 1:
                        ConvertirDivisa.conversor("USD", "ARS", consulta, usuario);
                        break;
                    case 2:
                        ConvertirDivisa.conversor("ARS", "USD", consulta, usuario);
                        break;
                    case 3:
                        ConvertirDivisa.conversor("USD", "BRL", consulta, usuario);
                        break;
                    case 4:
                        ConvertirDivisa.conversor("BRL", "USD", consulta, usuario);
                        break;
                    case 5:
                        ConvertirDivisa.conversor("USD", "COP", consulta, usuario);
                        break;
                    case 6:
                        ConvertirDivisa.conversor("COP", "USD", consulta, usuario);
                        break;
                    case 7:
                        ConvertirDivisa.conversor("USD", "CLP", consulta, usuario);
                        break;
                    case 8:
                        ConvertirDivisa.conversor("CLP", "USD", consulta, usuario);
                        break;
                    case 9:
                        System.out.println("Conversor de Divisas Finalizado");
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            }
        }
    }
