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

/*
 * ��ȡͼ��Ļ�����Ϣ��
 *   1.ͼ����
 *   2.ͼƬ��
 *   3.ͼƬ�Ŀ�ȡ��߶�
 */
public class GetBaseInfo2 {
	public static int index = 180;

	public static void main(String[] args) {
		File srcFolder = new File("J:\\�����ӹ�\\��·��������־");
		getBaseInfo(srcFolder);
		System.out.println(srcFolder.getName() + "������Ϣ��ȡ���");
	}

	private static void getBaseInfo(File srcFolder) {
		File[] fileList = srcFolder.listFiles();
		int fileCount = 0;
		int width = 0;
		int height = 0;
		
		for (File file : fileList) {
			if (file.isDirectory()) {
				// �ݹ������
				getBaseInfo(file);
			} else {
				// �ļ���Ѱ��
				if (file.getName().equals("1.jpg")) {
					// ��ȡͼƬ��ߣ�
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
				fileCount++;
			}
		}
		

		if (srcFolder.getName().length() > 4 && !srcFolder.getName().equals("��·��������־")) {
				GetBaseInfo2.index++;
				int position = srcFolder.getAbsolutePath().lastIndexOf("��·��������־");
				int endposition = srcFolder.getAbsolutePath().lastIndexOf("��");
				String filename = srcFolder.getAbsolutePath().substring(position,endposition+1).replace("\\","");
				String dateInfo = srcFolder.getAbsolutePath().substring(endposition+1).replace("\\","");
				String date[] = dateInfo.split("\\.");
				String year = date[0];
				String month = date[1];
				String day = date[2];
				
				if(month.length()<2){
					month = "0"+month;
				}
				
				if(day.length()<2){
					day = "0" + day;
				}
				
				String publish_time = year +"-" + month + "-" +day;
				
				String hash = "BL" +  filename.substring(8,10) + filename.substring(12,14);
				
				String result = GetBaseInfo2.index+"\t"+year+"\t"+hash+"\t"+filename+"\t"+"\t"+width+"\t"+height+"\t"+fileCount+"\t"+publish_time;
				
				 try {
				 writeInfoLog("D:\\��·������������Ϣ.txt",result);
				 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }
//				System.out.println(GetBaseInfo2.index+"\t"+year+"\t"+hash+"\t"+filename+"\t"+"\t"+width+"\t"+height+"\t"+fileCount+"\t"+publish_time);
				System.out.println(srcFolder.getName() + "��ȡ���");
		}
	}

	private static void writeInfoLog(String string, String result)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string),
				true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
