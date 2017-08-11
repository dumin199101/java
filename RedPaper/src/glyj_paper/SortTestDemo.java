package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class SortTestDemo {
	
	 public static int index = 0;

	public static void main(String[] args) {
		File srcFolder = new File("J:\\��ɫ�������Ͽ�ͼƬ��Դ��Ʒ����\\BL\\01\\12");
		sortFile(srcFolder);
//		sortFolder(srcFolder);
	}

	private static void sortFolder(File srcFolder) {
		// TODO Auto-generated method stub
		ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();
		String[] list = srcFolder.list(); // ��ȡ�ļ����ڵ������ļ���
		if (list != null) {
			// ��� //ǳ���� Arrays.asList(list)
			for (String name : list) {
				imgURList.add(new FileNameSort(name)); // ���ļ�������list����
			}

			// �� list ����
			Collections.sort(imgURList);
			
			for(FileNameSort name : imgURList){
				System.out.println(name);
			}

		}
	}

	private static void sortFile(File srcFolder) {
		// TODO Auto-generated method stub
		// ����ͼƬ����ֱ�ӻ�ȡ
				ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();
				String[] list = srcFolder.list(); // ��ȡ�ļ����ڵ������ļ���
				if (list != null) {
					// ��� //ǳ���� Arrays.asList(list)
					for (String name : list) {
						imgURList.add(new FileNameSort(name)); // ���ļ�������list����
					}

					// �� list ����
					Collections.sort(imgURList);
					
					for(FileNameSort name : imgURList){
						System.out.println(name);
//						testBLRename(srcFolder, name);
					}

				}
	}

	private static void testBLRename(File srcFolder, FileNameSort name) {
		SortTestDemo.index++;
		File srcFile = new File(srcFolder, name.toString());
		File destFile = new File(srcFolder,Integer.toString(SortTestDemo.index)+".jpg");
		System.out.println(destFile.getAbsolutePath());
		rename(srcFile,destFile);
	}
	
	private static void rename(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		if(srcFile.renameTo(destFile)){
			System.out.println(srcFile.getAbsolutePath()+"�������ɹ�");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"������ʧ��");
		}
		
	}
	
	
}
