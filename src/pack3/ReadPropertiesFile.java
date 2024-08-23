package pack3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Properties;


public class ReadPropertiesFile {

	public static void main(String[] args) {
		Properties properties = environment();
//		properties.list(System.out);
		for (String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			System.out.println(key + " => " + value);
		}
	}

	public static Properties environment() {
		Properties props = new Properties();
		try (InputStream inStream = new FileInputStream("fakeMailConfig.properties")) {

			props.load(inStream);

		} catch (IOException e) {
		}
		return props;

	}

	public static String getPath() {
		CodeSource codeSource = ReadPropertiesFile.class.getProtectionDomain().getCodeSource();
		File jarFile = null;
		try {
			jarFile = new File(codeSource.getLocation().toURI().getPath());
		} catch (URISyntaxException e) {
		}
		@SuppressWarnings("null")
		String jarDir = jarFile.getParentFile().getPath();
		return jarDir;
	}

}
