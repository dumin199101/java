package glyj_pdfbox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * PDF转换操作：
 * @author Administrator
 *
 */
public class PDFBoxTest {
    public static void main(String[] args) throws IOException, ParseException {
//    	 createPDF();
//    	 addPageToPDF();
//    	 loadPDF();
//    	deletePDFPage();
//    	setPDFInformation();
//    	getPDFInformation();
//    	addContentToPDF();
//    	addMultiLineToPDF();
//    	getTextFromPDF();
//    	insertImgToPDF();
//    	splitPDF();
//      mergePDF();
//                getImageFromPDF();
	}
    

    /**
     * 从PDF文件中提取图片
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getImageFromPDF() throws InvalidPasswordException,
			IOException {
		//第1步：加载现有PDF文件
		File file = new File("D:\\Mytest\\Output\\ExtractPDF\\3\\1.pdf"); 
		PDDocument document = PDDocument.load(file) ;
		//步骤2：实例化PDFRenderer类
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		//步骤3：从PDF文件绘制图像
		BufferedImage image = pdfRenderer.renderImage(0) ;
		//第4步：编写图像到文件
		ImageIO.write(image, "JPEG" , new File("D:\\Mytest\\Output\\PDFToJPG\\2-4\\1.jpg") );
		//5.关闭文档
		document.close() ;
	}


    /**
     * 合并PDF文件
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws FileNotFoundException
     */
	public static void mergePDF() throws InvalidPasswordException,
			IOException, FileNotFoundException {
		//    	第1步：加载现有PDF文件
		    	File file1 = new File("D:\\Mytest\\Input\\2.pdf"); 
		    	PDDocument document1 = PDDocument.load(file1) ;
		    	File file2 = new File("D:\\Mytest\\Input\\2.pdf"); 
		    	PDDocument document2 = PDDocument.load(file2) ;
		    	//步骤2：实例化PDFMergerUtility类
		    	PDFMergerUtility mergerUtility = new PDFMergerUtility();
		    	//第3步：设置目标文件
		    	mergerUtility.setDestinationFileName("D:\\Mytest\\Output\\CreatePDF\\mergePDF.pdf");
		    	//第4步：设置源文件
		    	mergerUtility.addSource(file1);
		    	mergerUtility.addSource(file2);
		    	//第5步：合并文件
		    	mergerUtility.mergeDocuments();
		    	//6.关闭文档
		    	document1.close();
		    	document2.close();
	}


    /**
     * 拆分PDF,大文件内存溢出
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void splitPDF() throws InvalidPasswordException, IOException {
		//第1步：加载现有PDF文件
    	File file = new File("D:\\Mytest\\Input\\南疆勘界日记图说-R_PS_Merge.pdf");
    	PDDocument document = PDDocument.load(file);
    	//步骤2：实例化分配器类
    	Splitter splitter = new Splitter();
    	//第3步：拆分PDF文件
    	List<PDDocument> Pages = splitter.split(document) ;
    	//第4步：创建一个Iterator对象
    	Iterator<PDDocument> iterator = Pages.listIterator() ;
    	int i = 1;
        while(iterator.hasNext() ) {
           PDDocument pd = iterator.next() ;
           pd.save("D:\\Mytest\\Output\\ExtractPDF\\4\\"+ i++ +".pdf") ;
        }
        System.out.println("Multiple PDF’s created") ;
        //关闭文档
        document.close() ;
	}

    

    /**
     * 插入图像到PDF文件
     * @throws IOException
     */
	public static void insertImgToPDF() throws IOException {
		//1.创建PDF文档
    	PDDocument document = new PDDocument();
    	//2.添加空白页
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.选择当前页
    	PDPage cpage = document.getPage(0);
    	//4.创建PDImageXObject对象
    	PDImageXObject imageXObject = PDImageXObject.createFromFile("D:\\Mytest\\Output\\PDFToJPG\\2-2\\1.jpg", document);
    	//5.创建内容流
    	PDPageContentStream pageContentStream = new PDPageContentStream(document, cpage);
    	//6.插入图像：x坐标，y坐标（？）位置不对
    	pageContentStream.drawImage(imageXObject,0,200);
    	//7.关闭内容流
    	pageContentStream.close();
    	//8.保存文档
    	document.save("D:\\Mytest\\Output\\CreatePDF\\createImg.pdf");
    	//9.关闭文档
    	document.close();
	}


    
    /**
     * 从PDF文件中获取文本
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getTextFromPDF() throws InvalidPasswordException,
			IOException {
		//1.加载现有的PDF文档
    	File file = new File("D:\\Mytest\\Output\\ExtractPDF\\西域补志-R\\40.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.实例化PDFTextStripper类
    	PDFTextStripper pdfTextStripper = new PDFTextStripper();
    	//3.获取文本
    	String text = pdfTextStripper.getText(document);
    	System.out.println(text);
    	//4.关闭文档
    	document.close();
	}


    /**
     *  添加多行到PDF文档
     * @throws IOException
     */
	public static void addMultiLineToPDF() throws IOException {
		//1.创建PDF文档
    	PDDocument document = new PDDocument();
    	//2.添加空白页
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.选择当前页
    	PDPage cpage = document.getPage(0);
    	//4.准备内容流
    	PDPageContentStream contentStream = new PDPageContentStream(document, cpage);
    	//5.开始文本
    	contentStream.beginText();
    	//6.设置文本字体
    	contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
    	//7.设置起始位置
    	contentStream.newLineAtOffset(25, 500);
    	//8.设置文本行距
    	contentStream.setLeading(12.5f);
    	//9.插入文本
    	String text = "Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!";
    	String text2 = "Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!";
    	contentStream.showText(text);
    	contentStream.newLine();
    	contentStream.showText(text2);
    	//10.结束文本
    	contentStream.endText();
    	//11.关闭内容流
    	contentStream.close();
    	//12.保存文档
    	document.save("D:\\Mytest\\Output\\CreatePDF\\writeText_2.pdf");
    	//13.关闭文档
    	document.close();
	}


    
    //向PDF中插入文本
	public static void addContentToPDF() throws IOException {
		//1.创建PDF文档
    	PDDocument document = new PDDocument();
    	//2.添加空白页
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.选择当前页
    	PDPage cpage = document.getPage(0);
    	//4.准备内容流
    	PDPageContentStream contentStream = new PDPageContentStream(document, cpage);
    	//5.开始文本
    	contentStream.beginText();
    	//6.设置文本字体
    	contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
    	//7.设置起始位置
    	contentStream.newLineAtOffset(25, 500);
    	//8.插入文本
    	String text = "Hello PDFBox!";
    	contentStream.showText(text);
    	//9.结束文本
    	contentStream.endText();
    	//10.关闭内容流
    	contentStream.close();
    	//11.保存文档
    	document.save("D:\\Mytest\\Output\\CreatePDF\\writeText.pdf");
    	//12.关闭文档
    	document.close();
	}


