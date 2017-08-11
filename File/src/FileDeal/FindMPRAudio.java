package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制所有的音频文件夹到指定目录
 * 
 * @author Administrator
 * 
 */
public class FindMPRAudio {
	public static void main(String[] args) {

		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book");

		File destFolder = new File("G:\\Audio");
		
		destFolder.mkdir();
		
		long start_time = System.currentTimeMillis();

		try {
			copyAudioFolder(srcFolder, destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end_time = System.currentTimeMillis();
		
		long seconds = (end_time - start_time) / 1000;
		
		System.out.println("音频文件夹拷贝完成，共耗时"+ seconds + "s");

	}

	private static void copyAudioFolder(File srcFolder, File destFolder)
			throws IOException {
		// TODO Auto-generated method stub
		if (srcFolder.isDirectory()) {
			
			  File newFolder = new File(destFolder,srcFolder.getName());
			  
			  newFolder.mkdir();
			  
			  File[] fileArr = srcFolder.listFiles();
			  
			  
			  for(File f : fileArr){
				  
				  
				   copyAudioFolder(f, newFolder);
				  
				  
			  }
			
			
			
			
			
			
			

		} else {
			
			if(srcFolder.getName().endsWith(".mp3")){
				
				File newFile = new File(destFolder, srcFolder.getName());

				copyAudioFile(srcFolder, newFile);

				System.out.println(newFile.getAbsolutePath() + "文件复制完成");    
				
				
				
				
				
			}

			

		}

	}

	private static void copyAudioFile(File srcFolder, File newFile)
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
