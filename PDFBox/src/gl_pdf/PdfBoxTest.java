package gl_pdf;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfBoxTest {

    /**
     * 从PDF文件中提取文本
     * @throws FileNotFoundException
     * @throws IOException
     */
	private static void getTextFromPDF() throws FileNotFoundException,
			IOException {
		FileInputStream   fis   =   new   FileInputStream("D:\\Mytest\\Input\\传奇大将陈赓.pdf"); 
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Mytest\\Output\\PDFToTxt\\pdf_change.txt"));
		PDFParser   p   =   new   PDFParser((RandomAccessRead) fis); 
		p.parse();         
		PDFTextStripper   ts   =   new   PDFTextStripper();         
		String   s   =   ts.getText(p.getPDDocument()); 
		writer.write(s);
		System.out.println(s); 
		fis.close(); 
		writer.close();
	}
	
	
	private static void getImageFromPDF() throws IOException{
		//第1步：加載現有PDF文件
		File file = new File("D:\\Mytest\\Output\\ExtractPDF\\2\\13.pdf"); 
		PDDocument document = PDDocument.load(file) ;
		//第二步：實例化PDFRenderer類
		PDFRenderer renderer = new PDFRenderer(document);
		//步驟3：從PDF文件繪製圖像
		BufferedImage image = renderer.renderImage(0) ;
		//第4步：編寫圖像到文件
		ImageIO.write(image, "JPEG" , new File("D:\\Mytest\\Output\\PDFToJPG\\13.jpg") );
		//步驟5：關閉文檔
		document.close();
	}
	
	
	public   static   void   main(String[]   args)   throws   Exception{ 
		      getImageFromPDF();
         
    }

}