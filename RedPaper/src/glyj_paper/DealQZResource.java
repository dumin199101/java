package glyj_paper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������Ⱥ��ͼƬ������ȡ��Ӧ��ϵ
 * @author Administrator
 *
 */
public class DealQZResource {
	
	private static String juanID = "";
	private static int qiID = 0;
	
    public static void main(String[] args) {
		File srcFolder = new File("J:\\�����ӹ�\\Ⱥ���ܿ�");
		getReferRelationofResourceAndRename(srcFolder);
	}

	private static void getReferRelationofResourceAndRename(File srcFolder) {
		// TODO Auto-generated method stub
				File[] fileArr = srcFolder.listFiles();
				String result = "";

				ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();

				for (File f : fileArr) {
					imgURList.add(new FileNameSort(f.getName())); // ���ļ�������list����
				}

				Collections.sort(imgURList);

				for (FileNameSort name : imgURList) {
					File f = new File(srcFolder, name.toString());
					if (f.isDirectory()) {
						if (f.getName().matches("[01]\\d��(.+)��")) {
							DealQZResource.juanID = f.getName().substring(0, 2);
						}
						if (!f.getName().matches("[01]\\d��(.+)��")) {
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
