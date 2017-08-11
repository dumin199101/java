package deal_txt_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 拆分Txt文档
 * 
 * @author dd
 *
 */
public class ExtractTxtTest {
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("E:\\lieyan\\公司相关\\党史\\测试\\第1册.txt"), "GB2312"));
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
