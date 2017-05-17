package glyj_lhh_database;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*******************************************************************************
 * Description: ͼƬˮӡ������ 
 * @author lieyan
 * @version 1.0
 */
public class ImageRemarkUtil {

    // ˮӡ͸����
    private static float alpha = 0.5f;
    // ˮӡ����λ��
    private static int positionWidth = 150;
    // ˮӡ����λ��
    private static int positionHeight = 300;
    // ˮӡ��������
    private static Font font = new Font("����", Font.BOLD, 72);
    // ˮӡ������ɫ
    private static Color color = Color.red;

    /**
     * 
     * @param srcImgPath 
     * @param iconPath 
     * @param alpha
     *            ˮӡ͸����
     * @param positionWidth
     *            ˮӡ����λ��
     * @param positionHeight
     *            ˮӡ����λ��
     * @param font
     *            ˮӡ��������
     * @param color
     *            ˮӡ������ɫ
     */
    public static void setImageMarkOptions(String iconPath, String srcImgPath, float alpha, int positionWidth,
            int positionHeight, Font font, Color color) throws IOException{
    	
    	//��ˮӡͼƬ���������½�ƫ��20px��λ��
    	File file = new File(srcImgPath);
        Image image = ImageIO.read(file);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
    	
    	Image waterImage = ImageIO.read(new File(iconPath));    // ˮӡ�ļ�
        int width_1 = waterImage.getWidth(null);
        int height_1 = waterImage.getHeight(null);
    	 
        int widthDiff = width - width_1 - 20;
        int heightDiff = height - height_1 -20;
    	
    	
        if (alpha != 0.0f)
            ImageRemarkUtil.alpha = alpha;
        if (positionWidth != 0){
        	ImageRemarkUtil.positionWidth = positionWidth;
        }else{
        	ImageRemarkUtil.positionWidth = widthDiff;
        }
        	
        if (positionHeight != 0){
        	ImageRemarkUtil.positionHeight = positionHeight;
        }else{
        	ImageRemarkUtil.positionHeight = heightDiff;
        }
            
        if (font != null)
            ImageRemarkUtil.font = font;
        if (color != null)
            ImageRemarkUtil.color = color;
    }

    /**
     * ��ͼƬ���ˮӡͼƬ
     * 
     * @param iconPath
     *            ˮӡͼƬ·��
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath) {
        markImageByIcon(iconPath, srcImgPath, targerPath, null);
    }

    /**
     * ��ͼƬ���ˮӡͼƬ��������ˮӡͼƬ��ת�Ƕ�
     * 
     * @param iconPath
     *            ˮӡͼƬ·��
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     * @param degree
     *            ˮӡͼƬ��ת�Ƕ�
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath, Integer degree) {
        OutputStream os = null;
        try {

            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 1���õ����ʶ���
            Graphics2D g = buffImg.createGraphics();

            // 2�����ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 3������ˮӡ��ת
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }

            // 4��ˮӡͼƬ��·�� ˮӡͼƬһ��Ϊgif����png�ģ�����������͸����
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 5���õ�Image����
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));

            // 6��ˮӡͼƬ��λ��
            g.drawImage(img, positionWidth, positionHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 7���ͷ���Դ
            g.dispose();

            // 8������ͼƬ
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

//            System.out.println("ͼƬ������ˮӡͼƬ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��ͼƬ���ˮӡ����
     * 
     * @param logoText
     *            ˮӡ����
     * @param srcImgPath
     *            ԴͼƬ·��
     * @param targerPath
     *            Ŀ��ͼƬ·��
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath) {
        markImageByText(logoText, srcImgPath, targerPath, null);
    }

    /**
     * ��ͼƬ���ˮӡ���֡�������ˮӡ���ֵ���ת�Ƕ�
     * 
     * @param logoText
     * @param srcImgPath
     * @param targerPath
     * @param degree
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath, Integer degree) {

        InputStream is = null;
        OutputStream os = null;
        try {
            // 1��ԴͼƬ
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 2���õ����ʶ���
            Graphics2D g = buffImg.createGraphics();
            // 3�����ö��߶εľ��״��Ե����
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 4������ˮӡ��ת
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }
            // 5������ˮӡ������ɫ
            g.setColor(color);
            // 6������ˮӡ����Font
            g.setFont(font);
            // 7������ˮӡ����͸����
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 8����һ����->���õ����ݣ�������������->������ͼƬ�ϵ�����λ��(x,y)
            g.drawString(logoText, positionWidth, positionHeight);
            // 9���ͷ���Դ
            g.dispose();
            // 10������ͼƬ
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

            System.out.println("ͼƬ������ˮӡ����");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
      
//        testWaterMark();
    	File srcFolder = new File("H:\\Goosuu\\LhhImg");
    	
    	batchAddWaterMark(srcFolder);

    }

    //��������ˮӡ
    private static void batchAddWaterMark(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr  = srcFolder.listFiles();
		for(File file : fileArr){
	   		 if(file.isDirectory()){
	   			  batchAddWaterMark(file);
	   		 }else{
	   			String targetIconPath,srcImgPath; 
	   			targetIconPath = srcImgPath = file.getAbsolutePath();
	   			String iconPath = "H:\\Goosuu\\watermark.png";
		         try {
		 			setImageMarkOptions(iconPath,srcImgPath,0.9f, 0, 0, null, null);
		 		} catch (IOException e) {
		 			e.printStackTrace();
		 		}
		         // ��ͼƬ���ˮӡͼƬ
		         markImageByIcon(iconPath, srcImgPath, targetIconPath);
		         System.out.println("���ļ���#"+srcFolder.getName()+"�µ�ͼƬ"+file.getName()+"���ˮӡͼƬ����...");
	   			
	   		 }
   	    }     	
		    	
	}

	/**
     * ����ˮӡ����
     */
	private static void testWaterMark() {
		String srcImgPath = "H:\\Goosuu\\3.jpg";
//        String logoText = "�� ӡ �� Ч";
        String iconPath = "H:\\Goosuu\\watermark.png";

//        String targerTextPath = "d:/qie_text.jpg";
//        String targerTextPath2 = "d:/qie_text_rotate.jpg";

        String targerIconPath = "H:\\Goosuu\\3.jpg";
//        String targerIconPath2 = "d:/qie_icon_rotate.jpg";

//        System.out.println("��ͼƬ���ˮӡ���ֿ�ʼ...");
        // ��ͼƬ���ˮӡ����
//        markImageByText(logoText, srcImgPath, targerTextPath);
        // ��ͼƬ���ˮӡ����,ˮӡ������ת-45
//        markImageByText(logoText, srcImgPath, targerTextPath2, -45);
//        System.out.println("��ͼƬ���ˮӡ���ֽ���...");

        System.out.println("��ͼƬ���ˮӡͼƬ��ʼ...");
        try {
			setImageMarkOptions(iconPath,srcImgPath,0.9f, 0, 0, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // ��ͼƬ���ˮӡͼƬ
        markImageByIcon(iconPath, srcImgPath, targerIconPath);
        // ��ͼƬ���ˮӡͼƬ,ˮӡͼƬ��ת-45
//        markImageByIcon(iconPath, srcImgPath, targerIconPath2, -45);
        System.out.println("��ͼƬ���ˮӡͼƬ����...");
	}

}
