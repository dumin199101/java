package deal_word_test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.textmining.text.extraction.WordExtractor;

/**
 * http://blog.sina.com.cn/s/blog_87df085f0102w17v.html
 * @author dd
 *
 */
public class POIWordUtil {

	public static void main(String[] args) {
		try {
			String text = POIWordUtil.readDoc("E:\\lieyan\\公司相关\\党史\\测试\\毛文稿第一册（1949－1950）.doc");
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readDoc(String doc) throws Exception {
		// 创建输入流读取DOC文件
		FileInputStream in = new FileInputStream(new File(doc));
		WordExtractor extractor = null;
		String text = null;
		// 创建WordExtractor
		extractor = new WordExtractor();
		// 对DOC文件进行提取
		text = extractor.extractText(in);
		return text;
	}

	public static boolean writeDoc(String path, String content) {
		boolean w = false;
		try {
			// byte b[] = content.getBytes("ISO-8859-1");
			byte b[] = content.getBytes();
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			POIFSFileSystem fs = new POIFSFileSystem();
			DirectoryEntry directory = fs.getRoot();
			DocumentEntry de = directory.createDocument("WordDocument", bais);
			FileOutputStream ostream = new FileOutputStream(path);
			fs.writeFilesystem(ostream);
			bais.close();
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return w;
	}

	
}
