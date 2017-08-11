package glyj_sinocomic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��ȡ���е���Ƶ��Դ
 * 
 * @author Administrator
 * 
 */
public class GetAllAudio {
	public static void main(String[] args) throws IOException {

		File srcFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Resource");

		File destFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Audio");
	

			try {
				getAllAudio(srcFolder, destFolder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

	private static void getAllAudio(File srcFolder, File destFolder)
			throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		File newFolder = new File(destFolder, srcFolder.getName());

		newFolder.mkdir();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().equals("img")) {

					continue;

				}

				getAllAudio(file, newFolder);

			} else {

				File newFile = new File(newFolder, file.getName());

				copyFile(file, newFile);

				System.out.println(file.getAbsolutePath() + "�ļ��������");

			}

		}

	}

	private static void copyFile(File file, File newFile) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(newFile));

		int len = 0;

		byte[] bys = new byte[1024];

		while ((len = bis.read(bys)) != -1) {

			bos.write(bys, 0, len);

		}

		bis.close();

		bos.close();

	}

}
