package glyj_paper;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;



/**
 * 
 * ͳ��ÿ��ͼƬ�ļ������ļ��ĸ���
 * ͳ��ͼƬ�ļ��Ŀ�ȸ��߶�
 * �������кţ�1941051701
 * ���ɼ���ʱ�䣺19410517
 * ������д��һ����ʱ�ļ���ȥ
 * ���������������ݹ飩
 * ����и����⣺����1-10.jpg���ֵľ��ܵ�2-9.jpg�ĺ��ȥ��
 * @author Administrator
 *
 */
public class ScanDir {
	public static void main(String[] args) {
        File srcFolder = new File("D:\\�»��ձ�");  
		scanDir(srcFolder);
		System.out.println("��ϲ�㣬�����ļ���Ϣ������ȡ�����");
	}

	private static void scanDir(File srcFolder) {
		int fileCount = 0;
		int width =0,height=0;
		String monthName = srcFolder.getName();
		int  position = srcFolder.getParent().lastIndexOf("\\");
		String yearName = srcFolder.getParent().substring(position+1);
		File[] fileArr = srcFolder.listFiles();
		if(fileArr==null){
			return;
		}
		List<File> fileList = new ArrayList<File>();
		for(File f : fileArr){
			if(f.isDirectory()){
				//������ļ���,�ݹ�
				scanDir(f);
			}else{
//				if(f.getName().equals("1-1.jpg")){
//					//��ȡͼƬ��ߣ�
//					BufferedImage bufferedImage = null;
//					try {
//						bufferedImage = ImageIO.read(f);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}   
//					 width = bufferedImage.getWidth();   
//					 height = bufferedImage.getHeight();
//				}
				
				
				
				
				//������ļ���
				fileList.add(f);
				
				Collections.sort(fileList,new Comparator<File>() {
					@Override
					public int compare(File o1, File o2) {
						// TODO Auto-generated method stub
//						int result = o1.getName().compareToIgnoreCase(o2.getName());
//						int result1 = result == 0 ? o1.getName().length() - o2.getName().length() : result;
//						return result1;
						return o1.getName().length() - o2.getName().length();
					}
				});				
				fileCount++;
			}
		}
		
		int index = 0;
		
		for(File f : fileList){
			index++;
			String fileName = f.getName();
			if(fileName.endsWith(".jpg")){
				 if(fileName.length()==7){
					 fileName = yearName+monthName+"0"+fileName.substring(0,3).replace('-', '0');
				 }else if(fileName.length()==8){
					 fileName = yearName+monthName+fileName.substring(0,4).replace('-', '0');
				 }else if(fileName.length()==9){
					 fileName = yearName+monthName+fileName.substring(0,5).replace("-","");
				 }
			}
			String result = f.getName()+"\t"+fileName+"\t"+fileName.substring(0,8)+"\t"+index;
			System.out.println("+++++++++"+result);
			//����ӡ���д��Log��־
//			try {
//				writeDataLog("D:\\writeDemoLog.txt",result);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//���и���������
//			renameName(f,index);
		}
		//����ļ�����
//		System.out.println("�����ļ��У�"+srcFolder.getName()+"����"+fileCount+"���ļ�");
		//���ͼƬ��С��
//		System.out.println("ͼƬ�Ĵ�С��"+width+":"+height);
		System.out.println(srcFolder.getName()+"�ļ���ȡ���");
	}

	private static void renameName(File f, int index) {
		// TODO Auto-generated method stub
		if(!f.renameTo(new File(f.getParent(),index+".jpg"))){
			System.out.println(f.getName()+"�ļ�������ʧ��");
		}
	}

	private static void writeDataLog(String string, String result) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string), true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	
	

}
