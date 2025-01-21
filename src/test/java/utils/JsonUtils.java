package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    private static final String JSON_FILE_PATH = "./testConfig.json";

    public static String readJsonFromFile(String key) {
        String value = null;
        try (InputStream is = Files.newInputStream(Paths.get(JSON_FILE_PATH))) {
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);
            value = jsonObject.getString(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}