package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 做四大名著的文件复制，但是剔除音频资源：
 * 
 * @author Administrator
 * 
 */

public class FileCopySiDaMingZhu {
	public static void main(String[] args) {

		File srcFolder = new File("H:\\lhh\\Public\\Mpr\\Book");

		File destFolder = new File("J:\\lhhAudio");

		destFolder.mkdir();
		
		long start_time = System.currentTimeMillis();

		try {
			copyFolder(srcFolder, destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end_time = System.currentTimeMillis();
		
		
		long seconds = (end_time - start_time) / 1000;
		
		System.out.println("文件复制完成,共耗时"+ seconds +"s");

	}

	private static void copyFolder(File srcFolder, File destFolder)
			throws IOException {
		// TODO Auto-generated method stub

		if (srcFolder.isDirectory()) {
			
			File newFolder = new File(destFolder,srcFolder.getName());
			
			newFolder.mkdir();
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File f : fileArr){
				
				copyFolder(f, newFolder);
				
				
			}
			
			


		} else {

			//if (srcFolder.getName().endsWith(".jpg") || srcFolder.getName().endsWith("png")) {

				File newFile = new File(destFolder, srcFolder.getName());

				copyFile(srcFolder, newFile);
				
				System.out.println(newFile.getAbsolutePath() +"文件复制完成");

			//}

		}

	}

	private static void copyFile(File srcFolder, File newFile)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFolder));

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(newFile));

		byte[] bys = new byte[1024];

		int len = 0;

		while ((len = bis.read(bys)) != -1) {

			bos.write(bys, 0, len);

		}

		bos.close();

		bis.close();

	}
}
