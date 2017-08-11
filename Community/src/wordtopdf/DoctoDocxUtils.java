package wordtopdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * ת��doc�ļ���docx�ļ�
 * 
 * @author dd
 *
 */

/*���е�44���е� invoke���������е�Variant(n)����ָ�����Ϊ���ļ����ͣ�n��ȡֵ��Χ��0-25�������Ƿֱ��ǣ�
*Variant(0):doc
*Variant(1):dot
*Variant(2-5)��Variant(7):txt
*Variant(6):rft
*Variant(8)��Variant(10):htm
*Variant(9):mht
*Variant(11)��Variant(19-22):xml
*Variant(12):docx
*Variant(13):docm
*Variant(14):dotx
*Variant(15):dotm
*Variant(16)��Variant(24):docx
*Variant(17):pdf
*Variant(18):xps
*Variant(23):odt
*Variant(25):��Office2003��2007��ת��������أ�ִ�б�����󵯳�һ�������˵����Ҫ���߰汾�� Microsoft Works Converter
*/ 
public class DoctoDocxUtils {

	public static void doc2docx(String srcFilePath, String destFilePath) throws Exception {
		ActiveXComponent app = null;
		try {
			ComThread.InitSTA();
			// ����word����
			app = new ActiveXComponent("Word.Application");
			// ����word���ɼ�
			app.setProperty("Visible", false);
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// �������word�ĵ�
			Object doc = Dispatch
					.invoke((Dispatch) docs, "Open", Dispatch.Method,
							new Object[] { srcFilePath, new Variant(false), new Variant(true) }, new int[1])
					.toDispatch();
			
			//����ļ�, ����Variant(n)����ָ�����Ϊ���ļ����ͣ������������������
			Dispatch.invoke((Dispatch) doc,"SaveAs", Dispatch.Method, new Object[]{destFilePath,new Variant(16)}, new int[1]); 

			//���Ҳ����
			Variant f = new Variant(false);
			//�رղ��˳�
			Dispatch.call((Dispatch) doc, "Close", f);
			app.invoke("Quit", new Variant[] {});
			System.out.println(srcFilePath+"ת����ϡ�"); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
