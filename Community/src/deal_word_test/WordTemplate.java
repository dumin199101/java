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
	
	// 创建Word输出流
	private static FileOutputStream fos;
	

	public static void createWord(File destFile,String content) throws IOException{
		
		// 初始化输出流
		fos = new FileOutputStream(destFile);
		XWPFDocument doc = new XWPFDocument();

		
		/*
		p1.setBorderBottom(Borders.DOUBLE);
		p1.setBorderTop(Borders.DOUBLE);
		p1.setBorderRight(Borders.DOUBLE);
		p1.setBorderLeft(Borders.DOUBLE);
		p1.setBorderBetween(Borders.SINGLE);
		p1.setVerticalAlignment(TextAlignment.TOP); //段落文本垂直居上

		*/

		// 创建1段文字,通过段落创建 
		//XWPFRun r1 = p1.createRun(); //创建一套通用属性（居中，字体……）的文本区域
		// 设置是否粗体
//		r1.setBold(true);
		String[] contents = content.split("\n");
		for(int i=0;i<contents.length;i++){
			// 创建段落
			XWPFParagraph p1 = doc.createParagraph();
			if(i==0||(i==1&&contents[i].startsWith("（"))){
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
		    r1.setFontFamily("微软雅黑");
		}
//		r1.setText(content);
//		r1.setFontFamily("Courier");
//		r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//		r1.setTextPosition(100); //行文字基线向上偏移100

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
		p3.setWordWrap(true); //段落结束
		// 设置该段落填充满本页,下面在显示新文本将在下一页显示
		p3.setPageBreak(true); //分页符


		p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
		p3.setAlignment(ParagraphAlignment.BOTH); //两端对齐
		p3.setSpacingLineRule(LineSpacingRule.EXACT); //设置行间距。指定行高15磅，文字超过行高，进行裁剪
		p3.setIndentationFirstLine(600); */
		
		//添加一个回车符
//		r5.addCarriageReturn();
		
		//添加一个换行符
//		r5.addBreak();

		doc.write(fos);
		fos.close();
		System.out.println( destFile.getName()+" Create Successfully....");
	}

}
