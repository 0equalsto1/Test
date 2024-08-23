package pack3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.activation.MimetypesFileTypeMap;

public class MyZipFileList {

	public void printFileList(String filePath) {

		ZipFile zip = null;
		try {

			zip = new ZipFile(filePath);
			final Enumeration<? extends ZipEntry> entries = zip.entries();
			entries.nextElement();
			while (entries.hasMoreElements()) {
				final ZipEntry entry = entries.nextElement();
				System.out.println(entry.getName());
				File f = new File(entry.getName());
	   String mimetype= new MimetypesFileTypeMap().getContentType(f);
	   String type = mimetype.split("/")[0];
	   if(type.equals("image"))
	       System.out.println("It's an image");
	   else 
	       System.out.println("It's NOT an image");
			}
			zip.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String a[]) {

		MyZipFileList mfe = new MyZipFileList();
		mfe.printFileList("C:/Users/Mahendra/Desktop/UploadZip.zip");
	}
}