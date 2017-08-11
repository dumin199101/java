package glyj_lhh_database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

/**
 * 
 * @author lieyan
 * @dateTime 2014-06-07
 *		�����߶�ʵ�ֶ�IMG��PDF�໥ת����
 *		���в�����Ҫ��������2��jar��
 *			itext-2.0.2.jar		
 *			PDFRenderer.jar
 *
 */
@SuppressWarnings("unused")
public class ImgPdfUtils {
	public static void main(String[] args) throws Exception {
		//������pdf�в�ֳ�����pdf
//		pdfExtraction("H:\\Goosuu\\PDF\\1.pdf","H:\\23.pdf",23);
		
		//������pdf�������jpg
//		pdfToJpg("H:\\Goosuu\\PDF\\1.pdf","H:\\1.jpg",1);
		
		//����jpgת����pdf
//		jpgToPdf(new File("H:\\Goosuu\\LhhImg\\1\\img\\1.jpg"),new File("H:\\1.pdf"));
		
		//�ļ�����
//		listOrder();
		
		//�����jpgֱ�Ӻϲ���pdf��
//		ImgPdfUtils.imgMerageToPdf(new File("H:\\Goosuu\\LhhImg\\1\\img").listFiles(),new File("H:\\Goosuu\\PDF","1.pdf"));
		
		//���������jpg�ϳ�pdf��
//		File srcFolder = new File("J:\\Lhh\\Lhh_Book");
//		batchTransferImgToPdf(srcFolder);
		
		
		
	}
	
	
	
	
	
	
	private static void batchTransferImgToPdf(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		for(File file : fileArr){
			if(file.isDirectory()){
				     batchTransferImgToPdf(file);
//				     if(file.getName().equals("img")||file.getName().equals("audio")){
//				    	 continue;
//				     }
					try {
						ImgPdfUtils.imgMerageToPdf(new File("J:\\Lhh\\Lhh_Book\\"+file.getName()).listFiles(),new File("J:\\Lhh\\PDF",file.getName()+".pdf"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(file.getName()+"��PDF�ļ��������");
			}
		}
		
	}






	private static void listOrder() {
		
		File[] listFiles = new File("H:\\Goosuu\\LhhImg\\1\\img").listFiles();
		TreeMap<Integer, File> tree = new TreeMap<Integer, File>();
		for(File f : listFiles)
		{
			tree.put(Integer.parseInt(f.getName().replaceAll(".jpg$", "")), f);
		}
		for(Entry<Integer, File> eif : tree.entrySet())
		{
			System.out.println(eif.getKey()+"="+eif.getValue().toString());
		}
	}
	/**	
	 * @param list	ͼƬ����
	 * @param file ����·��
	 * @return	true,�ϲ����
	 * 		����ļ�������1.jpg��2.jpg��3.jpg��4.jpg�����ġ�����Ҫ�Լ���дTreeMap������ʽ��
	 */
	public static boolean imgMerageToPdf(File[] list, File file)throws Exception {
		//1����ͼƬ�ļ�ͨ��TreeMap�����ƽ�����Ȼ����
		Map<Integer,File> mif = new TreeMap<Integer,File>();
		for(File f : list)
			mif.put(Integer.parseInt(f.getName().replaceAll(".jpg$", "")), f);
		
		//2����ȡ��һ��Img�Ŀ�����ΪPDF�ĵ���׼
		ByteArrayOutputStream baos = new ByteArrayOutputStream(2048*3);
		InputStream is = new FileInputStream(mif.get(1));
		for(int len;(len=is.read())!=-1;)
			baos.write(len);
		
		baos.flush();
		Image image = Image.getInstance(baos.toByteArray());
		float width = image.width();
		float height = image.height();
		baos.close();
		
		//3:ͨ����� ��ʵ����PDF�ĵ�����
		Document document = new Document(new Rectangle(width,height));
		PdfWriter pdfWr = PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		
		//4����ȡÿһ��ͼƬ�ļ���תΪIMG����װ�ص�Document������
		for(Entry<Integer,File> eif : mif.entrySet())
		{
			//4.1:��ȡ���ڴ���
			baos = new ByteArrayOutputStream(2048*3);
			is = new FileInputStream(eif.getValue());
			for(int len;(len=is.read())!=-1;)
				baos.write(len);
			baos.flush();
			
			//4.2ͨ��byte�ֽ�����IMG����
			image = Image.getInstance(baos.toByteArray());
			Image.getInstance(baos.toByteArray());
			image.setAbsolutePosition(0.0f, 0.0f);
			
			//4.3����ӵ�document��
			document.add(image);
			document.newPage();
			baos.close();
		}
		
		//5���ͷ���Դ
		document.close();
		pdfWr.close();
		
		return true;
	}
	/**
	 * 
	 * @param source Դ�ļ�
	 * @param target Ŀ���ļ�
	 * @param x	��ȡԴ�ļ��еĵڼ�ҳ
	 */
	private static void pdfToJpg(String source,String target,int x) throws Exception {
		//�������ж�ȡ��������д�루��ѡ������������ļ�����R��ʾ����ֻ�Ƿ���ģʽ
		RandomAccessFile rea = new RandomAccessFile(new File(source), "r");

		//������ȡ���ڴ��У�Ȼ��ӳ��һ��PDF����
		FileChannel channel = rea.getChannel();
		ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
		PDFFile pdfFile = new PDFFile(buf);
        PDFPage page = pdfFile.getPage(x);  

        // get the width and height for the doc at the default zoom  
        java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, (int) page.getBBox()  
                .getWidth(), (int) page.getBBox().getHeight());  

        // generate the image  
		java.awt.Image img = page.getImage(rect.width, rect.height, // width &
				rect, // clip rect
				null, // null for the ImageObserver
				true, // fill background with white
				true // block until drawing is done
				);  

        BufferedImage tag = new BufferedImage(rect.width, rect.height,  
                BufferedImage.TYPE_INT_RGB);  
        
        tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height,  
                null);  
        FileOutputStream out = new FileOutputStream(target); // ������ļ���  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        encoder.encode(tag); // JPEG����  
        out.close();  		
	}
	/**
	 * @param source  ԴPDF�ļ�·��
	 * @param target  ����PDF�ļ�·��
	 * @param pageNum  ��ȡPDF�е�pageNumҳ
	 * @throws Exception  
	 */
	private static void pdfExtraction(String source,String target,int pageNum) throws Exception{
		//1������PDF��ȡ����
		PdfReader pr = new PdfReader(source);
		System.out.println("this document "+pr.getNumberOfPages()+" page");
		
		//2������pageҳתΪ��ȡ������document����
		Document doc = new Document(pr.getPageSize(pageNum));
		
		//3��ͨ��PdfCopyת�䵥���洢
		PdfCopy copy = new PdfCopy(doc, new FileOutputStream(new File(target)));
		doc.open();
		doc.newPage();
		
		//4����ȡ��1ҳ��װ�ص�document�С�
		PdfImportedPage page = copy.getImportedPage(pr,pageNum);
		copy.addPage(page);	
		
		//5���ͷ���Դ
		copy.close();
		doc.close();
		pr.close();
	}
	/**
	 * @param pdfFile ԴPDF�ļ�
	 * @param imgFile	ͼƬ�ļ�
	 */
	private static void jpgToPdf(File pdfFile,File imgFile)  throws Exception {
		//�ļ�תimg
		InputStream is = new FileInputStream(pdfFile);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for(int i;(i=is.read())!=-1;)
		{
			baos.write(i);
		}
		baos.flush();
		
		//ȡ��ͼ��Ŀ�͸ߡ�
		Image img = Image.getInstance(baos.toByteArray());
		float width = img.width();
		float height = img.height();
		img.setAbsolutePosition(0.0F, 0.0F);//ȡ��ƫ��
		System.out.println("width = "+width+"\theight"+height);
		
		//imgתpdf
		Document doc = new Document(new Rectangle(width,height));
		PdfWriter pw = PdfWriter.getInstance(doc,new FileOutputStream(imgFile));
		doc.open();
		doc.add(img);
		
		//�ͷ���Դ
		System.out.println(doc.newPage());
		pw.flush();
		baos.close();
		doc.close();
		pw.close();
	}
	
}