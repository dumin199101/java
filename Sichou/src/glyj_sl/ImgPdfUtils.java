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
 * @dateTime 2014-06-07 本工具对实现对IMG与PDF相互转换。 运行测试需要导入以下2个jar包 itext-2.0.2.jar
 *           PDFRenderer.jar
 * 
 */
@SuppressWarnings("unused")
public class ImgPdfUtils {
	public static void main(String[] args) throws Exception {
		//遍历目录拆分pdf文件：
//		File srcDir = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\成本PDF\\古代卷(241)");
//		scanPdfExtraction(srcDir);
		// 1.从整个pdf中拆分成单个pdf
//		 pdfExtraction("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\成本PDF\\古代卷(241)\\003新疆国界图志1.pdf","J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\拆分每本PDF\\003新疆国界图志1");
		// 2.从单个pdf转成单个jpg
//	    File srcPdfDir = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\拆分每本PDF");
//		File dest = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\Resource_Img");
//		scanPdfLists(srcPdfDir, dest);
		//3.从单个PDF中提取文本：
//		PDFBoxUtils.getTextFromPDF("D:\\001ADAEB-FA7C-4D40-AD01-D0FBD3313A76.pdf");
		PDFBoxUtils.extractImageFromPDF("D:\\资源处理\\Input\\015钦定皇舆西域图志5.pdf","D:\\资源处理\\Output");
		
	}

	private static void scanPdfExtraction(File srcDir) throws Exception {
		// TODO Auto-generated method stub
		File[] fileArr = srcDir.listFiles();
		if(fileArr!=null){
              for(File file : fileArr){
            	  if(file.getName().endsWith(".pdf")&&file.isFile()){
            			 pdfExtraction(srcDir.getAbsolutePath()+"\\"+file.getName(),"J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\拆分每本PDF\\"+file.getName().replaceAll(".pdf",""));
            			 System.out.println(file.getName()+"文件拆分完毕");
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

	

}