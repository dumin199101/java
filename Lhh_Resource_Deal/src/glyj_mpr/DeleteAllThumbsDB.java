package glyj_mpr;


import java.io.File;
import java.io.IOException;

/**
 * ɾ�����е�thumbs.db
 * 
 * @author Administrator
 * 
 */
public class DeleteAllThumbsDB {

	public static void main(String[] args) {
		File srcFolder = new File("E:\\������������Դ����");

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

					System.out.println(file.getName() + "�ļ��ѱ�ɾ��");

				}

			}

		}

	}

}
