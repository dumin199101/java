package deal_word_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.hwpf.usermodel.Section;


/**
 * 创建word文档
 * 
 * @author dd
 *
 */
public class CreateWordDocument {
	public static void main(String[] args) throws IOException {
		// createBlankWordDocument();
//		 writeInfoToDocument();		 
	}



	private static void writeInfoToDocument() {
		try {
			// 新建 HWPFDocument 对象，读入doc文件
			HWPFDocument doc = new HWPFDocument(new FileInputStream("E:\\lieyan\\公司相关\\党史\\测试\\毛文稿第一册（1949－1950）.doc"));
			// 得到整个doc文档的Range，可以理解为文档对象
			Range r = doc.getRange();

			System.out.println("Example you supplied:");
			System.out.println("---------------------");

			String text = new String("");
			// 得到整个文档里面的所有纯文字，包含回车换行。一段是一行
			text = r.text();
			// System.out.println(text); //读取文档中的纯文本

			// 得到整个文档的分节数。一般只有一节，排版很漂亮的word文档一般分为多节
			System.out.println("numSections: " + r.numSections());
			// 得到倒数第一节的Section对象
			Section section = r.getSection(r.numSections() - 1);
			// 得到该节里面的段落数
			System.out.println(section.numParagraphs()); // 一行就是一段
			System.out.println("numParagraphs: " + section.numParagraphs());

			String searchText = "${Ryan}";
			String replacementText = "Apache Software Foundation";

			// 循环得到每一段落的文字。这个跟Range.text()是不同的。
			for (int np = 0; np < section.numParagraphs(); np++) {
				Paragraph para = section.getParagraph(np);
				// 得到该段落的文字
				text = para.text();
				System.out.println(Integer.toString(np) + ":" + text);
				int offset = text.indexOf(searchText);
				if (offset >= 0) {
					System.out.println(Integer.toString(np) + ":" + para.text());
					// 如果找到了，就进行文字的替换。replaceText只能针对段落
					para.replaceText(searchText, replacementText);
					break;
				}
			}

			// 写入到新的doc文件
			OutputStream outdoc = new FileOutputStream("E:\\lieyan\\公司相关\\党史\\测试\\毛文稿第一册（1949－1950）_1.doc");
			doc.write(outdoc);

			outdoc.flush();
			outdoc.close();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// 创建空白的word文档
	private static void createBlankWordDocument() throws FileNotFoundException, IOException {
		// Blank Document
		XWPFDocument document = new XWPFDocument();
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("E:\\lieyan\\公司相关\\党史\\测试\\Docs\\document.docx"));
		document.write(out);
		out.close();
		System.out.println("create document.docx successully");
	}
}
