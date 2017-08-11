package wordtopdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
/**
 * ת��word�ĵ���pdf
 * @author dd
 *
 */
public class WordtoPDFUtils {
	private static final Integer WORD_TO_PDF_OPERAND = 17;

	public static void doc2pdf(String srcFilePath, String pdfFilePath) throws Exception {
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
}