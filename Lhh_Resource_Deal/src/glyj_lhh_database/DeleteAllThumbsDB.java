package glyj_lhh_database;

import java.io.File;
import java.io.IOException;

/**
 * 删除所有的thumbs.db
 * 
 * @author Administrator
 * 
 */
public class DeleteAllThumbsDB {

	public static void main(String[] args) {
		File srcFolder = new File("J:\\Lhh\\Lhh_Book");

		try {
			deleteFile(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void deleteFile(File delFolder) throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr = delFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteFile(file);

			} else {

				if (file.getName().contains("Thumbs.db")) {

					file.delete();

					System.out.println(file.getAbsolutePath() + "文件已被删除");

				}

			}

		}

	}

}

