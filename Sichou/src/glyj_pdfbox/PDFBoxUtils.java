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
	 * 转换PDF文件为图片文件
	 * @param srcFile  原始PDF文件路径
	 * @param destFile 提取图片文件保存路径
	 * @throws InvalidPasswordException
	 * @throws IOException
	 */
	public static void getImageFromPDF(String srcFile,String destFile) throws InvalidPasswordException,
			IOException {
		//第1步：加载现有PDF文件
		File file = new File(srcFile); 
		PDDocument document = PDDocument.load(file) ;
		//步骤2：实例化PDFRenderer类
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		//步骤3：从PDF文件绘制图像
		BufferedImage image = pdfRenderer.renderImage(0) ;
		//第4步：编写图像到文件
		ImageIO.write(image, "JPEG" , new File(destFile) );
		//5.关闭文档
		document.close() ;
	}
	
    /**
     *  合并PDF文件
     * @param srcFile1 要合并的文件1
     * @param srcFile2 要合并的文件2
     * @param destFile 要保存的文件
     * @throws InvalidPasswordException
     * @throws IOException
     * @throws FileNotFoundException
     */
	public static void mergePDF(String srcFile1,String srcFile2,String destFile) throws InvalidPasswordException,
			IOException, FileNotFoundException {
		//    	第1步：加载现有PDF文件
		    	File file1 = new File(srcFile1); 
		    	PDDocument document1 = PDDocument.load(file1) ;
		    	File file2 = new File(srcFile2); 
		    	PDDocument document2 = PDDocument.load(file2) ;
		    	//步骤2：实例化PDFMergerUtility类
		    	PDFMergerUtility mergerUtility = new PDFMergerUtility();
		    	//第3步：设置目标文件
		    	mergerUtility.setDestinationFileName(destFile);
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
	 * 获取PDF源文件的页码数
	 * @param srcFile
	 * @return
	 * @throws InvalidPasswordException
	 * @throws IOException
	 */
	public static int getPages(String srcFile) throws InvalidPasswordException, IOException{
		//第1步：加载现有PDF文件
    	File file = new File(srcFile);
    	PDDocument document = PDDocument.load(file);
    	//第2步：PDF文件的页数
    	int pages = document.getNumberOfPages();
    	return pages;
	}
	
	/**
	 * 创建一个空的PDF
	 * @throws IOException 
	 */
	public static void createBlankPDF(String srcFile) throws IOException{
		//步骤1：创建一个空文件
    	PDDocument document = new PDDocument();
    	//第2步：创建一个空白页
    	PDPage page = new PDPage();
    	//步骤3：添加空白页到文档中去
    	document.addPage(page);
    	//步骤4：将文档保存
    	document.save(srcFile);
    	//步骤5：关闭文档
    	document.close();
	}
	
	/**
	 * 从PDF文件中提取图片文件
	 */
	public static void extractImageFromPDF(String srcFile,String destFolder){
		// 待解析PDF
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
	 * 从PDF文件中提取文本文件
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
