package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����Ƶ�ļ����в���հ���Ƶ:
 * 
 * 9.��Ϊ�е���Ƶ��Ҫ�������հ���Ƶ���е���Ƶ��Ҫ�������հ���Ƶ��ͳһ����������ҳ���հף�βҳ 1.mp3 blank.mp3 foot.mp3
 *    ������úú�Ϊ��������ô��ɾ��blank.mp3
 * 
 * @author Administrator
 * 
 */
public class InsertBlankAudio {

	public static void main(String[] args) {

		File srcFolder = new File("E:\\������������Դ����\\Book\\�账��ͼ��");

		try {
			copyBlankAudio(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void copyBlankAudio(File srcFolder)  throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		
		if (srcFolder.getName().equals("audio")) {

			// ����blank.mp3��ָ��Ŀ¼��
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("E:\\������������Դ����\\Resource\\blank.mp3"));

			File newFile = new File(srcFolder, "blank.mp3");
//			 File newFile = new File(srcFolder, "foot.mp3");
//			 File newFile = new File(srcFolder, "1.mp3");

			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(newFile));

			byte[] bys = new byte[1024];

			int len = 0;

			while ((len = bis.read(bys)) != -1) {

				bos.write(bys, 0, len);

			}

			System.out.println(newFile.getAbsolutePath() + "�ļ����Ƴɹ�");

			bis.close();

			bos.close();

		}

		for (File file : fileArr) {

			if (file.isDirectory()) {

				copyBlankAudio(file);

			}

		}
		
		
	}

}
