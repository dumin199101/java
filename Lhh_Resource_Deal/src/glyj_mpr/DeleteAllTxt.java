package glyj_mpr;

import java.io.File;

/**
 * 5.删除所有的txt文件：
 * 
 * @author Administrator
 * 
 */
public class DeleteAllTxt {
	public static void main(String[] args) {
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");
		deleteAllTxt(srcFolder);
	}

	private static void deleteAllTxt(File srcFolder) {

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteAllTxt(file);

			} else {

				if (file.getName().endsWith(".txt")) {

					file.delete();

					System.out.println(file.getAbsolutePath() + "删除成功");

				}

			}

		}

	}
}
