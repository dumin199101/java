package glyj_mpr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ȶ�audio��jpg�ļ��ĸ���������Ӧ����һ���ģ������һ������������ģ�
 * 
 * @author Administrator
 * 
 */
public class CompareJpgAudio {

	public static void main(String[] args) {

		File srcFolder = new File("E:\\������������Դ����\\Book");

		try {
			comparejpgaudio(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Procedure End");

	}

	private static void comparejpgaudio(File srcFolder) throws IOException {

		File[] fileArr = srcFolder.listFiles();

		int imgCount = 0;
		int audioCount = 0;

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().equals("img")) {

					File[] fileArrs = file.listFiles();

					imgCount = fileArrs.length;

					if (imgCount != audioCount) {

						System.out.println(file.getParent() + "---" + imgCount
								+ "---" + audioCount);

						// ���ͬ��д�뵽compare.txt
						FileOutputStream fos = new FileOutputStream(
								"E:\\������������Դ����\\Txt\\compare_bookname.txt", true);

//						fos.write((file.getParent() + "---imgCount:" + imgCount
//								+ "---audioCount:" + audioCount).getBytes());
						
						fos.write(file.getParent().getBytes());

						fos.write("\r\n".getBytes());

						fos.close();

					}

				}

				if (file.getName().equals("audio")) {

					File[] fileArrs = file.listFiles();

					audioCount = fileArrs.length;

				}

				comparejpgaudio(file);

			}

		}

	}

}
