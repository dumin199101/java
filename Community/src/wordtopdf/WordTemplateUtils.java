package wordtopdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 * 格式化Word文本
 * @author dd
 *
 */
public class WordTemplateUtils {
	// 创建Word输出流
	private static FileOutputStream fos;

	public static void createWord(File destFile, String content) throws IOException {

		// 初始化输出流
		fos = new FileOutputStream(destFile);
		XWPFDocument doc = new XWPFDocument();
        //对文本做换行处理
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
		}
		
		doc.write(fos);
		fos.close();
	}

}
