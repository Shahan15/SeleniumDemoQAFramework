package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; //class to handle key value pairs
import static java.nio.file.FileSystems.getDefault;

public class FileHandler {

    static Properties properties = new Properties();//instantiating Properties class

    //To make code more dynamic and portable need to build file path dynamically
    //Fs will get the system separator e.g. / or \
    //dir will get the user directory
    public static String Fs = getDefault().getSeparator();
    public static String dir = System.getProperty("user.dir");
    public static String ConfigPath = dir + Fs + "src" + Fs + "test" + Fs + "resources" + Fs;
    public static String ConfigFile = ConfigPath + "config.properties";

    public static String reports = ConfigPath + "Reports" + Fs;
    public static String screenshotPath = ConfigPath + "ScreenshotsFolder" + Fs;

    public static String readFile(String strKey)  {
        String result="";
        try {
            FileInputStream fis = new FileInputStream(ConfigFile);
            properties.load(fis); //loads properties from file
            result = properties.getProperty(strKey);
        }catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    public static String getProperty(String key) {
        String results = properties.getProperty(key);
        return results;
    } //this returns the key from config.properties


    public static class JSONReader {
        public static class UserData {
            public String username;
            public String password;
        }
    }

    @DataProvider(name = "jsonData")
    public Object[][] readJsonData() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JSONReader.UserData[] users = objectMapper.readValue(new
                File("src/test/resources/testData.json"), JSONReader.UserData[].class);
        Object[][] data = new Object[users.length][2];

        for (int i = 0; i < users.length; i++) {
            data[i][0] = users[i].username;
            data[i][1] = users[i].password;
        }
        return data;
    }

    public static JSONReader.UserData getFirstUserFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONReader.UserData[] users = objectMapper.readValue(new File("src/test/resources/testData.json"), JSONReader.UserData[].class);
        return users[0]; // Return the first user in the JSON array
    }

    public static JSONReader.UserData getFirstUserPasswordFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONReader.UserData[] users = objectMapper.readValue(new File("src/test/resources/testData.json"), JSONReader.UserData[].class);
        return users[0]; // Return the first user password in the JSON array
    }
}
