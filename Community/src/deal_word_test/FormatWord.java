package deal_word_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * ��ʽ��Word�ĵ�
 * 
 * @author dd �ο��ֲ᣺https://www.w3cschool.cn/apache_poi_word/
 */
public class FormatWord {
	// ����Word�����
	private static FileOutputStream fos;

	public static void main(String[] args) throws IOException {
		fos = new FileOutputStream("E:\\lieyan\\��˾���\\��ʷ\\����\\Documents\\Output Files\\007�л����񹲺͹�����������������_format.doc");
		XWPFDocument doc = new XWPFDocument();
		// word 2003�� ͼƬ���ᱻ��ȡ
		InputStream is = new FileInputStream(
				new File("E:\\lieyan\\��˾���\\��ʷ\\����\\Documents\\Output Files\\007�л����񹲺͹�����������������.doc"));
		WordExtractor ex = new WordExtractor(is);
		String content = ex.getText();
		String[] contents = content.split("\n");
		for (int i = 0; i < contents.length; i++) {
			// ��������
			XWPFParagraph p1 = doc.createParagraph();
			if (i == 0 || (i == 1 && contents[i].startsWith("��"))) {
				p1.setAlignment(ParagraphAlignment.CENTER);
			} else {
				p1.setAlignment(ParagraphAlignment.LEFT);
			}

			XWPFRun r1 = p1.createRun();

			if (i == 0) {
				r1.setBold(true);
				r1.setFontSize(20);
			} else {
				r1.setFontSize(12);
				r1.setBold(false);
			}

			r1.setText(contents[i]);
			r1.setFontFamily("΢���ź�");
			
			doc.write(fos);
			fos.close();
			System.out.println(" Create Successfully....");
			
		}
	}
}
