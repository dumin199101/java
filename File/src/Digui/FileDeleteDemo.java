package Digui;

import java.io.File;

public class FileDeleteDemo {

	public static void main(String[] args) {
		// 封装目录
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\prc\\Resource\\Prc_ImgSrc");
		// 递归实现
		deleteFolder(srcFolder);
	}

	private static void deleteFolder(File srcFolder) {
		// 获取该目录下的所有文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();

		if (fileArray != null) {
			// 遍历该File数组，得到每一个File对象
			for (File file : fileArray) {
				// 判断该File对象是否是文件夹
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
