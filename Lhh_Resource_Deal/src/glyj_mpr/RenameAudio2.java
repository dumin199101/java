package glyj_mpr;

import java.io.File;

/**
 * ��������Ƶ�ļ���
 * 
 * @author Administrator
 * 
 */
public class RenameAudio2 {
	public static void main(String[] args) {

		File srcFolder = new File("E:\\������������Դ����\\Book\\�账��ͼ��");

		renameAudio(srcFolder);

		System.out.println("Procedure End");

	}

	private static void renameAudio(File srcFolder) {

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().contains("audio")) {
					// ����������
					renameAudioFile(file);
				}

				// �ݹ飺
				renameAudio(file);

			}

		}

	}

	private static void renameAudioFile(File file) {
		// TODO Auto-generated method stub
		File[] fileArr = file.listFiles();

		int x = 1;

		for (File f : fileArr) {
			
			//1.mp3 001.mp3 12.mp3 012.mp3 125.mp3����

//			if (f.getName().length() <= 6) {
//
//				if (f.getName().length() == 6) {
//
//					File dest = new File(file, "0" + f.getName());
//
//					if (f.renameTo(dest)) {
//
//						System.out.println("�ļ��������ɹ�:" + dest.getAbsolutePath());
//
//					} else {
//
//						System.out.println("�ļ�������ʧ��:" + f.getAbsolutePath());
//
//					}
//
//				}
//
//				if (f.getName().length() == 5) {
//
//					File dest = new File(file, "00" + f.getName());
//
//					if (f.renameTo(dest)) {
//
//						System.out.println("�ļ��������ɹ�:" + dest.getAbsolutePath());
//
//					} else {
//
//						System.out.println("�ļ�������ʧ��:" + f.getAbsolutePath());
//
//					}
//
//				}
//
//			}
			
			
			
		    //2.��������ͼ�飬��ֹ+1ʱ100���ϵĳ���
//			File dest = new File(file, f.getName().concat("bak.mp3"));
//
//			if (f.renameTo(dest)) {
//
//				System.out.println("�ļ��������ɹ�:" + dest.getAbsolutePath());
//
//			} else {
//
//				System.out.println("�ļ�������ʧ��:" + f.getAbsolutePath());
//
//			}
			
			
			//3.��������1��ʼ��
//			 File dest = new File(file, String.valueOf(x) + ".mp3");
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("�ļ��������ɹ�:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("�ļ�������ʧ��:" + f.getAbsolutePath());
//			
//			 }
//			
//			 x++;

			
			
			
			

		}

	}
}
