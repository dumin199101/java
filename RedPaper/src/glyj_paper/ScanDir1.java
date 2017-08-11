package glyj_paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * 生成序列号：1941051701
 * 生成检索时间：19410517
 * 将数据写入一个临时文件中去
 * 批量改名（父级递归）
 * @author Administrator
 *
 */
public class ScanDir1 {
	public static void main(String[] args) {
//		File srcFolder = new File("J:\\报刊加工\\解放日报");  
		File srcFolder = new File("J:\\报刊加工\\新华日报");  
		scanDir(srcFolder);
		System.out.println("恭喜你，所有文件信息批量提取完毕了");
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
				//如果是文件夹,递归
				scanDir(f);
			}else{
				//如果是文件：
				index++;
				String fileName = f.getName();
				if(fileName.endsWith(".jpg")){
					 if(fileName.length()==7){
						 fileName = yearName+monthName+"0"+fileName.substring(0,3).replace('-', '0');
					 }else if(fileName.length()==8){
						 if(fileName.substring(0,2).contains("-")){
							 //证明是1-10.jpg
							 fileName = yearName+monthName+"0"+fileName.substring(0,4).replace("-", "");
						 }else{
							 //证明是10-1.jpg
							 fileName = yearName+monthName+fileName.substring(0,4).replace('-', '0');
						 }
					 }else if(fileName.length()==9){
						 fileName = yearName+monthName+fileName.substring(0,5).replace("-","");
					 }
				}
//				String result = f.getName()+"\t"+"JF"+fileName+"\t";
//				String result2 = "JF"+fileName.substring(0,10)+"\t"+"JF"+fileName.substring(0,6)+"\t"+index+"\t"+"解放日报"+"\t"+fileName.substring(0,4)+"-"+fileName.substring(4,6)+"-"+fileName.substring(6,8)+"\t"+"1-"+(fileName.substring(8).startsWith("0")?fileName.substring(8,10).replace("0",""):fileName.substring(8,10))+"\t"+fileName.substring(0,4)+"年"+fileName.substring(4,6)+"月";
//				String result = f.getName()+"\t"+"XH"+fileName+"\t";
				String result2 = "XH"+fileName.substring(0,10)+"\t"+"XH"+fileName.substring(0,6)+"\t"+index+"\t"+"新华日报"+"\t"+fileName.substring(0,4)+"-"+fileName.substring(4,6)+"-"+fileName.substring(6,8)+"\t"+"1-"+(fileName.substring(8).startsWith("0")?fileName.substring(8,10).replace("0",""):fileName.substring(8,10))+"\t"+fileName.substring(0,4)+"年"+fileName.substring(4,6)+"月";
//				System.out.println("+++++++++"+result2);
				//将打印结果写入Log日志
				try {
//					writeDataLog("D:\\解放日报-新华日报信息采集Log.txt",result);
					writeDataLog("D:\\解放日报-新华日报信息采集Log-2Log.txt", result2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//进行改名操作：1-1.jpg 1941010101.jpg
//				renameName1(f,fileName);
				//进行改名操作2 1941010101.jpg 1.jpg
				renameName2(new File(new File(f.getParent()),fileName),index);
				
			}
		}
		System.out.println(srcFolder.getName()+"文件提取完毕");
	}
	
	
	
	private static void renameName1(File f, String fileName) {
		// TODO Auto-generated method stub
		if(!f.renameTo(new File(f.getParent(),fileName+".jpg"))){
			System.out.println(f.getName()+"文件重命名失败");
		}
	}

	private static void renameName2(File f, int index) {
		// TODO Auto-generated method stub
//		System.out.println(f.getName()+".jpg");
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
