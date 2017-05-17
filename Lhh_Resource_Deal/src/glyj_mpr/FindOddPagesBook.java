package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 查找为图片个数奇数的图书：插入blank.jpg
 * @author Administrator
 *
 */
public class FindOddPagesBook {
	
	public static void main(String[] args) {
		
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");
		
		try {
			findOddPagesBook(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void findOddPagesBook(File srcFolder) throws IOException{
	    
		File[] fileArr = srcFolder.listFiles();
		
		if(srcFolder.getName().contains("img")){
			
			if(fileArr.length%2!=0){
				
				// 复制blank.jpg到指定目录：
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream("E:\\连环画新增资源处理\\Resource\\blank.jpg"));

				File newFile = new File(srcFolder, "blank.jpg");

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
			
			
		}
		
		
		for (File file : fileArr) {

			if (file.isDirectory()) {

				findOddPagesBook(file);

			}

		}
		
		
		
		
		
	}

}
