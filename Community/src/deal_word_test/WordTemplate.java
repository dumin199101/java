package deal_word_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



public class WordTemplate {
	
	// ����Word�����
	private static FileOutputStream fos;
	

	public static void createWord(File destFile,String content) throws IOException{
		
		// ��ʼ�������
		fos = new FileOutputStream(destFile);
		XWPFDocument doc = new XWPFDocument();

		
		/*
		p1.setBorderBottom(Borders.DOUBLE);
		p1.setBorderTop(Borders.DOUBLE);
		p1.setBorderRight(Borders.DOUBLE);
		p1.setBorderLeft(Borders.DOUBLE);
		p1.setBorderBetween(Borders.SINGLE);
		p1.setVerticalAlignment(TextAlignment.TOP); //�����ı���ֱ����

		*/

		// ����1������,ͨ�����䴴�� 
		//XWPFRun r1 = p1.createRun(); //����һ��ͨ�����ԣ����У����塭�������ı�����
		// �����Ƿ����
//		r1.setBold(true);
		String[] contents = content.split("\n");
		for(int i=0;i<contents.length;i++){
			// ��������
			XWPFParagraph p1 = doc.createParagraph();
			if(i==0||(i==1&&contents[i].startsWith("��"))){
				p1.setAlignment(ParagraphAlignment.CENTER);
			}else{
				p1.setAlignment(ParagraphAlignment.LEFT);
			}
			
			XWPFRun r1 = p1.createRun();
			
			if(i==0){
				r1.setBold(true);
				r1.setFontSize(20);
			}else{
				r1.setFontSize(12);
				r1.setBold(false);
			}
			  
		    r1.setText(contents[i]);
		    r1.setFontFamily("΢���ź�");
		}
//		r1.setText(content);
//		r1.setFontFamily("Courier");
//		r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//		r1.setTextPosition(100); //�����ֻ�������ƫ��100

	 /*   XWPFParagraph p2 = doc.createParagraph();
		p2.setAlignment(ParagraphAlignment.RIGHT);*/

		/*
		p2.setBorderBottom(Borders.DOUBLE);
		p2.setBorderTop(Borders.DOUBLE);
		p2.setBorderRight(Borders.DOUBLE);
		p2.setBorderLeft(Borders.DOUBLE);
		p2.setBorderBetween(Borders.SINGLE);
        */

/*		XWPFRun r2 = p2.createRun();
		r2.setText("Hello Hello Hello Hello Hello Hello Hello");
		r2.setStrike(true);
		r2.setFontSize(20);

		XWPFRun r3 = p2.createRun();
		r3.setText("World World World World World World World");
		r3.setStrike(true);
		r3.setFontSize(20);

		
		XWPFParagraph p3 = doc.createParagraph();
		p3.setWordWrap(true); //�������
		// ���øö����������ҳ,��������ʾ���ı�������һҳ��ʾ
		p3.setPageBreak(true); //��ҳ��


		p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
		p3.setAlignment(ParagraphAlignment.BOTH); //���˶���
		p3.setSpacingLineRule(LineSpacingRule.EXACT); //�����м�ࡣָ���и�15�������ֳ����иߣ����вü�
		p3.setIndentationFirstLine(600); */
		
		//����һ���س���
//		r5.addCarriageReturn();
		
		//����һ�����з�
//		r5.addBreak();

		doc.write(fos);
		fos.close();
		System.out.println( destFile.getName()+" Create Successfully....");
	}

}