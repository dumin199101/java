package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class SortTestDemo {

	public static void main(String[] args) {
		File srcFolder = new File("J:\\�����ӹ�\\Ⱥ���ܿ�\\01��һ��");
//		sortFile(srcFolder);
		sortFolder(srcFolder);
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
					}

				}
	}
	
	
}
