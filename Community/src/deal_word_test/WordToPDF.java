package deal_word_test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
/**
 * 参考：http://www.cnblogs.com/xxyfhjl/p/6773786.html
 * @author dd
 *
 */
public class WordToPDF {
	private static final Integer WORD_TO_PDF_OPERAND = 17;

	public void doc2pdf(String srcFilePath, String pdfFilePath) throws Exception {
		ActiveXComponent app = null;
		Dispatch doc = null;
		try {
			ComThread.InitSTA();
			app = new ActiveXComponent("Word.Application");
			app.setProperty("Visible", false);
			Dispatch docs = app.getProperty("Documents").toDispatch();
			Object[] obj = new Object[] { srcFilePath, new Variant(false), new Variant(false), // 是否只读
					new Variant(false), new Variant("pwd") };
			doc = Dispatch.invoke(docs, "Open", Dispatch.Method, obj, new int[1]).toDispatch();
			// Dispatch.put(doc, "Compatibility", false); //兼容性检查,为特定值false不正确
			Dispatch.put(doc, "RemovePersonalInformation", false);
			Dispatch.call(doc, "ExportAsFixedFormat", pdfFilePath, WORD_TO_PDF_OPERAND); // word保存为pdf格式宏，值为17

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (doc != null) {
				Dispatch.call(doc, "Close", false);
			}
			if (app != null) {
				app.invoke("Quit", 0);
			}
			ComThread.Release();
		}
	}
	
	public static void main(String[] args) {
		String path = "E:\\lieyan\\公司相关\\党史\\测试\\Documents\\Output Files\\";
		try {
			new WordToPDF().doc2pdf(path + "010关于陈明仁部整编问题给林彪、华中局的电报.doc", path+ "010关于陈明仁部整编问题给林彪、华中局的电报.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over...");
	}
}
