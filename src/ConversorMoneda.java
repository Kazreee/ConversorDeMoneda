import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
    public void conversor(String base, String target, double amount) {
        URI direccion = URI.create(String.format("https://v6.exchangerate-api.com/v6/9c3a90a17b373994cdc90fb7/pair/%s/%s", base, target));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda data = new Gson().fromJson(response.body(), Moneda.class);
            double resultado_conversion = amount * data.conversion_rate();
            System.out.printf("%.2f [%s] corresponde al valor final de =>>> %.2f [%s]\n", amount, base, resultado_conversion, target);

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new RuntimeException("No fue posible la conversion");
        }
    }
}
