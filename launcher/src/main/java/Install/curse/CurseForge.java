package Install.curse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;
import java.util.Properties;

public class CurseForge {
    Properties properties;

    public CurseForge(Properties properties, Map<String, Double> screenProperties){
        this.properties = properties;
    }

    private void games() throws IOException, URISyntaxException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v1/games")).toURL();
        Connection(obj);
    }

    private void categories() throws IOException, URISyntaxException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v1/categories")).toURL();
        Connection(obj);

    }

    private void game() throws IOException, URISyntaxException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v1/games/{gameId}")).toURL();
        Connection(obj);
    }

    private void versions() throws URISyntaxException, IOException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v1/games/{gameId}/versions")).toURL();
        Connection(obj);
    }

    private void versionType() throws IOException, URISyntaxException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v1/games/{gameId}/version-types")).toURL();
        Connection(obj);
    }

    private void versionsV2() throws URISyntaxException, IOException {
        URL obj = new URI(properties.getProperty("curseBaseAPI").concat("v2/games/{gameId}/versions")).toURL();
        Connection(obj);
    }

    private void Connection(URL obj) throws IOException {
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        setConProperties(con);

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response);
    }

    private void setConProperties(HttpsURLConnection con){
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-api-key", properties.getProperty("curseAPIKey"));
    }

}
