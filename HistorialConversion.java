import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class HistorialConversion {
    public static void guardarConversion(String base, String destino, double monto, double convertido, double tasa) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Conversion conversion = new Conversion(
                base, destino, monto, convertido, tasa, LocalDateTime.now().toString()
        );

        try (FileWriter writer = new FileWriter("historial_conversiones.json", true)) {
            gson.toJson(conversion, writer);
            writer.write(System.lineSeparator()); // Añade una línea entre conversiones
            System.out.println("✔️ Conversión guardada en historial_conversiones.json");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la conversión: " + e.getMessage());
        }
    }

        private static class Conversion {
        String base;
        String destino;
        double monto;
        double convertido;
        double tasa;
        String fecha;

        public Conversion(String base, String destino, double monto, double convertido, double tasa, String fecha) {
            this.base = base;
            this.destino = destino;
            this.monto = monto;
            this.convertido = convertido;
            this.tasa = tasa;
            this.fecha = fecha;
        }
    }
}