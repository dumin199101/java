package glyj_sl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * hash PDF文件到对应的文件夹目录下
 * @author Administrator
 *
 */
public class HashPDFToDir {
     public static void main(String[] args) throws IOException {
    	 //文件散列
//	     hashPDFtoDir();
    	 //删除整本文件
    	 File srcFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\拆分每本PDF");
//    	 deleteSourceFile(srcFolder);
         //重命名图片
    	 renameFile(srcFolder);
    	 
	 }

	
	private static void hashPDFtoDir() throws IOException {
		File srcFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\成本PDF\\古代卷(241)");
	     File destFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\拆分每本PDF");
	     File[] fileArr = srcFolder.listFiles();
	     if(fileArr!=null){
	    	 for(File file : fileArr){
	    		 if(file.isFile()&&file.getName().endsWith(".pdf")){
	    			    File newFolder = new File(destFolder,file.getName().replaceAll(".pdf", ""));
	    			    if(!newFolder.exists()){
	    			    	newFolder.mkdirs();
	    			    }
	    			    //复制文件到目录下
	    			    File srcFile = new File(srcFolder,file.getName());
		    			File destFile = new File(newFolder,file.getName());
	    			    copyFile(srcFile, destFile);
	    		 }
	    	 }
	     }
	}
     
     private static void copyFile(File srcFile, File destFile) throws IOException {
 		// TODO Auto-generated method stub
 		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
 		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
 		int len = 0;
 		byte[] bys = new byte[1024];
 		while((len = bis.read(bys))!=-1){
 			bos.write(bys, 0, len);
 		}
 		bis.close();
 		bos.close();
 		System.out.println(destFile.getName()+"文件复制完成");
 	}
     
     /**
      * 删除散列后的原始文件
      * @param srcFolder
      */
     private static void deleteSourceFile(File srcFolder){
    	 File[] fileArr = srcFolder.listFiles();
    	 if(fileArr!=null){
    		 for(File file : fileArr){
    			  if(file.isDirectory()){
    				  //遍历
    				  deleteSourceFile(file);
    			  }else{
    				  //删除文件
    				  if(!file.getName().contains("_")){
    					  //做删除操作：
    					  if(file.delete()){
    						  System.out.println(file.getName()+"删除成功");
    					  }else{
    						  System.out.println(file.getName()+"删除失败");
    					  }
    				  }
    			  }
    		 }
    	 }
     }
     
     /**
      * 对拆分后的文件进行重命名：
      * @param srcFolder
      */
     private static void renameFile(File srcFolder){
    	 File[] fileArr = srcFolder.listFiles();
    	 if(fileArr!=null){
    		 for(File file : fileArr){
    			  if(file.isDirectory()){
    				  //遍历
    				  renameFile(file);
    			  }else{
    				  int pos = file.getName().lastIndexOf("_");
    				  File srcFile = new File(srcFolder,file.getName());
    				  File destFile = new File(srcFolder,file.getName().substring(pos+1));
    			      if(srcFile.renameTo(destFile)){
    			    	  System.out.println(srcFile.getName()+"rename Success");
    			      }else{
    			    	  System.out.println(srcFile.getName()+"rename failed");
    			      }
    			  }
    		 }
    	 }
    	 
     }
     
}
