package deal_word_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

/**
 * 拆分Word数据
 * 
 * @author dd
 *
 */
public class ExtractWordTest {
	public static void main(String[] args) {
		extractWord2003();

	}

	private static void extractWord2003() {
		try {
			File destFolder = new File("E:\\lieyan\\公司相关\\党史\\测试\\Txts");
			// word 2003： 图片不会被读取
			InputStream is = new FileInputStream(new File("E:\\lieyan\\公司相关\\党史\\测试\\毛文稿第一册（1949－1950）.doc"));
			WordExtractor ex = new WordExtractor(is);
			String text2003 = ex.getText();
			// 通过标签<REC>进行每一篇的拆分
			String[] articles = text2003.split("<REC>");
			Pattern bookname = Pattern.compile("<书名>=(.*)");
			Pattern authorname = Pattern.compile("<作者>=(.*)");
			Pattern titlename = Pattern.compile("<题目>=(.*)");
			Pattern contentname = Pattern.compile("<正文>=([\\s\\S]*)");
			Pattern publishtime = Pattern.compile("<正文>=\\r\\n(.*\\r\\n(.*))");
			int index = -1;
			for (String article : articles) {
				index++;
				if (article.equals(""))
					continue;
				Matcher m_bookname = bookname.matcher(article);
				Matcher m_authorname = authorname.matcher(article);
				Matcher m_titlename = titlename.matcher(article);
				Matcher m_contentname = contentname.matcher(article);
				Matcher m_publishtime = publishtime.matcher(article);
				String book_name = "";
				String author_name = "";
				String title_name = "";
				String content_name = "";
				String publish_time = "";
				if (m_bookname.find() && m_titlename.find() && m_contentname.find())
					if (m_authorname.find())
						author_name = m_authorname.group(1).equals("") ? "暂无" : m_authorname.group(1);
				if (m_publishtime.find()) {
					publish_time = m_publishtime.group(2).length() > 14 ? "暂无" : m_publishtime.group(2);

				book_name = m_bookname.group(1);
				title_name = m_titlename.group(1);
				content_name = m_contentname.group(1);
				
				
				//写入Txt文本
				/*
                File destFile = new File(destFolder,String.format("%03d",index)+title_name+".txt");
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile), "GB2312"));
//				System.out.println(String.format("%03d",index) + "---" + book_name + "---" + author_name + "---" + title_name + "---"
//							+ publish_time);
				bw.write(content_name.trim());
				bw.flush();
				bw.close();
				System.out.println(title_name+" Create Successfully");
				*/
				
				//直接写入word文档
				File destFile = new File(destFolder,String.format("%03d",index)+title_name+".docx");
				WordTemplate.createWord(destFile, content_name.trim());
				

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void extractWord2007() throws IOException, XmlException, OpenXML4JException {
		// word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
		OPCPackage opcPackage = POIXMLDocument.openPackage("E:\\lieyan\\公司相关\\党史\\测试\\毛文稿第一册（1949－1950）.docx");
		POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
		String text2007 = extractor.getText();
		System.out.println(text2007);
	}

}
