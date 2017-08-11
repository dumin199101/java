package glyj_paper;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * ��ȡͼ��Ļ�����Ϣ��
 *   1.ͼ����
 *   2.ͼƬ��
 *   3.ͼƬ�Ŀ�ȡ��߶�
 */
public class GetBaseInfo {
//   public static int index = 0;	
   public static int index = 71;	
   public static void main(String[] args) {
//	         File srcFolder = new File("J:\\�����ӹ�\\����ձ�");
	         File srcFolder = new File("J:\\�����ӹ�\\�»��ձ�");
	         getBaseInfo(srcFolder);
	         System.out.println(srcFolder.getName()+"������Ϣ��ȡ���");
   }

	private static void getBaseInfo(File srcFolder) {
		File[] fileList = srcFolder.listFiles();
		int fileCount = 0;
		int width = 0;
		int height = 0;
		
		for(File file : fileList){
			if(file.isDirectory()){
				//�ݹ������
				getBaseInfo(file);
			}else{
			    //�ļ���Ѱ��
				if(file.getName().equals("1.jpg")){
					//��ȡͼƬ��ߣ�
					BufferedImage bufferedImage = null;
					try {
						bufferedImage = ImageIO.read(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
					 width = bufferedImage.getWidth();   
					 height = bufferedImage.getHeight();
				}
//				System.out.println(file.getName());
			    fileCount++;
			}
		}
		
	    if(srcFolder.getName().length()==2){
	    	GetBaseInfo.index++;
//	    	int position = srcFolder.getAbsolutePath().lastIndexOf("����ձ�");
	    	int position = srcFolder.getAbsolutePath().lastIndexOf("�»��ձ�");
			String filename = srcFolder.getAbsolutePath().substring(position).replace('\\','-');
//			String result = GetBaseInfo.index + "\t"+filename.substring(5,9)+"\t"+"JF" + filename.substring(5,9)+filename.substring(10,12) +"\t"+  filename.substring(0,4)+filename.substring(5,9)+"��"+filename.substring(10,12)+"��" + "\t" + width + "\t" + height + "\t" + fileCount;
			String result = GetBaseInfo.index + "\t"+filename.substring(5,9)+"\t"+"XH" + filename.substring(5,9)+filename.substring(10,12) +"\t"+  filename.substring(0,4)+filename.substring(5,9)+"��"+filename.substring(10,12)+"��" + "\t" + width + "\t" + height + "\t" + fileCount;
			try {
				writeInfoLog("D:\\�»��ձ�����ձ�������Ϣ.txt",result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(result);
//			System.out.println("ͼ������"+filename.substring(0,4)+filename.substring(5,9)+"��"+filename.substring(10,12)+"��" );
//			System.out.println("ͼƬ�ĳߴ磺���Ϊ:"+width+",�߶ȣ�"+height);
			System.out.println(srcFolder.getName()+"��ȡ���");
	    }	
	}

	private static void writeInfoLog(String string, String result) throws IOException{
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string), true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	
}
