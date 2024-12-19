import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws Exception {
        //TODO : Implement CSV file with term list in one side, and starting offset position in the other
        URL url = new URL("https://g.tenor.com/v1/search?q=jojo&key=LIVDSRZULELA&limit=8&pos=10");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        if (status==200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println(content);

            Gson g = new Gson();
            GifResponse response = g.fromJson(content.toString(), GifResponse.class);
            for (GifResponse.Result result : response.results) {
                System.out.println(result.id);
                for (GifResponse.Media media : result.media) {
                    System.out.println(media.gif.url);
                    System.out.println(media.tinygif.url);
                }
            }




}}}
