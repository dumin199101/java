package glyj_mpr;

import java.io.File;

/**
 * 5.ɾ�����е�txt�ļ���
 * 
 * @author Administrator
 * 
 */
public class DeleteAllTxt {
	public static void main(String[] args) {
		File srcFolder = new File("E:\\������������Դ����\\Book");
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

					System.out.println(file.getAbsolutePath() + "ɾ���ɹ�");

				}

			}

		}

	}
}
