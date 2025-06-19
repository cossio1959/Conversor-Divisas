
import java.util.Scanner;

public class ConvertirDivisa {
    public static void conversor(String divisa, String divisaConvertida, ConsultaDivisa consulta, Scanner usuario) {
        double monto;
        double montoConvertido;

        Divisas divisas = consulta.buscarDivisa(divisa, divisaConvertida);
        System.out.println("La conversión para el día es de: [" +
                divisa + "] equivalente a: " +
                divisas.conversion_rate() + " [" +
                divisaConvertida + "]");

        System.out.println("Ingrese el monto que desea convertir " + divisa);
        monto = Double.parseDouble(usuario.nextLine());
        montoConvertido = monto * divisas.conversion_rate();

        System.out.println("El valor de: " + monto + "[" + divisa + "]" +
                " corresponde al valor de: " + montoConvertido + "[" +
                divisas.target_code() + "]");

        // Guardar conversión en archivo JSON
        HistorialConversion.guardarConversion(divisa, divisaConvertida, monto, montoConvertido, divisas.conversion_rate());
    }

    public static void convertirDivisa(ConsultaDivisa consulta, Scanner usuario) {
        String divisa = usuario.nextLine().toUpperCase();
        String divisaConvertida = usuario.nextLine().toUpperCase();
        conversor(divisa, divisaConvertida, consulta, usuario);
    }
}