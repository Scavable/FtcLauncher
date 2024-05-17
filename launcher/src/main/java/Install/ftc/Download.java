package Install.ftc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import instance.Instance;
import org.w3c.dom.ls.LSOutput;
import util.FTCEnum;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Download {
    public Download(Instance instance) throws IOException, URISyntaxException {
        if(!instance.installed){
            File file = new File(System.getProperty("user.dir").concat("/Instances/")+instance.getName());
            if(!file.exists()){
                if(file.mkdir()){
                    System.out.println("Directory created: "+file.getAbsolutePath());
                }

            }
            URL url = new URL(FTCEnum.properties.getProperty(FTCEnum.Info.PACKAGEURL.getString()).concat(instance.getDownloadLocation()));
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.connect();
            if(httpsURLConnection.getResponseCode() == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                httpsURLConnection.disconnect();
                JsonNode node = new ObjectMapper().readTree(stringBuilder.toString());
                System.out.println(node);
                instance.installed = true;
        }

        }


//        ObjectMapper mapper = new ObjectMapper();
//        mapper.readValue(url, PacksURL.class);

    }
}
