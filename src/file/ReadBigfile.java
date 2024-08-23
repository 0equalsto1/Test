package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadBigfile {

	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();
		long count = Files.lines(Paths.get("/home/mahendra/workspace/doc/SPARK/exm/data.txt")).
		filter(i->Integer.parseInt(i)%2==0).count();
		System.out.println(count+"  " + (System.currentTimeMillis() - s));
	}

}
