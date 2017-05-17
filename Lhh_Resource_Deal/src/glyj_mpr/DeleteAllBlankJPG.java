package glyj_mpr;

import java.io.File;
import java.io.IOException;

/**
 * 删除所有的blank.jpg
 * @author Administrator
 *
 */

public class DeleteAllBlankJPG {
	
	public static void main(String[] args) {
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");

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

				if (file.getName().contains("blank.jpg")) {

					file.delete();

					System.out.println(file.getName() + "文件已被删除");

				}

			}

		}

	}
	
	

}
