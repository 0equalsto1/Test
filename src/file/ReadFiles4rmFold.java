package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReadFiles4rmFold {
	public static void main(String[] args) throws IOException {
//		File folder = new File("/log/song-log/2020-10-21");
		Files.list(Paths.get("/log/song-log"))// .filter(f->f.toString().contains("cronTab"))
//        .forEach(System.out::println);
				.forEach(e -> {
					try {
						readAndDelete(e.toFile());
					} catch (IOException e1) {
					}
				});
//		processFiles(folder);
	}

	public static void readAndDelete(final File folder) throws IOException {
		if (folder.isDirectory()) {
			System.out.println("isDirectory : " + folder.getName());
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					readAndDelete(fileEntry);
				} else
					readFile(fileEntry);
			}
		} else
			readFile(folder);
	}

	public static void readFile(File f) throws IOException {
		Files.readAllLines(f.toPath()).stream().forEach(System.out::println);
		f.delete();
	}

	public static void processFiles(final File folder) {
		Map<String, Integer> map = new HashMap<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				processFiles(fileEntry);
			} else {
				countWords(fileEntry, map);
			}
		}
		printWordFrequencyGrt1(map);
	}

	private static void printWordFrequencyGrt1(Map<String, Integer> map) {
		map.keySet().stream().filter(k -> k.length() > 2 && map.get(k) > 1)
				.forEach(k -> System.out.println(k + " : " + map.get(k)));
	}

	private static void countWords(File fileEntry, Map<String, Integer> map) {
		try {
			for (String s : Files.readAllLines(fileEntry.toPath())) {
				s = s.replaceAll("[^a-zA-Z0-9\\s+]", "").toLowerCase();
				for (String ss : s.split(" ")) {
					map.compute(ss, (k, v) -> v == null ? 1 : v + 1);
				}

			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
