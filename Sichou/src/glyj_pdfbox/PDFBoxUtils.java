package glyj_pdfbox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBoxUtils {
	
	/**
	 * ת��PDF�ļ�ΪͼƬ�ļ�
	 * @param srcFile  ԭʼPDF�ļ�·��
	 * @param destFile ��ȡͼƬ�ļ�����·��
	 * @throws InvalidPasswordException
	 * @throws IOException
	 */
	public static void getImageFromPDF(String srcFile,String destFile) throws InvalidPasswordException,
			IOException {
		//��1������������PDF�ļ�
		File file = new File(srcFile); 
		PDDocument document = PDDocument.load(file) ;
		//����2��ʵ����PDFRenderer��
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		//����3����PDF�ļ�����ͼ��
		BufferedImage image = pdfRenderer.renderImage(0) ;
		//��4������дͼ���ļ�
		ImageIO.write(image, "JPEG" , new File(destFile) );
		//5.�ر��ĵ�
		document.close() ;
	}
	
    /**
     *  �ϲ�PDF�ļ�
     * @param srcFile1 Ҫ�ϲ����ļ�1
     * @param srcFile2 Ҫ�ϲ����ļ�2
     * @param destFile Ҫ������ļ�
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws FileNotFoundException
     */
	public static void mergePDF(String srcFile1,String srcFile2,String destFile) throws InvalidPasswordException,
			IOException, FileNotFoundException {
		//    	��1������������PDF�ļ�
		    	File file1 = new File(srcFile1); 
		    	PDDocument document1 = PDDocument.load(file1) ;
		    	File file2 = new File(srcFile2); 
		    	PDDocument document2 = PDDocument.load(file2) ;
		    	//����2��ʵ����PDFMergerUtility��
		    	PDFMergerUtility mergerUtility = new PDFMergerUtility();
		    	//��3��������Ŀ���ļ�
		    	mergerUtility.setDestinationFileName(destFile);
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
	 * ��ȡPDFԴ�ļ���ҳ����
	 * @param srcFile
	 * @return
	 * @throws InvalidPasswordException
	 * @throws IOException
	 */
	public static int getPages(String srcFile) throws InvalidPasswordException, IOException{
		//��1������������PDF�ļ�
    	File file = new File(srcFile);
    	PDDocument document = PDDocument.load(file);
    	//��2����PDF�ļ���ҳ��
    	int pages = document.getNumberOfPages();
    	return pages;
	}
	
	/**
	 * ����һ���յ�PDF
	 * @throws IOException 
	 */
	public static void createBlankPDF(String srcFile) throws IOException{
		//����1������һ�����ļ�
    	PDDocument document = new PDDocument();
    	//��2��������һ���հ�ҳ
    	PDPage page = new PDPage();
    	//����3����ӿհ�ҳ���ĵ���ȥ
    	document.addPage(page);
    	//����4�����ĵ�����
    	document.save(srcFile);
    	//����5���ر��ĵ�
    	document.close();
	}
	
	/**
	 * ��PDF�ļ�����ȡͼƬ�ļ�
	 */
	public static void extractImageFromPDF(String srcFile,String destFolder){
		// ������PDF
        File pdfFile = new File(srcFile);      

        PDDocument document = null;  
        try {  
            document = PDDocument.load(pdfFile);  
        } catch (IOException e) {  
            e.printStackTrace();
        }  

        int pages_size = document.getNumberOfPages();

//        System.out.println("getAllPages==============="+pages_size);  
        
        int j=1;

        for(int i=0;i<pages_size;i++) {  
            PDPage page = document.getPage(i);
            PDResources resources = page.getResources();  
            Iterable xobjects = resources.getXObjectNames();
            if (xobjects != null) {  
                Iterator imageIter = xobjects.iterator();  
                while (imageIter.hasNext()) {  
                    COSName key = (COSName) imageIter.next();  
                    if(resources.isImageXObject(key)){              
                        try {                     
                            PDImageXObject image = (PDImageXObject) resources.getXObject(key);  
                            BufferedImage bufferedImage = image.getImage();     
                            File destDir = new File(destFolder+"\\"+pdfFile.getName().replaceAll(".pdf", ""));
                            if(!destDir.exists()){
                            	destDir.mkdirs();
                            } 	
                            String suffix = image.getSuffix().equals("jpg") ? image.getSuffix() : "jpg";
                            FileOutputStream fos = new FileOutputStream(new File(destDir,j+"."+suffix));  
                            ImageIO.write(bufferedImage, "jpeg", fos);  
                            System.out.println(image.getSuffix() + ","+image.getHeight() +"," + image.getWidth());
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } 
                        //image count
                        j++;  
                    }                 
                }  
            } 
        } 

//        System.out.println(j);
	}
	
	/**
	 * ��PDF�ļ�����ȡ�ı��ļ�
	 */
	public static void getTextFromPDF(String srcFile){
		File file = new File(srcFile);
		PDDocument document = null;
		try{
			document = PDDocument.load(file);
			int pages = document.getNumberOfPages();
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setSortByPosition(true);
			stripper.setStartPage(1);
			stripper.setEndPage(pages);
			String text = stripper.getText(document);
			System.out.println(text);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
	}
	
	
}
