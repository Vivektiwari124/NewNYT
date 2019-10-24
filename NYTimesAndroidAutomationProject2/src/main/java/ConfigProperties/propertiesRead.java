package ConfigProperties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertiesRead {
	static String systemDir = System.getProperty("user.dir");
	static Properties prop;

	public static Properties readProperties() {
		try {
			File appp = new File(systemDir + "\\src\\main\\java\\ConfigProperties\\" + "config.properties");
			FileInputStream fileInput = new FileInputStream(appp);
			prop = new Properties();
			prop.load(fileInput);
			return prop;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
