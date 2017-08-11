package FileAddResourceDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DealNewAddResource {

	public static void main(String[] args) throws IOException {

		File srcFolder = new File("D:\\��Դ����\\Resource");
		
		//���ɵĴ�˵02 ���� ���ɵĴ�˵05 ����
		// File srcFolder = new
		// File("I:\\����Զ��\\��Դ����\\�񻰹���ϵ��\\���ɵĴ�˵01\\img\\108527.jpg");

		// 1.ɨ����Դ��
//		 scanResource(srcFolder);

		// 2.ɾ�����е�txt�ı���
//		 deleteTxt(srcFolder);

		// 3.�����пհ�ҳ���飬ɾ��blank.jpg
//		 FindBlankJpgAndDelete(srcFolder);

		// 4.ͳ��ͼƬ�ĸ��������Ϊ����ҳ���,����blank.jpg��
//		 FindOddPageInsertBlankJpg(srcFolder);

		// 5.�����ļ� 
//		 scanResource(srcFolder);

		// 6.��ΪͼƬ�ļ������й��ɣ�����������ͼƬ������Ҫע����������bakһ�£���������1��ʼ,���Ҫ��3�����
//		 renameJpg(srcFolder);

		// 7.ȥ��background.mp3��foot.mp3
//		 deleteBgFootMP3(srcFolder);

		// -----------------------------------------------------------ʯ�ù� ��Ҷɽ

		// 8.ͳ����Ƶ������ͼƬ������
//		 findImgAndAudioCount(srcFolder);

		// 9.��Ϊ�е���Ƶ��Ҫ�������հ���Ƶ���е���Ƶ��Ҫ�������հ���Ƶ��ͳһ����������ҳ���հף�βҳ��������úú�Ϊ��������ô��ɾ��blank.mp3
//		 copyBlankAudio(srcFolder);

		// 10.ɾ����Ƶ����Ϊ�����е�blank.mp3
//		 deleteOddBlankMp3(srcFolder);

		// 11.����Ƶ�ļ�������������
//		renameAudio(srcFolder);

	}

	private static void renameAudio(File srcFolder) {
		// TODO Auto-generated method stub

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

			// 1.�����Ƿ���1��ʼ����,��������������
//			 if (f.getName().length() <= 6) {
//			
//			 if (f.getName().length() == 6) {
//			
//			 File dest = new File(file, "0" + f.getName());
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
//			 }
//			
//			 if (f.getName().length() == 5) {
//			
//			 File dest = new File(file, "00" + f.getName());
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
//			 }
//			
//			 }

			// 2.��������ͼ�飬��ֹ+1ʱ100���ϵĳ���
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

			// 3.��������1��ʼ��

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

	private static void deleteOddBlankMp3(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		if (srcFolder.getName().endsWith("audio")) {

			// ���Ϊ������ɾ��blank.mp3
			if (fileArr.length % 2 != 0) {

				// System.out.println(srcFolder.getAbsolutePath());

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

	private static void copyBlankAudio(File srcFolder) throws IOException {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		// ����һ�µ�ǰ�ļ�����audio�ļ�����ͼƬ�ĸ���,���Ϊ����������blank.jpg
		if (srcFolder.getName().contains("audio")) {

			// ����blank.mp3��ָ��Ŀ¼��
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("D:\\��Դ����\\blank.mp3"));

//			File newFile = new File(srcFolder, "blank.mp3");
			 File newFile = new File(srcFolder, "foot.mp3");
//			 File newFile = new File(srcFolder, "-1.mp3");

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

	private static void findImgAndAudioCount(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		System.out.println(srcFolder.getAbsolutePath() + "���ļ�����:"
				+ fileArr.length);

		for (File file : fileArr) {

			if (file.isDirectory()) {

				findImgAndAudioCount(file);

			}

		}

	}

	private static void deleteBgFootMP3(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteBgFootMP3(file);

			} else {

				if (file.getName().endsWith("background.mp3")
						|| file.getName().endsWith("foot.mp3")) {

					if (file.delete()) {

						System.out.println(file.getAbsolutePath() + "�ļ�ɾ���ɹ�");

					} else {

						System.out.println(file.getAbsolutePath() + "�ļ�ɾ��ʧ��");

					}

				}

			}

		}

	}

	private static void renameJpg(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().contains("img")) {
					// ����������
					renameFile(file);
				}

				// �ݹ飺
				renameJpg(file);

			}

		}

	}

	private static void renameFile(File file) {
		// TODO Auto-generated method stub
		// ����2����������

		File[] fileArr = file.listFiles();

		int x = 1;

		for (File f : fileArr) {

			// 1.�����Ƿ���1��ʼ����,��������������
//			 if(f.getName().length()<=6){
//			
//			 if(f.getName().length()==6){
//			
//			
//			 File dest = new File(file,"0" + f.getName());
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("�ļ��������ɹ�:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("�ļ�������ʧ��:"+ f.getAbsolutePath());
//			
//			 }
//			
//			
//			
//			
//			 }
//			
//			
//			 if(f.getName().length()==5){
//			
//			 File dest = new File(file,"00" + f.getName());
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("�ļ��������ɹ�:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("�ļ�������ʧ��:"+ f.getAbsolutePath());
//			
//			 }
//			
//			
//			 }
//			
//			
//			 }

			// 2.��������ͼ�飬��ֹ+1ʱ100���ϵĳ���
//			 File dest = new File(file,f.getName().concat("bak.jpg"));
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("�ļ��������ɹ�:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("�ļ�������ʧ��:"+ f.getAbsolutePath());
//			
//			 }

			// 3.��������1��ʼ��

//			 File dest = new File(file, String.valueOf(x) + ".jpg");
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

			// Ϊ��ֹ����������bak,���ֱ��������

			// File dest = new File(file,f.getName().concat("bak.jpg"));
			//
			// if(f.renameTo(dest)){
			//
			// System.out.println("�ļ��������ɹ�:"+ dest.getAbsolutePath());
			//
			// }else{
			//
			// System.out.println("�ļ�������ʧ��:"+ f.getAbsolutePath());
			//
			// }

			// ���������Ȱ�bak��ԭ��
			// if(f.getName().contains("jpgbak.jpg")){
			//
			// String[] s = f.getName().split("bak.jpg");
			//
			// System.out.println(s[0]);
			//
			// File dest = new File(file,s[0]);
			//
			// if(f.renameTo(dest)){
			//
			// System.out.println("�ļ��������ɹ�:"+ dest.getAbsolutePath());
			//
			// }else{
			//
			// System.out.println("�ļ�������ʧ��:"+ f.getAbsolutePath());
			//
			// }
			//
			//
			//
			//
			// }

		}

	}

	private static void FindOddPageInsertBlankJpg(File srcFolder)
			throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		// ����һ�µ�ǰ�ļ�����img�ļ�����ͼƬ�ĸ���,���Ϊ����������blank.jpg ���ļ����²���
		if (srcFolder.getName().contains("img")) {

			if (fileArr.length % 2 != 0) {

				// ����blank.jpg��ָ��Ŀ¼��
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream("D:\\��Դ����\\blank.jpg"));

				File newFile = new File(srcFolder, "blank.jpg");

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

		}

		for (File file : fileArr) {

			if (file.isDirectory()) {

				FindOddPageInsertBlankJpg(file);

			}

		}

	}

	private static void FindBlankJpgAndDelete(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			// �ж����ļ������ļ��У�
			if (file.isDirectory()) {

				// ����ļ�������
				// System.out.println("�ļ��У�"+file.getAbsolutePath());

				FindBlankJpgAndDelete(file);

			} else {

				// �ļ���
				if (file.getName().endsWith("blank.jpg")) {

					if (file.delete()) {

						System.out.println("blank.jpg�ļ���ɾ����"
								+ file.getAbsolutePath());

					} else {

						System.out.println("blank.jpg�ļ�ɾ��ʧ�ܣ�"
								+ file.getAbsolutePath());

					}

				}

				// System.out.println("  �ڲ��ļ�:"+file.getAbsolutePath());

			}

		}

	}

	private static void deleteTxt(File srcFolder) {
		// TODO Auto-generated method stub �ٶ���������Ŀ¼��ʽ�����ﲻ���ļ����ж���,����ʱһ������Ŀ¼������
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			// �ж����ļ������ļ��У�
			if (file.isDirectory()) {

				// ����ļ�������
				// System.out.println("�ļ��У�"+file.getAbsolutePath());

				deleteTxt(file);

			} else {

				// �ļ���
				if (file.getName().endsWith(".txt")) {

					if (file.delete()) {

						System.out
								.println("txt�ļ���ɾ����" + file.getAbsolutePath());

					} else {

						System.out.println("txt�ļ�ɾ��ʧ�ܣ�"
								+ file.getAbsolutePath());

					}

				}

				// System.out.println("  �ڲ��ļ�:"+file.getAbsolutePath());

			}

		}

	}

	private static void scanResource(File srcFolder) {
		// TODO Auto-generated method stub
		if (srcFolder.isDirectory()) {

			File[] fileArr = srcFolder.listFiles();

			for (File file : fileArr) {

				// �ж����ļ������ļ��У�
				if (file.isDirectory()) {

					// ����ļ�������
					System.out.println("�ļ��У�" + file.getAbsolutePath());

					scanResource(file);

				} else {

					// �ļ���
					System.out.println("  �ڲ��ļ�:" + file.getAbsolutePath());

				}

			}

		} else {

			// ������ļ���
			System.out.println("����ļ���" + srcFolder.getAbsolutePath());

		}

	}

}
