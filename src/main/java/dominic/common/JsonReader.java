package dominic.common;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

    public JSONObject readData(String filePath) {
        JSONParser jsonParser = new JSONParser();
        JSONObject dataObject = null;

        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON file
            Object obj = jsonParser.parse(reader);
            dataObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataObject;
    }
}
