package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileExample1 {

	public static void main(String[] args) throws InterruptedException {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();

        String jvmName = bean.getName();
        System.out.println("Name = " + jvmName);
		try (BufferedReader br = Files.newBufferedReader(Paths.get("D:/MSR/PlayOut Logging.txt"))) {

			String line;
			try (FileWriter writer = new FileWriter("C:\\Users\\mahendra.rawat\\Desktop\\twoThread.txt",true);
					BufferedWriter bw = new BufferedWriter(writer)) {
				while ((line = br.readLine()) != null) {

					bw.write(line+" "+jvmName.split("@")[0]);
					bw.newLine();
					bw.flush();
					System.out.println("----------");
					TimeUnit.SECONDS.sleep(5);

				}
			} catch (IOException e) {
				System.err.format("IOException: %s%n", e);
			}

		}

		catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}

}