package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 查找所有静读文件夹中的图片资源：
 * @author Administrator
 *
 */
public class FindJpeg {
	public static void main(String[] args) {
        
		//封装源目录：
//		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book");
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Resource\\Lhh_Book");
		
		
		
		
		//封装目的地目录：
		File destFolder = new File("H:\\Resource");
		
		//如果目的地目录不存在那么就创建
		if(!destFolder.exists()){
			
			destFolder.mkdirs();
			
		}
		
		//获得程序开始运行时间：
		long start_time = System.currentTimeMillis();
		
		
		//复制文件夹
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end_time = System.currentTimeMillis();
		
		long seconds = (end_time - start_time) / 1000;
		
		System.out.println("资源复制完成，用时：" + seconds + "s");
		
	}

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		// TODO Auto-generated method stub
		if(srcFolder.isDirectory()){
			//如果是文件夹就递归
			
			//1.在目的地创建一个目标文件夹：
			File destDir = new File(destFolder,srcFolder.getName());
			
			destDir.mkdir();
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				copyFolder(file, destDir);
				
			}
			
			
			
		}else{
			//如果是文件就做文件复制：
			
			File newFile = new File(destFolder,srcFolder.getName());
			
			copyFile(srcFolder,newFile);
			
			
			System.out.println(newFile.getAbsolutePath() +  "文件复制成功");
			
			
			
			
		}
		
		
		
		
	}

	private static void copyFile(File srcFolder, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFolder));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		
		//复制数据：
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = bis.read(bys)) != -1){
			
			bos.write(bys, 0, len);
			
		}
		
		//释放资源
		
		bos.close();
		bis.close();
		
		
		
		
		
	}
}

