package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class SortTestDemo {

	public static void main(String[] args) {
		File srcFolder = new File("J:\\报刊加工\\群众周刊\\01第一卷");
//		sortFile(srcFolder);
		sortFolder(srcFolder);
	}

	private static void sortFolder(File srcFolder) {
		// TODO Auto-generated method stub
		ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();
		String[] list = srcFolder.list(); // 获取文件夹内的所有文件名
		if (list != null) {
			// 深拷贝 //浅拷贝 Arrays.asList(list)
			for (String name : list) {
				imgURList.add(new FileNameSort(name)); // 把文件名放入list里面
			}

			// 对 list 排序
			Collections.sort(imgURList);
			
			for(FileNameSort name : imgURList){
				System.out.println(name);
			}

		}
	}

	private static void sortFile(File srcFolder) {
		// TODO Auto-generated method stub
		// 存在图片，则直接获取
				ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();
				String[] list = srcFolder.list(); // 获取文件夹内的所有文件名
				if (list != null) {
					// 深拷贝 //浅拷贝 Arrays.asList(list)
					for (String name : list) {
						imgURList.add(new FileNameSort(name)); // 把文件名放入list里面
					}

					// 对 list 排序
					Collections.sort(imgURList);
					
					for(FileNameSort name : imgURList){
						System.out.println(name);
					}

				}
	}
	
	
}
