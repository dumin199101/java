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
 * PDFת��������
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
     * ��PDF�ļ�����ȡͼƬ
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getImageFromPDF() throws InvalidPasswordException,
			IOException {
		//��1������������PDF�ļ�
		File file = new File("D:\\Mytest\\Output\\ExtractPDF\\3\\1.pdf"); 
		PDDocument document = PDDocument.load(file) ;
		//����2��ʵ����PDFRenderer��
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		//����3����PDF�ļ�����ͼ��
		BufferedImage image = pdfRenderer.renderImage(0) ;
		//��4������дͼ���ļ�
		ImageIO.write(image, "JPEG" , new File("D:\\Mytest\\Output\\PDFToJPG\\2-4\\1.jpg") );
		//5.�ر��ĵ�
		document.close() ;
	}


    /**
     * �ϲ�PDF�ļ�
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws FileNotFoundException
     */
	public static void mergePDF() throws InvalidPasswordException,
			IOException, FileNotFoundException {
		//    	��1������������PDF�ļ�
		    	File file1 = new File("D:\\Mytest\\Input\\2.pdf"); 
		    	PDDocument document1 = PDDocument.load(file1) ;
		    	File file2 = new File("D:\\Mytest\\Input\\2.pdf"); 
		    	PDDocument document2 = PDDocument.load(file2) ;
		    	//����2��ʵ����PDFMergerUtility��
		    	PDFMergerUtility mergerUtility = new PDFMergerUtility();
		    	//��3��������Ŀ���ļ�
		    	mergerUtility.setDestinationFileName("D:\\Mytest\\Output\\CreatePDF\\mergePDF.pdf");
		    	//��4��������Դ�ļ�
		    	mergerUtility.addSource(file1);
		    	mergerUtility.addSource(file2);
		    	//��5�����ϲ��ļ�
		    	mergerUtility.mergeDocuments();
		    	//6.�ر��ĵ�
		    	document1.close();
		    	document2.close();
	}


    /**
     * ���PDF,���ļ��ڴ����
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void splitPDF() throws InvalidPasswordException, IOException {
		//��1������������PDF�ļ�
    	File file = new File("D:\\Mytest\\Input\\�Ͻ������ռ�ͼ˵-R_PS_Merge.pdf");
    	PDDocument document = PDDocument.load(file);
    	//����2��ʵ������������
    	Splitter splitter = new Splitter();
    	//��3�������PDF�ļ�
    	List<PDDocument> Pages = splitter.split(document) ;
    	//��4��������һ��Iterator����
    	Iterator<PDDocument> iterator = Pages.listIterator() ;
    	int i = 1;
        while(iterator.hasNext() ) {
           PDDocument pd = iterator.next() ;
           pd.save("D:\\Mytest\\Output\\ExtractPDF\\4\\"+ i++ +".pdf") ;
        }
        System.out.println("Multiple PDF��s created") ;
        //�ر��ĵ�
        document.close() ;
	}

    

    /**
     * ����ͼ��PDF�ļ�
     * @throws IOException
     */
	public static void insertImgToPDF() throws IOException {
		//1.����PDF�ĵ�
    	PDDocument document = new PDDocument();
    	//2.��ӿհ�ҳ
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.ѡ��ǰҳ
    	PDPage cpage = document.getPage(0);
    	//4.����PDImageXObject����
    	PDImageXObject imageXObject = PDImageXObject.createFromFile("D:\\Mytest\\Output\\PDFToJPG\\2-2\\1.jpg", document);
    	//5.����������
    	PDPageContentStream pageContentStream = new PDPageContentStream(document, cpage);
    	//6.����ͼ��x���꣬y���꣨����λ�ò���
    	pageContentStream.drawImage(imageXObject,0,200);
    	//7.�ر�������
    	pageContentStream.close();
    	//8.�����ĵ�
    	document.save("D:\\Mytest\\Output\\CreatePDF\\createImg.pdf");
    	//9.�ر��ĵ�
    	document.close();
	}


    
    /**
     * ��PDF�ļ��л�ȡ�ı�
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getTextFromPDF() throws InvalidPasswordException,
			IOException {
		//1.�������е�PDF�ĵ�
    	File file = new File("D:\\Mytest\\Output\\ExtractPDF\\����־-R\\40.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.ʵ����PDFTextStripper��
    	PDFTextStripper pdfTextStripper = new PDFTextStripper();
    	//3.��ȡ�ı�
    	String text = pdfTextStripper.getText(document);
    	System.out.println(text);
    	//4.�ر��ĵ�
    	document.close();
	}


    /**
     *  ��Ӷ��е�PDF�ĵ�
     * @throws IOException
     */
	public static void addMultiLineToPDF() throws IOException {
		//1.����PDF�ĵ�
    	PDDocument document = new PDDocument();
    	//2.��ӿհ�ҳ
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.ѡ��ǰҳ
    	PDPage cpage = document.getPage(0);
    	//4.׼��������
    	PDPageContentStream contentStream = new PDPageContentStream(document, cpage);
    	//5.��ʼ�ı�
    	contentStream.beginText();
    	//6.�����ı�����
    	contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
    	//7.������ʼλ��
    	contentStream.newLineAtOffset(25, 500);
    	//8.�����ı��о�
    	contentStream.setLeading(12.5f);
    	//9.�����ı�
    	String text = "Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!Hello PDFBox!";
    	String text2 = "Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!";
    	contentStream.showText(text);
    	contentStream.newLine();
    	contentStream.showText(text2);
    	//10.�����ı�
    	contentStream.endText();
    	//11.�ر�������
    	contentStream.close();
    	//12.�����ĵ�
    	document.save("D:\\Mytest\\Output\\CreatePDF\\writeText_2.pdf");
    	//13.�ر��ĵ�
    	document.close();
	}


    
    //��PDF�в����ı�
	public static void addContentToPDF() throws IOException {
		//1.����PDF�ĵ�
    	PDDocument document = new PDDocument();
    	//2.��ӿհ�ҳ
    	PDPage page = new PDPage();
    	document.addPage(page);
    	//3.ѡ��ǰҳ
    	PDPage cpage = document.getPage(0);
    	//4.׼��������
    	PDPageContentStream contentStream = new PDPageContentStream(document, cpage);
    	//5.��ʼ�ı�
    	contentStream.beginText();
    	//6.�����ı�����
    	contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
    	//7.������ʼλ��
    	contentStream.newLineAtOffset(25, 500);
    	//8.�����ı�
    	String text = "Hello PDFBox!";
    	contentStream.showText(text);
    	//9.�����ı�
    	contentStream.endText();
    	//10.�ر�������
    	contentStream.close();
    	//11.�����ĵ�
    	document.save("D:\\Mytest\\Output\\CreatePDF\\writeText.pdf");
    	//12.�ر��ĵ�
    	document.close();
	}


    /**
     * ��ȡPDF�ĵ�������Ϣ
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void getPDFInformation() throws InvalidPasswordException,
			IOException {
		//1.���������ĵ�
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\����󽫳���_2.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.���PDDocumentInformation����
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
    	//�ر��ĵ�
    	document.close();
	}


    /**
     * ����PDF�ĵ����������
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws ParseException
     */
	public static void setPDFInformation() throws InvalidPasswordException,
			IOException, ParseException {
		//1.���������ĵ�
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\����󽫳���.pdf");
    	PDDocument document = PDDocument.load(file);
    	//2.���PDDocumentInformation����
    	PDDocumentInformation pdd = document.getDocumentInformation();
    	pdd.setAuthor("����");
    	pdd.setTitle("PDF�ĵ�");
    	pdd.setCreator("����");
    	pdd.setSubject("PDFBox����PDF�ĵ�");
    	pdd.setKeywords("ѧϰ����ϰ");
    	Calendar c = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = sdf.parse("2017-06-21 05:22:11");
    	c.setTime(date);
    	pdd.setCreationDate(c);
    	c.set(2017, 6, 21, 6, 30, 14);
    	pdd.setModificationDate(c);
    	//3.����
    	document.save("D:\\Mytest\\Output\\CreatePDF\\����󽫳���_2.pdf");
    	//4.�ر��ĵ�
    	document.close();
	}


    //ɾ��PDF�е�ҳ
	public static void deletePDFPage() throws InvalidPasswordException,
			IOException {
		//��1������������PDF�ļ�
    	File file = new File("D:\\Mytest\\Output\\CreatePDF\\����󽫳���.pdf");
    	PDDocument document = PDDocument.load(file);
    	//��2����PDF�ļ���ҳ��
    	int pages = document.getNumberOfPages();
    	System.out.println(pages);
    	//��3����ɾ��ҳ
    	document.removePage(0); //ɾ����һҳ��������0��ʼ
    	//����4�����ĵ�����
    	document.save("D:\\Mytest\\Output\\CreatePDF\\����󽫳���_1.pdf"); //����ʹ������һ���ļ�
    	//����5���ر��ĵ�
    	document.close();
	}

    
    /**
     * ����PDF�ĵ�
     * @throws InvalidPasswordException
     * @throws IOException
     */
	public static void loadPDF() throws InvalidPasswordException, IOException {
		//��1������������PDF�ļ�
    	File file = new File("D:\\Mytest\\Input\\����󽫳���.pdf"); 
    	PDDocument document = PDDocument .load(file);
    	//����2�����ĵ�����
    	document.save("D:\\Mytest\\Output\\CreatePDF\\����󽫳���.pdf");
    	//����3���ر��ĵ�
    	document.close();
	}


    /**
     * ��ӿհ�ҳ��PDF�ļ�
     * @throws IOException
     */
	public static void addPageToPDF() throws IOException {
		//����1������һ�����ļ�
    	PDDocument document = new PDDocument();
    	//��2��������һ���հ�ҳ
    	PDPage page = new PDPage();
    	//����3����ӿհ�ҳ���ĵ���ȥ
    	document.addPage(page);
    	//����4�����ĵ�����
    	document.save("D:\\Mytest\\Output\\CreatePDF\\2.pdf");
    	//����5���ر��ĵ�
    	document.close();
	}


    /**
     * ����PDF�ĵ�
     * @throws IOException
     */
	public static void createPDF() throws IOException {

    	 //����1������һ�����ļ�:����PDDocument���ڰ���org.apache.pdfbox.pdmodel ����PDFDocument���ڴ��б�ʾ
    	 PDDocument document = new PDDocument() ;
    	 //����2�����ĵ�����:�����ĵ�������Ҫ�����ļ����������·���������������ʹ��PDDocument���Save()����
    	 document.save("D:\\Mytest\\Output\\CreatePDF\\1.pdf") ;
    	 //����3���ر��ĵ�������Ҫ�ر�PDDocumentʹ�ö���close ()������
    	 document.close();
	}
	
	
    

}