package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CountLines {

	public static void main(String[] args) throws IOException {
		String pathname = "C:/Users/mahendra.rawat/Desktop/LOG/2019-05-14/2019-05-14_17.log";
		File file = new File(pathname);
		long s = System.currentTimeMillis();
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
		lineNumberReader.skip(Long.MAX_VALUE);
		int lines = lineNumberReader.getLineNumber();
		System.out.println(lines + " " + (System.currentTimeMillis() - s));
		lineNumberReader.close();
		BufferedReader br = Files.newBufferedReader(Paths.get(pathname));
		 s = System.currentTimeMillis();
		int count = 0;
		for (;;) {
			String line = br.readLine();
			if (line == null)
				break;
			count++;
		}
		br.close();
		System.out.println(count + " " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		List<String> alist = Files.lines(Paths.get(pathname))
//			    .filter(line -> line.contains("abc"))
				.collect(Collectors.toList());
		System.out.println(alist.size() + " " + (System.currentTimeMillis() - s));
		System.out.println(alist.get(alist.size() - 1));
		s = System.currentTimeMillis();
		System.out.println(Files.lines(Paths.get(pathname)).count() + " "
				+ (System.currentTimeMillis() - s));
	}

	}


