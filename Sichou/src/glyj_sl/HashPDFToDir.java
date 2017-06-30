package glyj_sl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * hash PDF�ļ�����Ӧ���ļ���Ŀ¼��
 * @author Administrator
 *
 */
public class HashPDFToDir {
     public static void main(String[] args) throws IOException {
    	 //�ļ�ɢ��
//	     hashPDFtoDir();
    	 //ɾ�������ļ�
    	 File srcFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\���ÿ��PDF");
//    	 deleteSourceFile(srcFolder);
         //������ͼƬ
    	 renameFile(srcFolder);
    	 
	 }

	
	private static void hashPDFtoDir() throws IOException {
		File srcFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\�ɱ�PDF\\�Ŵ���(241)");
	     File destFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\���ÿ��PDF");
	     File[] fileArr = srcFolder.listFiles();
	     if(fileArr!=null){
	    	 for(File file : fileArr){
	    		 if(file.isFile()&&file.getName().endsWith(".pdf")){
	    			    File newFolder = new File(destFolder,file.getName().replaceAll(".pdf", ""));
	    			    if(!newFolder.exists()){
	    			    	newFolder.mkdirs();
	    			    }
	    			    //�����ļ���Ŀ¼��
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
 		System.out.println(destFile.getName()+"�ļ��������");
 	}
     
     /**
      * ɾ��ɢ�к��ԭʼ�ļ�
      * @param srcFolder
      */
     private static void deleteSourceFile(File srcFolder){
    	 File[] fileArr = srcFolder.listFiles();
    	 if(fileArr!=null){
    		 for(File file : fileArr){
    			  if(file.isDirectory()){
    				  //����
    				  deleteSourceFile(file);
    			  }else{
    				  //ɾ���ļ�
    				  if(!file.getName().contains("_")){
    					  //��ɾ��������
    					  if(file.delete()){
    						  System.out.println(file.getName()+"ɾ���ɹ�");
    					  }else{
    						  System.out.println(file.getName()+"ɾ��ʧ��");
    					  }
    				  }
    			  }
    		 }
    	 }
     }
     
     /**
      * �Բ�ֺ���ļ�������������
      * @param srcFolder
      */
     private static void renameFile(File srcFolder){
    	 File[] fileArr = srcFolder.listFiles();
    	 if(fileArr!=null){
    		 for(File file : fileArr){
    			  if(file.isDirectory()){
    				  //����
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
