package glyj_mpr;

import java.io.File;

/**
 * 重命名音频文件： 1.先把原来的文件从2开始重命名 2.按奇数偶数填入blank.mp3 foot.mp3 1.mp3 3.再次重命名文件，从1开始
 * 
 * @author Administrator
 * 
 */
public class RenameAudio {
	public static void main(String[] args) {

		File srcFolder = new File("E:\\连环画新增资源处理\\Book\\需处理图书");
//		File srcFolder = new File("E:\\连环画新增资源处理\\Book\\需处理图书\\四大名著单本故事之石碣村·闹江州\\audio");

		renameAudio(srcFolder);

		System.out.println("Procedure End");

	}

	private static void renameAudio(File srcFolder) {

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().contains("audio")) {
					// 重命名即可
					renameAudioFile(file);
				}

				// 递归：
				renameAudio(file);

			}

		}

	}

	private static void renameAudioFile(File file) {
		// TODO Auto-generated method stub
		File[] fileArr = file.listFiles();

		int x = 2;
		

		for (File f : fileArr) {
			
			System.out.println(f.getName());
			
			//1.mp3 001.mp3 12.mp3 012.mp3 125.mp3不变

//			if (f.getName().length() <= 6) {
//
//				if (f.getName().length() == 6) {
//
//					File dest = new File(file, "0" + f.getName());
//
//					if (f.renameTo(dest)) {
//
//						System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//
//					} else {
//
//						System.out.println("文件重命名失败:" + f.getAbsolutePath());
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
//						System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//
//					} else {
//
//						System.out.println("文件重命名失败:" + f.getAbsolutePath());
//
//					}
//
//				}
//
//			}
			
			
			
		    //2.先重命名图书，防止+1时100以上的出错：
//			File dest = new File(file, f.getName().concat("bak.mp3"));
//
//			if (f.renameTo(dest)) {
//
//				System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//
//			} else {
//
//				System.out.println("文件重命名失败:" + f.getAbsolutePath());
//
//			}
			
			
			//3.重命名从2开始：
//			 File dest = new File(file, String.valueOf(x) + ".mp3");
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("文件重命名失败:" + f.getAbsolutePath());
//			
//			 }
//			
//			 x++;

			
			
			
			

		}

	}
}
