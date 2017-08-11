package wordtopdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 转换doc文件到docx文件
 * 
 * @author dd
 *
 */

/*其中第44行中的 invoke（）函数中的Variant(n)参数指定另存为的文件类型（n的取值范围是0-25），他们分别是：
*Variant(0):doc
*Variant(1):dot
*Variant(2-5)，Variant(7):txt
*Variant(6):rft
*Variant(8)，Variant(10):htm
*Variant(9):mht
*Variant(11)，Variant(19-22):xml
*Variant(12):docx
*Variant(13):docm
*Variant(14):dotx
*Variant(15):dotm
*Variant(16)、Variant(24):docx
*Variant(17):pdf
*Variant(18):xps
*Variant(23):odt
*Variant(25):与Office2003与2007的转换程序相关，执行本程序后弹出一个警告框说是需要更高版本的 Microsoft Works Converter
*/ 
public class DoctoDocxUtils {

	public static void doc2docx(String srcFilePath, String destFilePath) throws Exception {
		ActiveXComponent app = null;
		try {
			ComThread.InitSTA();
			// 启动word程序
			app = new ActiveXComponent("Word.Application");
			// 设置word不可见
			app.setProperty("Visible", false);
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// 打开输入的word文档
			Object doc = Dispatch
					.invoke((Dispatch) docs, "Open", Dispatch.Method,
							new Object[] { srcFilePath, new Variant(false), new Variant(true) }, new int[1])
					.toDispatch();
			
			//另存文件, 其中Variant(n)参数指定另存为的文件类型，详见代码结束后的文字
			Dispatch.invoke((Dispatch) doc,"SaveAs", Dispatch.Method, new Object[]{destFilePath,new Variant(16)}, new int[1]); 

			//这句也不懂
			Variant f = new Variant(false);
			//关闭并退出
			Dispatch.call((Dispatch) doc, "Close", f);
			app.invoke("Quit", new Variant[] {});
			System.out.println(srcFilePath+"转换完毕。"); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
