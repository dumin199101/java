package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class SortTestDemo {
	
	 public static int index = 0;

	public static void main(String[] args) {
		File srcFolder = new File("J:\\红色报刊资料库图片资源成品数据\\BL\\01\\12");
		sortFile(srcFolder);
//		sortFolder(srcFolder);
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
			System.out.println(srcFile.getAbsolutePath()+"重命名成功");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"重命名失败");
		}
		
	}
	
	
}
