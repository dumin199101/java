package glyj_mpr;

import java.io.File;

/**
 * 删除音频数为奇数的blank音频：
 * @author Administrator
 *
 */
public class DeleteOddBlankAudio {
    public static void main(String[] args) {
		
    	 File srcFolder = new File("E:\\连环画新增资源处理\\Book\\需处理图书");
    	
    	 deleteOddBlankMp3(srcFolder);
    	 
    	 
    	 
    	 
    	
	}

	
    private static void deleteOddBlankMp3(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		if (srcFolder.getName().equals("audio")) {

			// 如果为奇数，删除blank.mp3
			if (fileArr.length % 2 != 0) {

				// 执行删除操作：

				File parentDirectory = new File(srcFolder.getAbsolutePath());

				File blankAudio = new File(parentDirectory, "blank.mp3");

				if (blankAudio.delete()) {

					System.out.println(blankAudio + "删除成功");

				} else {

					System.out.println(blankAudio + "删除失败");

				}

			}

		}

		// 递归：

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteOddBlankMp3(file);

			}

		}

	}
    
}
