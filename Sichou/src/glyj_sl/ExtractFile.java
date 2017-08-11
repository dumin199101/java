package glyj_sl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����ļ�
 * @author Administrator
 *
 */
public class ExtractFile {
	 public static int index = 0;
     public static void main(String[] args) {
    	 String parentDir = "J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ԭʼ����\\˿��֮·����ʷ�����׼�Ҫ\\˿��֮·����Ŵ����ײ���260�֣�_PDF\\һ��252-260";
    	 File srcFolder = new File(parentDir);	
	     try {
			scanDir(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	 }

	private static void scanDir(File srcFolder) throws IOException {
		File destFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\�ɱ�PDF\\�Ŵ���(241)");
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
	     if(fileArr!=null){
	    	 for(File file : fileArr){
	    		 if(file.isDirectory()){
	    			 scanDir(file);
	    		 }else{
	    			 if(!file.getName().endsWith("����.pdf"))
	    				 continue;
	    			 ExtractFile.index++;
//	    			 System.out.println(ExtractFile.index+":"+file.getAbsolutePath());
	    			 String parent = file.getParent();
	    			 int pos = parent.lastIndexOf("\\");
	    			 //����PDF��ָ��Ŀ¼
	    			 File srcFile = new File(srcFolder,file.getName());
	    			 File destFile = new File(destFolder,parent.substring(pos+1)+".pdf");
	    			 copyFile(srcFile,destFile);
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
}
