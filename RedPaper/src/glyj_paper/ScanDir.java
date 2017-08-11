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
 * 统计每个图片文件夹中文件的个数
 * 统计图片文件的宽度跟高度
 * 生成序列号：1941051701
 * 生成检索时间：19410517
 * 将数据写入一个临时文件中去
 * 批量改名（父级递归）
 * 这个有个问题：处理1-10.jpg这种的就跑到2-9.jpg的后边去了
 * @author Administrator
 *
 */
public class ScanDir {
	public static void main(String[] args) {
        File srcFolder = new File("D:\\新华日报");  
		scanDir(srcFolder);
		System.out.println("恭喜你，所有文件信息批量提取完毕了");
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
				//如果是文件夹,递归
				scanDir(f);
			}else{
//				if(f.getName().equals("1-1.jpg")){
//					//获取图片宽高：
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
				
				
				
				
				//如果是文件：
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
			//将打印结果写入Log日志
//			try {
//				writeDataLog("D:\\writeDemoLog.txt",result);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//进行改名操作：
//			renameName(f,index);
		}
		//输出文件个数
//		System.out.println("父级文件夹："+srcFolder.getName()+"下有"+fileCount+"个文件");
		//输出图片大小：
//		System.out.println("图片的大小："+width+":"+height);
		System.out.println(srcFolder.getName()+"文件提取完毕");
	}

	private static void renameName(File f, int index) {
		// TODO Auto-generated method stub
		if(!f.renameTo(new File(f.getParent(),index+".jpg"))){
			System.out.println(f.getName()+"文件重命名失败");
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
