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
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

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
		// 1.������pdf�в�ֳɵ���pdf
//		 pdfExtraction("D:\\Mytest\\Input\\2.pdf","D:\\Mytest\\Output\\ExtractPDF\\2");
		// 2.�ӵ���pdfת�ɵ���jpg
	    File srcPdfDir = new File("D:\\Mytest\\Output\\ExtractPDF\\2");
		File dest = new File("D:\\Mytest\\Output\\PDFToJPG\\2-2");
		scanPdfLists(srcPdfDir, dest);
//		pdfToJpg("D:\\Mytest\\Input\\��ʲ����_2.pdf","D:\\Mytest\\Output\\PDFToJPG\\10.jpg",10);
//		System.out.println("over");
	}

	private static void scanPdfLists(File srcPdfDir, File dest) {
		if (!dest.exists())
			dest.mkdirs();
		// TODO Auto-generated method stub
		File[] fileArr = srcPdfDir.listFiles();
		for (File file : fileArr) {
			try {
				pdfToJpg(srcPdfDir.getAbsolutePath() + "\\" + file.getName(),
						dest.getAbsolutePath() + "\\"
								+ file.getName().replaceAll("pdf", "jpg"), 1);
				System.out.println(file.getName()+"transfered success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	/**
	 * @param source
	 *            Դ�ļ�
	 * @param target
	 *            Ŀ���ļ�
	 * @param x
	 *            ��ȡԴ�ļ��еĵڼ�ҳ
	 */
	private static void pdfToJpg(String source, String target, int x)
			throws Exception {
		// �������ж�ȡ��������д�루��ѡ������������ļ�����R��ʾ����ֻ�Ƿ���ģʽ
		RandomAccessFile rea = new RandomAccessFile(new File(source), "r");

		// ������ȡ���ڴ��У�Ȼ��ӳ��һ��PDF����
		FileChannel channel = rea.getChannel();
		ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,
				channel.size());
		PDFFile pdfFile = new PDFFile(buf);
		PDFPage page = pdfFile.getPage(x);

		// get the width and height for the doc at the default zoom
		java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, (int) page
				.getBBox().getWidth(), (int) page.getBBox().getHeight());

		// generate the image
		java.awt.Image img = page.getImage(rect.width, rect.height, // width &
				rect, // clip rect
				null, // null for the ImageObserver
				true, // fill background with white
				true // block until drawing is done
				);

		BufferedImage tag = new BufferedImage(rect.width, rect.height,
				BufferedImage.TYPE_INT_RGB);

		tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);
		FileOutputStream out = new FileOutputStream(target); // ������ļ���
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag); // JPEG����
		out.close();
	}

}