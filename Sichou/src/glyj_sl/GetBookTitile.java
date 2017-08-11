package glyj_sl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GetBookTitile {
    public static void main(String[] args) {
//		getBookTitleInfo();
    	getBookPagesInfo();
	}

    
    /**
     * ��ȡͼ��ҳ��
     */
    private static void getBookPagesInfo() {
		// TODO Auto-generated method stub
    	File srcFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\Resource_Img\\�Ŵ���(241)");
		try {
			getBookPages(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getBookPages(File srcFolder) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		int fileCount = 0;
		if(fileArr!=null){
		    for(File file : fileArr){
		    	if(file.isDirectory()){
		    		getBookPages(file);
		    	}else{
		    		fileCount++;
		    	}
		    }	
		}
		if(!srcFolder.getName().contains("�Ŵ���"))
			System.out.println(srcFolder.getName().substring(3)+"\t"+fileCount);
	}


	/**
     * ��ȡͼ�����
     */
	private static void getBookTitleInfo() {
		File srcFolder = new File("J:\\�½�˿��֮·����ʷ�����׼�Ҫ���ݿ�ӹ�����\\�ɱ�PDF\\�Ŵ���(241)");
		try {
			getyBookTitle(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getyBookTitle(File srcFolder) throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr  = srcFolder.listFiles();
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\�Ŵ���241��Title.txt"));
		for(File file : fileArr){
			 int pos = file.getName().lastIndexOf(".pdf");
		     bw.write(file.getName().substring(3,pos)+"\t");
		     bw.newLine();
		     bw.flush();
		}
		bw.close();
	}
	
   
}
