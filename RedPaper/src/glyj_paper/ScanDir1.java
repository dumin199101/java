package glyj_paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * �������кţ�1941051701
 * ���ɼ���ʱ�䣺19410517
 * ������д��һ����ʱ�ļ���ȥ
 * ���������������ݹ飩
 * @author Administrator
 *
 */
public class ScanDir1 {
	public static void main(String[] args) {
//		File srcFolder = new File("J:\\�����ӹ�\\����ձ�");  
		File srcFolder = new File("J:\\�����ӹ�\\�»��ձ�");  
		scanDir(srcFolder);
		System.out.println("��ϲ�㣬�����ļ���Ϣ������ȡ�����");
	}

	private static void scanDir(File srcFolder) {
		String monthName = srcFolder.getName();
		int index = 0;
		int  position = srcFolder.getParent().lastIndexOf("\\");
		String yearName = srcFolder.getParent().substring(position+1);
		File[] fileArr = srcFolder.listFiles();
		if(fileArr==null){
			return;
		}
		for(File f : fileArr){
			if(f.isDirectory()){
				//������ļ���,�ݹ�
				scanDir(f);
			}else{
				//������ļ���
				index++;
				String fileName = f.getName();
				if(fileName.endsWith(".jpg")){
					 if(fileName.length()==7){
						 fileName = yearName+monthName+"0"+fileName.substring(0,3).replace('-', '0');
					 }else if(fileName.length()==8){
						 if(fileName.substring(0,2).contains("-")){
							 //֤����1-10.jpg
							 fileName = yearName+monthName+"0"+fileName.substring(0,4).replace("-", "");
						 }else{
							 //֤����10-1.jpg
							 fileName = yearName+monthName+fileName.substring(0,4).replace('-', '0');
						 }
					 }else if(fileName.length()==9){
						 fileName = yearName+monthName+fileName.substring(0,5).replace("-","");
					 }
				}
//				String result = f.getName()+"\t"+"JF"+fileName+"\t";
//				String result2 = "JF"+fileName.substring(0,10)+"\t"+"JF"+fileName.substring(0,6)+"\t"+index+"\t"+"����ձ�"+"\t"+fileName.substring(0,4)+"-"+fileName.substring(4,6)+"-"+fileName.substring(6,8)+"\t"+"1-"+(fileName.substring(8).startsWith("0")?fileName.substring(8,10).replace("0",""):fileName.substring(8,10))+"\t"+fileName.substring(0,4)+"��"+fileName.substring(4,6)+"��";
//				String result = f.getName()+"\t"+"XH"+fileName+"\t";
				String result2 = "XH"+fileName.substring(0,10)+"\t"+"XH"+fileName.substring(0,6)+"\t"+index+"\t"+"�»��ձ�"+"\t"+fileName.substring(0,4)+"-"+fileName.substring(4,6)+"-"+fileName.substring(6,8)+"\t"+"1-"+(fileName.substring(8).startsWith("0")?fileName.substring(8,10).replace("0",""):fileName.substring(8,10))+"\t"+fileName.substring(0,4)+"��"+fileName.substring(4,6)+"��";
//				System.out.println("+++++++++"+result2);
				//����ӡ���д��Log��־
				try {
//					writeDataLog("D:\\����ձ�-�»��ձ���Ϣ�ɼ�Log.txt",result);
					writeDataLog("D:\\����ձ�-�»��ձ���Ϣ�ɼ�Log-2Log.txt", result2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//���и���������1-1.jpg 1941010101.jpg
//				renameName1(f,fileName);
				//���и�������2 1941010101.jpg 1.jpg
				renameName2(new File(new File(f.getParent()),fileName),index);
				
			}
		}
		System.out.println(srcFolder.getName()+"�ļ���ȡ���");
	}
	
	
	
	private static void renameName1(File f, String fileName) {
		// TODO Auto-generated method stub
		if(!f.renameTo(new File(f.getParent(),fileName+".jpg"))){
			System.out.println(f.getName()+"�ļ�������ʧ��");
		}
	}

	private static void renameName2(File f, int index) {
		// TODO Auto-generated method stub
//		System.out.println(f.getName()+".jpg");
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
