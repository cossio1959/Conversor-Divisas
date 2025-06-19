import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisas buscarDivisa(String divisa, String divisaConvertida) {
        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/a96b572fd76c5d4580fa32e9/pair/"+divisa+"/"+divisaConvertida);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la Divisa");
        }
    }
}