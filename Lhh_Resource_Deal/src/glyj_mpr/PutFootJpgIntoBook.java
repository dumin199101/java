package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * ��ȱ��foot.jpgͼ���а�foot.jpg���뵽ͼ����
 * 
 * @author Administrator
 * 
 */
public class PutFootJpgIntoBook {
	public static void main(String[] args) {

		File srcFolder = new File("E:\\������������Դ����\\Book");

		File bookName = new File("E:\\������������Դ����\\Txt\\result_nofootJPG.txt");

		try {
			putFootJppIntoBook(srcFolder, bookName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void putFootJppIntoBook(File srcFolder, File bookName)
			throws IOException {

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				BufferedReader br = new BufferedReader(new FileReader(bookName));

				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream("E:\\������������Դ����\\Resource\\foot.jpg"));

				int len = 0;

				byte[] bys = new byte[1024];

				String line = null;

				while ((line = br.readLine()) != null) {

					if (file.getName().equals(line)) {

						// System.out.println(file.getName());
						//
						// System.exit(0);

						// ˵��ȱ��foot.jpg
						while ((len = bis.read(bys)) != -1) {

							BufferedOutputStream bos = new BufferedOutputStream(
									new FileOutputStream(
											"E:\\������������Դ����\\Book\\����ս��\\"
													+ line + "\\img\\foot.jpg"));
							
							
							
							

							bos.write(bys, 0, len);

						}

						System.out.println("E:\\������������Դ����\\Book\\����ս��\\" + line
								+ "foot.jpg�������");

					}

				}

				putFootJppIntoBook(file, bookName);

			}

		}

	}
}
