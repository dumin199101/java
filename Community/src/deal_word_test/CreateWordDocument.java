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
 * ����word�ĵ�
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
			// �½� HWPFDocument ���󣬶���doc�ļ�
			HWPFDocument doc = new HWPFDocument(new FileInputStream("E:\\lieyan\\��˾���\\��ʷ\\����\\ë�ĸ��һ�ᣨ1949��1950��.doc"));
			// �õ�����doc�ĵ���Range����������Ϊ�ĵ�����
			Range r = doc.getRange();

			System.out.println("Example you supplied:");
			System.out.println("---------------------");

			String text = new String("");
			// �õ������ĵ���������д����֣������س����С�һ����һ��
			text = r.text();
			// System.out.println(text); //��ȡ�ĵ��еĴ��ı�

			// �õ������ĵ��ķֽ�����һ��ֻ��һ�ڣ��Ű��Ư����word�ĵ�һ���Ϊ���
			System.out.println("numSections: " + r.numSections());
			// �õ�������һ�ڵ�Section����
			Section section = r.getSection(r.numSections() - 1);
			// �õ��ý�����Ķ�����
			System.out.println(section.numParagraphs()); // һ�о���һ��
			System.out.println("numParagraphs: " + section.numParagraphs());

			String searchText = "${Ryan}";
			String replacementText = "Apache Software Foundation";

			// ѭ���õ�ÿһ��������֡������Range.text()�ǲ�ͬ�ġ�
			for (int np = 0; np < section.numParagraphs(); np++) {
				Paragraph para = section.getParagraph(np);
				// �õ��ö��������
				text = para.text();
				System.out.println(Integer.toString(np) + ":" + text);
				int offset = text.indexOf(searchText);
				if (offset >= 0) {
					System.out.println(Integer.toString(np) + ":" + para.text());
					// ����ҵ��ˣ��ͽ������ֵ��滻��replaceTextֻ����Զ���
					para.replaceText(searchText, replacementText);
					break;
				}
			}

			// д�뵽�µ�doc�ļ�
			OutputStream outdoc = new FileOutputStream("E:\\lieyan\\��˾���\\��ʷ\\����\\ë�ĸ��һ�ᣨ1949��1950��_1.doc");
			doc.write(outdoc);

			outdoc.flush();
			outdoc.close();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// �����հ׵�word�ĵ�
	private static void createBlankWordDocument() throws FileNotFoundException, IOException {
		// Blank Document
		XWPFDocument document = new XWPFDocument();
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Docs\\document.docx"));
		document.write(out);
		out.close();
		System.out.println("create document.docx successully");
	}
}