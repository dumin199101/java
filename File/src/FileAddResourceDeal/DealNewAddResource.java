package FileAddResourceDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DealNewAddResource {

	public static void main(String[] args) throws IOException {

		File srcFolder = new File("D:\\资源处理\\Resource");
		
		//八仙的传说02 娇娜 八仙的传说05 宝碗
		// File srcFolder = new
		// File("I:\\谷浪远景\\资源处理\\神话故事系列\\八仙的传说01\\img\\108527.jpg");

		// 1.扫描资源：
//		 scanResource(srcFolder);

		// 2.删除所有的txt文本：
//		 deleteTxt(srcFolder);

		// 3.查找有空白页的书，删除blank.jpg
//		 FindBlankJpgAndDelete(srcFolder);

		// 4.统计图片的个数，如果为奇数页输出,插入blank.jpg：
//		 FindOddPageInsertBlankJpg(srcFolder);

		// 5.遍历文件 
//		 scanResource(srcFolder);

		// 6.因为图片文件命名有规律，所以先命名图片，但是要注意先重命名bak一下，在重命名1开始,这个要分3步完成
//		 renameJpg(srcFolder);

		// 7.去除background.mp3跟foot.mp3
//		 deleteBgFootMP3(srcFolder);

		// -----------------------------------------------------------石姑姑 荷叶山

		// 8.统计音频数量跟图片数量：
//		 findImgAndAudioCount(srcFolder);

		// 9.因为有的音频需要放两个空白音频，有的音频需要放三个空白音频，统一放三个，首页，空白，尾页，如果放置好后为奇数，那么就删除blank.mp3
//		 copyBlankAudio(srcFolder);

		// 10.删除音频个数为奇数中的blank.mp3
//		 deleteOddBlankMp3(srcFolder);

		// 11.对音频文件进行重命名：
//		renameAudio(srcFolder);

	}

	private static void renameAudio(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().contains("audio")) {
					// 重命名即可
					renameAudioFile(file);
				}

				// 递归：
				renameAudio(file);

			}

		}

	}

	private static void renameAudioFile(File file) {
		// TODO Auto-generated method stub

		File[] fileArr = file.listFiles();

		int x = 1;

		for (File f : fileArr) {

			// 1.查找是否有1开始的书,先重命名这批书
//			 if (f.getName().length() <= 6) {
//			
//			 if (f.getName().length() == 6) {
//			
//			 File dest = new File(file, "0" + f.getName());
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("文件重命名失败:" + f.getAbsolutePath());
//			
//			 }
//			
//			 }
//			
//			 if (f.getName().length() == 5) {
//			
//			 File dest = new File(file, "00" + f.getName());
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("文件重命名失败:" + f.getAbsolutePath());
//			
//			 }
//			
//			 }
//			
//			 }

			// 2.先重命名图书，防止+1时100以上的出错：
//			File dest = new File(file, f.getName().concat("bak.mp3"));
//
//			if (f.renameTo(dest)) {
//
//				System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//
//			} else {
//
//				System.out.println("文件重命名失败:" + f.getAbsolutePath());
//
//			}

			// 3.重命名从1开始：

//			 File dest = new File(file, String.valueOf(x) + ".mp3");
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("文件重命名失败:" + f.getAbsolutePath());
//			
//			 }
//			
//			 x++;
			

		}

	}

	private static void deleteOddBlankMp3(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		if (srcFolder.getName().endsWith("audio")) {

			// 如果为奇数，删除blank.mp3
			if (fileArr.length % 2 != 0) {

				// System.out.println(srcFolder.getAbsolutePath());

				// 执行删除操作：

				File parentDirectory = new File(srcFolder.getAbsolutePath());

				File blankAudio = new File(parentDirectory, "blank.mp3");

				if (blankAudio.delete()) {

					System.out.println(blankAudio + "删除成功");

				} else {

					System.out.println(blankAudio + "删除失败");

				}

			}

		}

		// 递归：

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteOddBlankMp3(file);

			}

		}

	}

	private static void copyBlankAudio(File srcFolder) throws IOException {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		// 计算一下当前文件夹下audio文件夹下图片的个数,如果为奇数，复制blank.jpg
		if (srcFolder.getName().contains("audio")) {

			// 复制blank.mp3到指定目录：
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("D:\\资源处理\\blank.mp3"));

//			File newFile = new File(srcFolder, "blank.mp3");
			 File newFile = new File(srcFolder, "foot.mp3");
//			 File newFile = new File(srcFolder, "-1.mp3");

			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(newFile));

			byte[] bys = new byte[1024];

			int len = 0;

			while ((len = bis.read(bys)) != -1) {

				bos.write(bys, 0, len);

			}

			System.out.println(newFile.getAbsolutePath() + "文件复制成功");

			bis.close();

			bos.close();

		}

		for (File file : fileArr) {

			if (file.isDirectory()) {

				copyBlankAudio(file);

			}

		}

	}

	private static void findImgAndAudioCount(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		System.out.println(srcFolder.getAbsolutePath() + "中文件个数:"
				+ fileArr.length);

		for (File file : fileArr) {

			if (file.isDirectory()) {

				findImgAndAudioCount(file);

			}

		}

	}

	private static void deleteBgFootMP3(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				deleteBgFootMP3(file);

			} else {

				if (file.getName().endsWith("background.mp3")
						|| file.getName().endsWith("foot.mp3")) {

					if (file.delete()) {

						System.out.println(file.getAbsolutePath() + "文件删除成功");

					} else {

						System.out.println(file.getAbsolutePath() + "文件删除失败");

					}

				}

			}

		}

	}

	private static void renameJpg(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {

				if (file.getName().contains("img")) {
					// 重命名即可
					renameFile(file);
				}

				// 递归：
				renameJpg(file);

			}

		}

	}

	private static void renameFile(File file) {
		// TODO Auto-generated method stub
		// 进行2步重命名：

		File[] fileArr = file.listFiles();

		int x = 1;

		for (File f : fileArr) {

			// 1.查找是否有1开始的书,先重命名这批书
//			 if(f.getName().length()<=6){
//			
//			 if(f.getName().length()==6){
//			
//			
//			 File dest = new File(file,"0" + f.getName());
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("文件重命名成功:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("文件重命名失败:"+ f.getAbsolutePath());
//			
//			 }
//			
//			
//			
//			
//			 }
//			
//			
//			 if(f.getName().length()==5){
//			
//			 File dest = new File(file,"00" + f.getName());
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("文件重命名成功:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("文件重命名失败:"+ f.getAbsolutePath());
//			
//			 }
//			
//			
//			 }
//			
//			
//			 }

			// 2.先重命名图书，防止+1时100以上的出错：
//			 File dest = new File(file,f.getName().concat("bak.jpg"));
//			
//			 if(f.renameTo(dest)){
//			
//			 System.out.println("文件重命名成功:"+ dest.getAbsolutePath());
//			
//			 }else{
//			
//			 System.out.println("文件重命名失败:"+ f.getAbsolutePath());
//			
//			 }

			// 3.重命名从1开始：

//			 File dest = new File(file, String.valueOf(x) + ".jpg");
//			
//			 if (f.renameTo(dest)) {
//			
//			 System.out.println("文件重命名成功:" + dest.getAbsolutePath());
//			
//			 } else {
//			
//			 System.out.println("文件重命名失败:" + f.getAbsolutePath());
//			
//			 }
//			
//			 x++;

			// 为防止命名出错：先bak,这个直接舍弃掉

			// File dest = new File(file,f.getName().concat("bak.jpg"));
			//
			// if(f.renameTo(dest)){
			//
			// System.out.println("文件重命名成功:"+ dest.getAbsolutePath());
			//
			// }else{
			//
			// System.out.println("文件重命名失败:"+ f.getAbsolutePath());
			//
			// }

			// 命名出粗先把bak还原：
			// if(f.getName().contains("jpgbak.jpg")){
			//
			// String[] s = f.getName().split("bak.jpg");
			//
			// System.out.println(s[0]);
			//
			// File dest = new File(file,s[0]);
			//
			// if(f.renameTo(dest)){
			//
			// System.out.println("文件重命名成功:"+ dest.getAbsolutePath());
			//
			// }else{
			//
			// System.out.println("文件重命名失败:"+ f.getAbsolutePath());
			//
			// }
			//
			//
			//
			//
			// }

		}

	}

	private static void FindOddPageInsertBlankJpg(File srcFolder)
			throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		// 计算一下当前文件夹下img文件夹下图片的个数,如果为奇数，复制blank.jpg 对文件夹下操作
		if (srcFolder.getName().contains("img")) {

			if (fileArr.length % 2 != 0) {

				// 复制blank.jpg到指定目录：
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream("D:\\资源处理\\blank.jpg"));

				File newFile = new File(srcFolder, "blank.jpg");

				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(newFile));

				byte[] bys = new byte[1024];

				int len = 0;

				while ((len = bis.read(bys)) != -1) {

					bos.write(bys, 0, len);

				}

				System.out.println(newFile.getAbsolutePath() + "文件复制成功");

				bis.close();

				bos.close();

			}

		}

		for (File file : fileArr) {

			if (file.isDirectory()) {

				FindOddPageInsertBlankJpg(file);

			}

		}

	}

	private static void FindBlankJpgAndDelete(File srcFolder) {
		// TODO Auto-generated method stub

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			// 判断是文件还是文件夹：
			if (file.isDirectory()) {

				// 输出文件夹名：
				// System.out.println("文件夹："+file.getAbsolutePath());

				FindBlankJpgAndDelete(file);

			} else {

				// 文件：
				if (file.getName().endsWith("blank.jpg")) {

					if (file.delete()) {

						System.out.println("blank.jpg文件已删除："
								+ file.getAbsolutePath());

					} else {

						System.out.println("blank.jpg文件删除失败："
								+ file.getAbsolutePath());

					}

				}

				// System.out.println("  内层文件:"+file.getAbsolutePath());

			}

		}

	}

	private static void deleteTxt(File srcFolder) {
		// TODO Auto-generated method stub 假定进来是以目录形式，这里不做文件夹判断了,遍历时一定是以目录进来的
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			// 判断是文件还是文件夹：
			if (file.isDirectory()) {

				// 输出文件夹名：
				// System.out.println("文件夹："+file.getAbsolutePath());

				deleteTxt(file);

			} else {

				// 文件：
				if (file.getName().endsWith(".txt")) {

					if (file.delete()) {

						System.out
								.println("txt文件已删除：" + file.getAbsolutePath());

					} else {

						System.out.println("txt文件删除失败："
								+ file.getAbsolutePath());

					}

				}

				// System.out.println("  内层文件:"+file.getAbsolutePath());

			}

		}

	}

	private static void scanResource(File srcFolder) {
		// TODO Auto-generated method stub
		if (srcFolder.isDirectory()) {

			File[] fileArr = srcFolder.listFiles();

			for (File file : fileArr) {

				// 判断是文件还是文件夹：
				if (file.isDirectory()) {

					// 输出文件夹名：
					System.out.println("文件夹：" + file.getAbsolutePath());

					scanResource(file);

				} else {

					// 文件：
					System.out.println("  内层文件:" + file.getAbsolutePath());

				}

			}

		} else {

			// 如果是文件：
			System.out.println("外层文件：" + srcFolder.getAbsolutePath());

		}

	}

}
