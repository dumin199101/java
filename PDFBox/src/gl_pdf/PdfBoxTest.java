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
     * ��PDF�ļ�����ȡ�ı�
     * @throws FileNotFoundException
     * @throws IOException
     */
	private static void getTextFromPDF() throws FileNotFoundException,
			IOException {
		FileInputStream   fis   =   new   FileInputStream("D:\\Mytest\\Input\\����󽫳���.pdf"); 
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
		//��1�������d�F��PDF�ļ�
		File file = new File("D:\\Mytest\\Output\\ExtractPDF\\2\\13.pdf"); 
		PDDocument document = PDDocument.load(file) ;
		//�ڶ�����������PDFRenderer�
		PDFRenderer renderer = new PDFRenderer(document);
		//���E3����PDF�ļ��L�u�D��
		BufferedImage image = renderer.renderImage(0) ;
		//��4���������D���ļ�
		ImageIO.write(image, "JPEG" , new File("D:\\Mytest\\Output\\PDFToJPG\\13.jpg") );
		//���E5���P�]�ęn
		document.close();
	}
	
	
	public   static   void   main(String[]   args)   throws   Exception{ 
		      getImageFromPDF();
         
    }

}