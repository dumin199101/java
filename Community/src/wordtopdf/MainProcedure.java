package wordtopdf;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

/**
 * 主程序： 1.拆分word文档为word文件 WordExtractUtils 2.格式化doc文档 WordTemplateUtils
 * 3.转化doc文档为docx文档 DoctoDocxUtils 4.转化docx文档为pdf文档DoxxtoPDFUtils
 * 
 * @author dd
 * @time 2017-08-10
 *
 */
public class MainProcedure {
	public static void main(String[] args) {
		/*
		 * File srcFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Doc");
		 * deleteFolder(srcFolder);
		 */

		// 1.拆分word文档为word文件 WordExtractUtils

		// File srcFile = new
		// File("E:\\lieyan\\公司相关\\党史\\生产\\Source\\毛文稿第一册（1949－1950）.doc");
		// File destFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Doc");
		// WordExtractUtils.extractWord2003(srcFile, destFolder);

		// 2.转化doc文档为pdf文档 WordToPDFUtils(失败)
		/*
		 * File srcFolder = new
		 * File("E:\\lieyan\\公司相关\\党史\\生产\\Docs\\Output Files"); File destFolder
		 * = new File("E:\\lieyan\\公司相关\\党史\\生产\\Pdf"); File[] fileArr =
		 * srcFolder.listFiles(); for(File file : fileArr){ try {
		 * WordtoPDFUtils.doc2pdf(srcFolder.getAbsolutePath()+
		 * "\\"+file.getName(),destFolder.getAbsolutePath()+"\\
		 * "+file.getName().replaceAll(".doc", ".pdf"));
		 * System.out.println(file.getName()+"Success"); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */

		// 2.转换doc文件到docx文件
//		File srcFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Doc\\建国以来毛泽东文稿（1）");
//		File destFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Docx");
//		File newFolder = new File(destFolder, srcFolder.getName());
//		if(!newFolder.exists())
//			newFolder.mkdirs();
//		File[] fileArr = srcFolder.listFiles();
//		for (File file : fileArr) {
//			try {
//				DoctoDocxUtils.doc2docx(new File(srcFolder, file.getName()).getAbsolutePath(),
//						new File(newFolder, file.getName().replaceAll(".doc", ".docx")).getAbsolutePath());
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		// 3.转换docx到pdf
		/*
		 * try { DocxtoPDFUtils.createPDF(
		 * "E:\\lieyan\\公司相关\\党史\\生产\\Docx\\007中华人民共和国中央人民政府公告.docx",
		 * "E:\\lieyan\\公司相关\\党史\\生产\\Pdf\\007中华人民共和国中央人民政府公告.pdf"); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (XmlException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (OpenXML4JException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		
		File srcFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Docx\\建国以来毛泽东文稿（1）");
		File destFolder = new File("E:\\lieyan\\公司相关\\党史\\生产\\Pdf");
		File newFolder = new File(destFolder, srcFolder.getName());
		if(!newFolder.exists())
			newFolder.mkdirs();
		File[] fileArr = srcFolder.listFiles();
		for (File file : fileArr) {
			try {
				DocxtoPDFUtils.createPDF(new File(srcFolder, file.getName()).getAbsolutePath(),
						new File(newFolder, file.getName().replaceAll(".docx", ".pdf")).getAbsolutePath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/* 递归删除文件夹 */
	private static void deleteFolder(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		for (File file : fileArr) {
			if (file.isDirectory()) {
				deleteFolder(file);
			} else {
				file.delete();
			}
		}
		srcFolder.delete();
	}
}
