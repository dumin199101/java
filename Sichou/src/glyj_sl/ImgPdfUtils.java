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
 * @dateTime 2014-06-07 本工具对实现对IMG与PDF相互转换。 运行测试需要导入以下2个jar包 itext-2.0.2.jar
 *           PDFRenderer.jar
 * 
 */
@SuppressWarnings("unused")
public class ImgPdfUtils {
	public static void main(String[] args) throws Exception {
		// 1.从整个pdf中拆分成单个pdf
//		 pdfExtraction("D:\\Mytest\\Input\\2.pdf","D:\\Mytest\\Output\\ExtractPDF\\2");
		// 2.从单个pdf转成单个jpg
	    File srcPdfDir = new File("D:\\Mytest\\Output\\ExtractPDF\\2");
		File dest = new File("D:\\Mytest\\Output\\PDFToJPG\\2-2");
		scanPdfLists(srcPdfDir, dest);
//		pdfToJpg("D:\\Mytest\\Input\\喀什噶尔_2.pdf","D:\\Mytest\\Output\\PDFToJPG\\10.jpg",10);
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
	 *            源PDF文件路径
	 * @param target
	 *            保存PDF文件路径
	 * @throws Exception
	 */
	private static void pdfExtraction(String source, String target)
			throws Exception {
		// 0：判断目标目录是否存在：
		if (!new File(target).exists()) {
			new File(target).mkdirs();
		}
		// 1：创建PDF读取对象
		PdfReader pr = new PdfReader(source);
		int pages = pr.getNumberOfPages();
		System.out.println("this document " + pages + " page");
		for (int i = 1; i <= pages; i++) {
			// 2：将第page页转为提取，创建document对象
			Document doc = new Document(pr.getPageSize(i));
			// 3：通过PdfCopy转其单独存储
			PdfCopy copy = new PdfCopy(doc, new FileOutputStream(new File(
					target, i + ".pdf")));
			doc.open();
			doc.newPage();
			// 4：获取当前页，装载到document中。
			PdfImportedPage page = copy.getImportedPage(pr, i);
			copy.addPage(page);
			System.out.println(target + ":" + i + ".pdf" + ",Extracted");
			// 5：释放资源
			copy.close();
			doc.close();
		}
		pr.close();
	}

	/**
	 * @param source
	 *            源文件
	 * @param target
	 *            目标文件
	 * @param x
	 *            读取源文件中的第几页
	 */
	private static void pdfToJpg(String source, String target, int x)
			throws Exception {
		// 创建从中读取和向其中写入（可选）的随机访问文件流，R表示对其只是访问模式
		RandomAccessFile rea = new RandomAccessFile(new File(source), "r");

		// 将流读取到内存中，然后还映射一个PDF对象
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
		FileOutputStream out = new FileOutputStream(target); // 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag); // JPEG编码
		out.close();
	}

}