package FileAddResourceDeal;

import java.io.File;

/**
 * 遍历删除某个文件夹下的所有文件
 * @author Administrator
 *
 */
public class DeleteFile {
	
	 public static void main(String[] args) {
		
		 File srcFolder = new File("H:\\资源处理\\神话故事系列");
		 
		 
		 deleteFolder(srcFolder);
		 
		 
		 
		 
		 
		 
		 
	 }

	private static void deleteFolder(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		
		for(File f : fileArr){
			
			if(f.isDirectory()){
				
				 deleteFolder(f);
				
			}else{
				
				//删除文件：
				
				if(f.delete()){
					
					System.out.println(f.getName() + "文件删除成功");
					
				}else{
					
					System.out.println(f.getName() + "文件删除失败");
					
				}
				
				
			}
			
			
			//删除文件：
			
			if(srcFolder.delete()){
				
				System.out.println(srcFolder.getName() + "文件删除成功");
				
			}else{
				
				System.out.println(srcFolder.getName() + "文件删除失败");
				
			}
			
			
			
		}
		
		
		
		
	}
	

}
