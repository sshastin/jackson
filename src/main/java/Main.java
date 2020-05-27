import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"name\" : \"Битцевский парк\"}";

        Station station = null;

        try {
            station = objectMapper.readValue(json, Station.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(station.toString());

        Line line = null;
        String lineJson = Files.readString(Paths.get("C:\\Users\\sshas\\OneDrive\\Java\\Experiments\\ParseJsonWithJackson\\src\\main\\JSON\\line.json"));
        try {
            line = objectMapper.readValue(lineJson, Line.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(line.toString());

        Connection connection = null;
        String connectionJson = Files.readString(Paths.get("C:\\Users\\sshas\\OneDrive\\Java\\Experiments\\ParseJsonWithJackson\\src\\main\\JSON\\connection.json"));

        try {
            connection = objectMapper.readValue(connectionJson, Connection.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(connection.toString());
    }
}