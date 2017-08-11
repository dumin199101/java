package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������о����ļ����е�ͼƬ��Դ��
 * @author Administrator
 *
 */
public class FindJpeg {
	public static void main(String[] args) {
        
		//��װԴĿ¼��
//		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book");
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Resource\\Lhh_Book");
		
		
		
		
		//��װĿ�ĵ�Ŀ¼��
		File destFolder = new File("H:\\Resource");
		
		//���Ŀ�ĵ�Ŀ¼��������ô�ʹ���
		if(!destFolder.exists()){
			
			destFolder.mkdirs();
			
		}
		
		//��ó���ʼ����ʱ�䣺
		long start_time = System.currentTimeMillis();
		
		
		//�����ļ���
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end_time = System.currentTimeMillis();
		
		long seconds = (end_time - start_time) / 1000;
		
		System.out.println("��Դ������ɣ���ʱ��" + seconds + "s");
		
	}

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		// TODO Auto-generated method stub
		if(srcFolder.isDirectory()){
			//������ļ��о͵ݹ�
			
			//1.��Ŀ�ĵش���һ��Ŀ���ļ��У�
			File destDir = new File(destFolder,srcFolder.getName());
			
			destDir.mkdir();
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				copyFolder(file, destDir);
				
			}
			
			
			
		}else{
			//������ļ������ļ����ƣ�
			
			File newFile = new File(destFolder,srcFolder.getName());
			
			copyFile(srcFolder,newFile);
			
			
			System.out.println(newFile.getAbsolutePath() +  "�ļ����Ƴɹ�");
			
			
			
			
		}
		
		
		
		
	}

	private static void copyFile(File srcFolder, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFolder));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		
		//�������ݣ�
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = bis.read(bys)) != -1){
			
			bos.write(bys, 0, len);
			
		}
		
		//�ͷ���Դ
		
		bos.close();
		bis.close();
		
		
		
		
		
	}
}

