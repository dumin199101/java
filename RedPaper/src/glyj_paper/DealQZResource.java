package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 重命名群众图片，并提取对应关系
 * @author Administrator
 *
 */
public class DealQZResource {
	
	private static String juanID = "";
	private static int qiID = 0;
	
    public static void main(String[] args) {
		File srcFolder = new File("J:\\报刊加工\\群众周刊");
		getReferRelationofResourceAndRename(srcFolder);
	}

	private static void getReferRelationofResourceAndRename(File srcFolder) {
		// TODO Auto-generated method stub
				File[] fileArr = srcFolder.listFiles();
				String result = "";

				ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();

				for (File f : fileArr) {
					imgURList.add(new FileNameSort(f.getName())); // 把文件名放入list里面
				}

				Collections.sort(imgURList);

				for (FileNameSort name : imgURList) {
					File f = new File(srcFolder, name.toString());
					if (f.isDirectory()) {
						if (f.getName().matches("[01]\\d第(.+)卷")) {
							DealQZResource.juanID = f.getName().substring(0, 2);
						}
						if (!f.getName().matches("[01]\\d第(.+)卷")) {
							DealQZResource.qiID++;
							String qiID = "";
							if (DealQZResource.qiID <= 9) {
								qiID = "00" + DealQZResource.qiID;
							} else if(DealQZResource.qiID >= 10 && DealQZResource.qiID<=99) {
								qiID = "0" + DealQZResource.qiID;
							}else{
								qiID = Integer.toString(DealQZResource.qiID);
							}
							result = "QZ"
									+ DealQZResource.juanID + qiID + "\t";
							System.out.println(result);
						}
						
						getReferRelationofResourceAndRename(f);
					}
				}
	}
}
