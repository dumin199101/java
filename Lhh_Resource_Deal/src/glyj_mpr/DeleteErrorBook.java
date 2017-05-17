package glyj_mpr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 删除错误的图书：
 * 
 * @author Administrator
 * 
 */
public class DeleteErrorBook {
	public static void main(String[] args) {
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");
		File bookinfo = new File("E:\\连环画新增资源处理\\Txt\\compare_bookname.txt");

		try {
			deleteErrorBook(srcFolder, bookinfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void deleteErrorBook(File srcFolder, File bookinfo)
			throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		if (fileArr != null) {

			for (File file : fileArr) {

				if (file.isDirectory()) {

					BufferedReader br = new BufferedReader(new FileReader(
							bookinfo));

					String line = null;

					while ((line = br.readLine()) != null) {

						if (line.equals(file.getAbsolutePath())) {

							// System.out.println(file.getName());
							File newFolder = new File(file.getAbsolutePath());
							deleteBook(newFolder);

						}

					}

					deleteErrorBook(file, bookinfo);

				}

			}

		}

	}

	private static void deleteBook(File newFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = newFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteBook(file);

			} else {

				// System.out.println(file.getAbsolutePath());
				if (file.delete()) {

					System.out.println(file.getAbsolutePath() + "文件删除成功");

				} else {

					System.out.println(file.getAbsolutePath() + "文件删除失败");

				}

			}

		}

		// 删文件夹：
		if (newFolder.delete()) {
			System.out.println(newFolder.getAbsolutePath() + "文件夹删除成功");
		} else {
			System.out.println(newFolder.getAbsolutePath() + "文件夹删除失败");
		}

	}

}
