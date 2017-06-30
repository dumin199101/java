package glyj_sl;

import java.io.File;

/**
 * 重命名
 * @author Administrator
 *
 */
public class RenameFile {
     public static void main(String[] args) {
    	 String parentDir = "J:\\新疆丝绸之路西域史料文献辑要数据库原始数据\\丝绸之路西域史料文献辑要\\丝绸之路西域古代文献部（260种）_PDF\\一版252-260\\110-155平定陕甘新疆回匪方略1-46";
	     File srcFolder = new File(parentDir);	
	     scanDir(srcFolder);
	 }

	private static void scanDir(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
	     if(fileArr!=null){
	    	 for(File file : fileArr){
	    		 if(file.isDirectory()){
	    			 scanDir(file);
	    		 }else{
	    			 if(file.getName().endsWith(".tif"))
	    				 continue;
	    			 File srcFile = new File(srcFolder,file.getName());
	    			 File destFile = new File(srcFolder,"正文.pdf");
	    			 if(srcFile.renameTo(destFile)){
	    				 System.out.println(srcFile.getName()+"重命名成功");
	    			 }else{
	    				 System.out.println(srcFile.getName()+"重命名失败");
	    			 }
	    		 }
	    	 }
	     }
	}
}
