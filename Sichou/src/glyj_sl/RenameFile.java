package glyj_sl;

import java.io.File;

/**
 * ������
 * @author Administrator
 *
 */
public class RenameFile {
     public static void main(String[] args) {
    	 String parentDir = "J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ԭʼ����\\˿��֮·����ʷ�����׼�Ҫ\\˿��֮·����Ŵ����ײ���260�֣�_PDF\\һ��252-260\\110-155ƽ���¸��½��ط˷���1-46";
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
	    			 File destFile = new File(srcFolder,"����.pdf");
	    			 if(srcFile.renameTo(destFile)){
	    				 System.out.println(srcFile.getName()+"�������ɹ�");
	    			 }else{
	    				 System.out.println(srcFile.getName()+"������ʧ��");
	    			 }
	    		 }
	    	 }
	     }
	}
}
