package wordtopdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * 转换docx文档到pdf
 * @author dd
 *
 */
public class DocxtoPDFUtils {
   public static void createPDF(String srcFile,String destFile) throws IOException, XmlException, OpenXML4JException{
	   Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(destFile));
			document.open();

			//读取word2007文本
			OPCPackage opcPackage = POIXMLDocument.openPackage(srcFile);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String content = extractor.getText();
			
			//设置字体：
			BaseFont bfChinese  = null;
			Font font = null;
			
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
			
			//声明段落：
			Paragraph p = null;
			
			//做段落拆分：
			String[] contents = content.split("\n");
			for (int i = 0; i < contents.length; i++) {
				// 创建段落
				if (i == 0 || (i == 1 && contents[i].startsWith("（"))) {
					if (i == 0) {
						font = new Font(bfChinese, 20, Font.BOLD, BaseColor.BLACK);
					} else {
						font = new Font(bfChinese, 12, Font.NORMAL, BaseColor.BLACK);
					}
					p = new Paragraph(contents[i], font);
					p.setAlignment(Element.ALIGN_CENTER);

				} else {
					font = new Font(bfChinese, 12, Font.NORMAL, BaseColor.BLACK);
					p = new Paragraph(contents[i], font);
					p.setAlignment(Element.ALIGN_LEFT);
				}
				
				
				document.add(p);

			}

			document.close();
			writer.close();
			System.out.println(srcFile+"Create Successfully");
		} catch (

		DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
   }
}
