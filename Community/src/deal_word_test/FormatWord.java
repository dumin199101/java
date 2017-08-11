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
 * 格式化Word文档
 * 
 * @author dd 参考手册：https://www.w3cschool.cn/apache_poi_word/
 */
public class FormatWord {
	// 创建Word输出流
	private static FileOutputStream fos;

	public static void main(String[] args) throws IOException {
		fos = new FileOutputStream("E:\\lieyan\\公司相关\\党史\\测试\\Documents\\Output Files\\007中华人民共和国中央人民政府公告_format.doc");
		XWPFDocument doc = new XWPFDocument();
		// word 2003： 图片不会被读取
		InputStream is = new FileInputStream(
				new File("E:\\lieyan\\公司相关\\党史\\测试\\Documents\\Output Files\\007中华人民共和国中央人民政府公告.doc"));
		WordExtractor ex = new WordExtractor(is);
		String content = ex.getText();
		String[] contents = content.split("\n");
		for (int i = 0; i < contents.length; i++) {
			// 创建段落
			XWPFParagraph p1 = doc.createParagraph();
			if (i == 0 || (i == 1 && contents[i].startsWith("（"))) {
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
			r1.setFontFamily("微软雅黑");
			
			doc.write(fos);
			fos.close();
			System.out.println(" Create Successfully....");
			
		}
	}
}
