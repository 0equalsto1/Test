package pack3;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class LeftShift {

	public static void main(String[] args) throws IOException {
		int bit = 0;
		for (int i = 0; i < 16; i++) {
			bit |= i << i;
		}
		System.out.println(bit);
		
		Path rootPath = Paths.get("E:\\Email-Servers\\uploadhosting - Copy");
		Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS)
		    .sorted(Comparator.reverseOrder())
		    .map(Path::toFile)
		    .forEach(File::delete);
	}

}
