package deal_word_test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
/**
 * �ο���http://www.cnblogs.com/xxyfhjl/p/6773786.html
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
			Object[] obj = new Object[] { srcFilePath, new Variant(false), new Variant(false), // �Ƿ�ֻ��
					new Variant(false), new Variant("pwd") };
			doc = Dispatch.invoke(docs, "Open", Dispatch.Method, obj, new int[1]).toDispatch();
			// Dispatch.put(doc, "Compatibility", false); //�����Լ��,Ϊ�ض�ֵfalse����ȷ
			Dispatch.put(doc, "RemovePersonalInformation", false);
			Dispatch.call(doc, "ExportAsFixedFormat", pdfFilePath, WORD_TO_PDF_OPERAND); // word����Ϊpdf��ʽ�ֵ꣬Ϊ17

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
		String path = "E:\\lieyan\\��˾���\\��ʷ\\����\\Documents\\Output Files\\";
		try {
			new WordToPDF().doc2pdf(path + "010���ڳ����ʲ�����������ֱ롢���оֵĵ籨.doc", path+ "010���ڳ����ʲ�����������ֱ롢���оֵĵ籨.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over...");
	}
}