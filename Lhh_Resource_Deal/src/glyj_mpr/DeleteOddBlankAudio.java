package glyj_mpr;

import java.io.File;

/**
 * ɾ����Ƶ��Ϊ������blank��Ƶ��
 * @author Administrator
 *
 */
public class DeleteOddBlankAudio {
    public static void main(String[] args) {
		
    	 File srcFolder = new File("E:\\������������Դ����\\Book\\�账��ͼ��");
    	
    	 deleteOddBlankMp3(srcFolder);
    	 
    	 
    	 
    	 
    	
	}

	
    private static void deleteOddBlankMp3(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		if (srcFolder.getName().equals("audio")) {

			// ���Ϊ������ɾ��blank.mp3
			if (fileArr.length % 2 != 0) {

				// ִ��ɾ��������

				File parentDirectory = new File(srcFolder.getAbsolutePath());

				File blankAudio = new File(parentDirectory, "blank.mp3");

				if (blankAudio.delete()) {

					System.out.println(blankAudio + "ɾ���ɹ�");

				} else {

					System.out.println(blankAudio + "ɾ��ʧ��");

				}

			}

		}

		// �ݹ飺

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteOddBlankMp3(file);

			}

		}

	}
    
}
