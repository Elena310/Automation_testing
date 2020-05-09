import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseData {

    private static final Properties prop = getProperties();
    public static final String USER = prop.getProperty("USER");
    public static final String PWD = prop.getProperty("PWD");
    public static final String DBNAME = prop.getProperty("DBNAME");
    public static final String HOST = prop.getProperty("HOST");
    public static final String PORT = prop.getProperty("PORT");

    private static Properties getProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream
                ("/Users/natalliasamarava/Automated course/Day9/src/main/resources/db.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
