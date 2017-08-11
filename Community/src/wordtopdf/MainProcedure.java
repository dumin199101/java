package wordtopdf;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

/**
 * ������ 1.���word�ĵ�Ϊword�ļ� WordExtractUtils 2.��ʽ��doc�ĵ� WordTemplateUtils
 * 3.ת��doc�ĵ�Ϊdocx�ĵ� DoctoDocxUtils 4.ת��docx�ĵ�Ϊpdf�ĵ�DoxxtoPDFUtils
 * 
 * @author dd
 * @time 2017-08-10
 *
 */
public class MainProcedure {
	public static void main(String[] args) {
		/*
		 * File srcFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Doc");
		 * deleteFolder(srcFolder);
		 */

		// 1.���word�ĵ�Ϊword�ļ� WordExtractUtils

		// File srcFile = new
		// File("E:\\lieyan\\��˾���\\��ʷ\\����\\Source\\ë�ĸ��һ�ᣨ1949��1950��.doc");
		// File destFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Doc");
		// WordExtractUtils.extractWord2003(srcFile, destFolder);

		// 2.ת��doc�ĵ�Ϊpdf�ĵ� WordToPDFUtils(ʧ��)
		/*
		 * File srcFolder = new
		 * File("E:\\lieyan\\��˾���\\��ʷ\\����\\Docs\\Output Files"); File destFolder
		 * = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Pdf"); File[] fileArr =
		 * srcFolder.listFiles(); for(File file : fileArr){ try {
		 * WordtoPDFUtils.doc2pdf(srcFolder.getAbsolutePath()+
		 * "\\"+file.getName(),destFolder.getAbsolutePath()+"\\
		 * "+file.getName().replaceAll(".doc", ".pdf"));
		 * System.out.println(file.getName()+"Success"); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */

		// 2.ת��doc�ļ���docx�ļ�
//		File srcFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Doc\\��������ë���ĸ壨1��");
//		File destFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Docx");
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

		// 3.ת��docx��pdf
		/*
		 * try { DocxtoPDFUtils.createPDF(
		 * "E:\\lieyan\\��˾���\\��ʷ\\����\\Docx\\007�л����񹲺͹�����������������.docx",
		 * "E:\\lieyan\\��˾���\\��ʷ\\����\\Pdf\\007�л����񹲺͹�����������������.pdf"); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (XmlException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (OpenXML4JException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		
		File srcFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Docx\\��������ë���ĸ壨1��");
		File destFolder = new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Pdf");
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

	/* �ݹ�ɾ���ļ��� */
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