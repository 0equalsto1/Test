package pack2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNIO {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		recursiveDelete(new File("SMSSenderService"));
//		 deletingDirectoriesRecursively(Paths.get("SMSSenderService"));
		long end = System.currentTimeMillis();
		System.out.println("Time taken by process : " + (end - start) / 1000);
	}

	public static void deletingDirectoriesRecursively(Path rootPath) {
		try {
			Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println("delete file: " + file.toString());
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					System.out.println("delete dir: " + dir.toString());
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void recursiveDelete(File file) {
		if (!file.exists())
			return;

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				recursiveDelete(f);
			}
		}

		if (file.isDirectory()) {
			file.delete();
			System.out.println("Deleted folder: " + file.getName());
		} else {
			file.delete();
			System.out.println("Deleted file: " + file.getName());
		}
	}

}
