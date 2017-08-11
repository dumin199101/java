package wordtopdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.extractor.WordExtractor;
/**
 * ���word�ĵ�
 * @author dd
 *
 */
public class WordExtractUtils {
	/**
	 * 
	 * @param srcFile �������ı��ļ�
	 * @param destFolder �����ļ��Ĵ洢�ļ���
	 */
	public static void extractWord2003(File srcFile,File destFolder) {
		try {
			//1.��ȡ�ı���Ϣ
			InputStream is = new FileInputStream(srcFile);
			WordExtractor ex = new WordExtractor(is);
			String text2003 = ex.getText();
			//2.ͨ����ǩ<REC>����ÿһƪ�Ĳ��
			String[] articles = text2003.split("<REC>");
			Pattern bookname = Pattern.compile("<����>=(.*)");
			Pattern authorname = Pattern.compile("<����>=(.*)");
			Pattern titlename = Pattern.compile("<��Ŀ>=(.*)");
			Pattern contentname = Pattern.compile("<����>=([\\s\\S]*)");
			Pattern publishtime = Pattern.compile("<����>=\\r\\n(.*\\r\\n(.*))");
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
						author_name = m_authorname.group(1).equals("") ? "����" : m_authorname.group(1);
					if (m_publishtime.find()) {
						publish_time = m_publishtime.group(2).length() > 14 ? "����" : m_publishtime.group(2);
					book_name = m_bookname.group(1);
					title_name = m_titlename.group(1);
					content_name = m_contentname.group(1);
					//���ɻ�����Ϣ��
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\lieyan\\��˾���\\��ʷ\\����\\Txt\\baseInfo.txt",true), "UTF-8"));
					String baseInfo = book_name+"\t"+title_name+"\t"+publish_time+"\t"+author_name;
					bw.write(baseInfo);
					bw.newLine();
					bw.flush();
					bw.close();
					// ֱ��д��word�ĵ�
					File destFold = new File(destFolder,book_name);
					if(!destFold.exists())
						destFold.mkdirs();
					File destFile = new File(destFold, String.format("%03d", index) + title_name + ".doc");
					WordTemplateUtils.createWord(destFile, content_name.trim());
					System.out.println(destFile.getName()+"�ļ����ɳɹ�...");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}