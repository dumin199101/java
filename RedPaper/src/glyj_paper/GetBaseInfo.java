package glyj_paper;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 提取图书的基本信息：
 *   1.图书名
 *   2.图片数
 *   3.图片的宽度、高度
 */
public class GetBaseInfo {
//   public static int index = 0;	
   public static int index = 71;	
   public static void main(String[] args) {
//	         File srcFolder = new File("J:\\报刊加工\\解放日报");
	         File srcFolder = new File("J:\\报刊加工\\新华日报");
	         getBaseInfo(srcFolder);
	         System.out.println(srcFolder.getName()+"基本信息提取完毕");
   }

	private static void getBaseInfo(File srcFolder) {
		File[] fileList = srcFolder.listFiles();
		int fileCount = 0;
		int width = 0;
		int height = 0;
		
		for(File file : fileList){
			if(file.isDirectory()){
				//递归遍历：
				getBaseInfo(file);
			}else{
			    //文件搜寻：
				if(file.getName().equals("1.jpg")){
					//获取图片宽高：
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
//	    	int position = srcFolder.getAbsolutePath().lastIndexOf("解放日报");
	    	int position = srcFolder.getAbsolutePath().lastIndexOf("新华日报");
			String filename = srcFolder.getAbsolutePath().substring(position).replace('\\','-');
//			String result = GetBaseInfo.index + "\t"+filename.substring(5,9)+"\t"+"JF" + filename.substring(5,9)+filename.substring(10,12) +"\t"+  filename.substring(0,4)+filename.substring(5,9)+"年"+filename.substring(10,12)+"月" + "\t" + width + "\t" + height + "\t" + fileCount;
			String result = GetBaseInfo.index + "\t"+filename.substring(5,9)+"\t"+"XH" + filename.substring(5,9)+filename.substring(10,12) +"\t"+  filename.substring(0,4)+filename.substring(5,9)+"年"+filename.substring(10,12)+"月" + "\t" + width + "\t" + height + "\t" + fileCount;
			try {
				writeInfoLog("D:\\新华日报解放日报基本信息.txt",result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(result);
//			System.out.println("图书名："+filename.substring(0,4)+filename.substring(5,9)+"年"+filename.substring(10,12)+"月" );
//			System.out.println("图片的尺寸：宽度为:"+width+",高度："+height);
			System.out.println(srcFolder.getName()+"提取完毕");
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
