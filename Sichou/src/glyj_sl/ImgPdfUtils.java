package glyj_sl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import glyj_pdfbox.PDFBoxUtils;
/**
 * 
 * @author lieyan
 * @dateTime 2014-06-07 �����߶�ʵ�ֶ�IMG��PDF�໥ת���� ���в�����Ҫ��������2��jar�� itext-2.0.2.jar
 *           PDFRenderer.jar
 * 
 */
@SuppressWarnings("unused")
public class ImgPdfUtils {
	public static void main(String[] args) throws Exception {
		//����Ŀ¼���pdf�ļ���
//		File srcDir = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\�ɱ�PDF\\�Ŵ���(241)");
//		scanPdfExtraction(srcDir);
		// 1.������pdf�в�ֳɵ���pdf
//		 pdfExtraction("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\�ɱ�PDF\\�Ŵ���(241)\\003�½�����ͼ־1.pdf","J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\���ÿ��PDF\\003�½�����ͼ־1");
		// 2.�ӵ���pdfת�ɵ���jpg
//	    File srcPdfDir = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\���ÿ��PDF");
//		File dest = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\Resource_Img");
//		scanPdfLists(srcPdfDir, dest);
		//3.�ӵ���PDF����ȡ�ı���
//		PDFBoxUtils.getTextFromPDF("D:\\001ADAEB-FA7C-4D40-AD01-D0FBD3313A76.pdf");
		PDFBoxUtils.extractImageFromPDF("D:\\��Դ����\\Input\\015�ն���������ͼ־5.pdf","D:\\��Դ����\\Output");
		
	}

	private static void scanPdfExtraction(File srcDir) throws Exception {
		// TODO Auto-generated method stub
		File[] fileArr = srcDir.listFiles();
		if(fileArr!=null){
              for(File file : fileArr){
            	  if(file.getName().endsWith(".pdf")&&file.isFile()){
            			 pdfExtraction(srcDir.getAbsolutePath()+"\\"+file.getName(),"J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\���ÿ��PDF\\"+file.getName().replaceAll(".pdf",""));
            			 System.out.println(file.getName()+"�ļ�������");
            	  }
              }
		}
	}

	private static void scanPdfLists(File srcPdfDir, File dest) {
		if (!dest.exists())
			dest.mkdirs();
		// TODO Auto-generated method stub
		File[] fileArr = srcPdfDir.listFiles();
		if(fileArr!=null){
			for (File file : fileArr) {
				if(file.isDirectory()){
				      scanPdfLists(file, new File(dest,file.getName()));	
				}else{
					try {
						PDFBoxUtils.getImageFromPDF(srcPdfDir.getAbsolutePath() + "\\" + file.getName(), dest.getAbsolutePath() + "\\"
									+ file.getName().replaceAll("pdf", "jpg"));
						System.out.println(srcPdfDir.getAbsolutePath() + "\\" +file.getName()+"transfered success");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @param source
	 *            ԴPDF�ļ�·��
	 * @param target
	 *            ����PDF�ļ�·��
	 * @throws Exception
	 */
	private static void pdfExtraction(String source, String target)
			throws Exception {
		// 0���ж�Ŀ��Ŀ¼�Ƿ���ڣ�
		if (!new File(target).exists()) {
			new File(target).mkdirs();
		}
		// 1������PDF��ȡ����
		PdfReader pr = new PdfReader(source);
		int pages = pr.getNumberOfPages();
		System.out.println("this document " + pages + " page");
		for (int i = 1; i <= pages; i++) {
			// 2������pageҳתΪ��ȡ������document����
			Document doc = new Document(pr.getPageSize(i));
			// 3��ͨ��PdfCopyת�䵥���洢
			PdfCopy copy = new PdfCopy(doc, new FileOutputStream(new File(
					target, i + ".pdf")));
			doc.open();
			doc.newPage();
			// 4����ȡ��ǰҳ��װ�ص�document�С�
			PdfImportedPage page = copy.getImportedPage(pr, i);
			copy.addPage(page);
			System.out.println(target + ":" + i + ".pdf" + ",Extracted");
			// 5���ͷ���Դ
			copy.close();
			doc.close();
		}
		pr.close();
	}

	

}