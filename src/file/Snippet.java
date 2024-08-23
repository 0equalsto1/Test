package file;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;

public class Snippet {
	public static void main(String[] args) throws URISyntaxException {
		String path = new File(Snippet.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		System.out.println(path);

		CodeSource codeSource = Snippet.class.getProtectionDomain().getCodeSource();
		File jarFile = new File(codeSource.getLocation().toURI().getPath());
		path = jarFile.getParentFile().getPath();
		System.out.println(path);
		Path p = Paths.get(Snippet.class.getProtectionDomain().getCodeSource().getLocation().toURI());

		System.out.println(p.getParent().toString());
	}
}