    /**
     * 获取PDF文档属性信息
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getPDFInformation() throws InvalidPasswordException,
			IOException {
		//1.加载已有文档
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓_2.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.获得PDDocumentInformation对象
    	PDDocumentInformation pdd = document.getDocumentInformation();
    	String author = pdd.getAuthor();
    	String title = pdd.getTitle();
    	String creator = pdd.getCreator();
    	String subject = pdd.getSubject();
    	String keywords = pdd.getKeywords();
    	Calendar c = pdd.getCreationDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String create_time = sdf.format(c.getTime());
    	c = pdd.getModificationDate();
    	String modify_time = sdf.format(c.getTime());
    	System.out.println("Document Info:"+author+","+title+","+creator+","+subject+","+keywords+","+create_time+","+modify_time);
    	//关闭文档
    	document.close();
	}


    /**
     * 设置PDF文档的相关属性
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws ParseException
     */
	public static void setPDFInformation() throws InvalidPasswordException,
			IOException, ParseException {
		//1.加载已有文档
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.获得PDDocumentInformation对象
    	PDDocumentInformation pdd = document.getDocumentInformation();
    	pdd.setAuthor("烈焰");
    	pdd.setTitle("PDF文档");
    	pdd.setCreator("杜民");
    	pdd.setSubject("PDFBox操作PDF文档");
    	pdd.setKeywords("学习，练习");
    	Calendar c = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = sdf.parse("2017-06-21 05:22:11");
    	c.setTime(date);
    	pdd.setCreationDate(c);
    	c.set(2017, 6, 21, 6, 30, 14);
    	pdd.setModificationDate(c);
    	//3.保存
    	document.save("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓_2.pdf");
    	//4.关闭文档
    	document.close();
	}


    //删除PDF中的页
	public static void deletePDFPage() throws InvalidPasswordException,
			IOException {
		//第1步：加载现有PDF文件
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓.pdf");
    	PDDocument document = PDDocument.load(file);
    	//第2步：PDF文件的页数
    	int pages = document.getNumberOfPages();
    	System.out.println(pages);
    	//第3步：删除页
    	document.removePage(0); //删除第一页：索引从0开始
    	//步骤4：将文档保存
    	document.save("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓_1.pdf"); //必须使用另外一个文件
    	//步骤5：关闭文档
    	document.close();
	}

    
    /**
     * 加载PDF文档
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void loadPDF() throws InvalidPasswordException, IOException {
		//第1步：加载现有PDF文件
    	File file = new File("D:\\Mytest\\Input\\传奇大将陈赓.pdf"); 
    	PDDocument document = PDDocument .load(file);
    	//步骤2：将文档保存
    	document.save("D:\\Mytest\\Output\\CreatePDF\\传奇大将陈赓.pdf");
    	//步骤3：关闭文档
    	document.close();
	}


    /**
     * 添加空白页到PDF文件
     * @throws IOException
     */
	public static void addPageToPDF() throws IOException {
		//步骤1：创建一个空文件
    	PDDocument document = new PDDocument();
    	//第2步：创建一个空白页
    	PDPage page = new PDPage();
    	//步骤3：添加空白页到文档中去
    	document.addPage(page);
    	//步骤4：将文档保存
    	document.save("D:\\Mytest\\Output\\CreatePDF\\2.pdf");
    	//步骤5：关闭文档
    	document.close();
	}


    /**
     * 创建PDF文档
     * @throws IOException
     */
	public static void createPDF() throws IOException {

    	 //步骤1：创建一个空文件:所述PDDocument属于包类org.apache.pdfbox.pdmodel ，是PDFDocument的内存中表示
    	 PDDocument document = new PDDocument() ;
    	 //步骤2：将文档保存:创建文档后，您需要将该文件保存所需的路径，你可以这样做使用PDDocument类的Save()方法
    	 document.save("D:\\Mytest\\Output\\CreatePDF\\1.pdf") ;
    	 //步骤3：关闭文档：你需要关闭PDDocument使用对象close ()方法。
    	 document.close();
	}
	
	
    

}