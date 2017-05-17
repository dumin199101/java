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
 * Description: 图片水印工具类 
 * @author lieyan
 * @version 1.0
 */
public class ImageRemarkUtil {

    // 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 150;
    // 水印纵向位置
    private static int positionHeight = 300;
    // 水印文字字体
    private static Font font = new Font("宋体", Font.BOLD, 72);
    // 水印文字颜色
    private static Color color = Color.red;

    /**
     * 
     * @param srcImgPath 
     * @param iconPath 
     * @param alpha
     *            水印透明度
     * @param positionWidth
     *            水印横向位置
     * @param positionHeight
     *            水印纵向位置
     * @param font
     *            水印文字字体
     * @param color
     *            水印文字颜色
     */
    public static void setImageMarkOptions(String iconPath, String srcImgPath, float alpha, int positionWidth,
            int positionHeight, Font font, Color color) throws IOException{
    	
    	//将水印图片放置于右下角偏移20px的位置
    	File file = new File(srcImgPath);
        Image image = ImageIO.read(file);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
    	
    	Image waterImage = ImageIO.read(new File(iconPath));    // 水印文件
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
     * 给图片添加水印图片
     * 
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath) {
        markImageByIcon(iconPath, srcImgPath, targerPath, null);
    }

    /**
     * 给图片添加水印图片、可设置水印图片旋转角度
     * 
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath, Integer degree) {
        OutputStream os = null;
        try {

            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 1、得到画笔对象
            Graphics2D g = buffImg.createGraphics();

            // 2、设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 3、设置水印旋转
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }

            // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 5、得到Image对象。
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));

            // 6、水印图片的位置
            g.drawImage(img, positionWidth, positionHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 7、释放资源
            g.dispose();

            // 8、生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

//            System.out.println("图片完成添加水印图片");

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
     * 给图片添加水印文字
     * 
     * @param logoText
     *            水印文字
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     */
    public static void markImageByText(String logoText, String srcImgPath,
            String targerPath) {
        markImageByText(logoText, srcImgPath, targerPath, null);
    }

    /**
     * 给图片添加水印文字、可设置水印文字的旋转角度
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
            // 1、源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 2、得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 3、设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            // 4、设置水印旋转
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }
            // 5、设置水印文字颜色
            g.setColor(color);
            // 6、设置水印文字Font
            g.setFont(font);
            // 7、设置水印文字透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
            g.drawString(logoText, positionWidth, positionHeight);
            // 9、释放资源
            g.dispose();
            // 10、生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);

            System.out.println("图片完成添加水印文字");

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

    //批量生成水印
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
		         // 给图片添加水印图片
		         markImageByIcon(iconPath, srcImgPath, targetIconPath);
		         System.out.println("给文件夹#"+srcFolder.getName()+"下的图片"+file.getName()+"添加水印图片结束...");
	   			
	   		 }
   	    }     	
		    	
	}

	/**
     * 测试水印生成
     */
	private static void testWaterMark() {
		String srcImgPath = "H:\\Goosuu\\3.jpg";
//        String logoText = "复 印 无 效";
        String iconPath = "H:\\Goosuu\\watermark.png";

//        String targerTextPath = "d:/qie_text.jpg";
//        String targerTextPath2 = "d:/qie_text_rotate.jpg";

        String targerIconPath = "H:\\Goosuu\\3.jpg";
//        String targerIconPath2 = "d:/qie_icon_rotate.jpg";

//        System.out.println("给图片添加水印文字开始...");
        // 给图片添加水印文字
//        markImageByText(logoText, srcImgPath, targerTextPath);
        // 给图片添加水印文字,水印文字旋转-45
//        markImageByText(logoText, srcImgPath, targerTextPath2, -45);
//        System.out.println("给图片添加水印文字结束...");

        System.out.println("给图片添加水印图片开始...");
        try {
			setImageMarkOptions(iconPath,srcImgPath,0.9f, 0, 0, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 给图片添加水印图片
        markImageByIcon(iconPath, srcImgPath, targerIconPath);
        // 给图片添加水印图片,水印图片旋转-45
//        markImageByIcon(iconPath, srcImgPath, targerIconPath2, -45);
        System.out.println("给图片添加水印图片结束...");
	}

}
