package Digui;

import java.io.File;

public class FileDeleteDemo {

	public static void main(String[] args) {
		// ��װĿ¼
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\prc\\Resource\\Prc_ImgSrc");
		// �ݹ�ʵ��
		deleteFolder(srcFolder);
	}

	private static void deleteFolder(File srcFolder) {
		// ��ȡ��Ŀ¼�µ������ļ������ļ��е�File����
		File[] fileArray = srcFolder.listFiles();

		if (fileArray != null) {
			// ������File���飬�õ�ÿһ��File����
			for (File file : fileArray) {
				// �жϸ�File�����Ƿ����ļ���
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					
					if(!(file.getName().endsWith("_thumb.jpg"))){
						
						System.out.println(file.getAbsolutePath() + "---" + file.delete());
						
					}
					
					
				}
			}

			
		}
	}
	
	
	
}
