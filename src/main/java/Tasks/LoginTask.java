package Tasks;

import com.google.gson.Gson;
import postbodies.LoginPass;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
public class LoginTask { //TokenCatch

    LoginPass loginPass;

    public LoginTask(LoginPass loginPass) {
        this.loginPass = loginPass;
    }

    protected HttpResponse<String> call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/login"))
                .timeout(Duration.ofSeconds(5))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(loginPass)))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
