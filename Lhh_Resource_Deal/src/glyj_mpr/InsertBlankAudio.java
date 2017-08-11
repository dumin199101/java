package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 向音频文件夹中插入空白音频:
 * 
 * 9.因为有的音频需要放两个空白音频，有的音频需要放三个空白音频，统一放三个，首页，空白，尾页 1.mp3 blank.mp3 foot.mp3
 *    如果放置好后为奇数，那么就删除blank.mp3
 * 
 * @author Administrator
 * 
 */
public class InsertBlankAudio {

	public static void main(String[] args) {

		File srcFolder = new File("E:\\连环画新增资源处理\\Book\\需处理图书");

		try {
			copyBlankAudio(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void copyBlankAudio(File srcFolder)  throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		
		if (srcFolder.getName().equals("audio")) {

			// 复制blank.mp3到指定目录：
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("E:\\连环画新增资源处理\\Resource\\blank.mp3"));

			File newFile = new File(srcFolder, "blank.mp3");
//			 File newFile = new File(srcFolder, "foot.mp3");
//			 File newFile = new File(srcFolder, "1.mp3");

			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(newFile));

			byte[] bys = new byte[1024];

			int len = 0;

			while ((len = bis.read(bys)) != -1) {

				bos.write(bys, 0, len);

			}

			System.out.println(newFile.getAbsolutePath() + "文件复制成功");

			bis.close();

			bos.close();

		}

		for (File file : fileArr) {

			if (file.isDirectory()) {

				copyBlankAudio(file);

			}

		}
		
		
	}

}
